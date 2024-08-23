package leetcode.intrv;

class LongestPalindromicSubstring {
	static int resultStart;
	static int resultLength;

	public static void main(String[] args) {
		System.out.println(longestPalindrome("aabbaaa"));
	}

	public static String longestPalindrome(String s) {
		int strLength = 0;
		if (s == null || (strLength = s.length()) < 2) {
			return s;
		}

		for (int start = 0; start < strLength - 1; start++) {
			expandRange(s, start, start);
			expandRange(s, start, start + 1);
		}
		return s.substring(resultStart, resultStart + resultLength);
	}

	private static void expandRange(String str, int begin, int end) {
		while (begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
			begin--;
			end++;
		}
		if (resultLength < end - begin - 1) {
			resultStart = begin + 1;
			resultLength = end - begin - 1;
		}
	}
}