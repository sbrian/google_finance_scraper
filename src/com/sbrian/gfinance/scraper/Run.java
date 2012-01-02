package com.sbrian.gfinance.scraper;

import java.io.File;
import java.io.IOException;

import org.antlr.stringtemplate.StringTemplate;
import org.antlr.stringtemplate.StringTemplateGroup;
import org.apache.commons.io.output.FileWriterWithEncoding;


public class Run
{
	public static void main(String argv[]) throws Exception
	{
		String[] symbols = new String[]
		{
			"AAPL"
		};
		for(int x=0; x<symbols.length; x++)
		{
			generateReport(symbols[x], "/home/bsmith/Desktop/investment");
		}
	}
	
	public static void generateReport(String symbol, String path) throws IOException, ScraperCacheException
	{
		Scraper s = new Scraper();
		ReportCollection result = s.scrapeObjects(symbol);
		result.removeFirst();
		result.removeFirst();
		StringTemplateGroup templates = new StringTemplateGroup(
				"templates", "code_templates");
		StringTemplate createAndDeleteTest = templates.getInstanceOf("htmlTable");
		createAndDeleteTest.setAttribute("reports", result.getOrderedReports());
		
		FileWriterWithEncoding f = new FileWriterWithEncoding(
				path + File.separator + symbol + ".html", "UTF-8");
		f.write(createAndDeleteTest.toString());
		f.close();
	}
	
	public static void output(ReportCollection reportCollection, Report report, String property)
	{
		System.err.println(property + "\t\t" + report.getBigDecimalProperty(property) + "\t\t" + report.getChangeFromPrevious(property));
	}
}
