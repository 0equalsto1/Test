package date_time;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeFormatChange {

	public static void main(String[] args) throws ParseException {

		String dateString = "2018-07-31T12:00:00Z";
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		Date date = null;
		date = sdf.parse(dateString);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
		String formatDate = simpleDateFormat.format(date);
		System.out.println(formatDate);
		System.out.println(simpleDateFormat.parse(formatDate));
		convert(dateString);
	}

	public static void convert(String dateString) throws ParseException {
		System.out.println("Given date is " + dateString);
		LocalDateTime date = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));

		System.out
			.println("yyyy-MM-dd formatted date : " + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS").format(date));

	}

}