package snippet;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LRUCache {
	private int capacity;
	private Map<String, Object> lruCache;

	LRUCache(int capacity) {
		this.capacity = capacity;
		lruCache = new LinkedHashMap<>(capacity);
	}

	public Object get(String key) {
		Object value = lruCache.get(key);
		if (value == null)
			return -1;

		put(key, value);
		return value;

	}

	public void put(String key, Object value) {
		String removeKey = "";

		if (lruCache.size() == capacity) {
			Set<String> keySet = lruCache.keySet();
			removeKey = keySet.iterator().next();
			remove(removeKey);
		} else if (lruCache.containsKey(key)) {
			remove(key);
		}
		lruCache.put(key, value);

	}

	public void remove(String key) {
		lruCache.remove(key);

	}

	public static void main(String[] args) {
		LRUCache lru = new LRUCache(3);
		lru.put("k1", "v1");
		lru.put("k2", "v2");
		lru.put("k3", "v3");
		System.out.println(lru.lruCache);
		lru.put("k4", "v3");
		System.out.println(lru.lruCache);
		lru.put("k5", "v3");
		System.out.println(lru.lruCache);
		lru.get("k3");
		System.out.println(lru.lruCache);
		lru.put("k6", "v4");
		System.out.println(lru.lruCache);

	}
}
