package hashId;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeMap1 {
	public static void main(String[] args) {
		TreeMap m = new TreeMap();
		m.put("A", new Integer(1));
		m.put("B", new Integer(2));
//		System.out.println(m.entrySet());
		TreeMap<Integer, Integer> map = new TreeMap<>();
		Comparator<Integer> com = (a, b) -> map.get(b) - map.get(a);
		map.put(1, 2);
		map.put(2, 1);
		map.put(3, 5);
		map.put(4, 2);
		System.out.println(map);
		System.out.println(entriesSortedByValues(map));
	}

	static <K, V extends Comparable<? super V>> SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
		SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<Map.Entry<K, V>>(new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
				int res = e1.getValue().compareTo(e2.getValue());
                return -res ;
			}
		});
		sortedEntries.addAll(map.entrySet());
		return sortedEntries;
	}
}
