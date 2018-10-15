package answers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Question5 {
	private static Set<Integer> values;

	public static int shareExchange(int[] allowedAllocations, int totalValue) {
		values = new HashSet<Integer>();
		for(int i : allowedAllocations) {
			values.add(i);
		}
		return f(totalValue);

}

	private static int f(int totalValue) {
		if(values.contains(totalValue)) {
			return 1;
		}
		if(totalValue == 0) {
			return 0;
		}
		if(totalValue < 0) {
			return Integer.MAX_VALUE;
		}
		int min = Integer.MAX_VALUE;
		for(int i : values) {
			min = Math.min(min, f(totalValue-i));
		}
		return 1 + min;
	}
}
