package hashId;

import org.hashids.Hashids;

public class HashIdTest {
	public static void main(String[] args) {
		Hashids hashids = new Hashids("gaanagems",12);
		String hash = hashids.encode(100);
		System.out.println(hash);
		System.out.println(hashids.decode(hash)[0]);
	}
}
