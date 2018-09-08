package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.me.suriar.interview.MissingNumber;
import uk.me.suriar.interview.MissingNumberA;
import uk.me.suriar.interview.MissingNumberB;
import uk.me.suriar.interview.NumberArray;

public class TestMissingNumber
{
    private static MissingNumber createMissingNumber()
    {
	// return new MissingNumberA();
	return new MissingNumberB();
    }

    @Test
    public void testMissingEvenInEven()
    {
	assertEquals(4, createMissingNumber().detect(new NumberArray(8, 4)));
	assertEquals(2, createMissingNumber().detect(new NumberArray(6, 2)));
    }

    @Test
    public void testMissingOddInEven()
    {
	assertEquals(3, createMissingNumber().detect(new NumberArray(8, 3)));
	assertEquals(5, createMissingNumber().detect(new NumberArray(6, 5)));
    }

    @Test
    public void testMissingEvenInOdd()
    {
	assertEquals(4, createMissingNumber().detect(new NumberArray(7, 4)));
	assertEquals(2, createMissingNumber().detect(new NumberArray(5, 2)));
    }

    @Test
    public void testMissingOddInOdd()
    {
	assertEquals(3, createMissingNumber().detect(new NumberArray(13, 3)));
	assertEquals(7, createMissingNumber().detect(new NumberArray(11, 7)));
    }
}
