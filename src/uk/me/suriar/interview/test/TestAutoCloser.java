package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.AssertionFailedError;
import uk.me.suriar.interview.AutoCloser;

public class TestAutoCloser
{
    private int constructCount = 0;
    private int destructCount = 0;
    
    class Resource
    {
	public Resource()
	{
	    constructCount = 1;
	}
	
	public void destruct()
	{
	    ++destructCount;
	}
    }
    
    @Test
    public void testNull()
    {
	assertNull(AutoCloser.newResource(()->null, Resource::destruct));
    }
    
    @Test
    public void testNonNull() throws Exception
    {
	try(AutoCloser<Resource> acR = AutoCloser.newResource(Resource::new, Resource::destruct))
	{
	    assertNotNull(acR);
	    
	    Resource r = acR.getResource();
	    
	    assertEquals(1, constructCount);
	}
	assertEquals(1, destructCount);
    }
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
   @Test
    public void testThrow() throws Exception
    {
	thrown.expect(InvalidParameterException.class);
	try(AutoCloser<Resource> acR = AutoCloser.newResource(()->{throw new InvalidParameterException();}, Resource::destruct))
	{
	    assertFalse(true);
	}
	finally
	{
	    assertEquals(0, constructCount);
	    assertEquals(0, destructCount);
	}
    }
}
