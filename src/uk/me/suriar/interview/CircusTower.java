package uk.me.suriar.interview;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CircusTower
{
    private final Map<Person, Integer> cache = new HashMap<>();

    public int longestTower(final List<Person> persons)
    {
	persons.sort(Comparator.comparing(Person::getWeight).reversed());
	return longestSubTower(persons);
    }

    private int longestSubTower(List<Person> persons)
    {
	if (persons.isEmpty())
	    return 0;

	final Person basePerson = persons.get(0);
	final List<Person> subList = persons.subList(1, persons.size());
	return Math.max(longestSubTowerForPerson(basePerson, subList), longestSubTower(subList));
    }

    private int longestSubTowerForPerson(final Person person, final List<Person> persons)
    {
	return cache.computeIfAbsent(person, k -> {
	    int maxHeight = 0;

	    for (int i = 0; i < persons.size(); ++i)
	    {
		final Person p = persons.get(i);
		if (p.isShorterThan(person))
		{
		    maxHeight = Math.max(maxHeight,
			    longestSubTowerForPerson(p, persons.subList(i + 1, persons.size())));
		}
	    }

	    return maxHeight + 1;
	});
    }
}
