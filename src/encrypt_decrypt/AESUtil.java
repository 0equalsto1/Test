package encrypt_decrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.StringUtils;

public class AESUtil {
	private static final SecretKey WEB_SECRET_KEY = new SecretKeySpec("g@1n!(f1#r.0$)&%".getBytes(), "AES");
	private static final SecretKey SECRET_KEY = new SecretKeySpec("c1c6b8b2c1b1a1c7".getBytes(), "AES");
	
	
	public static String encrypt(final String plainText)
            throws Exception {
        if (StringUtils.isEmpty(plainText)) {
            return plainText;
        }
        try {
            byte[] plainTextByte = padString(plainText).getBytes();
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, SECRET_KEY);
            byte[] encryptedByte = cipher.doFinal(plainTextByte);
            return bytesToHex(encryptedByte);
        } catch (javax.crypto.IllegalBlockSizeException lbe) {
        }
        return null;
    }

    public static String decrypt(final String encryptedText)
            throws Exception {
        byte[] encryptedTextByte = hexToBytes(encryptedText);
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, SECRET_KEY);
        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
        return new String(decryptedByte).trim();
    }
    
	public static String encryptWebURL(final String plainText)
            throws Exception {
        if (StringUtils.isEmpty(plainText)) {
            return plainText;
        }
        try {
            byte[] plainTextByte = padString(plainText).getBytes();
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, WEB_SECRET_KEY);
            byte[] encryptedByte = cipher.doFinal(plainTextByte);
            return bytesToHex(encryptedByte);
        } catch (javax.crypto.IllegalBlockSizeException lbe) {
        }
        return null;
    }

    public static String decryptWebURL(final String encryptedText)
            throws Exception {
        byte[] encryptedTextByte = hexToBytes(encryptedText);
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, WEB_SECRET_KEY);
        byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
        return new String(decryptedByte).trim();
    }
	
    private static String padString(String source) {
        char paddingChar = 0;
        int size = 16;
        int x = source.length() % size;
        int padLength = size - x;
        for (int i = 0; i < padLength; i++) {
            source += paddingChar;
        }
        return source;
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