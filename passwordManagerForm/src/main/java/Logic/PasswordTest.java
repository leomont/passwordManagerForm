package Logic;

public class PasswordTest {
    public static void main(String[] args){
        String data = "Mensaje en texto plano";
        EncryptionService encryptor = null;
        try {
            encryptor = new EncryptionService();
            System.out.println("Texto originial :" + data);
            String encryptedData = encryptor.encrypt(data);
            System.out.println("Texto cifrado " + encryptedData);
            String decryptedData = encryptor.decrypt(encryptedData);
            System.out.println("Texto descifrado " + decryptedData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
