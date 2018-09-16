package uk.me.suriar.interview;

import java.util.Arrays;
import java.util.logging.Logger;

public class MajorityElementFinder
{
    static final Logger logger = Logger.getLogger(MajorityElementFinder.class.getName());

    public int find(final int[] elems)
    {
	logger.info(() -> String.format("find %s", Arrays.toString(elems)));
	final int candidate = findCandidate(elems);
	
	return validateMajority(candidate, elems);
    }
    
    private int findCandidate(final int[] elems)
    {
	int candidate = 0;
	int frequency = 0;
	for (int n : elems)
	{
	    if (frequency == 0)
	    {
		candidate = n;
		++frequency;
	    }
	    else if (n == candidate)
	    {
		++frequency;
	    }
	    else
	    {
		--frequency;
	    }
	}
	
	return candidate;
    }
    
    private int validateMajority(final int curr, final int[] elems)
    {
	final int limit = elems.length/2+1;
	int frequency = 0;
	for (int i = 0; i < elems.length; ++i)
	{
	    if (elems[i] == curr) ++frequency;
	    if (frequency >= limit) return curr;
	}
	return -1;
    }
}
