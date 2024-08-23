package leetcode.intrv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class AntiDiagonal {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		arr.add((ArrayList<Integer>) Arrays.stream(a[0]).boxed().collect(Collectors.toList()));
		arr.add((ArrayList<Integer>) Arrays.stream(a[1]).boxed().collect(Collectors.toList()));
		arr.add((ArrayList<Integer>) Arrays.stream(a[2]).boxed().collect(Collectors.toList()));
		System.out.println(diagonal(arr));
	}

	public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();

		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < A.get(i).size(); j++) {
				ArrayList<Integer> arrayList;
				if (map.containsKey(i + j))
					arrayList = map.get(i + j);
				else
					arrayList = new ArrayList<>();

				arrayList.add(A.get(i).get(j));
				map.put(i + j, arrayList);
			}
		}

		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

		for (int key : map.keySet()) {
			ans.add(map.get(key));
		}

		return ans;
	}
}