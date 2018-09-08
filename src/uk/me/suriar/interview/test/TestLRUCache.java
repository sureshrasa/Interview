package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import uk.me.suriar.interview.LRUCache;

public class TestLRUCache
{
    @Test
    public void testEmpty()
    {
	assertTrue(new LRUCache<Integer, String>().isEmpty());
    }

    @Test
    public void testAdd()
    {
	final LRUCache<Integer, String> cache = new LRUCache<>();

	cache.put(Integer.valueOf(2), "Hello");
	cache.put(Integer.valueOf(3), "World");

	assertFalse(cache.isEmpty());
	assertEquals("Hello", cache.get(Integer.valueOf(2)));
	assertEquals("World", cache.get(Integer.valueOf(3)));
	assertNull(cache.get(Integer.valueOf(4)));

	cache.put(Integer.valueOf(2), "Hola");
	assertEquals("Hola", cache.get(Integer.valueOf(2)));
    }

    @Test
    public void testCapacity()
    {
	final LRUCache<Integer, String> cache = new LRUCache<>(2);

	cache.put(Integer.valueOf(2), "Hello");
	cache.put(Integer.valueOf(3), "World");

	assertFalse(cache.isEmpty());
	assertEquals("Hello", cache.get(Integer.valueOf(2)));
	assertEquals("World", cache.get(Integer.valueOf(3)));
	assertEquals("Hello", cache.get(Integer.valueOf(2)));
	cache.put(Integer.valueOf(4), "Universe");
	assertNull(cache.get(Integer.valueOf(3)));
	assertEquals("Universe", cache.get(Integer.valueOf(4)));
    }
}
