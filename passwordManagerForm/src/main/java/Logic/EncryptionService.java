package Logic;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptionService {
    private final String algorithm = "AES";
    private final SecretKey secretKey;

    // Constructor
    public EncryptionService() throws Exception {
        // Genera una clave secreta para el algoritmo AES
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
        keyGenerator.init(128); // Tamaño de clave: 128 bits
        this.secretKey = keyGenerator.generateKey();
    }

    // Método para cifrar datos
    public String encrypt(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes); // Convierte a Base64 para almacenamiento
    }

    // Método para descifrar datos
    public String decrypt(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedData);
        byte[] originalBytes = cipher.doFinal(decodedBytes);
        return new String(originalBytes);
    }

    // Método para obtener la clave secreta en formato Base64
    public String getSecretKey() {
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    // Método para cargar una clave secreta desde Base64
    public static SecretKey loadSecretKey(String base64Key) {
        byte[] decodedKey = Base64.getDecoder().decode(base64Key);
        return new SecretKeySpec(decodedKey, "AES");
    }
}
