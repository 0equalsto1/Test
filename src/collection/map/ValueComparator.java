package collection.map;

import java.util.Comparator;
import java.util.Map;

public class ValueComparator implements Comparator<Integer> {

	private Map<Integer, String> map;
	private boolean ascOrder;

	public ValueComparator(Map<Integer, String> map, boolean ascOrder) {
		this.map = map;
		this.ascOrder = ascOrder;
	}

	public int compare(Integer a, Integer b) {
		if (ascOrder)
			return map.get(a).compareTo(map.get(b));
		else
			return map.get(b).compareTo(map.get(a));
	}
}