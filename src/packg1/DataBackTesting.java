package packg1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBackTesting {
/*public static void main(String[] args) throws ParseException {
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = new Date();
	String date2 = dateFormat.format(date);
	System.out.println(date2);
	Date date3 = dateFormat.parse(date2);
	System.out.println(date3);
	System.out.println(new Date().getTime());
}
}
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.Month;

public class Java8Tester {*/
   public static void main(String args[]){
	   DataBackTesting java8tester = new DataBackTesting();
      java8tester.testLocalDateTime();
   }
	
   public void testLocalDateTime(){
	   
	   Map<String, String> map = new HashMap<>();  
       map.put("name", "Java Pointers");  
       map.put("domain", "www.javapointers.com");  
       map.put("description", "Learn how to program in Java");
	   
       for (String keyMap : map.keySet()) {  
           System.out.println(keyMap + " " + map.get(keyMap));  
       }
       
       /*
	
	   int totalTimeinSec = 5;
		long startTime = System.currentTimeMillis();
		boolean toFinish = false;
		
		while (!toFinish) {
			toFinish = (System.currentTimeMillis() - startTime >= totalTimeinSec);
			for(int i=0;i<3;i++) {
				System.out.println(i);
			}
		}
   */
	   List<String> list = new ArrayList<>();
	   list.add("a");
	   list.add("b");
	   list.add("c");
	   list.add("d");
	   list.add("e");
	   list.add("f");
	   iterateList(list);
	   
	   Object obg = 13;
	   int i=(int) obg;
	   if(i==2){
		   
	   }
	   System.out.println(obg);
   }
   public void iterateList(List<String> list){
	   for(String s : list)
		   System.out.println(s);
   }
}