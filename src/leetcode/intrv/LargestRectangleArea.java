package leetcode.intrv;

import java.util.Stack;

public class LargestRectangleArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int largestRectangleArea(int[] heights) {
		int n = heights.length;
		Stack<Integer> st = new Stack<>();
		int maxA = 0;
		for (int i = 0; i <= n; i++) {
			while (!st.isEmpty() && (i == n || heights[st.peek()] >= heights[i])) {
				int height = heights[st.pop()];
				int width;
				if (st.isEmpty())
					width = i;
				else
					width = i - st.peek() - 1;

				maxA = Math.max(maxA, width * height);
			}
			st.push(i);
		}
		return maxA;
	}

	public int largestRectangleArea2(int[] heights) {
		int n = heights.length;
		Stack<Integer> st = new Stack<>();
		int leftSmall[] = new int[n];
		int rightSmall[] = new int[n];
		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
				st.pop();
			}

			if (st.isEmpty())
				leftSmall[i] = 0;
			else
				leftSmall[i] = st.peek() + 1;
			st.push(i);
		}

		st.clear();

		for (int i = n - 1; i >= 0; i--) {
			while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
				st.pop();
			}

			if (st.isEmpty())
				rightSmall[i] = n - 1;
			else
				rightSmall[i] = st.peek() - 1;

			st.push(i);
		}

		int maxA = 0;
		for (int i = 0; i < n; i++) {
			maxA = Math.max(maxA, heights[i] * (rightSmall[i] - leftSmall[i] + 1));
		}
		return maxA;

	}
}
