package pack3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Testing {

	public static void main(String[] args) throws ParseException {
//		System.out.println("".matches("\\d{1,}"));
//		DateFormat df = new SimpleDateFormat("YY");
//		System.out.println(df.format(new Date()));
		DateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for(int i=1;i<=10;i++){
			
	  Calendar c = Calendar.getInstance();
	  c.setTime(sdf.parse("2017-07-08"));
	  c.add(Calendar.DATE, i); // number of days to add
	  String date = sdf.format(c.getTime());
	  System.out.print(date+",");
		}
//		DateFormat targetFormat = new SimpleDateFormat("dd,MMM yyyy");
		Date date = originalFormat.parse("2017-06-12_02:05:58");
//		System.out.println(originalFormat.format(date));
//		System.out.println("2017-06-12".equals(originalFormat.format(date)));
//		arrayTest();
	}

	public static int versionCompare(String currentVer, String appVer) {
		String[] vals1 = currentVer.split("\\.");
		String[] vals2 = appVer.split("\\.");
		int i = 0;
		// set index to first non-equal ordinal or length of shortest version string
		while (i < vals1.length && i < vals2.length && vals1[i].equals(vals2[i])) {
			i++;
		}
		// compare first non-equal ordinal number
		if (i < vals1.length && i < vals2.length) {
			int diff = Integer.valueOf(vals1[i]).compareTo(Integer.valueOf(vals2[i]));
			return Integer.signum(diff);
		}
		// the strings are equal or one string is a substring of the other
		// e.g. "1.2.3" = "1.2.3" or "1.2.3" < "1.2.3.4"
		return Integer.signum(vals1.length - vals2.length);
	}

	public static void arrayTest() throws ParseException {
		SimpleDateFormat datePattern = new SimpleDateFormat("yyyy-MM-dd");
		Date date = datePattern.parse("2017-06-30");
		if ("2017-06-30".equals(datePattern.format(date)))
			System.out.println("true");
		else
			System.out.println("false");
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
