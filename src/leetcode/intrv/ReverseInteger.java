package leetcode.intrv;

public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(~8);
		System.out.println(reverse(12345));
		String binaryString = Integer.toBinaryString(8);
		System.out.println(binaryString);
		System.out.println(Integer.parseUnsignedInt(binaryString, 2));
		System.out.println(reverseBits(8));

	}

	public static int reverse(int x) {

		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (rev > 0 && rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			else if (rev < 0 && rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			rev = rev * 10 + pop;
		}
		return rev;
	}

	public static int reverseBits(int n) {
		int res = 0;
		for (int i = 0; i < 32; i++) {
			res = res << 1;
			res += n & 1;
			n = n >>> 1;
		}
		return res;
	}
}
