package snippet;

import java.util.HashMap;
import java.util.Stack;

public class LRU {
	
	private HashMap<String, Object> lruList;
	private Stack<String> stackOrder;
	private int capacity;

	LRU(int capacity) {
		this.capacity = capacity;
		lruList = new HashMap<>(capacity);
		stackOrder = new Stack<>();
	}

	public void put(String key, Object value) {
		String remove = "";
		if (lruList.containsKey(key) || lruList.size() == capacity) {
			if (lruList.containsKey(key)) {
				remove = key;
			} else {
				remove = stackOrder.firstElement();
			}
			stackOrder.removeElement(remove);
			lruList.remove(remove);
		}
		lruList.put(key, value);
		stackOrder.add(key);
	}

	public Stack<String> get() {
		return stackOrder;
	}

	public Object get(String key) {
		Object value = lruList.get(key);
		put(key, value);
		return value;
	}

	public static void main(String[] args) {
		LRU lru = new LRU(3);
		lru.put("k1", "v1");
		lru.put("k2", "v2");
		lru.put("k3", "v3");
		System.out.println(lru.get());
		lru.put("k4", "v3");
		lru.put("k5", "v3");
		System.out.println(lru.get());
		lru.get("k3");
		System.out.println(lru.get());
		lru.put("k6", "v4");
		System.out.println(lru.get());
	}
}