package Logic;
import java.util.List;

public interface iPasswordManager {
    void addPassword(PasswordEntry entry);

    void deletePassword(PasswordEntry entry);

    List<PasswordEntry> searchPassword(String keyword);

    String encryptPassword(String password);

    String decryptPassword(String encryptedPassword);
}
