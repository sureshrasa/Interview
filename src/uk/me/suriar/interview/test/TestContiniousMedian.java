package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import uk.me.suriar.interview.ContiniousMedian;

public class TestContiniousMedian
{
    @Test
    public void testEmpty()
    {
	assertNull(new ContiniousMedian().getMedian());
    }
    
    @Test
    public void testOne()
    {
	final ContiniousMedian continiousMedian = new ContiniousMedian();
	continiousMedian.add(Double.valueOf(2));
	assertEquals(Double.valueOf(2), continiousMedian.getMedian());
    }
    
    @Test
    public void testEven()
    {
	final ContiniousMedian continiousMedian = new ContiniousMedian();
	continiousMedian.add(2.0);
	continiousMedian.add(3.0);
	assertEquals(Double.valueOf(2.5), continiousMedian.getMedian());
    }
    
    @Test
    public void testOdd()
    {
	final ContiniousMedian continiousMedian = new ContiniousMedian();
	continiousMedian.add(5.0);
	continiousMedian.add(2.0);
	continiousMedian.add(3.0);
	assertEquals(Double.valueOf(3.0), continiousMedian.getMedian());
    }
    
    @Test
    public void testLeftBalancing()
    {
	final ContiniousMedian continiousMedian = new ContiniousMedian();
	continiousMedian.add(7.0);
	continiousMedian.add(5.0);
	continiousMedian.add(3.0);
	continiousMedian.add(2.0);
	continiousMedian.add(1.0);
	assertEquals(Double.valueOf(3.0), continiousMedian.getMedian());
    }
    
    @Test
    public void testRightBalancing()
    {
	final ContiniousMedian continiousMedian = new ContiniousMedian();
	continiousMedian.add(1.0);
	continiousMedian.add(2.0);
	continiousMedian.add(3.0);
	continiousMedian.add(5.0);
	continiousMedian.add(7.0);
	assertEquals(Double.valueOf(3.0), continiousMedian.getMedian());
    }
}
