package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		List<List<Integer>> subsets = new ArrayList<>();
		List<Integer> set = new ArrayList<>();
		int[] nums = { 1, 2, 3 };
//		subsets(nums, 0, subsets, set);
		System.out.println(subsets(nums));
	}

	public static void subsets(int[] nums, int index, List<List<Integer>> res, List<Integer> tmp) {
		if (index >= nums.length) {
			res.add(new ArrayList<>(tmp));
			return;
		}
		subsets(nums, index + 1, res, tmp);
		tmp.add(nums[index]);
		subsets(nums, index + 1, res, tmp);
		tmp.remove(tmp.size() - 1);

	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		for (int n : nums) {
			int size = result.size();
			for (int i = 0; i < size; i++) {
				List<Integer> subset = new ArrayList<>(result.get(i));
				subset.add(n);
				result.add(subset);
			}
		}
		return result;
	}
}
