package uk.me.suriar.interview.test;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import uk.me.suriar.interview.QuickSort;

public class TestQuickSort
{
    @Test
    public void testEmpty()
    {
	assertArrayEquals(new int[] {}, quickSort(new int[] {}));
    }

    private int[] quickSort(int[] elems)
    {
	new QuickSort().sort(elems);
	return elems;
    }
    
    @Test
    public void testOne()
    {
	assertArrayEquals(new int[] {3}, quickSort(new int[] {3}));
    }
    
    @Test
    public void testUnsortedOdd()
    {
	assertArrayEquals(new int[] {1, 2, 3}, quickSort(new int[] {3, 1, 2}));
    }
    
    @Test
    public void testUnsortedEven()
    {
	assertArrayEquals(new int[] {1, 2, 3, 4}, quickSort(new int[] {3, 1, 2, 4}));
    }
    
    @Test
    public void testSortedOdd()
    {
	assertArrayEquals(new int[] {1, 2, 3}, quickSort(new int[] {1, 2, 3}));
    }
    
    @Test
    public void testSortedEven()
    {
	assertArrayEquals(new int[] {1, 2, 3, 4}, quickSort(new int[] {1, 2, 3, 4}));
    }
    
    @Test
    public void testReverseEven()
    {
	assertArrayEquals(new int[] {1, 2, 3, 4}, quickSort(new int[] {4, 3, 2, 1}));
    }
}
