package string;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringDate {
	private static DateTimeFormatter dateTimeformatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) {
		String s1 = "2019-01-29 12:25:05";
		String s2 = "2019-01-29 12:25:05";
		long s = System.currentTimeMillis();
		System.out.println(s1.compareTo(s2) + "  " + (System.currentTimeMillis() - s));
		s = System.currentTimeMillis();
		LocalDateTime logDate = getDateTime(s1);
		LocalDateTime startTime = getDateTime(s2);
		System.out.println(logDate.isBefore(startTime) + "  " + (System.currentTimeMillis() - s));
	}

	public static LocalDateTime getDateTime(String date) {
		return LocalDateTime.parse(date, dateTimeformatter);

	}
}
