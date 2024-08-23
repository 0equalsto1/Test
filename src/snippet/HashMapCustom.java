package snippet;

import java.util.Arrays;

public class HashMapCustom<K, V> {
	private Entry<K, V>[] table; // Array of Entry.
	private int capacity = 4; // Initial capacity of HashMap

	static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Entry [key=" + key + ", value=" + value + ", next=" + next + "]";
		}

	}

	@SuppressWarnings("unchecked")
	public HashMapCustom() {
		table = new Entry[capacity];
	}

	public void put(K newKey, V data) {
		if (newKey == null)
			return; // does not allow to store null.

		// calculate hash of key.
		int index = getIndex(newKey);
		// create new entry.
		Entry<K, V> newEntry = new Entry<>(newKey, data);

		// if table location does not contain any entry, store entry there.
		if (table[index] == null) {
			table[index] = newEntry;
		} else {
			Entry<K, V> current = table[index];
			if (current.key.equals(newKey)) {
				current.value = data;
			} else {
				while (current != null && current.next != null)
					current = current.next;
				current.next = newEntry;
			}
		}
	}

	public V get(K key) {
		int hash = getIndex(key);
		if (table[hash] == null) {
			return null;
		}
		Entry<K, V> temp = table[hash];
		while (temp != null) {
			if (temp.key.equals(key))
				return temp.value;
			temp = temp.next; // return value corresponding to key.
		}
		return null; // returns null if key is not found.
	}

	public boolean remove(K deleteKey) {

		int index = getIndex(deleteKey);

		if (table[index] == null) {
			return false;
		}
		Entry<K, V> previous = null;
		Entry<K, V> current = table[index];

		while (current != null) { // we have reached last entry node of
									// bucket.
			if (current.key.equals(deleteKey)) {
				if (previous == null) { // delete first entry node.
					table[index] = table[index].next;
					return true;
				}
				previous.next = current.next;
				return true;
			}
			previous = current;
			current = current.next;
		}
		return false;

	}

	public void display() {

		for (int i = 0; i < capacity; i++) {
			if (table[i] != null) {
				Entry<K, V> entry = table[i];
				while (entry != null) {
					System.out.print("{" + entry.key + "=" + entry.value + "}" + " ");
					entry = entry.next;
				}
			}
		}

	}

	private int getIndex(K key) {
		return Math.abs(key.hashCode()) % capacity;
	}

	public static void main(String[] args) {
		HashMapCustom<String, String> ch = new HashMapCustom<>();
		ch.put("1", "one");
		ch.put("2", "two");
		ch.put("3", "three");
		ch.put("3", "4");
		ch.put("5", "five");
		System.out.println(ch);
	}

	@Override
	public String toString() {
		return Arrays.toString(table);
	}

}
