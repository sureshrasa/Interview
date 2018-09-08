package uk.me.suriar.interview;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CoinChange
{
    private final Map<String, Integer> cache = new HashMap<>();

    public int compute(final int n)
    {
	if (n == 0)
	    return 0;

	final Deque<Integer> coins = Stream.of(10, 5, 1).collect(Collectors.toCollection(ArrayDeque::new));

	return computePerm(n, 25, coins);
    }

    private int computePerm(final int n, int coinValue, final Deque<Integer> coins)
    {
	if (n < 0)
	    return 0;
	if (n == 0)
	    return 1;

	final String key = getKey(n, coinValue, coins);
	final Integer cachedValue = cache.get(key);
	if (cachedValue != null)
	    return cachedValue;

	// System.out.println(String.format("compute(%s,%s,%s)", n, coinValue, coins));
	int result = computePerm(n - coinValue, coinValue, coins);

	if (!coins.isEmpty())
	{
	    final int nextCoinValue = coins.removeFirst();
	    result += computePerm(n, nextCoinValue, coins);
	    coins.addFirst(nextCoinValue);
	}

	cache.put(key, result);
	return result;
    }

    private String getKey(final int n, final int coinValue, final Deque<Integer> coins)
    {
	return n + coinValue + coins.toString();
    }
}
