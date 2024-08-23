package packg1;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UseConstant {
public static void main(String[] args) {
	int i=0;
	System.out.println(i%20==0);
  SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
  System.out.println("file"+df.format(new Date()));
	String selectQuery = "SELECT `customer_id`,SUM(`wifi_data_earned`+`mobile_data_earned`) as Earning FROM `temp_table` WHERE `campaign_id` IN (1,4,7,14,23,25,26,56,193,224,225,237,255,260,261,298,306,307,325,343,344,349,355,370,371,372,380,383)"+
	"AND customer_id IN ($a)"+"GROUP BY customer_id"+"HAVING Earning > 0";
		
	StringBuffer buffer=new StringBuffer();
	for(int x =0;x<4;x++){
		 buffer.append(x);
		 buffer.append(",");
	 }
	buffer.deleteCharAt(buffer.length()-1);

	selectQuery.replace("$a", buffer.toString());
	System.out.println(selectQuery);
	
	List <String> l1 = new ArrayList<>();
	List<Integer> l2 = new ArrayList<>();
	System.out.println(l1.getClass() == l2.getClass());
}
}
