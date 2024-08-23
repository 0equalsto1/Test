package math;

import java.util.Arrays;
import java.util.List;

public class ComparatorValue {
	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(4, 12, 10, 13, 0);
		List<Integer> b = Arrays.asList(9, 10, 4);
		System.out.println(comparatorValue(a, b, 0));
	}

	public static int comparatorValue(List<Integer> a, List<Integer> b, int d) {
		// Write your code here

		int n = 0;
		for (Integer i : a) {
			int c = 0;
			for (Integer j : b) {
				int r = i - j;
				r = (r < 0 ? -r : r);
				if (r > d)
					c++;
				else
					break;
			}
			if (c == (b.size())) {
				n++;

			}
		}
		return n;
	}

}
