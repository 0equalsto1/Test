package leetcode.intrv;

public class PowerOfN {

	public static void main(String[] args) {
		/*System.out.println(power(2, 3));
		System.out.println(power(2, 5));
		System.out.println(power(2, -3));
		System.out.println(power(-2, 8));
		System.out.println(power(4, 4));*/
//		System.out.println(power(5.5, 1));

		double x = 2;
//		int n = -2;
		int n = 20;
		if (n < 0)
			System.out.println(1.0 / xpowerN(x, n));
		else
			System.out.println(xpowerN(x, n));
	}

	static double xpowerN(double x, int n) {

		if (x == 0 || n == 0)
			return 1;
		if (n == 1)
			return x;
		double ans = 1;
		while (n != 0) {
			if (n % 2 != 0)
				ans = ans * x;
			x = x * x;
			n = n / 2;

		}
		return ans;

	}
}
