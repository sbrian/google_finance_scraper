package com.sbrian.gfinance.scraper;

public interface ReportSource
{
	public Report findEarliestReport();
	
	public Report findLatestReport();
	
	public Report findPreviousReport(Report report);
}
