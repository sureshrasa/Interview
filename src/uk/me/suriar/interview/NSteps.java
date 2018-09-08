package uk.me.suriar.interview;

import java.util.HashMap;
import java.util.Map;

public class NSteps {
	private final Map<Integer,Integer> cache = new HashMap<>();
	
	public int count(int i) {
		return i <= 0 ? 0 : countRemaining(i);
	}
	
	private int countRemaining(int i) {
		if (i < 0) return 0;
		if (i == 0) return 1;
		 
		final Integer value = cache.get(i);
		if (value != null) return value;
		final int newValue = countRemaining(i-3) + countRemaining(i-2) + countRemaining(i-1);
		cache.put(i, newValue);
		return newValue;
	}

}
