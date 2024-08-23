package collection.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class SortByValue {

	public static void main(String... args) {
		Map<Integer, String> random = new HashMap<Integer, String>();
		for (int i = 0; i < 10; i++) {
//			random.put((int) (Math.random() * 100), String.valueOf((int) (Math.random() * 100)));
			random.put(i + 1, "5");
		}
		Set<Entry<Integer, String>> entrySet = random.entrySet();
		List<Entry<Integer, String>> list = new ArrayList<>(entrySet);
		System.out.println("Initial Map: " + Arrays.toString(entrySet.toArray()));
		System.out.println("Initial List: " + Arrays.toString(list.toArray()));
		list.sort((Entry<Integer, String> o1, Entry<Integer, String> o2) -> o1.getValue().compareTo(o2.getValue()));
		System.out.println("Sorted List: " + Arrays.toString(list.toArray()));
		long s = System.currentTimeMillis();
		Map<Integer, String> sorted = new TreeMap<Integer, String>(new ValueComparator(random, false));
		sorted.putAll(random);
		long e = System.currentTimeMillis();
		System.out.println("Sorted Map: " + Arrays.toString(sorted.entrySet().toArray()));
		System.out.println("time taken by comprator : " + (e - s));
	}

}