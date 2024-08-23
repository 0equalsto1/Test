package leetcode;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcdef";
        String text2 = "abchjk";
        int result = longestCommonSubsequenceDP(text1, text2);
        System.out.println("Length of the Longest Common Subsequence: " + result);

    }

    public static int longestCommonSubsequenceDP(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 0; i < text1.length(); ++i)
            for (int j = 0; j < text2.length(); ++j)
                if (text1.charAt(i) == text2.charAt(j)) dp[i + 1][j + 1] = 1 + dp[i][j];
                else dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
        return dp[text1.length()][text2.length()];
    }

    static int[][] memo = null;

    public static int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        return lcsHelper(text1, text2, 0, 0);
    }

    public static int lcsHelper(String text1, String text2, int i, int j) {
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }

        if (memo[i][j] > 0) {
            return memo[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j))
            return memo[i][j] = 1 + lcsHelper(text1, text2, i + 1, j + 1);
        int length1 = lcsHelper(text1, text2, i + 1, j);
        int length2 = lcsHelper(text1, text2, i, j + 1);
        return memo[i][j] = Math.max(length1, length2);

    }

}
