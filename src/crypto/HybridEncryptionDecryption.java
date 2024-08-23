package crypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/*
//AES (Advanced Encryption Standard) Symmetric Key Encryption,same key is used for both encryption and decryption.
//RSA (Rivest-Shamir-Adleman) Asymmetric Key Encryption,public key for encryption and a private key for decryption.
For Confidentiality (Encryption and Decryption):
Sender: Encrypts the message using the recipient's public key.
Receiver: Decrypts the message using their own private key.

For Digital Signatures (Authenticity and Integrity):
Sender: Signs the message using their private key.
Receiver: Verifies the signature using the sender's public key.
--------------------------------------------------------------------------------------------------------------
Generate a Symmetric Key: Use a symmetric encryption algorithm like AES to generate a key for encrypting the large data.

Encrypt the Data: Use the symmetric key to encrypt the large data. Symmetric encryption is efficient for handling
large volumes of data.

Encrypt the Symmetric Key: Use RSA to encrypt the symmetric key. This ensures that only authorized recipients who
have the private RSA key can decrypt the symmetric key and subsequently the data.

Transmit Both: Send both the encrypted symmetric key and the encrypted data to the recipient.

Recipient Decrypts:

Decrypt the Symmetric Key: The recipient uses their RSA private key to decrypt the symmetric key.
Decrypt the Data: The recipient uses the decrypted symmetric key to decrypt the data.*/

class HybridEncryptionServer {
    public static void main() throws Exception {
        // Generate a symmetric key (AES)
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // 128-bit AES key
        SecretKey secretKey = keyGen.generateKey();

        // Encrypt data with the symmetric key
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = aesCipher.doFinal("This is a large amount of data".getBytes());

        // Generate RSA key pair
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048); // RSA key size
        KeyPair keyPair = keyPairGen.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();

        // Encrypt the symmetric key with RSA
        Cipher rsaCipher = Cipher.getInstance("RSA");
        rsaCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedSymmetricKey = rsaCipher.doFinal(secretKey.getEncoded());

        // Transmit `encryptedSymmetricKey` and `encryptedData` to the recipient
        System.out.println("Encrypted Symmetric Key: " + Base64.getEncoder().encodeToString(encryptedSymmetricKey));
        System.out.println("Encrypted Data: " + Base64.getEncoder().encodeToString(encryptedData));
    }
}




//-------------------------------------------------------------

class HybridEncryptionClient {
    public static void main() throws Exception {
        // Simulate receiving the encrypted symmetric key and encrypted data
        String encryptedSymmetricKeyBase64 = "received_encrypted_symmetric_key";
        String encryptedDataBase64 = "received_encrypted_data";

        // Decode the base64 encoded strings
        byte[] encryptedSymmetricKey = Base64.getDecoder().decode(encryptedSymmetricKeyBase64);
        byte[] encryptedData = Base64.getDecoder().decode(encryptedDataBase64);

        // Load private RSA key (in practice, you should securely store and load the private key)
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(new X509EncodedKeySpec(Base64.getDecoder().decode("your_private_key_base64")));

        // Decrypt the symmetric key with RSA
        Cipher rsaCipher = Cipher.getInstance("RSA");
        rsaCipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] symmetricKeyBytes = rsaCipher.doFinal(encryptedSymmetricKey);
        SecretKey secretKey = new SecretKeySpec(symmetricKeyBytes, "AES");

        // Decrypt the data with the symmetric key
        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedData = aesCipher.doFinal(encryptedData);

        System.out.println("Decrypted Data: " + new String(decryptedData));
    }
}
/*
Summary:
Symmetric Encryption (like AES) is used for encrypting large amounts of data efficiently.
Asymmetric Encryption (like RSA) is used to encrypt the symmetric key, ensuring that only authorized parties can access the symmetric key and decrypt the data.
This hybrid approach leverages the strengths of both symmetric and asymmetric encryption to handle large data securely and efficiently.
*/
