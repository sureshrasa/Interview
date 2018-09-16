package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;

import java.util.logging.Level;

import org.junit.Before;
import org.junit.Test;

import com.sun.media.jfxmedia.logging.Logger;

import uk.me.suriar.interview.MajorityElementFinder;

public class TestMajorityElementFinder
{
    //@Before
    public void setup()
    {
	java.util.logging.Logger.getLogger(MajorityElementFinder.class.getName()).setLevel(Level.WARNING);
    }
    
    @Test
    public void testEmpty()
    {
	assertEquals(-1, new MajorityElementFinder().find(new int[] {}));
    }
    
    @Test
    public void testOne()
    {
	assertEquals(1, new MajorityElementFinder().find(new int[] {1}));
    }
    
    @Test
    public void testTwoMissing()
    {
	assertEquals(-1, new MajorityElementFinder().find(new int[] {1, 2}));
    }
    
    @Test
    public void testTwoFull()
    {
	assertEquals(2, new MajorityElementFinder().find(new int[] {2, 2}));
    }
    
    @Test
    public void testManyMissing()
    {
	assertEquals(-1, new MajorityElementFinder().find(new int[] {1, 2, 3, 5, 2, 9, 2, 5, 2}));
    }
    
    @Test
    public void testManyPresentEarly()
    {
	assertEquals(2, new MajorityElementFinder().find(new int[] {1, 2, 2, 5, 2, 9, 2, 5, 2}));
    }
    
    @Test
    public void testManyPresentLater()
    {
	java.util.logging.Logger.getLogger(MajorityElementFinder.class.getName()).setLevel(Level.INFO);
	assertEquals(2, new MajorityElementFinder().find(new int[] {9, 3, 1, 5, 2, 2, 2, 2, 2}));
    }
}
