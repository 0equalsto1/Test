package pack2;

import java.util.Scanner;

public class FizzBizz {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		for (int i = 1; i <= N; i++) {

			if (i % 15 == 0)
				System.out.println("FizzBuzz");
			else if (i % 3 == 0)
				System.out.println("Fizz");
			else if (i % 5 == 0)
				System.out.println("Buzz");
		}
	}

}
