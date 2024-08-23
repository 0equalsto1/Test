package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElements2 {

	public static void main(String[] args) {

		int[]arr= {100,1,11,1,120,111,123,1,-1,-100};
		System.out.println(nextGreaterElements(arr));
	}

	public static int[] nextGreaterElementsStack(int[] A) {
		int n = A.length, res[] = new int[n];
		Arrays.fill(res, -1);
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n * 2; i++) {
			while (!stack.isEmpty() && A[stack.peek()] < A[i % n])
				res[stack.pop()] = A[i % n];
			stack.push(i % n);
		}
		return res;
	}
	public static int[] nextGreaterElements(int[] arr) {

		int[] re = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			re[i] = -1;
			for (int j = i + 1; j < arr.length * 2; j++) {
				if (arr[j % arr.length] > arr[i]) {
					re[i] = arr[j % arr.length];
					break;
				}
			}
		}

		return re;
	}
}
