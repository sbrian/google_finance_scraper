package com.sbrian.gfinance.scraper;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Year extends ReportTime
{
	private int year;
	
	public Year(int year)
	{
		this.setYear(year);
	}

	public Year getNext()
	{
		return new Year(year + 1);
	}
	
	public Year getPrevious()
	{
		return new Year(year - 1);
	}
	
	public void setYear(int year)
	{
		this.year = year;
	}

	public int getYear()
	{
		return year;
	}
	
	public String toString()
	{
		return String.valueOf(year);
	}
	
	public Date getStartDate()
	{
		try
		{
			return new Date(new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(year + "-01-01")));
		}
		catch (ParseException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public Date getEndDate()
	{
		try
		{
			return new Date(new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(year + "-12-31")));
		}
		catch (ParseException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public boolean equals(Object o)
	{
		if ( o == null ) return false;
		if ( ! ( o instanceof Year ) )
		{
			return false;
		}
		return year == ((Year)o).year;	
	}
	
	public int hashCode()
	{
		return year;
	}
}
