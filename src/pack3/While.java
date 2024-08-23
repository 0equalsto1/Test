package pack3;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class While {

	public static void main(String[] args) throws ParseException {
		List list = new ArrayList<String>();
		System.out.println(System.currentTimeMillis());
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(System.currentTimeMillis());

		int mYear = calendar.get(Calendar.YEAR);
		int mMonth = calendar.get(Calendar.MONTH);
		int mDay = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
//		System.out.println(calendar.getTime().getHours());
		getPath();
	}
	public static void getPath() {
		Path currentRelativePath = Paths.get("");
  String s = currentRelativePath.toAbsolutePath().toString();
  System.out.println(s);
	}
	public static String addDays(String date, int daaysToadd) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(date));
		c.add(Calendar.DATE, daaysToadd); // number of days to add
		date = sdf.format(c.getTime());
		return date;

	}
}
