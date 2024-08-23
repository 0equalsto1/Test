package leetcode.intrv;

class LinkedListLoop {
	static ListNode head;

	class ListNode {
		int data;
		ListNode next;

		ListNode(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int new_data) {
		ListNode new_node = new ListNode(new_data);

		new_node.next = head;

		head = new_node;
	}

	int detectLoop() {
		if (head == null || head.next == null)
			return 0;
		ListNode slow = head, fast = head.next;
		while (fast.next != null) {
			if (slow == fast)
				return 1;
			slow = slow.next;
			fast = fast.next.next;
		}
		return 0;
	}

	public static void main(String args[]) {
		LinkedListLoop llist = new LinkedListLoop();

		llist.push(20);
		llist.push(4);
		llist.push(80);
		llist.push(40);
		llist.push(15);
		llist.push(10);

//		head.next.next.next.next.next.next = head.next.next;
		llist.detectLoop();
	}
}
