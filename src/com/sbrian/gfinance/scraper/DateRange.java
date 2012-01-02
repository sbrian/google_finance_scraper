package com.sbrian.gfinance.scraper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateRange
{
	private Date start;
	private Date end;

	public Date getStart()
	{
		return start;
	}

	public Date getEnd()
	{
		return end;
	}

	public DateRange(Date start, Date end)
	{
		super();
		this.start = start;
		this.end = end;
		
		// DO THIS EARLY, TO CONFIRM WE CAN.
		periodInMonths();
	}
	
	public static DateRange parse(String dateRangeString) throws ParseException
	{
		//System.err.println(dateRangeString);
		Matcher match1 = Pattern.compile("^([0-9]+) months ending ([0-9]{4}-[0-9]{2}-[0-9]{2})$")
			.matcher(dateRangeString);
		if ( match1.matches() )
		{
			Date d = new Date(
					DateUtils.padToEndOfMonth(new SimpleDateFormat("yyyy-MM-dd").parse(match1.group(2))));
			Calendar c = Calendar.getInstance();
			c.setTime(d.getTime());
			c.add(Calendar.MONTH, Integer.parseInt("-" + match1.group(1)));
			DateUtils.padToEndOfMonth(c);
			return new DateRange(new Date(c.getTime()), d);
		}
		Matcher match2 = Pattern.compile(
				"^([0-9]+) weeks ending ([0-9]{4}-[0-9]{2}-[0-9]{2})$")
				.matcher(dateRangeString);
		if (match2.matches())
		{
			Date d = new Date(new SimpleDateFormat(
					"yyyy-MM-dd").parse(match2.group(2)));
			Calendar c = Calendar.getInstance();
			c.setTime(d.getTime());
			c.add(Calendar.DAY_OF_YEAR, Integer.parseInt("-"
					+ (Integer.parseInt(match2.group(1)) * 7)));
			//System.err.println("Before padding: " +c.getTime());
			DateUtils.padToEndOfMonth(c);
			//System.err.println("After padding: " +c.getTime());
			d = new Date(DateUtils.padToEndOfMonth(d.getTime()));
			return new DateRange(new Date(c.getTime()), d);
		}
		throw new ParseException("Unable to parse '" + dateRangeString + "'", 0);
	}

	public boolean equals(Object o)
	{
		if ( o == null ) return false;
		if ( ! ( o instanceof DateRange ) )
		{
			return false;
		}
		DateRange d = (DateRange) o;
		return d.getStart().equals(getStart()) && d.getEnd().equals(getEnd());
	}
	
	public int hashCode()
	{
		return getStart().hashCode() * 2 + getEnd().hashCode() * 3;
	}
	
	public String toString()
	{
		return getStart().toString() + " to " + getEnd().toString();
	}
	
	public int periodInMonths()
	{
		//System.err.println("Figure out range of " + start + " to " + end);
		for( int x=1; x<20; x++ )
		{
			Calendar c = Calendar.getInstance();
			c.setTime(start.getTime());
			c.add(Calendar.MONTH, x);
			DateUtils.padToEndOfMonth(c);
			if ( c.getTime().equals(end.getTime()) )
			{
				return x;
			}
		}
		throw new RuntimeException("Couldn't figure out period in months");
	}
	
	public DateRange subtract(DateRange d)
	{
		if (!d.getStart().equals(getStart()))
		{
			throw new RuntimeException("Must have same start date");
		}
		if (d.periodInMonths() >= periodInMonths())
		{
			throw new RuntimeException(
					"Subtracted value must have higher end date");
		}
		Calendar c = Calendar.getInstance();
		c.setTime(getStart().getTime());
		c.add(Calendar.MONTH, d.periodInMonths());
		DateUtils.padToEndOfMonth(c);
		return new DateRange(new Date(c.getTime()), getEnd());
	}
}
