package bit;

public class NearestPowerOf2 {
	public static void main(String[] args) {
		/*
		 * int num = 11; int nearest = 1; while (nearest <= num) { nearest <<= 1; }
		 * nearest >>= 1; System.out.println("Nearest power of 2 for " + num + " is: " +
		 * nearest);
		 */

		int num = 111;
		int nearest = 1;
		int numberOfLeadingZeros = numberOfLeadingZeros(num - 1);
		int MSBPos = 32 - numberOfLeadingZeros;
		nearest = nearest << MSBPos;
		System.out.println("Nearest power of 2 for " + num + " is: " + nearest);
	}

	public static int numberOfLeadingZeros(int i) {
		// HD, Count leading 0's
		if (i <= 0)
			return i == 0 ? 32 : 0;
		int n = 31;
		if (i >= 1 << 16) {
			n -= 16;
			i >>>= 16;
		}
		if (i >= 1 << 8) {
			n -= 8;
			i >>>= 8;
		}
		if (i >= 1 << 4) {
			n -= 4;
			i >>>= 4;
		}
		if (i >= 1 << 2) {
			n -= 2;
			i >>>= 2;
		}
		return n - (i >>> 1);
	}

	public static int numberOfLeadingZerosChatGPT(int i) {
		if (i == 0)
			return 32;
		int n = 1;
		if (i >>> 16 == 0) {
			n += 16;
			i <<= 16;
		}
		if (i >>> 24 == 0) {
			n += 8;
			i <<= 8;
		}
		if (i >>> 28 == 0) {
			n += 4;
			i <<= 4;
		}
		if (i >>> 30 == 0) {
			n += 2;
			i <<= 2;
		}
		n -= i >>> 31;
		return n;
	}
}