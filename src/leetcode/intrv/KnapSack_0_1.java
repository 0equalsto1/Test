package leetcode.intrv;

import java.util.List;

public class KnapSack_0_1 {

	public static void main(String[] args) {
//		val = [60, 100, 120]
//		weight = [10, 20, 30]
		int[] val = { 10, 5, 12, 8 };// { 60, 100, 120 };
		int[] weight = { 1, 2, 3, 4 };// { 10, 20, 30 };
		int capacity = 5;// 50;
		System.out.println(KnapSack(val, weight, capacity));
	}

	public static int KnapSack(int[] val, int[] weight, int capacity) {
		int[] arr = new int[capacity + 1];
		int count = 0;
		for (int i = 0; i < weight.length; i++) {

			for (int w = capacity; w >= weight[i]; w--) {
				arr[w] = Math.max(arr[w], val[i] + arr[w - weight[i]]);
				count++;
				if (i == weight.length - 1)
					break;
			}
		}
		System.out.println("loop: " + count);
		return arr[capacity];
	}

	public static int solve(List<Integer> A, List<Integer> B, int C) {

		int[] arr = new int[C + 1];
		for (int i = 0; i < A.size(); i++) {

			for (int w = C; w >= B.get(i); w--) {
				arr[w] = Math.max(arr[w], A.get(i) + arr[w - B.get(i)]);
				if (i == B.size() - 1)
					break;
			}
		}
		return arr[C];

	}
}
