package dateAndTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Date {

public static void LocalDateTimeApi() 
{ 
	
	Calendar cal = Calendar.getInstance();
	cal.set(Calendar.HOUR_OF_DAY,11);
	cal.set(Calendar.MINUTE,30);
	
	Calendar cal2 = Calendar.getInstance();
	cal2.set(Calendar.HOUR_OF_DAY,13);
	cal2.set(Calendar.MINUTE,45);
	
	Calendar cal3 = Calendar.getInstance();
	cal3.set(Calendar.HOUR_OF_DAY,10	);
	cal3.set(Calendar.MINUTE,30);
	System.out.println(cal.compareTo(cal3) * cal3.compareTo(cal2) >= 0);
	java.util.Date d = cal.getTime();

	LocalDate date = LocalDate.now(); 
	System.out.println("the current date is "+ 
						date); 


	// the current time 
	LocalTime time = LocalTime.now(); 
	System.out.println("the current time is "+ 
						time); 
	

	// will give us the current time and date 
	LocalDateTime current = LocalDateTime.now(); 
	System.out.println("current date and time : "+ 
						current); 


	// to print in a particular format 
	DateTimeFormatter format = 
	DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); 
	
	String formatedDateTime = current.format(format); 
	
	System.out.println("in foramatted manner "+ 
						formatedDateTime); 


	// printing months days and seconds 
	Month month = current.getMonth(); 
	int day = current.getDayOfMonth(); 
	int seconds = current.getSecond(); 
	System.out.println("Month : "+month+" day : "+ 
						day+" seconds : "+seconds); 

	// printing some specified date 
	LocalDate date2 = LocalDate.of(1950,1,26); 
	System.out.println("the repulic day :"+date2); 

	// printing date with current time. 
	LocalDateTime specificDate = 
		current.withDayOfMonth(24).withYear(2016); 

	System.out.println("specfic date with "+ 
					"current time : "+specificDate); 
}

	// Driver code
	public static void main(String[] args) {
		LocalDateTimeApi();
	}
}
