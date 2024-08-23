package map;

import java.util.LinkedHashMap;
import java.util.Set;

class LinkedHashMap1 {
	public static void main(String args[]) {

		LinkedHashMap<MapDuplicateKey, String> hm = new LinkedHashMap<>();

		hm.put(new MapDuplicateKey("Vicky"), "Vicky");
		hm.put(new MapDuplicateKey("Vijay"), "Vijay");
		hm.put(new MapDuplicateKey("Rahul"), "Rahul");

		String string = hm.get(new MapDuplicateKey("Rahul"));
		System.out.println(string);
		Set<MapDuplicateKey> keySet = hm.keySet();
		System.out.println(keySet);
	}
}

class MapDuplicateKey {
	String name;

	public MapDuplicateKey(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "MapDuplicateKey [name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + name.length();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MapDuplicateKey other = (MapDuplicateKey) obj;
		if (!name.equals(other.name))
			return false;
		return true;
	}

}