package uk.me.suriar.interview;

public class BitAdder {

	public int add(int m, int n)
	{
		System.out.println("-----");
		do
		{
			System.out.println(String.format("m:%s n:%s", Integer.toBinaryString(m), Integer.toBinaryString(n)));
			final int result = m ^ n;
			n = ((m & n) << 1);
			m = result;
			
		} while (n != 0);
		
		return m;
	}
}
