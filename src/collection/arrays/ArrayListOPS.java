package collection.arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayListOPS {

	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
		List<Integer> list = new ArrayList<>(50000000);
		long s = System.currentTimeMillis();
		for (int i = 0; i < 5; i++)
			list.add(i + 1);

		long e = System.currentTimeMillis();
		System.out.println(e - s);

	}

}
