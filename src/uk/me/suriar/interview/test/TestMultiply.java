package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.me.suriar.interview.Multiply;

public class TestMultiply {

	@Test
	public void testByZero()
	{
		assertEquals(0, Multiply.eval(2, 0));
	}
	
	@Test
	public void testByOne()
	{
		assertEquals(3, Multiply.eval(3, 1));
	}
	
	@Test
	public void testByEven()
	{
		assertEquals(8, Multiply.eval(4, 2));
	}

	@Test
	public void testByOdd()
	{
		assertEquals(15, Multiply.eval(5, 3));
	}
}
