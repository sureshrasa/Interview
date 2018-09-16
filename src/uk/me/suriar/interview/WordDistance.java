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
	if (aPositions == null || bPositions == null)
	    return -1;

	final Comparator<Integer> intComparator = Comparator.naturalOrder();

	return aPositions.stream().map(aPos -> bPositions.stream().map(bPos -> Math.abs(aPos - bPos)-1
		).min(intComparator).get()).min(intComparator).get();
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
