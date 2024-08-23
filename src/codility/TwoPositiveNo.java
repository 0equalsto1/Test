package codility;

import java.util.Arrays;

public class TwoPositiveNo {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(500009)));
	}

	public static int[] solution(int N) {

		for (int i = 1; i < N; i++) {

			if (!Integer.toString(i).contains("0") && !Integer.toString(N - i).contains("0")) {
				return new int[] { i, N - i };
			}
		}

		return new int[] {};

	}

	public int[] getNoZeroIntegers(int n) {
		int A = 1, B = n - 1;
		while (containsZero(A) || containsZero(B)) {
			A++;
			B--;
		}
		return new int[] { A, B };
	}

	public boolean containsZero(int num) {
		while (num != 0) {
			int t = num % 10;
			if (t == 0)
				return true;
			num /= 10;
		}
		return false;
	}
}
