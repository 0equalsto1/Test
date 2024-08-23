package map;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class FrequencyGame {
	public static void main(String[] args) {

	}

	public static int largButMinFreq1(int arr[], int n) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		Comparator<Entry<Integer, Integer>> comparingByValue = Comparator.comparing(Entry::getValue);
		Comparator<Entry<Integer, Integer>> comparingByKey = Comparator.comparing(Entry::getKey);
		Comparator<Entry<Integer, Integer>> multipleFieldsComparator = comparingByValue
				.thenComparing(comparingByKey.reversed());

		LinkedHashMap<Integer, Integer> sortedMap = map.entrySet().stream().sorted(multipleFieldsComparator)
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		return sortedMap.entrySet().iterator().next().getKey();

	}

	public static int largButMinFreq2(int arr[], int n) {
		Arrays.sort(arr);
		int ans = 0;// 1,2,2,5,50
		for (int i = n - 1; i > 0; i = i - 2) {
			if (arr[i] != arr[i - 1]) {
				ans = arr[i];
				break;
			}
		}
		return ans;
	}

	public static int LargButMinFreq3(int a[], int n) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i = 0; i < n; i++) {
			hm.put(a[i], hm.getOrDefault(a[i], 0) + 1);
		}

		int res = -1;
		int minFreq = Integer.MAX_VALUE;
		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			int x = entry.getKey();
			int f = entry.getValue();
			if (f < minFreq) {
				minFreq = f;
				res = x;
			} else if (f == minFreq) {
				res = Math.max(res, x);
			}
		}

		return res;
	}
}
