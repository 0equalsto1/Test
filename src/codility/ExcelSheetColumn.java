package codility;

public class ExcelSheetColumn {

	public static void main(String[] args) {
		System.out.println('1' - '0');
		System.out.println(getNumber("999"));
//		System.out.println(titleToNumber("ZY"));
	}

	public static String convertToTitle(int n) {
		StringBuilder result = new StringBuilder();

		while (n > 0) {
			n--;
			result.insert(0, (char) ('A' + n % 26));
			n /= 26;
		}

		return result.toString();
	}

	public static int titleToNumber(String col) {
		// 123
		int ans = 0;

		for (char ch : col.toCharArray()) {
			ans = ans * 26 + (ch - 'A' + 1);
		}

		/*
		 int j = 0;
		 for (int i = col.length() - 1; i >= 0; i--) {
			ans = (int) (ans + (Math.pow(26, j++) * (col.charAt(i) - 'A' + 1)));
		}*/
		return ans;
	}

	public static int getNumber(String num) {
		int ans = 0;
		for (char ch : num.toCharArray()) {
			ans = ans * 10 + (ch - '0');
		}
		return ans;

	};
}
