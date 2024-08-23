package sorting;

public class MergekSortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode mergeKLists1(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;
		ListNode node1 = lists[0];
		for (int i = 1; i < lists.length; i++) {
			ListNode node2 = lists[i];
			node1 = mergeTwoSortedList(node1, node2);
		}
		return node1;

	}

	private ListNode mergeTwoSortedList(ListNode a, ListNode b) {
		ListNode dmHead = new ListNode(0), cur = dmHead;
		while (a != null && b != null) {
			if (a.val < b.val) {
				cur.next = a;
				a = a.next;
			} else {
				cur.next = b;
				b = b.next;
			}
			cur = cur.next;
		}
		cur.next = (a != null) ? a : b;

		return dmHead.next;
	}

	public ListNode mergeKLists(ListNode[] lists) {
		return mL(lists, 0, lists.length - 1);
	}

	private ListNode mL(ListNode[] lists, int l, int r) {
		if (r < l)
			return null;
		if (r == l)
			return lists[r];

		int mid = (l + r) / 2;
		ListNode a = mL(lists, l, mid);
		ListNode b = mL(lists, mid + 1, r);
		return mergeTwoSortedList(a, b);
	}

}
