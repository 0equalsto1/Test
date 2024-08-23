package collection;
// Java Program to find common elements 

// in two ArrayLists 
// Using retainAll() method 

// import ArrayList package 
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CommonTwoList {

	// main method
	public static void main(String[] args) {

		ArrayList<String> list1 = new ArrayList<>();

		list1.add("Hii");
		list1.add("Geeks");
		list1.add("for");
		list1.add("qwe");

		// print list 1
		System.out.println("List1: " + list1);

		// Create ArrayList list2
		ArrayList<String> list2 = new ArrayList<>();

		// Add values in ArrayList
		list2.add("Hii");
		list2.add("Geeks");
		list2.add("Gaurav");

		// print list 2
		System.out.println("List2: " + list2);

		// Find the common elements
		list1.retainAll(list2);

		// print list 1
		System.out.println("Common elements: " + list1);
		System.out.println(list1.stream() 
                .filter(list2::contains) 
                .collect(Collectors 
                             .toList()));
	}
}
