package math;

public class Factorial {
	public static void main(String[] args) {
		int n = 20;
		long s = System.currentTimeMillis();
		System.out.println("Factorial of " + n + " is: " + loop(n));
		System.out.println("Factorial of " + n + " is: " + recursion(n));
		System.out.println(System.currentTimeMillis()-s);
	}

	static long loop(int number) {
		long i, fact = 1;
		for (i = 1; i <= number; i++) {
			fact = fact * i;
		}
		return fact;
	}

	static long recursion(long n) {
		if (n == 1)
			return 1;
		else
			return (n * recursion(n - 1));
	}
}
