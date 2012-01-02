package com.sbrian.gfinance.scraper;

import java.io.IOException;

public class ScraperCacheException extends Exception
{

	public ScraperCacheException(String string)
	{
		super(string);
	}

	public ScraperCacheException(Exception e)
	{
		super(e);
	}

	private static final long serialVersionUID = -7239381072705961606L;

}
