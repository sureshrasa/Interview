package uk.me.suriar.interview;

import java.util.Comparator;
import java.util.List;

public class CircusTower
{
    public int longestTower(final List<Person> persons)
    {
	persons.sort(Comparator.comparing(Person::getWeight).reversed());
	return longestSubTower(persons);
    }

    private int longestSubTower(List<Person> persons)
    {
	if (persons.isEmpty())
	    return 0;
	
	final int[] tallestTowers = new int[persons.size()];
	int maxHeight = 0;
	
	for (int i = 0; i < persons.size(); ++i)
	{
	    tallestTowers[i] = findTallestFittingTower(persons, tallestTowers, i);
	    maxHeight = Math.max(maxHeight, tallestTowers[i]);
	}

	return maxHeight;
    }

    private int findTallestFittingTower(List<Person> persons, int[] tallestTowers, final int personPos)
    {
	final int heightLimit = persons.get(personPos).getHeight();
	
	int maxTowerHeight = 0;
	for (int i = 0; i <= personPos; ++i)
	{
	    final Person p = persons.get(i);
	    if (p.getHeight() >= heightLimit)
	    {
		maxTowerHeight = Math.max(maxTowerHeight, tallestTowers[i]);
	    }
	}
	return maxTowerHeight + 1;
    }
}
