package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FirstMissingPositive {

	public static void main(String[] args) {
		System.out.println(OptimalSolution(new int[] { -1, 1, 3, 10, 2147483647, 9 }));
//		System.out.println(solution(new int[] { 1, 2, 3, 10, 2147483647, 9 }));
	}

	public static int OptimalSolution(int[] A) {
		int i = 0;
		while (i < A.length) {
			if (A[i] > 0 && A[i] <= A.length && A[i] != A[A[i] - 1])
				swap(A, i, A[i] - 1);
			else
				i++;
		}
		i = 0;
		while (i < A.length && A[i] == i + 1)
			i++;
		return i + 1;
	}

	private static void swap(int[] A, int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static int usingSort(int[] a) {
		int l = a.length;
		Arrays.sort(a);
		int n = 1;
		for (int i = 0; i < l; i++) {
			if (a[i] <= 0)
				continue;
			if (a[i] > n)
				return n;
			if (n <= a[i])
				n++;
		}
		return n;
	}

	public static int solution2(int[] a) {
		int l = a.length;
		for (int i = 0; i < l; i++) {
			if (a[i] < 0)
				continue;
			int mod = a[i] % l;
			if (a[mod] > 0)
				a[mod] = -a[mod];
		}
		int i = 0;
		for (; i < l; i++) {
			if (a[i] >= 0)
				return i + 1;
		}
		return 1;
	}

	public static int solution(int[] a) {
		Set<Integer> set = new HashSet<>(a.length, 1.0f);
		for (int i : a) {
			if (i > 0)
				set.add(i);
		}
		int i = 1;
		while (set.contains(i))
			i++;
		return i;
	}

}
