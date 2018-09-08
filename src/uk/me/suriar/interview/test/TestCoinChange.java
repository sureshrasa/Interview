package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uk.me.suriar.interview.CoinChange;

public class TestCoinChange
{
    @Test
    public void testZeroCents()
    {
	assertEquals(0, new CoinChange().compute(0));
    }

    @Test
    public void test1Cent()
    {
	assertEquals(1, new CoinChange().compute(1));
    }

    @Test
    public void test4Cents()
    {
	assertEquals(1, new CoinChange().compute(4));
    }

    @Test
    public void test5Cents()
    {
	assertEquals(2, new CoinChange().compute(5));
    }

    @Test
    public void test10Cents()
    {
	// [10], [5,5], [5,1,1,1,1,1], [1..1]
	assertEquals(4, new CoinChange().compute(10));
    }

    @Test
    public void test25Cents()
    {
	// [25],
	// [10,10,5], [10,10,1..1],
	// [10,5,5,5], [10,5,5,1..1], [10,5,1..1,1..1], [10, 1..1,1..1,1..1],
	// [5,5,5,5,5],
	// [5,5,5,5,1..1], [5,5,5,1..1,1..1], [5,5,1..1,1..1,1..1],
	// [5,1..1,1..1,1..1,1..1],
	// [1..1,1..1,1..1,1..1,1..1]
	assertEquals(13, new CoinChange().compute(25));
    }

    @Test
    public void test30Cents()
    {
	assertEquals(13, new CoinChange().compute(1000));
    }
}
