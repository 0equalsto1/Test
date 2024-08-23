package leetcode.intrv;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] n = { 3, 2, 95, 4, -3 };
		int target = 92;// 0,3
		int[] twoSum = twoSum(n, target);
		System.out.println(Arrays.toString(twoSum));

	}

	public static int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		int length = nums.length;
		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				if (nums[i] + nums[j] == target) {
					res[0] = i;
					res[1] = j;
					return res;
				}

			}
		}
		return res;

	}

	public int[] two_Sum(int[] nums, int target) {

		Map<Integer, Integer> numMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int remaning = target - nums[i];
			if (numMap.containsKey(remaning)) {
				return new int[] { numMap.get(remaning), i };
			} else {
				numMap.put(nums[i], i);
			}
		}
		return new int[] {};

	}
}
