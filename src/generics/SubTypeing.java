package generics;

import java.util.ArrayList;
import java.util.List;

public class SubTypeing {

	public static void main(String[] args) {
		Object o = "";
		List<Object> list = new ArrayList<>();
		list.add("a");
		list.add(9);
		list.add(new StringBuffer());
		List<Integer> intlist = new ArrayList<>();
		List<? extends Number> wnknown = intlist;
		wnknown.add(null);
//		wnknown.add(2); read only
		List<? super String> superList = new ArrayList<>();
		superList.add("aa");
		superList.add(null);
//		superList.add(new Object());
//		varArgs();
	}

	public static void process(List<? extends Number> list) {
		list.add(null);
	}

	public static void addNumbers(List<? super Integer> list) {
		list.add(11);
	}
	public static void varArgs(int... args) {
		if (args.length==0) {
			return;
		}
	}
	
}
