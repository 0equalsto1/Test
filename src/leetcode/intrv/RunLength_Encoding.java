package leetcode.intrv;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

// Java program to implement run length encoding

public class RunLength_Encoding {
	public static void printRLE(String str) {
		List<Integer> ids = Arrays.asList(1, 1, 5, 5);
		System.out.println(deleteProducts(ids, 2));
		System.out.println("==================");
		int n = str.length();
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < n; i++) {

			// Count occurrences of current character
			int count = 1;
			while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
				count++;
				i++;
			}

			// Print character and its count
//			System.out.print(str.charAt(i));
//			System.out.print(count);
			b.append(str.charAt(i));
			if (count > 1)
				b.append(count);
		}
		System.out.println(b.toString());
	}

	public static void main(String[] args) {
		String str = "wwwwaaadexxxxxxywwws";
//		printRLE(str);
		System.out.println(compressString(str));

	}

	public static int deleteProducts(List<Integer> ids, int m) {
		// Write your code here
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>(ids.size(), 1.0f);
		int size = 0;

		for (Integer key : ids) {
			if (!map.containsKey(key)) {
				map.put(key, 1);
				size++;
			} else
				map.put(key, map.get(key) + 1);
		}
		for (Entry<Integer, Integer> mp : map.entrySet()) {
			if (mp.getKey() <= m) {
				m -= mp.getKey();
				count++;
			} else
				return size - count;
		}
		return size - count;
	}

	static String compressString(String str) {
		// wwwwaaadexxxxxxywww
		int n = str.length();
		int count = 1;
		int i = 0;
		StringBuilder b = new StringBuilder();
		for (; i < n - 1; i++) {

			if (str.charAt(i) == str.charAt(i + 1))
				count++;
			else {
				b.append(str.charAt(i));
				if (count > 1)
					b.append(count);
				count = 1;

			}

		}
		b.append(str.charAt(i));
		if (count > 1)
			b.append(count);
		return b.toString();

	}
}
