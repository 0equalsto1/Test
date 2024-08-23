package leetcode;

public class ReverseLinkedList {

	public static void main(String[] args) {
	}

	
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if (head == null || head.next == null)
			return head;
		ListNode cur1 = head;
		ListNode pre1 = null;
		for (int i = 1; i < left; i++) {
			pre1 = cur1;
			cur1 = cur1.next;
		}

		// reverse
		ListNode cur2 = cur1;
		ListNode pre2 = pre1;
		ListNode next;
		for (int i = left; i <= right; i++) {
			next = cur2.next;
			cur2.next = pre2;
			pre2 = cur2;
			cur2 = next;
		}

		// connect
		cur1.next = cur2;
		if (pre1 != null)
			pre1.next = pre2;
		else
			head = pre2;
		return head;

	}

	public ListNode reverseList1(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode cur = head;
		ListNode prev = null;
		ListNode next = null;
		while (cur != null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}

	public ListNode reverseList(ListNode head) {

		return reverseList(head, null);
	}

	private ListNode reverseList(ListNode head, ListNode prev) {

		if (head == null)
			return prev;
		ListNode next = head.next;
		head.next = prev;
		return reverseList(next, head);
	}
}

class ListNode {
	public int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

}
