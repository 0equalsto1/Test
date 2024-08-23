package numberFormat;

import java.text.NumberFormat;

public class Snippet {
	public static void main(String[] args) {
		long number = 20200000123l;
		NumberFormat numberFormat = NumberFormat.getInstance();

		String numberAsString = numberFormat.format(number);

		System.out.println(numberAsString);
	}
}
