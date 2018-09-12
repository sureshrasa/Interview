package uk.me.suriar.interview;

public class BitAdder
{
    public int add(int m, int n)
    {
	do
	{
	    final int result = m ^ n;
	    n = ((m & n) << 1);
	    m = result;

	} while (n != 0);

	return m;
    }
}
