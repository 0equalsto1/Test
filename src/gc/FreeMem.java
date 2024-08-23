package gc;

import java.util.ArrayList;
import java.util.List;

public class FreeMem {

	public static void main(String[] args) {
		long freeMemory = Runtime.getRuntime().freeMemory();
		System.out.println("freeMemory : " + freeMemory);
		f1();
		freeMemory = Runtime.getRuntime().freeMemory();
		System.out.println("freeMemory : " + freeMemory);
	}

	private static void f1() {
		List<String> list = new ArrayList<>();
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		long freeMemory = Runtime.getRuntime().freeMemory();
		System.out.println("freeMemory : " + freeMemory);
		list =null;
		list1 =null;
		list2 =null;
		System.gc();

	}

}
