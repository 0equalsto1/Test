package leetcode.intrv;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		int[] heights = { 7, 0, 4, 2, 5, 0, 6, 4, 0, 5 };

		int trap = maxArea(heights);
		System.out.println("water trapped2 is: " + trap);

	}

	public static int maxArea(int[] height) {
		int max = 0;
		int i = 0;
		int j = height.length - 1;
		while (i < j) {
			int minHight = height[i] < height[j] ? height[i] : height[j];
			max = Math.max(max, minHight * (j - i));
			if (height[i] < height[j])
				i++;
			else
				j--;
		}
		return max;
	}
}
