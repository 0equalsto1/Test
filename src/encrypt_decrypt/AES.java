package encrypt_decrypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {

	public static void main(String[] args) {
		int i = (int) Math.sqrt(10);
		final String secretKey = "c1c6b8b2c1b1a1c7";

		String originalString = "{\"deviceId\":\"Mi A1_053247fd9a63bff8\",\"trackId\":107,\"platform\":\"android\",\"time\":1594819265,\"source\":5,\"sourceId\":46,\"songTime\":355,\"pageId\":\"other\",\"sectionId\":\"home\",\"playOutMethod\":1,\"seedtrackId\":0,\"uuid\":\"0d0d4fe6-c69e-11ea-acd0-d43b04d0ba7e\",\"contentType\":1,\"seekPosition\":0,\"sectionPosition\":0,\"itemPosition\":0,\"queuePlayout\":0,\"searchId\":\"\",\"searchfeed\":0,\"tabId\":0}";
		String encryptedString = AES.encrypt(originalString, secretKey);
		String decryptedString = AES.decrypt(encryptedString, secretKey);

		System.out.println(originalString);
		System.out.println(encryptedString);
		System.out.println(decryptedString);
	}

	private static SecretKeySpec secretKey;
	private static byte[] key;

	public static void setKey(String myKey) {
		MessageDigest sha = null;
		try {
			key = myKey.getBytes();
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String encrypt(String strToEncrypt, String secret) {
		try {
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return Base64.getEncoder().withoutPadding().encodeToString(cipher.doFinal(strToEncrypt.getBytes()));
		} catch (Exception e) {
			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}

	public static String decrypt(String strToDecrypt, String secret) {
		try {
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			System.out.println("Error while decrypting: " + e.toString());
		}
		return null;
	}
}