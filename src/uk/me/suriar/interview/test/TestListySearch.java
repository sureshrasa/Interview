package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.me.suriar.interview.Listy;
import uk.me.suriar.interview.ListySearch;

public class TestListySearch {
	@Test
	public void testEmpty()
	{
		assertEquals(-1, new ListySearch().find(3, new Listy()));
	}
	
	@Test
	public void testOne()
	{
		assertEquals(0, new ListySearch().find(1, new Listy(1)));
	}
	
	@Test
	public void testMany()
	{
		assertEquals(11, new ListySearch().find(72, new Listy(1, 10, 32, 4, 16, 72, 2, 5, 98, 43, 15, 14, 12)));
	}
	
	@Test
	public void testNotInMany()
	{
		assertEquals(-1, new ListySearch().find(17, new Listy(1, 10, 32, 4, 16, 72, 2, 5, 98, 43, 15, 14, 12)));
	}

}
