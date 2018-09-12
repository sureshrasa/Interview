package uk.me.suriar.interview;

import java.awt.Point;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class EightQueens
{

    public Collection<String> generate(final int lastRow, final int lastCol)
    {
	return generate(new ArrayDeque<String>(), 8, 1, lastRow, lastCol, (r, c) -> true);
    }

    private Collection<String> generate(final Deque<String> currentLayout, final int totalQueens, final int firstRow,
	    final int lastRow, final int lastCol, final BiPredicate<Integer, Integer> isValid)
    {
	final Collection<String> result = new ArrayList<>();

	if (totalQueens <= 0)
	{
	    result.add(currentLayout.toString());
	    return result;
	}

	for (int row = firstRow; row <= lastRow; ++row)
	{
	    for (int col = 1; col <= lastCol; ++col)
	    {
		if (isValid.test(row, col))
		{
		    currentLayout.addLast(String.format("(%s,%s)", row, col));
		    result.addAll(generateRest(currentLayout, totalQueens - 1, row, col, lastRow, lastCol, isValid));
		    currentLayout.removeLast();
		}
	    }
	}
	return result;
    }

    private Collection<String> generateRest(final Deque<String> currentLayout, final int totalQueens, final int row,
	    final int col, final int lastRow, final int lastCol, final BiPredicate<Integer, Integer> isValid)
    {
	return generate(currentLayout, totalQueens, row + 1, lastRow, lastCol,
		(r, c) -> isValid.test(r, c) && r != row && c != col && Math.abs(r - row) != Math.abs(c - col));
    }
}
