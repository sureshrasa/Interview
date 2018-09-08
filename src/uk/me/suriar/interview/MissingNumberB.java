package uk.me.suriar.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MissingNumberB implements MissingNumber {

	@Override
	public int detect(NumberArray numberArray) {
		return findMissing(numberArray.getBitNumbers(), 0, numberArray.getNumBits());
	}

	private int findMissing(final Stream<BitNumber> stream, final int bitIndex, final int numBits) {
		if (bitIndex >= numBits) return 0;
		
		final List<BitNumber> zeros = new ArrayList<>();
		final List<BitNumber> ones = new ArrayList<>();
		
		stream.forEach(b->{
			(b.getBit(bitIndex) == 0 ? zeros : ones).add(b);
		});
		// odd : LSB(0) == LSB(1)
		// even: LSB(0) == LSB(1) + 1
		if (zeros.size() > ones.size())
		{
			System.out.println(String.format("Bit %s is missing 1", bitIndex));
			// 1 is missing
			return (findMissing(ones.stream(), bitIndex+1, numBits) << 1) | 1;
		}
		else
		{
			System.out.println(String.format("Bit %s is missing 0", bitIndex));
			return (findMissing(zeros.stream(), bitIndex+1, numBits) << 1) | 0;
		}
	}
}
