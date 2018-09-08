package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.me.suriar.interview.NumberArray;

public class TestNumberArray
{
    @Test
    public void testGetBit()
    {
	assertEquals(1, new NumberArray(6, 3).getBit(1, 0));

	assertEquals(0, new NumberArray(6, 3).getBit(3, 0));
	assertEquals(0, new NumberArray(6, 3).getBit(3, 1));
	assertEquals(1, new NumberArray(6, 3).getBit(3, 2));

	assertEquals(0, new NumberArray(6, 3).getBit(5, 0));
	assertEquals(1, new NumberArray(6, 3).getBit(5, 1));
	assertEquals(1, new NumberArray(6, 3).getBit(5, 2));
    }
}
