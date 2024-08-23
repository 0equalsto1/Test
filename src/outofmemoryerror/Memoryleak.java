package outofmemoryerror;

import java.util.HashMap;
import java.util.Map;

public class Memoryleak {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Map m = new HashMap();
		while (true) {
			for (int i = 0; i < 10000; i++) {
				if (!m.containsKey(new KeylessEntry.Key(i)))
					m.put(new KeylessEntry.Key(i), "Number:" + i);
			}
			System.out.println(m.size());
		}
	}
}

class KeylessEntry {

	static class Key {
		Integer id;

		Key(Integer id) {
			this.id = id;
		}

		@Override
		public int hashCode() {
			return id.hashCode();
		}
	}

}