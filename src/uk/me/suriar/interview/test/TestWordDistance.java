package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.me.suriar.interview.WordDistance;

public class TestWordDistance
{
    @Test
    public void testEmpty()
    {
	assertEquals(-1, new WordDistance().find("", "", new String[] {}));
    }
    
    @Test
    public void testMissingInEmpty()
    {
	assertEquals(-1, new WordDistance().find("hello", "world", new String[] {}));
    }

    @Test
    public void testSameWord()
    {
	assertEquals(-1, new WordDistance().find("hello", "hello", new String[] {"hello", "world", "hello"}));
    }
    
    @Test
    public void testTwo()
    {
	assertEquals(0, new WordDistance().find("hello", "world", new String[] {"hello", "world"}));
    }
    
    @Test
    public void testMany()
    {
	assertEquals(0, new WordDistance().find("hello", "world", new String[] {"hello", "cruel", "world", "hello", "friend"}));
	assertEquals(0, new WordDistance().find("cruel", "world", new String[] {"hello", "cruel", "world", "cruel", "dear", "friend"}));
	assertEquals(0, new WordDistance().find("cruel", "world", new String[] {"hello", "cruel", "cold", "world", "cruel", "dear", "friend", "world"}));
	assertEquals(0, new WordDistance().find("a", "b", new String[] {"b", "b", "a", "b", "a", "a", "b", "a", "c", "a"}));
    }
}
