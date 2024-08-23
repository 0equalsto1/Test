package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElements1 {
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] re = new int[nums1.length];
		Map<Integer, Integer> m = new HashMap<>();

		for (int i = 0; i < nums2.length; i++) {
			m.put(nums2[i], i);
		}

		for (int i = 0; i < nums1.length; i++) {
			re[i] = -1;
			for (int j = m.get(nums1[i]) + 1; j < nums2.length; j++) {
				if (nums2[j] > nums1[i]) {
					re[i] = nums2[j];
					break;
				}
			}
		}

		return re;
	}

	public int[] nextGreaterElement2(int[] findNums, int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		for (int num : nums) {
			while (!stack.isEmpty() && stack.peek() < num)
				map.put(stack.pop(), num);
			stack.push(num);
		}
		for (int i = 0; i < findNums.length; i++)
			findNums[i] = map.getOrDefault(findNums[i], -1);
		return findNums;
	}
}
