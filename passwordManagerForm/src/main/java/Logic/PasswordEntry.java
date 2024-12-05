package Logic;

public class PasswordEntry {
    private int id;
    private String title;
    private String username;
    private String encryptedPassword;
    private String url;
    private String notes;

    private static EncryptionService encryptionService; // Singleton para cifrado

    // Constructor
    public PasswordEntry(int id, String title, String username, String password, String url, String notes) {
        this.id = id;
        this.title = title;
        this.username = username;
        this.encryptedPassword = encryptPassword(password); // Cifrar al crear
        this.url = url;
        this.notes = notes;
    }

    // Método para cifrar contraseñas
    private String encryptPassword(String password) {
        try {
            return encryptionService.encrypt(password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para descifrar contraseñas
    public String decryptPassword() {
        try {
            return encryptionService.decrypt(encryptedPassword);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Otros getters y setters (sin cambios)
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUsername() {
        return username;
    }

    public String getUrl() {
        return url;
    }

    public String getNotes() {
        return notes;
    }

    public void setPassword(String newPassword) {
        this.encryptedPassword = encryptPassword(newPassword);
    }

    @Override
    public String toString() {
        return "PasswordEntry{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", url='" + url + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
