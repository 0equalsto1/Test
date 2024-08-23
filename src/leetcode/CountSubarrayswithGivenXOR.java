package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountSubarrayswithGivenXOR {

	public static void main(String[] args) {
		int[] arr = new int[] { 4, 2, 2, 6, 4 };
		System.out.println(solve(arr, 6));
		
		List<Integer> list = IntStream.of(arr)    // returns IntStream
                .boxed()
                .collect(Collectors.toList());
		System.out.println(solve((ArrayList<Integer>) list, 6));
	}

	public static int solve(ArrayList<Integer> A, int B) {

		HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
		int c = 0;
		int cpx = 0;
		int n = A.size();
		visited.put(0, 1);
		for (int i = 0; i < n; i++) {
			cpx = cpx ^ A.get(i);
			if (visited.get(cpx ^ B) != null)
				c += visited.get(cpx ^ B);
			/*if (cpx == B) {
				c++;
			}*/
			Integer vis = visited.get(cpx);
			if (vis != null)
				visited.put(cpx, vis + 1);
			else
				visited.put(cpx, 1);
		}
		return c;

	}

	public static int solve(int[] A, int B) {
		HashMap<Integer, Integer> visited = new HashMap<Integer, Integer>();
		int c = 0;
		int xor = 0;
		int n = A.length;
		visited.put(0, 1);
		for (int i = 0; i < n; i++) {
			xor = xor ^ A[i];
			int key = xor ^ B;
			if (visited.get(key) != null)
				c += visited.get(key);
			/*if (cpx == B) {
				c++;
			}*/
			Integer val = visited.get(xor);
			if (val != null)
				visited.put(xor, val + 1);
			else
				visited.put(xor, 1);
		}
		return c;
	}
}
