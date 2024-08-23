package date_time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Snippet {
	public static final String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

	public static void main(String[] args) {

		/*
		 * Date d = getDateFromPattern("2018-11-13 13:22:26",
		 * DATE_FORMAT_YYYY_MM_DD_HH_MM_SS); System.out.println(d.getTime() / 1000);
		 * 
		 */
		String format = format(new Date(), DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
		System.out.println(format);

	}

	public static String format(Date date, String pattern) {
		SimpleDateFormat dateFormat1 = new SimpleDateFormat(pattern);
		return dateFormat1.format(date);
	}
}
