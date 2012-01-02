package com.sbrian.gfinance.scraper;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Date implements Comparable<Date>
{
	java.util.Date underlying;
	
	public Date(java.util.Date date)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		underlying = c.getTime();
	}
	
	public java.util.Date getTime()
	{
		return underlying;
	}
	
	public boolean equals(Object date)
	{
		if ( date == null ) return false;
		if ( ! ( date instanceof Date ) )
		{
			return false;
		}
		return ((Date)date).getTime().equals(underlying);
	}
	
	public int hashCode()
	{
		return underlying.hashCode();
	}

	public int compareTo(Date date)
	{
		return underlying.compareTo(date.getTime());
	}
	
	public String toString()
	{
		return new SimpleDateFormat("yyyy-MM-dd").format(underlying);
	}
}
