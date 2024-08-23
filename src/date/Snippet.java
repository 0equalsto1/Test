package date;

import java.time.Instant;
import java.util.Date;

public class Snippet {
	public static void main(String[] args) {
			Date truncatedDate = null;//DateUtils.truncate(new Date(), Calendar.DATE);
			System.out.println(truncatedDate);
			Instant instant = truncatedDate.toInstant();
			System.out.println(instant.getEpochSecond());
	//		1591554600
		}
}

