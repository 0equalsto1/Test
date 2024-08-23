package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExample {
	public static void main(String[] args) {
		List<String> asList = new ArrayList<>(Arrays.asList("a", "b", "c"));
//		asList.add("d");
		List<String> list = new ArrayList<>();
		list.addAll(asList);
		System.out.println(list);
		list.add("g");
		ArrayList<String> list1 = new ArrayList<>(); // list 1

		list1.add("E");
		list1.add("B");
		list1.add("C");
		list1.add("D");

		ArrayList<String> list2 = new ArrayList<>(); // list 2

		list2.add("A");

		list1.addAll(list2);

		System.out.println(list1); // combined list
	}
}