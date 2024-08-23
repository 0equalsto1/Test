package pack2;
import java.util.*;  
class TestCollection15{  
 @SuppressWarnings("boxing")
public static void main(String args[]){  
	 List<String> list = new ArrayList<>();
	 HashMap<Integer,String> hm=new HashMap<>();  
  for(int i=0;i<50000000;i++){  
  	 hm.put(i,i+""); 
  }
  long s=System.currentTimeMillis();
  System.out.println(hm.size());
  System.out.println(hm.isEmpty());
  System.out.println(System.currentTimeMillis()-s);
 }  
}  