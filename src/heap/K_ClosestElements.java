package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class K_ClosestElements {

	static class Pair {
		Integer key;
		Integer value;

		public Pair(Integer key, Integer value) {
			this.key = key;
			this.value = value;
		}

		public Integer getKey() {
			return key;
		}

		public void setKey(Integer key) {
			this.key = key;
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
//		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		int[] arr = new int[] { 2, 2, 5, 50, 1 };
//		System.out.println(kClosestElements(arr, 4, 3));
//		System.out.println(findClosestElements(arr, 4, 3));
		System.out.println(largButMinFreq(arr, 5));
		System.out.println(largButMinFreq2(arr, 5));
	}

	public static List<Integer> kClosestElements(int[] arr, int k, int x) {
		List<Integer> list = new ArrayList<>(k);
		PriorityQueue<Pair> pQueue = new PriorityQueue<Pair>((p1, p2) -> {
			return p2.getValue().compareTo(p1.getValue());
		});

		for (int i = 0; i < arr.length; i++) {
			int abs = Math.abs(arr[i] - x);
			Pair pair = new Pair(arr[i], abs);
			if (pQueue.size() < k) {
				pQueue.add(pair);
			} else if (abs < pQueue.peek().getValue()) {
				pQueue.poll();
				pQueue.add(pair);
			}
		}
		while (pQueue.size() > 0) {
			list.add(pQueue.poll().getKey());
		}
		Collections.sort(list);
		return list;

	}

	public static List<Integer> findClosestElements(int[] arr, int k, int x) {

		List<Integer> res = new ArrayList<Integer>();

		int left = 0;
		int right = arr.length - 1;

		while ((right - left) >= k) {
			if (Math.abs(x - arr[left]) <= Math.abs(x - arr[right])) {
				right--;
			} else {
				left++;
			}
		}

		for (int i = left; i <= right; i++) {
			res.add(arr[i]);
		}

		return res;
	}

	public static int largButMinFreq(int arr[], int n) {
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
		int ans = 0;//1,2,2,5,50
		for (int i = n - 1; i > 0; i = i - 2) {
			if (arr[i] != arr[i - 1]) {
				ans = arr[i];
				break;
			}
		}
		return ans;
	}
}
