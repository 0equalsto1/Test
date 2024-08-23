package uuid;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.UUID;

public class SecureRandomString {
	private static final SecureRandom random = new SecureRandom();
	private static final Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
	private static final Base64.Decoder dcoder = Base64.getUrlDecoder();

	public static String generate() {
		byte[] buffer = new byte[20];
		random.nextBytes(buffer);
//		System.out.println(new String(buffer));
		return encoder.encodeToString(buffer);
	}
	public static String generate(byte[] buffer) {
		return encoder.encodeToString(buffer);
	}
	public static void main(String[] args) {
//		String generate = generate();
//		System.out.println(generate());
//		System.out.println(new String(dcoder.decode(generate)));
		System.out.println(generate(UUID.randomUUID().toString().getBytes()));
	}
}