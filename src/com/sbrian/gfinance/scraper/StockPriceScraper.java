package com.sbrian.gfinance.scraper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.HTML.Attribute;

import org.apache.commons.io.IOUtils;

public class StockPriceScraper
{
	private BigDecimal price = null;

	private List<String> headers;

	private Date currentDate;
	
	public Date getDateFound()
	{
		return currentDate;
	}

	private enum STATE
	{
		NOT_IN_TABLE, IN_TABLE, IN_HEADERS, IN_DATA, LOOKING_FOR_NEXT_DATA, FINISHED
	}

	private STATE state = STATE.NOT_IN_TABLE;

	private int posInData = 0;

	private Date searchDate;
	
	public BigDecimal findStockPrice(String symbol, Date date)
			throws IOException, ScraperCacheException
	{
		DateFormat formatter = new SimpleDateFormat("MMM+d,+yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(date.getTime());
		c.add(Calendar.DATE, -10);
		String startDate = formatter.format(c.getTime());
		c.add(Calendar.DATE, +20);
		String endDate = formatter.format(c.getTime());

		searchDate = date;

		URL url = new URL("http://www.google.com/finance/historical?q="
				+ symbol + "&startdate=" + startDate + "&enddate=" + endDate
				+ "&num=200");

		System.err.println("Getting stock price from: " + url);
		
		URLConnection conn = url.openConnection();
		conn.connect();

		BufferedReader streamReader = new BufferedReader(new InputStreamReader(
				conn.getInputStream(), "UTF-8"));
		String content = IOUtils.toString(streamReader);
		
		Callback callback = new Callback();
		new HTMLParse().getParser().parse(new StringReader(content),
				new Callback(), true);
		if ( price == null )
		{
			System.err.println("Warning: Couldn't get stock price");
		}
		return price;
	}

	private class Callback extends HTMLEditorKit.ParserCallback
	{
		public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos)
		{
			if (price != null)
				return;
			switch (state)
			{
			case NOT_IN_TABLE:
				if (t == HTML.Tag.TABLE)
						//&& "historical_price".equals(a
						//		.getAttribute(Attribute.CLASS)))
				{
					state = STATE.IN_TABLE;
				}
				break;
			case IN_TABLE:
				if (t == HTML.Tag.TR)
				{
					state = STATE.IN_HEADERS;
					headers = new LinkedList<String>();
				}
				break;
			case LOOKING_FOR_NEXT_DATA:
				if (t == HTML.Tag.TR)
				{
					state = STATE.IN_DATA;
					posInData = 0;
				}
				break;
			}
		}

		public void handleEndTag(HTML.Tag t, int pos)
		{
			if (price != null)
				return;
			switch (state)
			{
			case IN_HEADERS:
			case IN_DATA:
				if (t == HTML.Tag.TR)
				{
					state = STATE.LOOKING_FOR_NEXT_DATA;
				}
				break;
			case LOOKING_FOR_NEXT_DATA:
				if (t == HTML.Tag.TABLE)
				{
					state = STATE.NOT_IN_TABLE;
				}
			}
		}

		public void handleText(char[] data, int pos)
		{
			if (price != null)
				return;
			switch (state)
			{
			case IN_HEADERS:
				headers.add(new String(data).trim());
				break;
			case IN_DATA:
				if (headers.get(posInData).equals("Date"))
				{
					try
					{
						currentDate = new Date(new SimpleDateFormat(
								"MMM d, yyyy").parse(new String(data).trim()));
					}
					catch (ParseException e)
					{
						throw new RuntimeException("Couldn't parse: "
								+ new String(data));
					}
				}
				else if (headers.get(posInData).equals("Close"))
				{
					// System.err.println("Checking " + currentDate + " " +
					// searchDate);
					// System.err.println(currentDate.compareTo(searchDate));
					if (currentDate.compareTo(searchDate) <= 0)
					{
						price = new BigDecimal(new String(data).trim());
					}
				}
				posInData++;
				break;
			}
		}
	}

	private class HTMLParse extends HTMLEditorKit
	{
		public HTMLEditorKit.Parser getParser()
		{
			return super.getParser();
		}
	}
}
