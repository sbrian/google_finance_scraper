package com.sbrian.gfinance.scraper;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ParsedItems
{
	List<ParsedItem> list = new LinkedList<ParsedItem>();
	
	public void add(ParsedItem parsedItem)
	{
		list.add(parsedItem);
	}
	
	public int size()
	{
		return list.size();
	}
	
	public ParsedItem get(int pos)
	{
		return list.get(pos);
	}
	
	public Iterator iterator()
	{
		return list.iterator();
	}
	
	public void merge(ParsedItems parsedItems)
	{
		for( ParsedItem p : parsedItems.list )
		{
			ParsedItem matchingItem = findMatching(p);
			if ( matchingItem != null )
			{
				list.remove(matchingItem);
			}
			list.add(p);
		}
	}
	
	private ParsedItem findMatching(ParsedItem parsedItem)
	{
		for( ParsedItem p : list )
		{
			if ( p.getType().equals(parsedItem.getType())
				&& p.getDate().equals(parsedItem.getDate()) )
			{
				return p;
			}
		}
		return null;
	}
}