package com.sbrian.gfinance.scraper;

import java.util.Calendar;

public class Quarter extends ReportTime
{
	public enum QUARTER {
		First, Second, Third, Fourth
	}
	
	private QUARTER quarter;
	private Year year;
	
	public Quarter(Year year, QUARTER quarter)
	{
		this.year = year;
		this.quarter = quarter;
	}
	
	public Quarter(Date endDate)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(endDate.getTime());
		if ( c.get(Calendar.MONTH) == Calendar.JANUARY )
		{
			c.add(Calendar.YEAR, -1);
		}
		year = new Year(c.get(Calendar.YEAR));
		quarter = endMonthToQuarter(c.get(Calendar.MONTH));
	}
	
	public Quarter getPrevious()
	{
		switch(quarter)
		{
		case First:
			return new Quarter(new Year(year.getYear()-1), QUARTER.Fourth);
		case Second:
			return new Quarter(new Year(year.getYear()), QUARTER.First);
		case Third:
			return new Quarter(new Year(year.getYear()), QUARTER.Second);
		case Fourth:
			return new Quarter(new Year(year.getYear()), QUARTER.Third);
		}
		throw new RuntimeException();
	}
	
	public Quarter getNext()
	{
		switch(quarter)
		{
		case Fourth:
			return new Quarter(new Year(year.getYear()+1), QUARTER.First);
		case Third:
			return new Quarter(new Year(year.getYear()-1), QUARTER.Fourth);
		case Second:
			return new Quarter(new Year(year.getYear()-1), QUARTER.Third);
		case First:
			return new Quarter(new Year(year.getYear()-1), QUARTER.Second);
		}
		throw new RuntimeException();
	}
	
	private QUARTER endMonthToQuarter(int i)
	{
		if ( i >= Calendar.FEBRUARY && i < Calendar.MAY )
		{
			return QUARTER.First;
		}
		if ( i >= Calendar.MAY && i < Calendar.AUGUST )
		{
			return QUARTER.Second;
		}
		if ( i >= Calendar.AUGUST && i < Calendar.NOVEMBER )
		{
			return QUARTER.Third;
		}
		if ( ( i >= Calendar.NOVEMBER && i <= Calendar.DECEMBER )
			|| i == Calendar.JANUARY )
		{
			return QUARTER.Fourth;
		}
		throw new RuntimeException();
	}

	public String toString()
	{
		return year + " " + quarter + " Quarter";
	}
	
	public Date getStartDate()
	{
		Calendar c = Calendar.getInstance();
		c.set(year.getYear(), getStartMonth(), 1, 0, 0, 0);
		return new Date(c.getTime());
	}
	
	public Date getEndDate()
	{
		Calendar c = Calendar.getInstance();
		c.set(year.getYear(), getEndMonth() + 1, 1,  0, 0, 0);
		c.add(Calendar.DATE, -1);
		return new Date(c.getTime());
	}
	
	public int getEndMonth()
	{
		switch ( quarter )
		{
		case First:
			return Calendar.MARCH;
		case Second:
			return Calendar.JUNE;
		case Third:
			return Calendar.SEPTEMBER;
		case Fourth:
			return Calendar.DECEMBER;
		}
		throw new RuntimeException();
	}
	
	public int getStartMonth()
	{
		switch ( quarter )
		{
		case First:
			return Calendar.JANUARY;
		case Second:
			return Calendar.APRIL;
		case Third:
			return Calendar.JULY;
		case Fourth:
			return Calendar.OCTOBER;
		}
		throw new RuntimeException();
	}
	
	public boolean equals(Object o)
	{
		if ( o == null ) return false;
		if ( ! ( o instanceof Quarter ) )
		{
			return false;
		}
		return quarter.equals(((Quarter)o).quarter) && year.getYear() == ((Quarter)o).year.getYear();		
	}
	
	public int hashCode()
	{
		return quarter.hashCode() * 3 + year.getYear() * 2;
	}
}
