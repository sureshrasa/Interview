package uk.me.suriar.interview;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class FibonacciGen
{
    public int get(final int n)
    {
	if (n < 0) return -1;
	
	if (n <= 1) return 1;
	
	int nMinus1 = 1;
	int nMinus2 = 1;
	
	for (int i = 2; i <= n; ++i)
	{
	    final int prev = nMinus1;
	    nMinus1 = nMinus1 + nMinus2;
	    nMinus2 = prev;
	}
	
	return nMinus1;
    }
}
