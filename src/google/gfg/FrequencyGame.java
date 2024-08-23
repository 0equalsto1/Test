package google.gfg;

import java.util.HashMap;

/*
 * Given an array A of size N. The elements of the array 
 * consists of positive integers. You have to find the 
 * largest element with minimum frequency.
 */
public class FrequencyGame {

	public static void main(String[] args) {

	}

	public static int LargButMinFreq(int arr[], int n) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int key : map.keySet()) {
			int minVal = map.get(key);
			if (key > max && minVal <= min) {
				max = key;
				min = minVal;
			}
		}
		return max;
	}
}
