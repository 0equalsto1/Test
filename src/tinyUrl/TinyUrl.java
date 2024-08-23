package tinyUrl;

import java.io.IOException;

public class TinyUrl {
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	private static final int BASE = ALPHABET.length();

	public static String encode(int num) {
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			sb.append(ALPHABET.charAt(num % BASE));
			num /= BASE;
		}
		return sb.toString();
	}

	public static int decode(String str) {
		int num = 0;
		for (int i = str.length()-1; i >=0; i--) {
			char charAt = str.charAt(i);
			num = num * BASE + ALPHABET.indexOf(charAt);
		}//num = num + ALPHABET.indexOf(charAt) * base^j
		return num;
	}

	static String idToShortURL(int n) {
		// Map to store 62 possible characters
		char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

		StringBuffer shorturl = new StringBuffer();

		// Convert given integer id to a base 62 number
		while (n > 0) {
			// use above map to store actual character
			// in short url
			shorturl.append(map[n % 62]);
			n = n / 62;
		}

		// Reverse shortURL to complete base conversion
		return shorturl.toString();
	}

	// Function to get integer ID back from a short url
	static int shortURLtoID(String shortURL) {
		int id = 0; // initialize result

		// A simple base conversion logic
		for (int i = shortURL.length() - 1; i >= 0; i--) {
			if ('a' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'z')
				id = id * 62 + shortURL.charAt(i) - 'a';
			if ('A' <= shortURL.charAt(i) && shortURL.charAt(i) <= 'Z')
				id = id * 62 + shortURL.charAt(i) - 'A' + 26;
			if ('0' <= shortURL.charAt(i) && shortURL.charAt(i) <= '9')
				id = id * 62 + shortURL.charAt(i) - '0' + 52;
		}
		return id;
	}

	// Driver Code
	public static void main(String[] args) throws IOException {
//		int n = Integer.MAX_VALUE;
		int n = 900000000;
		String shorturl = idToShortURL(n);
		System.out.println("Generated short url is " + shorturl);
		System.out.println("Id from url is " + shortURLtoID(shorturl));
		String encode = encode(n);
		System.out.println("encode	" + encode);
		System.out.println("decode	" + decode(encode));
	}
}