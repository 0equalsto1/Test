package leetcode;

import java.util.Arrays;

public class UniquePaths {

	public static void main(String[] args) {
		int m = 3, n = 5;
		uniquePaths2(m, n);
		System.out.println(uniquePathsDP(m, n));
		System.out.println(uniquePaths2DDP(m, n));
	}

	public static int uniquePathsDP(int m, int n) {
		int[] dp = new int[n];
		dp[0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[j] += dp[j - 1];
			}
		}
		return dp[n - 1];
	}

	public static int uniquePaths2DDP(int m, int n) {

		int[][] dp = new int[m][n];
		Arrays.fill(dp[0], 1);
		for (int i = 0; i < dp.length; i++)
			dp[i][0] = 1;
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
			}
		}
		return dp[m - 1][n - 1];
	}

	public static void uniquePaths2(int m, int n) {
		int dp[][] = new int[m][n];
		dp = new int[m][n];
		System.out.println(countPathsMemo(0, 0, m, n, dp));

	}

	static int countPathsMemo(int i, int j, int m, int n, int[][] memo) {
		if (i == (m - 1) && j == (n - 1))
			return 1;
		if (i >= m || j >= n)
			return 0;
		if (memo[i][j] > 0)
			return memo[i][j];

		return memo[i][j] = countPathsMemo(i + 1, j, m, n, memo) + countPathsMemo(i, j + 1, m, n, memo);
	}

	int countPathsRec(int i, int j, int n, int m) {
		if (i == (n - 1) && j == (m - 1))
			return 1;
		if (i >= n || j >= m)
			return 0;
		return countPathsRec(i + 1, j, n, m) + countPathsRec(i, j + 1, n, m);
	}

}
