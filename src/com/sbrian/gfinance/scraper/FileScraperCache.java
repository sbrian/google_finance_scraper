package com.sbrian.gfinance.scraper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.CRC32;

import org.apache.commons.io.IOUtils;

public class FileScraperCache implements ScraperCache
{
	File cacheDir;
	
	public FileScraperCache(File cacheDir)
	{
		this.cacheDir = cacheDir;
	}
	
	public void cache(String symbol, String data) throws ScraperCacheException
	{
		symbol = symbol.toUpperCase();
		try
		{
			_cache(symbol, data);
		}
		catch(IOException e)
		{
			throw new ScraperCacheException(e);
		}
	}
	
	private void _cache(String symbol, String data) throws IOException,
			ScraperCacheException
	{
		File target = new File(getPath(symbol, true).getPath()
				+ File.separator
				+ new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()) + ".html");
		FileWriter f = new FileWriter(target);
		IOUtils.write(data, f);
		IOUtils.closeQuietly(f);
	}

	public Set<String> getAllFromCache(String symbol) throws ScraperCacheException
	{
		try
		{
			return _getAllFromCache(symbol);
		}
		catch(IOException e)
		{
			throw new ScraperCacheException(e);
		}
	}
	
	
	/**
	 * Guaranteed to return in ascending date order.
	 * 
	 * @param symbol
	 * @return
	 * @throws ScraperCacheException
	 * @throws IOException
	 */
	private Set<String> _getAllFromCache(String symbol) throws ScraperCacheException, IOException
	{
		Set<String> ret = new HashSet<String>();
		File dir = getPath(symbol, false);
		if (!dir.isDirectory())
		{
			return ret;
		}
		String[] files = dir.list(new FilenameFilter()
		{
			public boolean accept(File dir, String name)
			{
				return name.matches(".*\\.html$");
			}
		});
		
		Arrays.sort(files);
		
		for ( int n=0; n<files.length; n++ )
		{
			ret.add(IOUtils.toString(new FileInputStream(new File(dir, files[n]))));
		}
		return ret;
	}
	
	private File getPath(String symbol, boolean create) throws IOException,
		ScraperCacheException
	{
		if (create && !cacheDir.isDirectory())
		{
			if (!cacheDir.mkdir())
				throw new ScraperCacheException("Can't make: "
						+ cacheDir.toString());
		}
		CRC32 crc32 = new CRC32();
		crc32.update(symbol.getBytes());
		File subdir = new File(cacheDir.getPath() + File.separator
				+ crc32.getValue());
		if (create && !subdir.isDirectory())
		{
			if (!subdir.mkdir())
				throw new ScraperCacheException("Can't make: "
						+ cacheDir.toString());
		}
		subdir = new File(subdir.getPath() + File.separator
				+ symbol.replace(":", "_"));
		if (create && !subdir.isDirectory())
		{
			if (!subdir.mkdir())
				throw new ScraperCacheException("Can't make: "
						+ cacheDir.toString());
		}
		return subdir;
	}
}
