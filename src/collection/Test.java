package collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap; 

class Test { 
	public static void main(String[] args) 
	{
	/*	ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
		 
		map.put("First", 10);
		map.put("Second", 20);
		map.put("Third", 30);
		map.put("Fourth", 40);
		 
		Iterator<String> iterator = map.keySet().iterator();
		 
		while (iterator.hasNext()) {
		    String key = iterator.next();
		    map.put("Fifth", 50);
		}
		System.out.println(map);*/
		 
		ArrayList<String> list = new ArrayList<String>(); 

		list.add("A"); 
		list.add("B"); 
		list.add("C"); 
		list.add("D"); 
		list.add("E"); 

		Iterator<String> iterator = list.iterator(); 

		System.out.println("List elements : "); 
		list.add("");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		System.out.println(list); 
	
		} 
} 
