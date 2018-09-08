package uk.me.suriar.interview;

public class MissingNumberA implements MissingNumber
{

    /*
     * (non-Javadoc)
     * 
     * @see uk.me.suriar.interview.MissingNumber#detect(uk.me.suriar.interview.
     * NumberArray)
     */
    @Override
    public int detect(final NumberArray numberArray)
    {
	final int n = numberArray.getSize();
	System.out.println(String.format("detecting %s -----", n));

	final int numBits = numberArray.getNumBits();

	int result = 0;

	for (int bit = numBits - 1; bit >= 0; --bit)
	{
	    result <<= 1;

	    result |= getBit(numberArray, n, bit);
	    System.out.println(String.format("result =%s", result));
	}

	return result;
    }

    private int getBit(final NumberArray numberArray, final int n, final int i)
    {
	final int nPlus1 = n + 1;

	final int twoPoweri = 1 << i;

	final int cycles = nPlus1 / twoPoweri;

	final int totalOnes = (cycles / 2) * twoPoweri + (cycles % 2) * (nPlus1 % twoPoweri);

	final int[] counts = getBitCounts(numberArray, n, i);
	return (counts[1] != totalOnes) ? 1 : 0;
    }

    private int[] getBitCounts(final NumberArray numberArray, final int n, final int bitIndex)
    {
	final int[] counts = new int[2];

	for (int i = 0; i < n; ++i)
	{
	    ++counts[numberArray.getBit(i, bitIndex)];
	}

	return counts;
    }

}
