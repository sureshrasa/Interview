package uk.me.suriar.interview;

public class ListySearch
{
    public Object find(final int value, final Listy listy)
    {
	if (listy.getValue(0) == -1)
	    return -1;

	return findInRange(value, listy, 0, 1, Integer.MAX_VALUE);
    }

    private int findInRange(final int value, final Listy listy, final int lowerBound, final int testPos,
	    final int upperBound)
    {
	if (testPos < lowerBound | testPos > upperBound)
	    return -1;

	final int testValue = listy.getValue(testPos);

	if (testValue == -1 || testValue > value)
	    return findInRange(value, listy, lowerBound, (testPos + lowerBound) / 2, testPos - 1);

	if (testValue < value)
	    return findInRange(value, listy, testPos + 1, Math.min(upperBound, testPos * 2), upperBound);

	return testPos;
    }

}
