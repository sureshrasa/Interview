package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.me.suriar.interview.LangtonAnt;
import uk.me.suriar.interview.LangtonAnt.Point;

public class TestLangtonAnt
{
    private LangtonAnt langtonAnt = new LangtonAnt();

    @Test
    public void testZero()
    {
	assertEquals("[]", langtonAnt.walkBlacks(0));
	assertEquals(new Point(0, 0), langtonAnt.getTopLeft());
	assertEquals(new Point(0, 0), langtonAnt.getBotRight());
    }

    @Test
    public void testOne()
    {
	assertEquals("[(0,0)]", langtonAnt.walkBlacks(1));
	assertEquals(new Point(0, 1), langtonAnt.getTopLeft());
	assertEquals(new Point(0, 0), langtonAnt.getBotRight());
    }

    @Test
    public void testTwo()
    {
	assertEquals("[(0,1), (0,0)]", langtonAnt.walkBlacks(2));
	assertEquals(new Point(0, 1), langtonAnt.getTopLeft());
	assertEquals(new Point(1, 0), langtonAnt.getBotRight());
    }

    @Test
    public void test4()
    {
	assertEquals("[(0,1), (1,1), (0,0), (1,0)]", langtonAnt.walkBlacks(4));
	assertEquals(new Point(0, 1), langtonAnt.getTopLeft());
	assertEquals(new Point(1, 0), langtonAnt.getBotRight());
    }

    @Test
    public void test5()
    {
	assertEquals("[(0,1), (1,1), (1,0)]", langtonAnt.walkBlacks(5));
	assertEquals(new Point(0, 1), langtonAnt.getTopLeft());
	assertEquals(new Point(1, -1), langtonAnt.getBotRight());
    }

    @Test
    public void test6()
    {
	assertEquals("[(0,1), (1,1), (1,0), (0,-1)]", langtonAnt.walkBlacks(6));
	assertEquals(new Point(-1, 1), langtonAnt.getTopLeft());
	assertEquals(new Point(1, -1), langtonAnt.getBotRight());
    }

    @Test
    public void testMany()
    {
	assertEquals(
		"[(0,1), (1,1), (-1,0), (-1,-1), (1,-1), (2,-1), (3,-1), (0,-2), (1,-2), (2,-2), (3,-2), (1,-3), (2,-3)]",
		langtonAnt.walkBlacks(29));
	assertEquals(new Point(-1, 1), langtonAnt.getTopLeft());
	assertEquals(new Point(3, -3), langtonAnt.getBotRight());
    }

    @Test
    public void testPrint()
    {
	langtonAnt.print(101);
    }
}
