package leetcode.intrv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlattenArray {

	public static void main(String[] args) {
		Object[] array = { 1, 2, new Object[] { 3, 4, new Object[] { 5 }, 6, 7 }, 8, 9, 10 };
		System.out.println("original: " + Arrays.deepToString(array));

		List<Integer> list = new ArrayList<>();
		for (Object o : array) {
			if (o instanceof Integer)
				list.add(Integer.parseInt(o.toString()));
			else
				flatten((Object[]) o, list);
		}
		System.out.println("flatten : "+list);
	}

	private static void flatten(Object[] array, List<Integer> list) {
		if (array.length == 1)
			list.add(Integer.parseInt(array[0].toString()));
		else {
			for (Object o : array) {
				if (o instanceof Integer)
					continue;
				else
					flatten((Object[]) o, list);
			}

		}
	}
}
