package crypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class EncryptionExample {
    public static void main() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();

        String originalText = "SensitiveData";
        Cipher cipher = Cipher.getInstance("AES");

        // Encrypt
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedText = cipher.doFinal(originalText.getBytes());
        String encryptedString = Base64.getEncoder().encodeToString(encryptedText);
        System.out.println("Encrypted Text: " + encryptedString);

        // Decrypt
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedText = cipher.doFinal(Base64.getDecoder().decode(encryptedString));
        String decryptedString = new String(decryptedText);
        System.out.println("Decrypted Text: " + decryptedString);
    }
}
