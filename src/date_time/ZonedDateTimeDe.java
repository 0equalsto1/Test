package date_time;

import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

public class ZonedDateTimeDe {
	static DateTimeFormatter startFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 00:00:00");
	static DateTimeFormatter endFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 23:59:59");

	public static void main(String[] args) {
		/*final ZonedDateTime input = ZonedDateTime.now();
		ZonedDateTime fstDaylastWeek = input.with(DayOfWeek.MONDAY).minusWeeks(1);
		ZonedDateTime lstDaylastWeek = fstDaylastWeek.plusDays(6);
		System.out.println(fstDaylastWeek);
		System.out.println(lstDaylastWeek);*/
		/*System.out.println(input);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedString = input.format(formatter);
		System.out.println(formattedString);
		System.out.println(input.with(DayOfWeek.MONDAY));
		final ZonedDateTime startOfLastWeek = input.minusWeeks(1).with(DayOfWeek.MONDAY);
		System.out.println(startOfLastWeek);
		final ZonedDateTime endOfLastWeek = startOfLastWeek.plusDays(6);
		System.out.println(endOfLastWeek);*/
		getCondition(1);
		getCondition(2);
		getCondition(3);
		getCondition(4);
		getCondition(5);
		getCondition(6);
		getCondition(7);
	}

	{
		ZonedDateTime input = ZonedDateTime.now();

		String formattedString = input.format(startFormatter);
		System.out.println(formattedString);
	}
	{
		ZonedDateTime input = ZonedDateTime.now();
		ZonedDateTime currentWeek = input.with(DayOfWeek.MONDAY);
		ZonedDateTime startOfLastWeek = input.minusWeeks(1).with(DayOfWeek.MONDAY);
	}

	void calenderOPS() {

		Calendar cal = Calendar.getInstance();
		System.out.println(System.currentTimeMillis());
		System.out.println(cal.getTimeInMillis());
		cal.set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of day !
		cal.clear(Calendar.MINUTE);
		cal.clear(Calendar.SECOND);
		cal.clear(Calendar.MILLISECOND);
		Date firstDayOfTheWeek = cal.getTime();
		System.out.println(firstDayOfTheWeek);
		cal.set(Calendar.DAY_OF_WEEK, 2);
		System.out.println(cal.getTime());
		cal.set(Calendar.DAY_OF_MONTH, 1);
		System.out.println(cal.getTime());

	}

	public static String getCondition(int value) {
		final ZonedDateTime input = ZonedDateTime.now();

		String condition = "";
		String start = "";
		String end = "";
		switch (value) {
		// this week
		case 1:
			ZonedDateTime currentWeek = input.with(DayOfWeek.MONDAY);
			start = currentWeek.format(startFormatter);
			condition = "modified_on > " + "'" + start + "'";

			break;
		// last week
		case 2:
			ZonedDateTime fstDaylastWeek = input.with(DayOfWeek.MONDAY).minusWeeks(1);
			start = fstDaylastWeek.format(startFormatter);
			ZonedDateTime lstDaylastWeek = fstDaylastWeek.plusDays(6);
			end = lstDaylastWeek.format(endFormatter);
			condition = "modified_on between " + "'" + start + "'" + " and " + "'" + end + "'";
			break;
		// this month
		case 3:
			ZonedDateTime monthStart = input.with(TemporalAdjusters.firstDayOfMonth());
			start = monthStart.format(startFormatter);
			condition = "modified_on > " + "'" + start + "'";
			break;
		// last month
		case 4:
			ZonedDateTime lastMonth = input.minusMonths(1);
			ZonedDateTime fstDayLastMonth = lastMonth.with(TemporalAdjusters.firstDayOfMonth());
			start = fstDayLastMonth.format(startFormatter);
			ZonedDateTime lstDayLastMonth = lastMonth.with(TemporalAdjusters.lastDayOfMonth());
			end = lstDayLastMonth.format(endFormatter);
			condition = "modified_on between " + "'" + start + "'" + " and " + "'" + end + "'";
			break;
		// last 3 month
		case 5:
			ZonedDateTime startLast3Month = input.minusMonths(3).with(TemporalAdjusters.firstDayOfMonth());
			start = startLast3Month.format(startFormatter);
			ZonedDateTime endLast3Month = input.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
			end = endLast3Month.format(endFormatter);
			condition = "modified_on between " + "'" + start + "'" + " and " + "'" + end + "'";
			break;
		// last 6 month
		case 6:
			ZonedDateTime startLast6Month = input.minusMonths(6).with(TemporalAdjusters.firstDayOfMonth());
			start = startLast6Month.format(startFormatter);
			ZonedDateTime endLast6Month = input.minusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
			end = endLast6Month.format(endFormatter);
			condition = "modified_on between " + "'" + start + "'" + " and " + "'" + end + "'";
			break;
		// this year
		case 7:
			ZonedDateTime thisYear = input.with(TemporalAdjusters.firstDayOfYear());
			start = thisYear.format(startFormatter);
			condition = "modified_on > " + "'" + start + "'";
			break;

		default:
			condition = "modified_on > " + "'" + start + "'";
			break;
		}
		System.out.println("for value " + value + " = " + condition);
		return condition;
	}
}
