package uk.me.suriar.interview;

import java.awt.Point;

public class MatrixSearch {

	public Point find(final int value, final int[][] matrix) {
		if (matrix.length == 0) return null;
		
		final int rowHigh = matrix.length;
		final int colHigh = matrix[0].length;
		
		return findRegion(value, matrix, 0, 0, rowHigh-1, colHigh-1);
	}

	private Point findRegion(final int value, final int[][] matrix, final int rowLow, final int colLow, final int rowHigh, final int colHigh) {
		System.out.println(String.format("[%s,%s] -> [%s,%s]", rowLow,colLow, rowHigh, colHigh));
		
		if (rowLow > rowHigh || colLow > colHigh) return null;
		
		if (matrix[rowHigh][colHigh] < value) return null;
		if (matrix[rowLow][colLow] > value) return null;
		
		if (rowLow==rowHigh && colLow==colHigh) return new Point(colLow, rowLow);

		final int midRow = (rowLow+rowHigh)/2;
		final int midCol = (colLow+colHigh)/2;
		
		if (matrix[midRow][midCol] > value)
		{
			System.out.println(String.format("Midpoint [%s,%s] is greater", midRow, midCol));
			final int prevMidRow = Math.max(rowLow,midRow-1);
			final int prevMidCol = Math.max(colLow,midCol-1);
			
			Point result = findRegion(value, matrix, rowLow, colLow, prevMidRow, prevMidCol);
			if (result != null) return result;
			
			result = findRegion(value, matrix, rowLow, midCol, prevMidRow, colHigh);
			if (result != null) return result;
			
			return findRegion(value, matrix, midRow, colLow, rowHigh, prevMidCol);
		}
		if (matrix[midRow][midCol] < value)
		{
			System.out.println(String.format("Midpoint [%s,%s] is less", midRow, midCol));
			final int nextMidRow = Math.min(rowHigh,midRow+1);
			final int nextMidCol = Math.min(colHigh,midCol+1);
			
			Point result = findRegion(value, matrix, nextMidRow, nextMidCol, rowHigh, colHigh);
			if (result != null) return result;
			
			result = findRegion(value, matrix, nextMidRow, colLow, rowHigh, midCol);
			if (result != null) return result;
			
			return findRegion(value, matrix, rowLow, nextMidCol, midRow, colHigh);
		}

		return new Point(midCol, midRow);
	}
}
