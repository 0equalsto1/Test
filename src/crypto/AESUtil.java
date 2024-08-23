package crypto;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {
	private static final SecretKey SECRET_KEY = new SecretKeySpec("c1c6b8b2c1b1a1c7".getBytes(), "AES");
	private static String transformation = "AES";

	public static String encrypt(final String plainText) throws Exception {
		try {
			Cipher cipher = Cipher.getInstance(transformation);
			cipher.init(Cipher.ENCRYPT_MODE, SECRET_KEY);
			byte[] encryptedByte = cipher.doFinal(plainText.getBytes());
			return bytesToHex(encryptedByte);
//			return bytesToBase64(encryptedByte);
		} catch (javax.crypto.IllegalBlockSizeException lbe) {
		}
		return null;
	}

	private static String bytesToBase64(byte[] encryptedByte) {
		return Base64.getEncoder().encodeToString(encryptedByte);
	}

	public static void main(String[] args) throws Exception {
		String text = "{\"deviceId\":\"Mi A1_053247fd9a63bff8\",\"trackId\":78,\"platform\":\"samsungsdk\",\"time\":1590754875,\"source\":2,\"sourceId\":2961440,\"songTime\":18,\"pageId\":\"SEARCH\",\"sectionId\":\"SEARCHAUTOSUGGEST\",\"playOutMethod\":1,\"seedtrackId\":0,\"uuid\":\"e9d27bda-a1a6-11ea-b8ea-d43b04d0ba7e\",\"contentType\":1,\"seekPosition\":1,\"sectionPosition\":0,\"iteamPosition\":-1,\"queuePlayout\":1,\"searchId\":\"1590412006057~1~2\",\"searchfeed\":0}";
		String encrypt = encrypt(text);
		System.out.println("encrypt text: " + encrypt);
		String decrypt = decrypt(encrypt);
		System.out.println("decrypt text: " + decrypt);

	}

	public static String decrypt(final String encryptedText) throws Exception {
		byte[] encryptedTextByte = hexToBytes(encryptedText);
//		byte[] encryptedTextByte = base64ToBytes(encryptedText);
		Cipher cipher = Cipher.getInstance(transformation);
		cipher.init(Cipher.DECRYPT_MODE, SECRET_KEY);
		byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
		return new String(decryptedByte).trim();
	}

	private static byte[] base64ToBytes(String encryptedText) {
		return Base64.getDecoder().decode(encryptedText);
	}

	public static byte[] hexToBytes(String str) {
		if (str == null) {
			return null;
		} else if (str.length() < 2) {
			return null;
		} else {
			int len = str.length() / 2;
			byte[] buffer = new byte[len];
			for (int i = 0; i < len; i++) {
				buffer[i] = (byte) Integer.parseInt(str.substring(i * 2, i * 2 + 2), 16);
			}
			return buffer;
		}
	}

	public static String bytesToHex(byte[] data) {
		if (data == null) {
			return null;
		}
		int len = data.length;
		String str = "";
		for (int i = 0; i < len; i++) {
			if ((data[i] & 0xFF) < 16) {
				str = str + "0" + java.lang.Integer.toHexString(data[i] & 0xFF);
			} else {
				str = str + java.lang.Integer.toHexString(data[i] & 0xFF);
			}
		}
		return str;
	}

}
