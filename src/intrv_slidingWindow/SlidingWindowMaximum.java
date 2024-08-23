package intrv_slidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
//	  0  1   2   3  4  5  6  7 	
//	{ 1, 3, -1, -3, 5, 3, 6, 7 } k=3
	public static int[] maxSlidingWindowBruteForce(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return new int[0];
		int length = nums.length;
		int[] result = new int[length - k + 1];

		int max = 0;
		for (int i = 0; i < (length - k + 1); i++) {
			max = nums[i];
			for (int j = i + 1; j < i + k; j++) {
				if (nums[j] > max)
					max = nums[j];
			}
			result[i] = max;
		}

		return result;

	}

	// maintain decreasing order in queue
	public static int[] maxSlidingWindowDeque(int[] nums, int k) {

		if (nums == null || nums.length == 0)
			return new int[0];

		int[] result = new int[nums.length - k + 1];
		Deque<Integer> deque = new ArrayDeque<>();
		int i = 0;
		for (; i < nums.length; i++) {

			if (!deque.isEmpty() && deque.peek() == (i - k))
				deque.remove();

			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.removeLast();
			}
			deque.offer(i);
			if (i + 1 >= k)
				result[i + 1 - k] = nums[deque.peek()];
		}

		return result;
	}

//		  0  1   2   3  4  5  6  7 	
//		{ 1, 3, -1, -3, 5, 3, 6, 7 } k=3
	public static int[] maxSlidingWindowArray(int[] nums, int k) {
		int length = nums.length;
		if (nums == null || length == 0)
			return new int[0];
		int maxIndex = 0;
		int index = 0;
		int newLength = length - k + 1;
		int[] result = new int[newLength];
		for (int i = 1; i < length; i++) {

			if (maxIndex == i - k)
				maxIndex = i - 1;
			if (nums[i] > nums[maxIndex])
				maxIndex = i;
			if ((i + 1) % k == 0)
				result[index++] = nums[maxIndex];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		/*int[] a = { 1, 2, 3, 4, 5 };
		int k = 2;*/
		System.out.println(Arrays.toString(maxSlidingWindowBruteForce(a, k)));
		System.out.println(Arrays.toString(maxSlidingWindowArray(a, k)));
		long s = System.currentTimeMillis();
		System.out.println(Arrays.toString(maxSlidingWindowDeque(a, k)) + " \ntime taken: "
				+ (System.currentTimeMillis() - s) + "ms");
//		Arrays.asList("".split(",")).stream().mapToInt(Integer::parseInt).toArray();

	}

}
