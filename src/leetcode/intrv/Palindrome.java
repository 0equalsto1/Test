package leetcode.intrv;

public class Palindrome {

	public static void main(String[] args) {

		String str = "12321";
		System.out.println(isPalindrome(str));
	}

	private static boolean isPalindrome(String str) {

		for (int i = 0, j = str.length()-1; i < j; i++, j--) {
			if (str.charAt(i) != str.charAt(j))
				return false;
		}
		return true;
	}

}
