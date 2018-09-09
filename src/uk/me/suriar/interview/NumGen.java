package uk.me.suriar.interview;

public class NumGen
{
    private class BaseNumGen
    {
	final int base;
	final int[] generated;
	int nextIndex = 0;
	int currValue = 0;

	public BaseNumGen(final int base, final int[] generated)
	{
	    this.base = base;
	    this.generated = generated;
	}

	public int generateIfLess(final int i)
	{
	    while (currValue <= generated[i])
	    {
		currValue = generated[nextIndex] * base;
		++nextIndex;
	    }
	    return currValue;
	}
    }

    public int generate(final int k)
    {
	int[] generated = new int[k+1];
	
	generated[0] = 1;
	
	final BaseNumGen gen3 = new BaseNumGen(3, generated);
	final BaseNumGen gen5 = new BaseNumGen(5, generated);
	final BaseNumGen gen7 = new BaseNumGen(7, generated);
	
	final int Max = Integer.MAX_VALUE / 3;
	
	for (int i = 1; i <= k; ++i)
	{
	    generated[i] = Math.min(gen3.generateIfLess(i-1),
		    		Math.min(gen5.generateIfLess(i-1), gen7.generateIfLess(i-1)));
	    if (generated[i] >= Max)
		return -1;
	}
	
	return generated[k];
    }
}
