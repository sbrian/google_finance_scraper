package com.sbrian.gfinance.scraper;

import java.io.File;
import java.io.IOException;
import java.util.SortedSet;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateErrorListener;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.commons.io.output.FileWriterWithEncoding;


public class RunMine
{
	public static void main(String argv[]) throws Exception
	{
		String[] symbols = new String[]
		{
			"DNR",
			"TM",
			"NASDAQ:RYAAY",
			"VMW",
			"NASDAQ:LULU",
			"AMEX:APP",
			"AMAC",
			"NASDAQ:NTGR",
			"NVDA",
			"NYSE:TTM",
			"IRS",
			"SUNH",
			"NASDAQ:CRBC",
			"NYSE:LIZ",
			"NASDAQ:FRPT",
			"NASDAQ:AMAC",
			"ISRG",
			"NYSE:VMW",
			"AKAM"
		};
		//symbols = new String[]{ "LLNW", "MFE", "VMW", "DNR", "LIZ", "AKAM", "LULU", "ISRG", "RYAAY", "ESLT", "NYSE:CLF" };
		//symbols = new String[]{ "WXCO" };
		//symbols = new String[]{ "SUNH", "FVE", "SKH", "ENSG", "AVCA", "CSU", "SRZ" };
		symbols = new String[]{ "NASDAQ:AAPL"};
		for(int x=0; x<symbols.length; x++)
		{
			System.err.println(symbols[x]);
			generateReport(symbols[x], "/home/bsmith/jungledisk/home_files/Investment/scraper");
		}
	}
	
	public static void generateReport(String symbol, String path) throws IOException, ScraperCacheException
	{
		Scraper s = new Scraper();
		
		s.setCache(new FileScraperCache(new File(path + File.separator + "cache")));
		
		ReportCollection result = s.scrapeObjects(symbol);
		

		//result.removeFirst();
		//result.removeFirst();
		//result.removeFirst();
		
		StringTemplateGroup templates = new StringTemplateGroup(
				"templates", "code_templates");
		templates.setErrorListener(new StringTemplateErrorListener(){

			public void error(String arg0, Throwable arg1)
			{
				throw new RuntimeException(arg0, arg1);
				
			}

			public void warning(String arg0)
			{
				throw new RuntimeException(arg0);
				
			}});
		StringTemplate createAndDeleteTest = templates.getInstanceOf("htmlTable");
		SortedSet<Report> reports = result.getOrderedReports();
		
		//reports.remove(reports.first());
		//reports.remove(reports.first());
		
		createAndDeleteTest.setAttribute("reports", reports);
		
		FileWriterWithEncoding f = new FileWriterWithEncoding(
				path + File.separator + symbol + ".html", "UTF-8");
		f.write(createAndDeleteTest.toString());
		f.close();
	}
}
