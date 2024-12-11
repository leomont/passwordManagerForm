package Logic;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

    public class EncryptionService {
        private final String algorithm = "AES";
        private final SecretKey secretKey;


        public EncryptionService() throws Exception {

            KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
            keyGenerator.init(128);
            this.secretKey = keyGenerator.generateKey();
        }


        public String encrypt(String data) throws Exception {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        }


        public String decrypt(String encryptedData) throws Exception {
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
            byte[] originalBytes = cipher.doFinal(decodedBytes);
            return new String(originalBytes);
        }


        public String getSecretKey() {
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        }


        public static SecretKey loadSecretKey(String base64Key) {
            byte[] decodedKey = Base64.getDecoder().decode(base64Key);
            return new SecretKeySpec(decodedKey, "AES");
        }
    }


