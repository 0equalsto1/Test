package snippet;

public class CustomLinkedList<E> {
	private int size;
	private Node<E> first;
	private Node<E> last;

	public static void main(String[] args) {
		CustomLinkedList<String> cll = new CustomLinkedList<>();
		cll.add("1");
		cll.add("2");
		cll.add("3");
		cll.add("4");
		cll.add("5");
		System.out.println(cll);
		cll.remove("5");
		System.out.println(cll);
	}

	public void add(E e) {
		if (e == null)
			throw new NullPointerException("Element should not be null");
		Node<E> node = new Node<>(null, e);
		if (first == null) {
			first = node;
			last = node;

		} else {
			last.nxt = node;
			last = node;
		}
		size++;
	}

	public boolean remove(E e) {
		if (e == null)
			throw new NullPointerException("Element should not be null");
		E obj = null;
		boolean b = false;
		Node<E> current = first;
		Node<E> prev = first;
		while( current != null) {
			obj = current.data;
			if (obj.equals(e)) {
				e = null;
				b = true;

				if (current == first) {
					first = first.nxt;
				} else if (current == last) {
					last = prev;
					last.nxt = null;
				} else {
					prev.nxt = current.nxt;

				}

				break;
			}
			prev = current;
			current = current.nxt;

		}
		return b;

	}

	@Override
	public String toString() {
		Node<E> f = first;
		String s = "";
		while (f != null) {
			s = s + f + ",";
			f = f.nxt;
		}
		return s;
	}

	public int getSize() {
		return size;

	}

	private static class Node<E> {
		Node<E> nxt;
		E data;

		public Node(Node<E> nxt, E data) {
			this.nxt = nxt;
			this.data = data;
		}

		@Override
		public String toString() {
			return data + "";
		}

	}
}
