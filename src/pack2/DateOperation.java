package pack2;

import java.util.Calendar;

public class DateOperation {

	public static void main(String[] args) {
		GetMonthName();
	}

	public static void GetMonthName() {
		Calendar cal = Calendar.getInstance();
		// return new SimpleDateFormat("MMM_yyyy").format(cal.getTime());
		System.out.println(cal.get(Calendar.MONTH));
		countSubstringWithEqualEnds("abcabb");
	}

	static int countSubstringWithEqualEnds(String s) {
		int result = 0;
		int n = s.length();
		int MAX_CHAR = 26;

		// Calculating frequency of each character
		// in the string.
		int count[] = new int[MAX_CHAR];
		for (int i = 0; i < n; i++)
			count[s.charAt(i) - 'a']++;

		// Computing result using counts
		for (int i = 0; i < MAX_CHAR; i++) {
			result += (count[i] * (count[i] + 1) / 2);
		}

		return result;
	}
}
