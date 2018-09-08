package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.me.suriar.interview.NSteps;

public class TestNSteps
{

    @Test
    public void test1Step()
    {
	assertEquals(1, new NSteps().count(1));
    }

    @Test
    public void test2Steps()
    {
	assertEquals(2, new NSteps().count(2));
    }

    @Test
    public void test3Steps()
    {
	// 3 | 2,1 | 1,2 | 1,1,1
	assertEquals(4, new NSteps().count(3));
    }

    @Test
    public void test4Steps()
    {
	// 3,1 | 2,2 | 2,1,1 | 1,3 | 1,2,1 | 1,1,2 | 1,1,1,1
	assertEquals(7, new NSteps().count(4));
    }

    @Test
    public void testLargeSteps()
    {
	assertEquals(53798080, new NSteps().count(30));
    }

}
