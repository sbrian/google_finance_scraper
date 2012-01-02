package com.sbrian.gfinance.scraper;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public class Subtractable extends BaseObject
{
	private DateRange dateRange;
	
	public DateRange getDateRange()
	{
		return dateRange;
	}
	public void setDateRange(DateRange dateRange)
	{
		this.dateRange = dateRange;
	}
	
	public Subtractable subtract(Subtractable c)
	{
		try
		{
			return _subtract(c);
		}
		catch (IllegalArgumentException e)
		{
			throw new RuntimeException(e);
		}
		catch (IntrospectionException e)
		{
			throw new RuntimeException(e);
		}
		catch (IllegalAccessException e)
		{
			throw new RuntimeException(e);
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(e);
		}
		catch (InstantiationException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	private Subtractable _subtract(Subtractable c) throws IntrospectionException,
			IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, InstantiationException
	{
		Subtractable nc = (Subtractable)getClass().newInstance();
		nc.setDateRange(getDateRange().subtract(c.getDateRange()));
		PropertyDescriptor[] p = Introspector.getBeanInfo(this.getClass())
				.getPropertyDescriptors();
		for (int x = 0; x < p.length; x++)
		{
			if (!p[x].getPropertyType().equals(BigDecimal.class))
			{
				continue;
			}
			if ( p[x].getWriteMethod() == null )
			{
				continue;
			}
			BigDecimal tv = (BigDecimal) p[x].getReadMethod().invoke(this);
			BigDecimal cv = (BigDecimal) p[x].getReadMethod().invoke(c);
			p[x].getWriteMethod().invoke(nc, tv.subtract(cv));
		}
		return nc;
	}
}
