package com.sbrian.gfinance.scraper;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class SimpleMap<K, V> implements Map<K, V>
{

		public void clear()
		{
			throw new RuntimeException("Not implemented");
		}

		public abstract boolean containsKey(Object key);

		public boolean containsValue(Object value)
		{
			throw new RuntimeException("Not implemented");
		}

		public Set<java.util.Map.Entry<K, V>> entrySet()
		{
			throw new RuntimeException("Not implemented");
		}

		public abstract V get(Object key);

		public boolean isEmpty()
		{
			throw new RuntimeException("Not implemented");
		}

		public Set<K> keySet()
		{
			throw new RuntimeException("Not implemented");
		}

		public Percentage put(String key, V value)
		{
			throw new RuntimeException("Not implemented");
		}

		public void putAll(Map<? extends K, ? extends V> m)
		{
			throw new RuntimeException("Not implemented");	
		}

		public V remove(Object key)
		{
			throw new RuntimeException("Not implemented");	
		}

		public int size()
		{
			throw new RuntimeException("Not implemented");	
		}

		public Collection<V> values()
		{
			throw new RuntimeException("Not implemented");	
		}
}
