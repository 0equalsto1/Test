package iso;

import java.io.UnsupportedEncodingException;
import java.util.UUID;

public class StringMain {

	public static void main(java.lang.String[] args) throws UnsupportedEncodingException {

		int hashCode = UUID.randomUUID().hashCode();
		System.out.println(Math.abs(hashCode));
//		UUID randomUUID = UUID.randomUUID();
//		System.out.println(randomUUID.hashCode());
		/*
		 * for (int i = 0; i < 5; i++) { System.out.println(generateUniqueId()); }
		 */
	}

	public static int generateUniqueId() {
		String str = UUID.randomUUID().toString();
		int uid = str.hashCode();
		String filterStr = "" + uid;
		str = filterStr.replaceAll("-", "");
		return Integer.parseInt(str);
	}

	// XXX: replace with java.util.UUID

}
