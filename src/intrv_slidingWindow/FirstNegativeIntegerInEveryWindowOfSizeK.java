package intrv_slidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class FirstNegativeIntegerInEveryWindowOfSizeK {

	public static int[] firstNegativeIntegerDeque(int[] nums, int k) {

		if (nums == null || nums.length == 0)
			return new int[0];

		int[] result = new int[nums.length - k + 1];
		// 5, -2, 3, 4, -5 //k=2
//		int[] a = { 1, 3, -1, -3, 5, 3, 6, 7 };
		Deque<Integer> deque = new ArrayDeque<>();
		int i = 0;
		for (; i < nums.length; i++) {
			
			if (!deque.isEmpty() && deque.peekFirst() == (i - k))// when we reach window size +1
				deque.removeFirst();
			if (nums[i] < 0)
				deque.offer(i);

			if (i + 1 >= k) {// when we reach window size
				if (!deque.isEmpty())
					result[i + 1 - k] = nums[deque.peekFirst()];
				else
					result[i + 1 - k] = 0;
			}
		}

		return result;
	}

	private static void firstNegativeIntegerBruteForce(int[] arr, int k) {
		int n = arr.length;

		for (int i = 0; i < n - k + 1; i++) {
			boolean negFound = false;

			for (int j = i; j < i + k; j++) {
				// If current element if negative print it
				if (arr[j] < 0) {
					System.out.print(arr[j] + " ");
					negFound = true;
					break;
				}
			}
			// if there is no negative element then print 0
			if (!negFound)
				System.out.print("0 ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Example 1
		int arr1[] = new int[] { 5, -2, 3, 4, -5 };
		int k1 = 2;
		System.out.println(Arrays.toString(firstNegativeIntegerDeque(arr1, k1)));
		firstNegativeIntegerBruteForce(arr1, k1);
		// Example 2
		int arr2[] = new int[] { 7, 9, -1, 2, 3, 4, -2, -3, -4 };
		int k2 = 3;
		System.out.println(Arrays.toString(firstNegativeIntegerDeque(arr2, k2)));
		firstNegativeIntegerBruteForce(arr2, k2);

	}
}