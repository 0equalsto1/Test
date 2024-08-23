package pack2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

class A
{
    //A Class
}
 
public class MainClass
{
    public static void main(String[] args)
    {
    	
    	System.out.println("aaa aa  avvv ".replaceAll(" ", ""));
        /*System.out.println((1 << (Integer.SIZE - 3)) - 1);
        System.out.println(Runtime.getRuntime().availableProcessors());
        
        Calendar cal = Calendar.getInstance();
        System.out.println(new SimpleDateFormat("MMM").format(cal.getTime()));
        int year = Calendar.getInstance().get(Calendar.YEAR);
//        System.out.println(year);
        byte[] b= new byte[]{-1};*/
        long time = System.currentTimeMillis();
        System.out.println(time);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cald = Calendar.getInstance();
        cald.setTimeInMillis(time);
        System.out.println(dateFormat.format(cald.getTime()));
        dateFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println(dateFormat.format(cald.getTime()));
        
    }
    int test(List<String> list){
    	try {
				
			} finally {
				// TODO: handle finally clause
			}
			return 0;
    	
    }
}