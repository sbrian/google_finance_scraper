package com.sbrian.gfinance.scraper;

import java.math.BigDecimal;

public class Percentage
{
	public static BigDecimal HUNDRED = new BigDecimal("100");
	
	private BigDecimal delegate;
	
	public Percentage(BigDecimal bigDecimal)
	{
		this.delegate = bigDecimal;
	}
	
	public String toString()
	{
		return delegate.multiply(HUNDRED).toString();
	}
}
