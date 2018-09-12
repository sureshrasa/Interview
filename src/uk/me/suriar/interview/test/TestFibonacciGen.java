package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import uk.me.suriar.interview.FibonacciGen;

public class TestFibonacciGen
{
    @Test
    public void testNegative()
    {
	assertEquals(-1, new FibonacciGen().get(-1));
    }
    
    @Test
    public void testZero()
    {
	assertEquals(1, new FibonacciGen().get(0));
    }
    
    @Test
    public void testOne()
    {
	assertEquals(1, new FibonacciGen().get(1));
    }
    
    @Test
    public void testTwo()
    {
	assertEquals(2, new FibonacciGen().get(2));
    }
    
    @Test
    public void testCaching()
    {
	assertEquals(1346269, new FibonacciGen().get(30));
    }
}
