package com.sbrian.gfinance.scraper;

import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


public class ReportCollection implements ReportSource
{
	private SortedSet<Report> reports
		= new TreeSet<Report>();
	
	private Stock stock;
	
	public ReportCollection(Stock stock)
	{
		this.stock = stock;
	}
	
	public Stock getStock()
	{
		return stock;
	}
	
	public void add(Report report)
	{
		report.setReportSource(this);
		reports.add(report);
	}
	
	public Report findReport(ReportTime reportTime)
	{
		Iterator<Report> i = reports.iterator();
		Report q;
		while ( i.hasNext() )
		{
			q = i.next();
			if ( q.getReportTime().equals(reportTime) ) return q;
		}
		return null;	
	}
	
	public Report findEarliestReport()
	{
		return getOrderedReports().first();
	}
	
	public Report findLatestReport()
	{
		return getOrderedReports().last();
	}
	
	public Report findPreviousReport(Report report)
	{
		Report previous = null;
		Iterator<Report> i = getOrderedReports().iterator();
		while ( i.hasNext() )
		{
			Report thisReport = i.next();
			if ( thisReport.compareTo(report) >= 0 )
			{
				return previous;
			}
			previous = thisReport;
		}
		return previous;
	}
	
	public SortedSet<Report> getOrderedReports()
	{
		SortedSet<Report> reports = new TreeSet<Report>();
		Iterator<Report> i2 = getQuarterlyReports().iterator();
		
		if ( i2.hasNext())
		{
			ReportTime earliestQuarter = getQuarterlyReports().first().getReportTime();	
			Iterator<Report> i = getAnnualReports().iterator();
			while(i.hasNext())
			{
				Report a = i.next();
				if ( a.getReportTime().getEndDate().compareTo(earliestQuarter.getEndDate()) < 0
					&& a.getStockPrice() != null )
				{
					reports.add(a);
				}
			}
			while(i2.hasNext())
			{
				reports.add(i2.next());
			}
		}
		else
		{
			reports = getAnnualReports();
		}
		Report currentReport = getCurrentReport();
		if ( currentReport != null )
			reports.add(currentReport);
		return reports;
	}
	
	public SortedSet<Report> getQuarterlyReports()
	{
		SortedSet<Report> theseReports = new TreeSet<Report>();
		Iterator<Report> i = reports.iterator();
		while(i.hasNext())
		{
			Report a = i.next();
			if ( a.getReportTime() instanceof Quarter )
				theseReports.add(a);
		}
		return theseReports;
	}
	
	public SortedSet<Report> getAnnualReports()
	{
		SortedSet<Report> theseReports = new TreeSet<Report>();
		Iterator<Report> i = reports.iterator();
		while(i.hasNext())
		{
			Report a = i.next();
			if ( a.getReportTime() instanceof Year )
				theseReports.add(a);
		}
		return theseReports;
	}
	
	public Report getCurrentReport()
	{
		Iterator<Report> i = reports.iterator();
		while(i.hasNext())
		{
			Report a = i.next();
			if ( a.getReportTime() instanceof LatestBusinessDay )
				return a;
		}
		return null;
	}
	
	public void removeFirst()
	{
		reports.remove(reports.first());
	}

}
