package com.sbrian.gfinance.scraper;

import java.util.Calendar;

public class HalfYear extends ReportTime
{
	public enum HALF_YEAR {
		First, Second
	}
	
	private HALF_YEAR half;
	private Year year;
	
	public HalfYear(Year year, HALF_YEAR half)
	{
		this.year = year;
		this.half = half;
	}
	
	public HalfYear(Date endDate)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(endDate.getTime());
		if ( c.get(Calendar.MONTH) == Calendar.JANUARY )
		{
			c.add(Calendar.YEAR, -1);
		}
		year = new Year(c.get(Calendar.YEAR));
		half = endMonthToQuarter(c.get(Calendar.MONTH));
	}
	
	public HalfYear getPrevious()
	{
		switch(half)
		{
		case First:
			return new HalfYear(new Year(year.getYear()-1), HALF_YEAR.Second);
		case Second:
			return new HalfYear(new Year(year.getYear()), HALF_YEAR.First);
		}
		throw new RuntimeException();
	}
	
	public HalfYear getNext()
	{
		switch(half)
		{
		case Second:
			return new HalfYear(new Year(year.getYear()+1), HALF_YEAR.First);
		case First:
			return new HalfYear(new Year(year.getYear()-1), HALF_YEAR.Second);
		}
		throw new RuntimeException();
	}
	
	private HALF_YEAR endMonthToQuarter(int i)
	{
		if ( i >= Calendar.FEBRUARY && i < Calendar.AUGUST )
		{
			return HALF_YEAR.First;
		}
		if ( ( i >= Calendar.AUGUST && i <= Calendar.DECEMBER )
			|| i == Calendar.JANUARY )
		{
			return HALF_YEAR.Second;
		}
		throw new RuntimeException();
	}

	public String toString()
	{
		return year + " " + half + " Half";
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
		switch ( half )
		{
		case First:
			return Calendar.JUNE;
		case Second:
			return Calendar.DECEMBER;
		}
		throw new RuntimeException();
	}
	
	public int getStartMonth()
	{
		switch ( half )
		{
		case First:
			return Calendar.JANUARY;
		case Second:
			return Calendar.JULY;
		}
		throw new RuntimeException();
	}
	
	public boolean equals(Object o)
	{
		if ( o == null ) return false;
		if ( ! ( o instanceof HalfYear ) )
		{
			return false;
		}
		return half.equals(((HalfYear)o).half) && year.getYear() == ((HalfYear)o).year.getYear();		
	}
	
	public int hashCode()
	{
		return half.hashCode() * 3 + year.getYear() * 2;
	}
}
