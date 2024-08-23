package codility;

public class NumnerSystemConversion {

	public static void main(String[] args) {
		System.out.println(~-1 | 1);
		System.out.println(Integer.toBinaryString(~5 | 1));
		System.out.println(hexToDecimal("1A"));
		System.out.println(decToHexa(2545));
	}

	static int hexToDecimal(String hexVal) {

		int ans = 0;
		// char 'A, ascii = 65,'a'=97,'7'=55,'0'=48
		for (char ch : hexVal.toCharArray()) {

			if (ch >= '0' && ch <= '9') {
				ans = ans * 16 + (ch - 48);
			}

			else if (ch >= 'A' && ch <= 'F') {
				ans = ans * 16 + (ch - 55);
			}
		}
		return ans;

	}

	static String decToHexa(int n) {
		String ans = "";
		while (n != 0) {

			int rem = n % 16;

			if (rem < 10)
				ans = (char) (rem + 48) + ans;
			else
				ans = (char) (rem + 55) + ans;

			n = n / 16;
		}
		return ans;

	}

	public static String toHex(int num) {
		char[] map = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

		if (num == 0)
			return "0";
		String result = "";
		while (num != 0) {
			result = map[(num & 15)] + result;
			num = (num >>> 4);
		}
		return result;
	}

}
