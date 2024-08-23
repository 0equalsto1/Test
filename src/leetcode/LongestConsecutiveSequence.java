package leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {

		int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
		System.out.println(longestConsecutive(nums));
		System.out.println(longestConsecutiveMap(nums));
	}

	public static int longestConsecutive(int[] nums) {
		HashSet<Integer> set = new HashSet<>(nums.length, 1.0f);
		for (int n : nums) {
			set.add(n);
		}
		int max = 0;
		for (Integer n : nums) {
			if (set.contains(n - 1))
				continue;
			int l = 1;
			int cn = n;
			while (set.contains(cn + 1)) {
				l++;
				cn++;
			}
			if (l > max)
				max = l;
		}
		return max;
	}

	public static int longestConsecutiveMap(int[] nums) {
		int res = 0;
		HashMap<Integer, Integer> map = new HashMap<>(nums.length, 1.0f);
		for (int n : nums) {// 100, 4, 200, 1, 3, 2
			if (!map.containsKey(n)) {
				int left = map.getOrDefault(n - 1, 0);
				int right = map.getOrDefault(n + 1, 0);

				int sum = left + right + 1;
				map.put(n, sum);

				res = Math.max(res, sum);
				map.put(n - left, sum);
				map.put(n + right, sum);
			}
		}
		return res;
	}
}
