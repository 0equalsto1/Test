package pack3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TestTest {

	public static void main(String[] args) throws ParseException {
		String id ="5a38de9952eb2c4213285b9fxxxx";
		
		System.out.println(id.substring(0,4));
		String time = System.nanoTime()+"";
		time = time.substring(time.length()-1);
		System.out.println(time);
		Object obj = new Object();
		String client = "field";
		System.out.println("========== "+"field.lastID.directpolicyindia ".matches("(?i)"+client+".*"));
		String myDate = "2014-10-29";
		StringBuilder sb = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(myDate);
		long millis = date.getTime();
//		System.out.println(millis);
//		System.out.println(new Date(millis));

		Random r = new Random();
		int Low = 10;
		int High = 11;
		int Result = ThreadLocalRandom.current().nextInt(Low, High + 1);
//		System.out.println(2097152 / (2 << 19));
		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
//		cal.setFirstDayOfWeek(Calendar.FRIDAY);
//		cal.set(2017, 01, 01);// 2017-01-06
//		System.out.println(new SimpleDateFormat("MMM_yyyy").format(cal.getTime()));
		System.out.println(cal.getFirstDayOfWeek());
		System.out.println(cal.get(Calendar.WEEK_OF_YEAR));
//		System.out.println(new SimpleDateFormat("w").format(new java.util.Date()));
		
		Integer count = null;
		System.out.println(Integer.toString(8));

	}

}
