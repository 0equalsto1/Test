package pack2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Freq {
	static int i = 10;

	public static void main(String[] args) throws ParseException {
		System.out.println(addDaysToDate("2017-07-01", 30));
		System.out.println(getEarning(2, 1, 4));
		List<String> list = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		try {
			while (true)
				list.add("sfef");
			// recTest();
		} catch (OutOfMemoryError e) {
			System.out.println(e);
			// while (true)
			// list2.add("sfef");
			// recTest();
		}

	}

	public static long getEarning(long bg, long de, long we) {
		long min = 0;
		if (de < we) {
			if (de < bg) {
				min = de;
			} else {
				min = bg;
			}

		} else if (we < bg) {
			min = we;
		} else {
			min = bg;
		}
		return min;// min == 0 ? bg : (bg < min ? bg : min);
	}

	public static void recTest() {
		if (i++ == 15)
			return;
		recTest();
		System.out.println(i);
	}

	public static String addDaysToDate(String date, int daaysToadd) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(date));
		c.add(Calendar.DATE, daaysToadd); // number of days to add
		date = sdf.format(c.getTime());
		return date;

	}

}