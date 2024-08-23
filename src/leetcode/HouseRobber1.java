package leetcode;

public class HouseRobber1 {

	public static void main(String[] args) {

	}

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		int[] res = new int[nums.length];
		res[0] = nums[0];
		res[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < res.length; i++) {
			res[i] = Math.max(nums[i] + res[i - 2], res[i - 1]);
		}
		return res[nums.length - 1];
	}

	public int rob2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		int[] res = new int[nums.length];
		int _2before = nums[0];
		int _1before = Math.max(nums[0], nums[1]);
		int max = 0;
		for (int i = 2; i < res.length; i++) {
			max = Math.max(nums[i] + _2before, _1before);
			_2before = _1before;
			_1before = max;
		}
		return max;
	}

	public int rob3(int[] nums) {
		int _1before = 0, _2before = 0, max = 0;
		for (int i : nums) {
			max = Math.max(i + _2before, _1before);
			_2before = _1before;
			_1before = max;
		}
		return max;
	}
}
