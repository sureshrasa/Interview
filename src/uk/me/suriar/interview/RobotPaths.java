package uk.me.suriar.interview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.function.BiPredicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javafx.util.Pair;

public class RobotPaths {
	final Map<Pair<Integer,Integer>,List<String>> cache = new HashMap<>();

	public List<String> paths(final int row, final int col,
			final BiPredicate<Integer,Integer> isRestrictedSpace)
	{
		return appendPath(1, 1, row, col, isRestrictedSpace);
	}

	private List<String> appendPath(final int row, final int col, final int lastRow, final int lastCol,
			final BiPredicate<Integer, Integer> isRestrictedSpace)
	{
		final Pair<Integer, Integer> currPoint = new Pair<Integer, Integer>(row,col);
		
		final List<String> prevResult = cache.get(currPoint);
		if (prevResult != null) return prevResult;
		
		final String currPointDesc = addPoint(row, col);
		final List<String> paths = new ArrayList<>();
		
		if (row == lastRow && col == lastCol)
		{
			paths.add(currPointDesc);
		}
		else if (!isRestrictedSpace.test(row, col))
		{
			if (col < lastCol)
			{
				final List<String> result = appendPath(row, col+1, lastRow, lastCol, isRestrictedSpace);
				if (!result.isEmpty())
				{
					paths.addAll(prefixPaths(currPointDesc, result));
				}
			}
			if (row < lastRow)
			{
				final List<String> result = appendPath(row+1, col, lastRow, lastCol, isRestrictedSpace);
				if (!result.isEmpty())
				{
					paths.addAll(prefixPaths(currPointDesc, result));
				}
			}
		}
		
		cache.put(currPoint, paths);
		
		return paths;
	}

	private List<String> prefixPaths(String currPoint, List<String> paths) {
		return paths.stream().map((s)->currPoint+s).collect(Collectors.toList());
	}

	private String addPoint(int row, int col) {
		return String.format("[%s,%s]", row, col);
	}
}
