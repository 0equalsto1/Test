package leetcode.intrv;

class Kadane_MaximumSumSubArray {
	public static void main(String[] args) {
//		int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int [] a = {-2, -33, -54, -11, -1, -81, -95, -43}; 
		System.out.println("Maximum contiguous sum is " + maxSubArraySum(a));
	}

	static int maxSubArraySum(int a[]) {
		int size = a.length;
		int max = a[0], sum = a[0];

		for (int i = 1; i < size; i++) {
			sum = sum + a[i];
			if (a[i] > sum)
				sum = a[i];
			if (sum > max)
				max = sum;
				
		}
		return max;
	}
}
