package com.sbrian.gfinance.scraper;

public class LatestBusinessDay extends ReportTime
{
	private Date date;
	
	public LatestBusinessDay(Date date)
	{
		if ( date == null )
		{
			throw new RuntimeException("Cannot be null");
		}
		this.date = date;
	}
	
	public Date getEndDate()
	{
		return date;
	}

	public ReportTime getNext()
	{
		throw new RuntimeException("Does not apply");
	}

	public ReportTime getPrevious()
	{
		throw new RuntimeException("Does not apply");
	}

	public Date getStartDate()
	{
		return date;
	}
	
	public int compareTo(ReportTime reportTime)
	{
		// Is always more recent than any other type of time
		if ( ! ( reportTime instanceof LatestBusinessDay ) )
			return 1;
		return date.compareTo(reportTime.getEndDate());
	}
	
	public boolean equals(Object o)
	{
		if ( o == null ) return false;
		if ( ! ( o instanceof LatestBusinessDay ) )
		{
			return false;
		}
		return date.equals(((LatestBusinessDay)o).date);
	}
	
	public int hashCode()
	{
		return date.hashCode();
	}
	
	public String toString()
	{
		return date.toString();
	}

}
