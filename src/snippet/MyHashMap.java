package snippet;

public class MyHashMap<K, V> {

	private int DEFAULT_BUCKET_COUNT = 10;

	private Entry<K, V>[] buckets;

	@SuppressWarnings("unchecked")
	public MyHashMap() {
		buckets = new Entry[DEFAULT_BUCKET_COUNT];
	}

	@SuppressWarnings("unchecked")
	public MyHashMap(int capacity) {
		buckets = new Entry[capacity];
	}

	public V remove(K key) {
		throwIfKeyNull(key);
		int index = bucketIndexForKey(key);
		Entry<K, V> first = buckets[index];
		if (null == first)
			return null;
		Entry<K, V> prev = first;
		Entry<K, V> f = first;
		V val = null;
		while (f != null) {
			if (key.equals(f.getKey())) {
				if (f == first) {
					first = first.getNext();
					/*
					 * Entry<K, V> entry = new Entry<>(first.getKey(), first.getValue());
					 * entry.setNext(f.getNext());
					 */
					buckets[index] = first;
				} else if (f.getNext() == null) {
					prev.setNext(null);
				} else {
					prev.setNext(f.getNext());

				}
				break;
			}
			prev = f;
			f = f.getNext();
		}
		return val;

	}

	public V get(K key) {
		throwIfKeyNull(key);
		Entry<K, V> entry = buckets[bucketIndexForKey(key)];
		while (entry != null && !key.equals(entry.getKey()))
			entry = entry.getNext();
		return entry != null ? entry.getValue() : null;
	}

	public void put(K key, V value) {
		throwIfKeyNull(key);

		int bucketIndex = bucketIndexForKey(key);
		Entry<K, V> entry = buckets[bucketIndex];

		if (null == entry) {
			buckets[bucketIndex] = new Entry<>(key, value);
			return;
		}
		while (entry != null) {
			if (key.equals(entry.getKey())) {
				entry.setValue(value);
				break;
			} else if (entry.getNext() == null) {
				entry.setNext(new Entry<>(key, value));
				break;
			}
			entry = entry.getNext();
		}

	}

	public int bucketIndexForKey(K key) {
		return key.hashCode() % buckets.length;
	}

	private void throwIfKeyNull(K key) {
		if (key == null) {
			throw new IllegalArgumentException("key should not be null");
		}
	}

	@Override
	public String toString() {
		Object[] a = buckets;
		if (a == null)
			return null;

		if ((a.length - 1) == -1)
			return "{}";

		StringBuilder b = new StringBuilder();
		b.append('{');
		for (int i = 0; i < a.length; i++) {
			if (a[i] != null) {
				b.append(String.valueOf(a[i]));
				b.append(", ");
			}
		}
		return b.append('}').toString();
	}

	public static void main(String[] args) {
		/*
		 * Map<String, String> map = new HashMap<>(6); map.put("azx", "aaaaa");
		 */
		MyHashMap<String, String> myHashMap = new MyHashMap<>(5);
		System.out.println(myHashMap);
		myHashMap.put("a", "one");
		myHashMap.put("b", "two");
		myHashMap.put("abcd", "abcd");
		myHashMap.put("bacd", "bacd");
		myHashMap.put("bcda", "bcda");
		System.out.println(myHashMap);
		myHashMap.remove("bacd");
		System.out.println(myHashMap);
	}

}

class Entry<K, V> {

	private Entry<K, V> next;
	private final K key;
	private V value;

	public Entry(K key, V value) {
		this.key = key;
		this.setValue(value);
	}

	public K getKey() {
		return key;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public V getValue() {
		return value;
	}

	public void setNext(Entry<K, V> next) {
		this.next = next;
	}

	public Entry<K, V> getNext() {
		return next;
	}

	@Override
	public String toString() {
		String s = "key=" + key + ", value=" + value;
		return s;
	}

}
