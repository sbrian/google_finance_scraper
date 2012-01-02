package com.sbrian.gfinance.scraper;

public class Stock
{
	private String symbol;
	
	public Stock(String symbol)
	{
		if ( symbol.indexOf(":") == -1 )
		{
			throw new RuntimeException("Must specify exchange with :");
		}
		this.symbol = symbol.toUpperCase().trim();
	}
	
	public String getSymbol()
	{
		return symbol;
	}
}
