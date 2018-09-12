package uk.me.suriar.interview.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import uk.me.suriar.interview.StringPerm;

public class TestStringPerm
{
    //@Test
    public void testNull()
    {
	assertNull(new StringPerm().generate(null));
    }

    //@Test
    public void testEmpty()
    {
	final String[] expected = {};
	assertEquals(expected, new StringPerm().generate(""));
    }

    //@Test
    public void testSingle()
    {
	final String[] expected =
	{ "A" };
	assertEquals(expected, new StringPerm().generate("A"));
    }

    //@Test
    public void testTwo()
    {
	final String[] expected =
	{ "AB", "BA" };
	assertEquals(expected, new StringPerm().generate("AB"));
    }

    @Test
    public void testMany()
    {
	final String[] expected =
	{ "ABC", "BAC", "BCA", "ACB", "CAB", "CBA" };
	assertEquals(expected, new StringPerm().generate("ABCDEFGHIJ"));
    }

    private void assertEquals(String[] expected, Collection<String> generated)
    {
	Arrays.sort(expected);
	final Object[] actual = generated.toArray();
	Arrays.sort(actual);
	assertArrayEquals(expected, actual);
    }

    //@Test
    public void testDups()
    {
	final String[] expected =
	{ "ABA", "AAB", "BAA", };
	assertEquals(expected, new StringPerm().generate("ABA"));
    }
}
