package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.me.suriar.interview.SmallestK;

public class TestSmallestK
{
    //@Test
    public void testOne()
    {
	assertEquals(1, new SmallestK().find(new int[] { 1 }, 0));
    }
    
    //@Test
    public void testTwo()
    {
	assertEquals(1, new SmallestK().find(new int[] { 3, 1 }, 0));
    }
    
    //@Test
    public void testMany()
    {
	assertEquals(4, new SmallestK().find(new int[] { 4, 2, 3, 1 }, 3));
	assertEquals(4, new SmallestK().find(new int[] { 9, 5, 12, 15, 6, 3, 2, 4, 1 }, 3));
    }
    
    @Test
    public void testDups()
    {
	assertEquals(2, new SmallestK().find(new int[] { 9, 3, 6, 1, 3, 2, 4, 3, 1 }, 2));
	assertEquals(3, new SmallestK().find(new int[] { 9, 3, 6, 1, 3, 2, 4, 3, 1 }, 5));
	assertEquals(6, new SmallestK().find(new int[] { 9, 3, 6, 1, 3, 2, 4, 3, 1 }, 7));
    }
}
