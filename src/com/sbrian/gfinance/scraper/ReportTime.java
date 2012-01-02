package com.sbrian.gfinance.scraper;

public abstract class ReportTime implements Comparable<ReportTime>
{
	public abstract ReportTime getNext();
	
	public abstract ReportTime getPrevious();
	
	public abstract Date getStartDate();
	
	public abstract Date getEndDate();
	
	public int compareTo(ReportTime r)
	{
		return getStartDate().compareTo(r.getStartDate());
	}
}
