package leetcode.intrv;

import java.util.HashMap;

public class LongestSubAarray {

	public static void main(String[] args) {
		int nums[] = { 10, 5, 2, 7, 1, 9, 6, 15 };
		int k = 15;

		/*int nums[] = { 1, 2, 3 };
		int k = 3;*/
		System.out.println(subarraySum(nums, k));
		System.out.println(subarraySumUsingMap(nums, k));
	}

	public static int subarraySumUsingMap(int[] nums, int k) {
		int count = 0, sum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k))
				count += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}

	// only for +ve numbers
	public static int subarraySum(int[] nums, int k) {
		int length = nums.length;
		if (length == 1 && nums[0] != k)
			return 0;
		int sum = 0;
		int l = 0;
		int count = 0;
		int i = 0;
		for (; i < length; i++) {
			sum = sum + nums[i];
			if (sum == k) {
				sum = sum - nums[l];
				l++;
				count++;
			}
			while (sum > k) {
				sum = sum - nums[l];
				l++;
				if (sum == k) {
					sum = sum - nums[l];
					count++;
					l++;
				}
			}
		}
		return count;
	}

	// only for +ve numbers
	public static int longestSubarrayLen(int[] nums, int k) {

		int max = 0;
		int sum = 0;
		int l = 0;
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			if (max > length + 1 - i)
				break;
			sum = sum + nums[i];

			if (sum == k) {
				max = max > (i + 1 - l) ? max : i + 1 - l;
				sum = sum - nums[l];
				l++;
			} else if (sum > k) {
				sum = sum - nums[l];
				l++;
			}
		}
		return max;
	}

}
