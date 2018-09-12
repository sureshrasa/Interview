package uk.me.suriar.interview;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Collector;

public class Tower
{
    private final Deque<String> pole = new ArrayDeque<>();

    public Tower(final String... rings)
    {
	Arrays.stream(rings).forEach((r) -> pole.addFirst(r));
    }

    public String toString()
    {
	return pole.stream().collect(
		Collector.of(() -> new StringBuilder("["), StringBuilder::append, (l, r) -> {
		    l.append(r);
		    return l;
		})).append("]").toString();
    }

    public int height()
    {
	return pole.size();
    }

    public String removeFirst()
    {
	return pole.removeFirst();
    }

    public void addFirst(final String ring)
    {
	pole.addFirst(ring);
    }
}
