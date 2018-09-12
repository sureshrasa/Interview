package uk.me.suriar.interview;

import java.util.HashMap;
import java.util.Map;

public class NSteps
{
    private final Map<Integer, Integer> cache = new HashMap<>();

    public int count(int i)
    {
	return i <= 0 ? 0 : countRemaining(i);
    }

    private int countRemaining(int i)
    {
	if (i < 0) return 0;
	if (i == 0) return 1;

	return cache.computeIfAbsent(i,
		k -> countRemaining(i - 3) + countRemaining(i - 2) + countRemaining(i - 1));
    }

}
