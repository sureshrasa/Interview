package uk.me.suriar.interview;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WordDistance
{
    final Map<String, List<Integer>> wordPositions = new HashMap<>();

    public int find(final String wordA, final String wordB, final String[] words)
    {
	registerWords(words);

	return minDistance(wordPositions.get(wordA), wordPositions.get(wordB));
    }

    private int minDistance(final List<Integer> aPositions, final List<Integer> bPositions)
    {
	if (aPositions == null || aPositions.isEmpty() || bPositions == null || bPositions.isEmpty())
	    return -1;

	return (aPositions.size() < bPositions.size())
		? findMinDistance(aPositions, bPositions) : findMinDistance(bPositions, aPositions);
    }

    private int findMinDistance(final List<Integer> aPositions, final List<Integer> bPositions)
    {
	int currMinDistance = Integer.MAX_VALUE;
	int minDistance = Integer.MAX_VALUE;
	int aPos = 0;
	int bPos = 0;
	while (aPos < aPositions.size() && bPos < bPositions.size())
	{
	    final int distance = Math.abs(aPositions.get(aPos) - bPositions.get(bPos));
	    if (distance < currMinDistance)
	    {
		currMinDistance = distance;
		++bPos;
	    } else
	    {
		minDistance = Math.min(minDistance, currMinDistance);
		currMinDistance = Integer.MAX_VALUE;
		++aPos;
	    }
	}
	return Math.min(minDistance, currMinDistance) - 1;
    }

    private void registerWords(final String[] words)
    {
	for (int i = 0; i < words.length; ++i)
	{
	    final List<Integer> positions = wordPositions.computeIfAbsent(words[i], k -> new ArrayList<>());
	    positions.add(Integer.valueOf(i));
	}
    }
}
