package date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtil {
	public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy/MM/dd";
	public static final String DATE_FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_DD_MM_YYYY = "dd/MM/yyyy";
	public static final String DATE_FORMAT_E_MMM_DD_HH_MM_SS_Z_YYYY = "E MMM dd HH:mm:ss z yyyy";
	public static final String DATE_FORMAT_YYYY_MM_DD_DEFAULT = "yyyy-MM-dd";
	public static final String DATE_FORMAT_MM_DD_YYYY = "MM/dd/yyyy";

	public static void main(String[] args) {
		DateFormat dateFormat;
		dateFormat = DateFormat.getDateInstance(DateFormat.LONG);
		Date today = new Date();
		String strDate = dateFormat.format(today);
		System.out.println(strDate);

		System.out.println(LocalDateTime.now());
		System.out.println(getCurrentDate());
		LocalDateTime ldt = LocalDateTime.now();//dd.MMM.yyyy
		System.out.println(DateTimeFormatter.ofPattern("MMM dd, yyyy").format(ldt));
		System.out.println(DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(ldt));
		System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(ldt));
		System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt));
		System.out.println(ldt);
	}

	public static Long currentTimeInSeconds() {
		return System.currentTimeMillis() / 1000;
	}

	/**
	 * returns today's date without time, or with 00:00:00:000 time.
	 * 
	 * @return
	 */
	public static Date getTodaysDate() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * Returns date String in required pattern
	 *
	 * @param dateString yyyy-MM-dd HH:mm:ss
	 * @param pattern    like yyyy/MM/dd
	 * @return
	 * @throws ParseException
	 */
	public static String format(String dateString, String pattern) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD_HH_MM_SS);
		Date date = dateFormat.parse(dateString);
		SimpleDateFormat dateFormat2 = new SimpleDateFormat(pattern);
		return dateFormat2.format(date);
	}

	/**
	 * Returns date String in required pattern
	 *
	 * @param date    {@link Date}
	 * @param pattern like yyyy/MM/dd
	 * @return
	 * @throws ParseException
	 */
	public static String format(Date date, String pattern) {
		SimpleDateFormat dateFormat1 = new SimpleDateFormat(pattern);
		return dateFormat1.format(date);
	}

	public static Date addDaysToDate(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	public static long getRemainingDayFromPresentDay(long targetDate) {
		Calendar currentDate = Calendar.getInstance();
		Calendar sourceDate = new GregorianCalendar();
		sourceDate.setTimeInMillis(targetDate);
		return (sourceDate.getTimeInMillis() - currentDate.getTimeInMillis()) / (24 * 60 * 60 * 1000);
	}

	public static LocalDateTime getCurrentDateTime() {
		LocalDateTime now = LocalDateTime.now();
		return now;
	}

	public static String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD_DEFAULT);
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		return currentDate;
	}

	public static boolean isValidFormat(String format, String value) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(value);
			if (!value.equals(sdf.format(date))) {
				date = null;
			}
		} catch (ParseException ex) {
			date = null;
		}
		return date != null;
	}

}
