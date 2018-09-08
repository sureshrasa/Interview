package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.me.suriar.interview.LetterNumberSequence;

public class TestLetterNumberSequence
{
    @Test
    public void testEmpty()
    {
	assertEquals("", new LetterNumberSequence().find(""));
	assertEquals("", new LetterNumberSequence().find("abc"));
	assertEquals("", new LetterNumberSequence().find("123"));
    }
    
    @Test
    public void testSimplePair()
    {
	assertEquals("a1", new LetterNumberSequence().find("a1"));
	assertEquals("1a", new LetterNumberSequence().find("1a"));
    }
    
    @Test
    public void testAtStart()
    {
	assertEquals("123abc", new LetterNumberSequence().find("123abcxxx12"));
	assertEquals("abc123", new LetterNumberSequence().find("abc123xxxab"));
    }

    @Test
    public void testAtEnd()
    {
	assertEquals("123abc", new LetterNumberSequence().find("x1x222123abc"));
	assertEquals("abc123", new LetterNumberSequence().find("12xxxabc123"));
    }

    @Test
    public void testAtMiddle()
    {
	assertEquals("123abc", new LetterNumberSequence().find("123123abc1234"));
	assertEquals("abc123", new LetterNumberSequence().find("xxxxabc123xxxxx"));
    }
    
    @Test
    public void testComplex()
    {
	assertEquals("1bc2def123k7", new LetterNumberSequence().find("a1bc2def123k7"));
	assertEquals("123abc", new LetterNumberSequence().find("123abc"));
	assertEquals("abc123", new LetterNumberSequence().find("abc123"));
    }
    
    @Test
    public void testManyEquals()
    {
	assertEquals("a1", new LetterNumberSequence().find("a1xxb2xxc3xxd4xxe5xxf6"));
	assertEquals("0a", new LetterNumberSequence().find("0axx1bxx2cxx3dxx4exx5f"));
    }
    
    @Test
    public void testBadChars()
    {
	assertEquals("", new LetterNumberSequence().find("a1..b2--c3==d4++e5//f6"));
    }
}
