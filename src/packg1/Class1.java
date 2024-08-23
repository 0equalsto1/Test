package packg1;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Class1 {
	private static final Date end = new Date();

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println("Hello Java");
		BigInteger big1 = new BigInteger("1234567856656567242177779");
		BigInteger big2 = new BigInteger("12345565678566567131275737372");
		BigInteger bigSum = big1.add(big2);
		System.out.println(bigSum);
		ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>();
		String[] testStrings = { "All fall gala hall", "this\\is/a%test\t_~!@#$%^&*()dude" };
		String[] arrayOfString1;
		int j = (arrayOfString1 = testStrings).length;
		for (int i = 0; i < j; i++) {
			String s = arrayOfString1[i];
			String encodedString = URLEncoder.encode(s, "UTF-8");
			System.out.format("'%s'\n", new Object[] { encodedString });
			Collections.synchronizedList(new ArrayList<String>());

		}
		/*
		 * long sum = 0L; long startTime = System.currentTimeMillis(); for (long ii
		 * = 0; ii < Integer.MAX_VALUE; ii++) { sum += ii; } System.out.println(
		 * "timeTaken = "+(System.currentTimeMillis()-startTime));
		 * System.out.println(sum);
		 */
		int p = 1 << 30;
		System.out.format("********** " + p);
		System.out.println();
		String nul = "";
		System.out.println(nul.equals(""));
	}

	public boolean fun(String s) {
		if (s.equals(""))
			return true;
		else
			return false;
	}
}