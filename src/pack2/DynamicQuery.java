package pack2;

import java.util.HashMap;
import java.util.Map;

public class DynamicQuery {
	private Map<String, String> queryMap = new HashMap<>();

	public String getQuery(String key, String query) {
		System.out.println("asas"+"fgdfg");
		return null;

	}

	public void setQuery(String key, String query) {
		queryMap.put(key, query);
	}

	public static void main(String[] args) {
		String hello = "Hello", lo = "lo";
		System.out.println((hello == ("Hel"+"lo")));
		System.out.println((hello == ("Hel"+lo)));
		System.out.println(("Hel"+lo).hashCode()+"  "+hello.hashCode());
		System.out.println((("Hel"+lo).intern() == ("Hel"+lo).intern()));
		System.out.println((hello == ("Hel"+lo).intern()));
	}
}
