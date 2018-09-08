package uk.me.suriar.interview;

import java.util.Arrays;

public class Listy
{
    final int values[];

    public Listy(int... values)
    {
	this.values = values;
	Arrays.sort(this.values);
    }

    public int getValue(final int i)
    {
	if (i >= values.length)
	    return -1;

	return values[i];
    }
}
