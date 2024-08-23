package leetcode.intrv;

public class TrappingRainWater {
	public static void main(String[] args) {
		int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
//		int[] heights = { 17, 11, 17 };

		System.out.println("water trapped is: " + trap(heights));
//		System.out.println("water trapped2 is: " + trap2(heights));

	}

	public static int trap(int[] arr) {
		int l = 0;
		int r = arr.length - 1;
		int lm = 0, rm = 0, ans = 0;
		while (l < r) {
			lm = Math.max(lm, arr[l]);
			rm = Math.max(rm, arr[r]);
			if (lm < rm)
				ans = ans + lm - arr[l++];
			else
				ans = ans + rm - arr[r--];
		}
		return ans;
	}

	static int trap3(int[] arr) {
		int n = arr.length;
		int leftHights[] = new int[n];
		int rightHights[] = new int[n];
		leftHights[0] = arr[0];
		for (int i = 1; i < n; i++) {
			leftHights[i] = Math.max(leftHights[i - 1], arr[i]);
		}
		rightHights[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rightHights[i] = Math.max(rightHights[i + 1], arr[i]);
		}
		int waterTrapped = 0;
		for (int i = 0; i < n; i++) {
			waterTrapped += Math.min(leftHights[i], rightHights[i]) - arr[i];
		}
		return waterTrapped;
	}

}
