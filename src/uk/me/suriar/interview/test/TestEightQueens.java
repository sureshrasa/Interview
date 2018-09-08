package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.me.suriar.interview.EightQueens;

public class TestEightQueens
{
    @Test
    public void test8X8()
    {
	assertEquals("", new EightQueens().generate(8, 8).toString());
	// .stream().collect(Collector.of(StringBuilder::new, StringBuilder::append,
	// (l,r)->{l.append(r); return l;})))
    }
}
