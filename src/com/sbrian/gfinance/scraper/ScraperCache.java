package com.sbrian.gfinance.scraper;

import java.util.Set;

public interface ScraperCache
{
	public void cache(String symbol, String data) throws ScraperCacheException;
	
	public Set<String> getAllFromCache(String symbol) throws ScraperCacheException;
}
