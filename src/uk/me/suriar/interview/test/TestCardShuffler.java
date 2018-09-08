package uk.me.suriar.interview.test;

import org.junit.Test;

import uk.me.suriar.interview.CardShuffler;

public class TestCardShuffler
{
    @Test
    public void testShuffle()
    {
	System.out.println(new CardShuffler().shuffle(52));
    }
}
