package uk.me.suriar.interview;

import java.util.Arrays;
import java.util.logging.Logger;

public class MajorityElementFinder
{
    static final Logger logger = Logger.getLogger(MajorityElementFinder.class.getName());

    public int find(final int[] elems)
    {
	logger.info(() -> String.format("frequency search %s", Arrays.toString(elems)));
	
	if (elems.length == 0) return -1;
	if (elems.length == 1) return elems[0];
	
	final int limit = elems.length/2+1;
	final int last = elems.length-1;
	
	
	for (int i = 0; i < limit;)
	{
	    final int curr = elems[i];
	    final int nextStart = i+1;
	    logger.info(() -> String.format("frequency search %s: %s:%s", curr, nextStart, last));
	    
	    int next = nextStart;
	    int frequency = 1;
	    for (int j = i+1; j <= last; ++j)
	    {
		if (elems[j] == curr)
		{
		    ++frequency;
		    if (frequency >= limit) return curr;
		    swap(elems, next, j);
		    ++next;
		}
	    }
	    i = next;
	}
	return -1;
    }

    private void swap(int[] elems, int from, int to)
    {
	final int temp = elems[from];
	elems[from] = elems[to];
	elems[to] = temp;
    }
}
