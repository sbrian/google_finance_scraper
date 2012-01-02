package com.sbrian.gfinance.scraper;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import org.apache.commons.beanutils.BeanUtils;

public abstract class BaseObject
{
	public static BigDecimal ZERO = new BigDecimal("0.00");
	
	public String toString()
	{
		try
		{
			return BeanUtils.describe(this).toString();
		}
		catch (IllegalAccessException e)
		{
			throw new RuntimeException(e);
		}
		catch (InvocationTargetException e)
		{
			throw new RuntimeException(e);
		}
		catch (NoSuchMethodException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public boolean equals(Object o)
	{
		if ( o == null ) return false;
		if ( ! o.getClass().equals(getClass()) ) return false;
		return o.toString().equals(toString());
	}
	
	public int hashCode()
	{
		return toString().hashCode();
	}
}
