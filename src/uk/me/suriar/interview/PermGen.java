package uk.me.suriar.interview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collector;

public class PermGen
{
    public Collection<String> generate(final String seq)
    {
	if (seq == null)
	    return null;

	switch (seq.length())
	{
	case 0:
	    return new ArrayList<>();

	case 1:
	{
	    final List<String> result = new ArrayList<>();
	    result.add(seq);
	    return result;
	}

	default:
	{
	    final char elem = seq.charAt(0);
	    final Collection<String> restPerm = generate(seq.substring(1));

	    return restPerm.stream().map((s) -> generate(elem, s)).collect(
		    Collector.of(HashSet::new, HashSet::addAll, (l, r) -> {
			l.addAll(r);
			return l;
		    }));
	}

	}
    }

    private Collection<String> generate(final char elem, final String s)
    {
	final List<String> result = new ArrayList<>();

	final int length = s.length();
	for (int i = 0; i <= length; ++i)
	{
	    while (i < length && s.charAt(i) == elem)
	    {
		++i;
	    }

	    result.add(s.substring(0, i) + elem + s.substring(i));
	}

	return result;
    }

}
