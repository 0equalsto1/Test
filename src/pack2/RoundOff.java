package pack2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class RoundOff {

	@SuppressWarnings({ "unchecked", "boxing", "rawtypes" })
	public static void main(String[] args) {
		long data = 1025;
		if (data < (2 << 19)) {
			double val = (double) data / (2 << 9);
			int i = 0;
		}
		double d = (double) data / (1024);
		BigDecimal bd = new BigDecimal(d);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		System.out.println(bd);
		System.out.println(2 << 19);
		System.out.println((double) (124587 / 2569));
		System.out.println((double) 124587 / 2569);
		Map condition = new HashMap(2);
		condition.put("customer_id", 4534534);
		condition.put("cDate", "c5445345");
		StringBuilder names = new StringBuilder();
		names.append(condition.get("customer_id")).append("aaaa").append("000, ");
		System.out.println(names);
		System.out.println(names.toString().replaceAll(", $", " and more"));
		String h="a, b, c, ";
		System.out.println(h.replaceAll(", $", " rohit"));
		long l = new Long("30");
		System.out.println(l);
		System.out.println(minimum(2, 0, 1));
	}

	public static int minimum(int a, int b, int c) {
		if (b < a) {
			a = b;
		}
		if (c < a) {
			a = c;
		}
		return a;
	}

}
