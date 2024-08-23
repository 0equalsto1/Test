package date_time;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

public class DateDiff {

	public static void main(String[] args) throws InterruptedException {
		long epochSecond1 = Instant.now().getEpochSecond();
		System.out.println(epochSecond1);
		TimeUnit.SECONDS.sleep(4);
		long epochSecond2 = Instant.now().getEpochSecond();
		System.out.println(epochSecond2);
		LocalDate endofCentury = LocalDate.of(2014, 01, 01);
		LocalDate now = LocalDate.now();
		
		Period diff = Period.between(endofCentury, now);

		System.out.printf("Difference is %d years, %d months and %d days old", diff.getYears(), diff.getMonths(),
				diff.getDays());

		// your code
		Instant start = Instant.now();
		Instant end = Instant.now();
		Duration timeElapsed = Duration.between(start, end);
		System.out.println("Time taken: " + timeElapsed.toMillis() + " milliseconds");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		LocalDateTime dateTime1 = LocalDateTime.parse("2019-04-18 10:58:00", formatter);
		LocalDateTime dateTime2 = LocalDateTime.parse("2019-04-18 11:00:00", formatter);

		long diffInMilli = Duration.between(dateTime1, dateTime2).toMillis();
		long diffInSeconds = Duration.between(dateTime1, dateTime2).getSeconds();
		long diffInMinutes = Duration.between(dateTime1, dateTime2).toMinutes();
		System.out.println(diffInMilli+" : "+diffInSeconds+" : "+diffInMinutes);
		System.out.println("====================================================");
		
		LocalDateTime dateTim3 = LocalDateTime.parse("2019-05-14 00:15:48", formatter);
		System.out.println(dateTim3.getHour());
	}

}
