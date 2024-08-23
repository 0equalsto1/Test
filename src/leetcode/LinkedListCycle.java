package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow)
				return true;
		}
		return false;
	}

	public ListNode detectCycleMap(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		Map<ListNode, Integer> map = new HashMap<>();
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (fast == head)
				return head;
			Integer val = map.getOrDefault(slow, 0);
			if (val > 0)
				return slow;
			else
				map.put(slow, 1);
		}
		return null;

	}

	/*
	approach:
	When fast and slow meet at point p,
	the length they have run are 'a+2b+c' and 'a+b'.
	Since the fast is 2 times faster than the slow. So a+2b+c == 2(a+b), 
	then we get 'a==c'.	So when another slow2 pointer run from head to 'q', 
	at the same time, 	previous slow pointer will run from 'p' to 'q', 
	so they meet at the pointer 'q' together.
	 */
	public ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if (fast == slow) {
				fast = head;
				while (fast != slow) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;
	}
}
