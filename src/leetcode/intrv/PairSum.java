package leetcode.intrv;

import java.util.HashMap;
import java.util.Map;

class PairSum {
	static void printpairs(int arr[], int sum) {
		Map<Integer, Integer> s = new HashMap<>();
		for (int i = 0; i < arr.length; ++i) {
			int temp = sum - arr[i];

			if (temp >= 0 && s.containsKey(temp)) {
				System.out.println("index with given sum " + sum + " is (" + s.get(temp) + ", " + i + ")");
			}
			s.put(arr[i], i);
		}
	}

	public static void main(String[] args) {
		int A[] = { 1, 4, 45, 6, 10, 8 };
		int n = 16;
		printpairs(A, n);
	}
}
