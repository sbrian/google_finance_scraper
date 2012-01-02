package com.sbrian.gfinance.scraper;

import java.util.LinkedHashMap;
import java.util.Set;

public class ParsedItem
{
	private String date;
	private String type;
	
	private LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
	
	public void setDate(String date)
	{
		this.date = date;
	}
	public String getDate()
	{
		return date;
	}
	public void setType(String type)
	{
		this.type = type;
	}
	public String getType()
	{
		return type;
	}
	public void put(String key, String value)
	{
		map.put(key, value);
	}
	public String get(String key)
	{
		return map.get(key);
	}
	public Set<String> keySet()
	{
		return map.keySet();
	}
}
