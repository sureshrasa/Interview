package uk.me.suriar.interview;

import java.util.Arrays;
import java.util.stream.Stream;

public class NumberArray {
	private final BitNumber[] numbers;
	
	public NumberArray(final int n, final int missing) {
		numbers = new BitNumber[n];
		for (int i = 0; i<n; ++i)
		{
			if (i < missing)
				numbers[i] = new BitNumber(i);
			else
				numbers[i] = new BitNumber(i+1);
		}
	}
	
	public int getNumBits() {
		int result = 0;
		int n = numbers.length;
		
		while (n > 0)
		{
			n /= 2;
			++result;
		}
		System.out.println(String.format("num bits = %s", result));
		return result;
	}

	
	public BitNumber getBitNumber(final int i)
	{
		return numbers[i];
	}
	
	public Stream<BitNumber> getBitNumbers()
	{
		return Arrays.stream(numbers);
	}

	public int getBit(final int numIndex, final int bitIndex)
	{
		return numbers[numIndex].getBit(bitIndex);
	}
	
	public int getSize()
	{
		return numbers.length;
	}
}
