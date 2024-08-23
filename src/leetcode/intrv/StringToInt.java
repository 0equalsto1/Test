package leetcode.intrv;

public class StringToInt {

	public static int stringToInt(String s) {
		if (s == null || s.isEmpty())
			throw new NumberFormatException();
		int i = 0;
		char c = s.charAt(0);
		boolean isNagtive = false;
		if (c == '-') {
			isNagtive = true;
			i++;
		} else if (c == '+')
			i++;
		/*else if (!isInt(c))
			throw new NumberFormatException();*/

		long num = 0;//123
		int n = s.length();

		for (; i < n; i++) {
			c = s.charAt(i);
			if (!isInt(c))
				throw new NumberFormatException();
			num = num * 10 + ((int) c - 48);
			if (num > Integer.MAX_VALUE)
				throw new ArithmeticException("out of range");
		}

		return (int) (isNagtive ? -num : num);
	}

	private static boolean isInt(final char c) {
		// '0' and '9' assci value = 48,57
		return (c >= 48 && c <= 57);
	}

	public static void main(String[] args) {
//		String s = "+123";
//		String s = "-12122";
		String s = "-c12122";
		System.out.println(stringToInt(s));
	}
}