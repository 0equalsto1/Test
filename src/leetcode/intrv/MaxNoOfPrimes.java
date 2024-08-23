package leetcode.intrv;

import java.util.Arrays;
import java.util.Scanner;

public class MaxNoOfPrimes {

	public static void main(String args[]) throws Exception {
		/* Sample code to perform I/O:
		 * Use either of these methods for input
		
		//BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();                // Reading input from STDIN
		System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
		
		//Scanner
		Scanner s = new Scanner(System.in);
		String name = s.nextLine();                 // Reading input from STDIN
		System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
		
		*/

		// Write your code here
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			int n = s.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = s.nextInt();
			}
			System.out.println(subArray(a, n));
		}
		s.close();
	}

	public static void checkPrime(boolean p[], int n) {
		p[0] = false;
		p[1] = false;
		for (int i = 2; i * i <= n; i++) {
			if (p[i]) {
				for (int j = i * 2; j <= n; j = j + i) {
					p[j] = false;
				}
			}
		}
	}

	static int subArray(int[] a, int n) {
		int max = Arrays.stream(a).max().getAsInt();
		boolean[] p = new boolean[max + 1];
		Arrays.fill(p, true);
		checkPrime(p, max);
		int c = 0, m = 0;
		for (int i = 0; i < n; i++) {
			if (p[a[i]] == false)
				c = 0;
			else {
				c++;
				m = Math.max(c, m);
			}
		}
		return m;
	}

}
