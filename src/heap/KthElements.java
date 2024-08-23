package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthElements {
	public static void main(String[] args) {
		int findKthLargest = findKthLargestMinHeap(new int[] { 3, 2, 1, 5, 6, 4 }, 2);
		System.out.println(findKthLargest);
	}

	public static int findKthLargestMinHeap(int[] nums, int k) {
		final PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int val : nums) {
			pq.offer(val);

			if (pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}

	public static int findKthLargestMaxHeap(int[] nums, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for (int n : nums)
			pq.add(n);

		while (--k > 0) {
			pq.poll();
		}

		return pq.peek();
	}
}
