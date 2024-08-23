package leetcode;

public class HouseRobber2 {
	public int rob(int[] nums) {
		if (nums == null)
			return 0;
		if (nums.length == 1)
			return nums[0];
		return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
	}

	private int rob(int[] nums, int s, int e) {

		int _1before = 0, _2before = 0, max = 0;
		for (int i = s; i < e; i++) {
			max = Math.max(nums[i] + _2before, _1before);
			_2before = _1before;
			_1before = max;
		}
		return max;
	}

}
//{2, 3,6, 12, 15, 18}
//{15, 18, 2, 3, 6, 12}