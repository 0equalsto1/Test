package leetcode;

public class XtoPowerN {

	public static void main(String[] args) {
		System.out.println(xPowN(2.00000, -3));
//		System.out.println(myPow(2.00000, -10));
//		System.out.println(myPow2(2.00000, -5));
//		System.out.println(powerUsingIterative(2.00000, -5));
		int[] ans = new int[] {};
	}

	static double myPow(double x, int n) {
		if (n < 0)
			return 1 / (powerUsingRecursion1(x, n));
		else
			return powerUsingRecursion1(x, n);
	}

	static double myPow2(double x, int n) {
		if (n < 0)
			return 1 / (powerUsingRecursion2(x, n));
		else
			return powerUsingRecursion2(x, n);
	}

	static double powerUsingRecursion1(double x, int n) {
		if (n == 0)
			return 1;

		double ans = powerUsingRecursion1(x, n / 2);
		ans = ans * ans;
		if ((n & 1) == 1)
			ans = x * ans;

		return ans;
	}

	static double powerUsingRecursion2(double x, int n) {
		if (n == 0)
			return 1;

		if ((n & 1) == 1)
			return x * powerUsingRecursion2(x * x, n / 2);

		return powerUsingRecursion2(x * x, n / 2);

	}

	static double powerUsingIterative(double x, int n) {

		if (x == 0 || n == 0)
			return 1;
		if (n == 1)
			return x;
		if (n < 0)
			x = 1 / x;
		double ans = 1;
		while (n != 0) {
			if (n % 2 != 0)
				ans = ans * x;
			x = x * x;
			n = n / 2;

		}
		return ans;

	}

	public static double xPowN(double x, int n) {
		double ans = x;
		boolean even = n % 2 == 0;
		int p = even ? n : Math.abs(n) - 1;
		for (int i = p; i > 1; i = p) {
			ans = ans * ans;
			p = p / 2;
		}
		if (!even)
			ans = ans * x;
		if (n < 0)
			ans = 1 / ans;
		return ans;
	}
}
