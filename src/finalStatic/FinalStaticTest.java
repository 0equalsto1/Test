package finalStatic;

import java.util.HashMap;
import java.util.Map;

public class FinalStaticTest {
	private static final Map<String, String> map;
	static {
		map = new HashMap<>();
		map.put("1", "2");
	}

	public static void main(String[] args) {
		System.out.println(map);
		System.out.println(map.size());

	}

}
