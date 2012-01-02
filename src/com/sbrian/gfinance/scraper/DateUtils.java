package com.sbrian.gfinance.scraper;

import java.util.Calendar;
import java.util.Date;

public class DateUtils
{
	public static Date findLatestPreviousDateInBusinessWeek(Date date)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		while ( c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
			c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY )
		{
			c.add(Calendar.DATE, -1);
		}
		return c.getTime();	
	}

	public static Date padToEndOfMonth(Date d)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		padToEndOfMonth(c);
		return c.getTime();
	}
	
	public static void padToEndOfMonth(Calendar c)
	{
		if ( c.get(Calendar.DATE) < 15 )
		{
			// Pad to the end of the month
			int monthNow = c.get(Calendar.MONTH);
			while( c.get(Calendar.MONTH) == monthNow )
			{
				c.add(Calendar.DATE, -1);
			}
			return;
		}
		
		// Pad to the end of the month
		int monthNow = c.get(Calendar.MONTH);
		while( c.get(Calendar.MONTH) == monthNow )
		{
			c.add(Calendar.DATE, 1);
		}
		c.add(Calendar.DATE, -1);
	}
}
