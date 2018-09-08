package uk.me.suriar.interview.test;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Test;

import uk.me.suriar.interview.MatrixSearch;

public class TestMatrixSearch
{
    @Test
    public void testEmpty()
    {
	assertEquals(null, new MatrixSearch().find(12, new int[0][0]));
    }

    @Test
    public void test4X4()
    {
	final int[][] matrix = new int[2][2];

	for (int r = 0; r < matrix.length; ++r)
	{
	    for (int c = 0; c < matrix[r].length; ++c)
	    {
		matrix[r][c] = (r + 1) * (c + 1);
	    }
	}

	// 1 2
	// 2 4
	assertEquals(new Point(1, 1), new MatrixSearch().find(4, matrix));
    }

    @Test
    public void testNonEmpty()
    {
	final int[][] matrix = new int[16][16];

	int value = 0;
	for (int r = 0; r < matrix.length; ++r)
	{
	    for (int c = 0; c < matrix[r].length; ++c, ++value)
	    {
		matrix[r][c] = (value == 67) ? ++value : value;
		System.out.println(String.format("[%s,%s] = %s", r, c, matrix[r][c]));
	    }
	}
	matrix[15][3] = 70;

	// 1 2 3 4
	// 5 6 7 8
	// 9 10 11 12
	// 13 14 15 16
	// 17 18 19 20
	/*
	 * assertEquals(new Point(0, 0), new MatrixSearch().find(1, matrix));
	 * assertEquals(new Point(2, 2), new MatrixSearch().find(11, matrix));
	 * assertEquals(new Point(3, 2), new MatrixSearch().find(12, matrix));
	 * assertEquals(new Point(3, 0), new MatrixSearch().find(4, matrix));
	 */
	assertEquals(null, new MatrixSearch().find(67, matrix));
    }
}
