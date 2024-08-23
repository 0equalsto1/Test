package leetcode.intrv;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TargetSumSubsets {

	public static void main(String[] args) {
		int set[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;
//		int set[] = { 4, 2, 7, 1, 3 };
//		int sum = 10;
		System.out.println(isSubsetSum(set, sum));
		System.out.println(isSubsetSum3(set, sum));
		ArrayList<Integer> list = IntStream.of(set).boxed().collect(Collectors.toCollection(ArrayList::new));
		System.out.println(isSubsetSum2(list, sum));
	}

	private static boolean isSubsetSum(int[] set, int sum) {
		int arr[] = new int[sum + 1];
		arr[0] = 1;
		for (int s = 0; s < set.length; s++) {
			if (arr[sum] == 1)
				return true;
			for (int i = sum; i >= set[s]; i--) {

				if (arr[i] == 1)
					continue;
				if (arr[i] == set[s]) {
					arr[i] = 1;
					continue;
				}
				if (arr[i - set[s]] == 1) {
					arr[i] = 1;
				}

			}
		}
		return arr[sum] == 1;
	}

	private static boolean isSubsetSum3(int[] set, int sum) {
		int arr[] = new int[sum + 1];
		arr[0] = 1;
		for (int s : set) {
			if (arr[sum] == 1)
				return true;
			for (int i = sum; i >= s; i--) {

				arr[i] = (arr[i] == 1 ? 1 : (arr[i - s] == 1 ? 1 : 0));

			}
		}
		return arr[sum] == 1;
	}

	private static int isSubsetSum2(ArrayList<Integer> A, int B) {

		int arr[] = new int[B + 1];
		arr[0] = 1;
		for (int s : A) {
			if (arr[B] == 1)
				return 1;
			for (int i = B; i >= s; i--) {
				arr[i] = arr[i] == 1 ? 1 : (arr[i - s] == 1 ? 1 : 0);
			}
		}
		return arr[B];
	}

}
