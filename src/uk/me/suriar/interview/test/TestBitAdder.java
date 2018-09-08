package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.me.suriar.interview.BitAdder;

public class TestBitAdder
{
    @Test
    public void testAddZero()
    {
	assertEquals(12, new BitAdder().add(12, 0));
    }

    @Test
    public void testAddOne()
    {
	assertEquals(12, new BitAdder().add(11, 1));
    }

    @Test
    public void testAddMany()
    {
	assertEquals(1021 + 101, new BitAdder().add(1021, 101));
    }
}
