package com.sbrian.gfinance.scraper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.text.html.HTMLEditorKit;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.IOUtils;

public class Scraper
{	
	private ScraperCache cache;
	
	public void setCache(ScraperCache cache)
	{
		this.cache = cache;
	}
	
	public ReportCollection scrapeObjects(String symbol) throws IOException,
			ScraperCacheException
	{
		return scrapeObjects(new Stock(symbol));
	}
	
	private ReportCollection scrapeObjects(Stock stock) throws IOException, ScraperCacheException
	{
		ParsedItems result = new ParsedItems();
	
		List<ParsedItems> inCache = this.findInCache(stock.getSymbol());
		
		ParsedItems current = this.scrape(stock.getSymbol());
		
		for( ParsedItems p : inCache )
		{
			result.merge(p);
		}
		
		result.merge(current);
		
		Iterator<ParsedItem> i = result.iterator();
		Set<CashFlow> cashFlows = new LinkedHashSet<CashFlow>();
		Set<IncomeStatement> incomeStatements = new LinkedHashSet<IncomeStatement>();
		Set<BalanceSheet> balanceSheets = new LinkedHashSet<BalanceSheet>();
		while(i.hasNext())
		{
			Object o = entryToObject(i.next());
			if ( o instanceof CashFlow )
			{
				cashFlows.add((CashFlow)o);
			}
			else if ( o instanceof BalanceSheet )
			{
				balanceSheets.add((BalanceSheet)o);
			}
			else if ( o instanceof IncomeStatement )
			{
				incomeStatements.add((IncomeStatement)o);
			}
			else
			{
				throw new RuntimeException();
			}
		}

		Set<CashFlow> extraCashFlows = new LinkedHashSet<CashFlow>();
		createIntermediaryRanges(cashFlows, extraCashFlows);
		cashFlows.addAll(extraCashFlows);
		
		Set<IncomeStatement> extraIncomeStatements = new LinkedHashSet<IncomeStatement>();
		createIntermediaryRanges(incomeStatements, extraIncomeStatements);
		incomeStatements.addAll(extraIncomeStatements);
		
		ReportCollection reports = new ReportCollection(stock);
		
		Iterator<IncomeStatement> i2  = incomeStatements.iterator();
		
		while ( i2.hasNext() )
		{
			IncomeStatement is = i2.next();
			Report r = null;
			Calendar c = Calendar.getInstance();
			c.setTime(is.getDateRange().getEnd().getTime());
			System.err.println("Report has range: " + is.getDateRange() + " - " + is.getDateRange().periodInMonths());
			if ( is.getDateRange().periodInMonths() == 3 )
			{
				r = new Report(new Quarter(is.getDateRange().getEnd()), 4);
			}
			else if ( is.getDateRange().periodInMonths() == 12 )
			{
				c.setTime(is.getDateRange().getEnd().getTime());
				// Subtract three months, as an "annual" report might end somewhere in
				// the first quarter, although it is still a report for the previous year.
				c.add(Calendar.DATE, -91);
				System.err.println("Created annual report for: " + new Year(c.get(Calendar.YEAR)));
				r = new Report(new Year(c.get(Calendar.YEAR)), 1);
			}
			else if ( is.getDateRange().periodInMonths() == 6 )
			{
				r = new Report(new HalfYear(is.getDateRange().getEnd()), 2);
			}
			else
			{
				System.err.println("WARNING! Unsupported report range. " + is.getDateRange() + " - " + is.getDateRange().periodInMonths());
			}
			
			if ( r != null )
			{
				CashFlow cf = findCashFlow(cashFlows, is.getDateRange().getStart(),
						is.getDateRange().periodInMonths());
				if ( cf != null )
				{
				r.setIncomeStatement(is);
				r.setCashFlow(cf);
				r.setBalanceSheet(findBalanceSheet(balanceSheets, is.getDateRange().getEnd()));
				r.setStockPrice(new StockPriceScraper().findStockPrice(stock.getSymbol(), r.getEndDate()));
				reports.add(r);
				}
			}
		}
		
		Report latest = reports.findLatestReport();
		
		StockPriceScraper s = new StockPriceScraper();
		BigDecimal sp = s.findStockPrice(stock.getSymbol(), new Date(new java.util.Date()));
		Report currentReport = new Report(new LatestBusinessDay(s.getDateFound()),
				latest.getAnnualMultiplier().intValue());
		currentReport.setIncomeStatement(latest.getIncomeStatement());
		currentReport.setBalanceSheet(latest.getBalanceSheet());
		currentReport.setCashFlow(latest.getCashFlow());
		currentReport.setStockPrice(sp);
		reports.add(currentReport);
		return reports;
	}
	
	private BalanceSheet findBalanceSheet(Set<BalanceSheet> balanceSheets,
			Date end)
	{
		Iterator<BalanceSheet> i = balanceSheets.iterator();
		while( i.hasNext() )
		{
			BalanceSheet b = i.next();
			if ( b.getDate().equals(end) )
			{
				return b;
			}
		}
		return null;
		//throw new RuntimeException("Couldn't find balance sheet for " + end);
	}

	private CashFlow findCashFlow(Set<CashFlow> cashFlows, Date start,
			int periodInMonths)
	{
		Iterator<CashFlow> i = cashFlows.iterator();
		while( i.hasNext() )
		{
			CashFlow b = i.next();
			if ( b.getDateRange().periodInMonths() == periodInMonths 
				&& b.getDateRange().getStart().equals(start) )
				return b;
		}
		return null;
		//throw new RuntimeException("Couldn't find cash flow for " + start + " period " + periodInMonths);
	}

	private void createIntermediaryRanges(Set<? extends Subtractable> original,
			Set extras)
	{
		Iterator<? extends Subtractable> i = original.iterator();
		while( i.hasNext() )
		{
			Subtractable c = i.next();
			int p = c.getDateRange().periodInMonths();
			if ( p > 3 )
			{
				Subtractable extra = findAndSubtract(c, original, p - 3);
				if ( extra != null )
				{
					extras.add(extra);
				}
			}
		}
	}

	private Subtractable findAndSubtract(Subtractable c,
			Set<? extends Subtractable> toSearch, int p)
	{
		//System.err.println("Looking for match for statement from " + c.getDateRange());
		//System.err.println("Looking for a statement with period of " + p + " that starts on " + c.getDateRange().getStart());
		Iterator<? extends Subtractable> i = toSearch.iterator();
		while (i.hasNext())
		{
			Subtractable csub = i.next();
			int psub = csub.getDateRange().periodInMonths();
			//System.err.println("Period of " + psub);
			if (p == psub
					&& csub.getDateRange().getStart().equals(
							c.getDateRange().getStart()))
			{
				//System.err.println(c);
				//System.err.println(csub);
				return c.subtract(csub);
			}
		}
		return null;
	}

	private ParsedItems scrape(String symbol) throws IOException, ScraperCacheException
	{
		URL url = new URL("http://www.google.com/finance?fstype=ii&q=" + symbol);
		URLConnection conn = url.openConnection();
		conn.connect();
		
		BufferedReader streamReader = new BufferedReader(new InputStreamReader(
				conn.getInputStream(), "UTF-8"));
		String content = IOUtils.toString(streamReader);
		

		if ( cache != null )
		{
			cache.cache(symbol, content);
		}
		
		return parse(content);
	}
	
	private List<ParsedItems> findInCache(String symbol) throws IOException, ScraperCacheException
	{
		List<ParsedItems> list = new LinkedList<ParsedItems>();
		Set<String> contentInCache = cache.getAllFromCache(symbol);
		for ( String content : contentInCache )
		{
			list.add(parse(content));
		}
		return list;
	}
	
	private ParsedItems parse(String content) throws IOException, ScraperCacheException
	{
		//System.err.println(content);
		HtmlParseCallback callback = new HtmlParseCallback();
		new HTMLParse().getParser().parse(new StringReader(content), callback, true);
		return callback.getStatements();
	}

	private class HTMLParse extends HTMLEditorKit
	{
		public HTMLEditorKit.Parser getParser()
		{
			return super.getParser();
		}
	}
	
	private static BigDecimal convertToBigDecimal(String s)
	{
		if ( s.equals("-") )
		{
			return new BigDecimal("0.00");
		}
		s = s.replace(",", "");
		if ( ! s.matches("^\\-?[0-9]+(\\.[0-9]+)?$") )
		{
			throw new RuntimeException("Couldn't parse BigDecimal from '" + s + "'");
		}
		return new BigDecimal(s);
	}
	
	private static Object entryToObject(ParsedItem entry)
	{
		try
		{
			return _entryToObject(entry);
		}
		catch(ClassNotFoundException e)
		{
			throw new RuntimeException(e);
		}
		catch (ParseException e)
		{
			throw new RuntimeException(e);
		}
		catch (InstantiationException e)
		{
			throw new RuntimeException(e);
		}
		catch (IllegalAccessException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	private static Object _entryToObject(ParsedItem entry)
			throws ClassNotFoundException, ParseException,
			InstantiationException, IllegalAccessException
	{
		Object newObj = Class.forName(Scraper.class.getPackage().getName()
				+ "." + entry.getType()).newInstance();
		if ( newObj instanceof IncomeStatement )
		{
			return populateIncomeStatement((IncomeStatement)newObj, entry);
		}
		else if ( newObj instanceof BalanceSheet )
		{
			return populateBalanceSheet((BalanceSheet)newObj,entry);
		}
		else if ( newObj instanceof CashFlow )
		{
			return populateCashFlow((CashFlow)newObj, entry);
		}
		throw new RuntimeException("Design error");
	}

	private static CashFlow populateCashFlow(CashFlow cashFlow,
			ParsedItem entry) throws ParseException
	{
		cashFlow.setDateRange(DateRange.parse(entry.getDate()));
		populateFieldsFromMap(cashFlow, entry);
		return cashFlow;
	}

	private static BalanceSheet populateBalanceSheet(BalanceSheet balanceSheet,
			ParsedItem entry) throws ParseException
	{
		balanceSheet.setDate(new Date(
				DateUtils.padToEndOfMonth(new SimpleDateFormat("yyyy-MM-dd").parse(
				entry.getDate().replaceAll(".* ", "")))));
		populateFieldsFromMap(balanceSheet, entry);
		return balanceSheet;
	}

	private static IncomeStatement populateIncomeStatement(
			IncomeStatement incomeStatement, ParsedItem entry)
			throws ParseException
	{
		incomeStatement.setDateRange(DateRange.parse(entry.getDate()));
		populateFieldsFromMap(incomeStatement, entry);
		return incomeStatement;
	}

	private static void populateFieldsFromMap(Object bean,
			ParsedItem entry)
	{
		try
		{
			_populateFieldsFromMap(bean, entry);
		}
		catch (IllegalAccessException e)
		{
			throw new RuntimeException(e);
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(e);
		}
	}
		
	private static void _populateFieldsFromMap(Object obj,
			ParsedItem entry) throws IllegalAccessException, InvocationTargetException
	{
		Iterator<String> i = entry.keySet().iterator();
		while( i.hasNext() )
		{
			String k = i.next();
			if ( k.charAt(0) == '_' )
			{
				continue;
			}
			String propertyName = MethodNames.convertToMethodName(k);
			Object propertyValue;
			if ( propertyName.equals("totalCommonSharedsOutstanding") )
			{
				propertyValue = Long.parseLong(entry.get(k))
					* 1000000;
			}
			else
			{
				propertyValue = convertToBigDecimal(entry.get(k));
			}
			BeanUtils.setProperty(obj, propertyName,
				propertyValue);
		}
	}
}
