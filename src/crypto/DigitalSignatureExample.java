package crypto;

import java.security.*;
import java.util.Base64;
//Digital signatures are used to verify the authenticity and integrity of a message.

public class DigitalSignatureExample {
    public static void main() throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair pair = keyGen.generateKeyPair();
        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();

        String data = "Important Message";

        // Sign the data
        Signature signature = Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(data.getBytes());
        byte[] digitalSignature = signature.sign();

        System.out.println("Digital Signature: " + Base64.getEncoder().encodeToString(digitalSignature));

        // Verify the signature
        signature.initVerify(publicKey);
        signature.update(data.getBytes());
        boolean isVerified = signature.verify(digitalSignature);

        System.out.println("Signature Verified: " + isVerified);
    }
}
