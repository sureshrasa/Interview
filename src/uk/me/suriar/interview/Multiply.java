package uk.me.suriar.interview;

public class Multiply
{

    public static int eval(int m, int n)
    {
	System.out.println(String.format("%s X %s", m, n));
	if (m < n)
	    return eval(n, m);

	if (n == 0)
	    return 0;
	if (n == 1)
	    return m;
	if ((n % 2) == 1)
	{
	    return m + eval(m << 1, n >> 1);
	} else
	{
	    return eval(m << 1, n >> 1);
	}
    }

}
