package Logic;

import java.util.ArrayList;
import java.util.List;

public class PasswordManager implements iPasswordManager {
    private List<PasswordEntry> passwordList;
    private User user;
    private EncryptionService encryptionService;


    // Constructor
    public PasswordManager(User user) {
        this.passwordList = new ArrayList<>();
        this.user = user;

        try {
            this.encryptionService = new EncryptionService(); // Inicializa el servicio de cifrado

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Agregar una nueva entrada de contraseña
    public void addPassword(PasswordEntry entry) {
        passwordList.add(entry);
        System.out.println("Entrada agregada: " + entry.getTitle());
    }

    // Eliminar una entrada de contraseña
    public void deletePassword(PasswordEntry entry) {
        passwordList.remove(entry);
        System.out.println("Entrada eliminada: " + entry.getTitle());
    }

    // Buscar contraseñas por palabra clave
    public List<PasswordEntry> searchPassword(String keyword) {
        List<PasswordEntry> results = new ArrayList<>();
        for (PasswordEntry entry : passwordList) {
            if (entry.getTitle().contains(keyword) || entry.getUrl().contains(keyword)) {
                results.add(entry);
            }
        }
        return results;
    }

    // Cifrar una contraseña
    public String encryptPassword(String password) {
        try {
            return encryptionService.encrypt(password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Descifrar una contraseña
    public String decryptPassword(String encryptedPassword) {
        try {
            return encryptionService.decrypt(encryptedPassword);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Mostrar todas las entradas
    public void showAllEntries() {
        for (PasswordEntry entry : passwordList) {
            System.out.println(entry.toString());
        }
    }
}
