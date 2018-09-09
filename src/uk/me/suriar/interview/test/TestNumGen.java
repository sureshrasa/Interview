package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.me.suriar.interview.NumGen;

public class TestNumGen
{
    @Test
    public void testZero()
    {
	assertEquals(1, new NumGen().generate(0));
    }
    
    @Test
    public void testOne()
    {
	assertEquals(3, new NumGen().generate(1));
	assertEquals(5, new NumGen().generate(2));
	assertEquals(7, new NumGen().generate(3));
    }

    @Test
    public void testBigO()
    {
	assertEquals(597871125, new NumGen().generate(550));
    }

}
