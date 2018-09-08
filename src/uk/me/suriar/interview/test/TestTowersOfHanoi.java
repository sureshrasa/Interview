package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.me.suriar.interview.Tower;
import uk.me.suriar.interview.TowersOfHanoi;

public class TestTowersOfHanoi {
	@Test
	public void testOneRing()
	{
		assertEquals("{[A][][]}{[][][A]}",
				TowersOfHanoi.move(new Tower("A"), new Tower(), new Tower()));
	}
	
	@Test
	public void testTwoRings()
	{
		assertEquals("{[BA][][]}{[A][B][]}{[][B][A]}{[][][BA]}",
				TowersOfHanoi.move(new Tower("A","B"), new Tower(), new Tower()));
	}
	
	@Test
	public void test5Rings()
	{
		assertEquals("{[BA][][]}{[A][B][]}{[][B][A]}{[][][BA]}",
				TowersOfHanoi.move(new Tower("E","D","C","B","A"), new Tower(), new Tower()));
	}
}
