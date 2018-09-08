package uk.me.suriar.interview;

public class BitNumber
{
    private final int value;

    public BitNumber(final int i)
    {
	value = i;
    }

    public int getBit(int bitIndex)
    {
	return (value & (1 << bitIndex)) > 0 ? 1 : 0;
    }
}
