package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Generics {
	
	public static  <E> void printList(List<E> list) {
	    for (Object elem : list) {
	        System.out.println(elem + " ");
	    }
	    System.out.println();
	}
	
	public static void addNumbers(List<? super Number> list) {
	    for (int i = 1; i <= 10; i++) {
	        list.add(i);
	    }
	    
	    
	}
	public static void main(String[] args) {
//		test(1.1);
		
		ArrayList<String> list = new ArrayList<>();
		Collections.synchronizedList(list);
		list.add("a");
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("c");
		list.add("d");
		list.add("i");
		list.add("i");
		printList(list);
		System.out.println();
	}

	public static <T> Map<T, Long> getCount(List<T> list) {
		Map<T, Integer> map = new HashMap<>();
		Map<T, Long> counting = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		return counting;

	}
	public static  Map<?, Long> getCount2(ArrayList<?> list) {
		Map<?, Integer> map = new HashMap<>();
		Map<?, Long> counting = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		return counting;

	}

	public static void test(Object s) {
		System.out.println("Object");
	}
	
	public static void test(int s) {
		System.out.println("String");
	}
}
