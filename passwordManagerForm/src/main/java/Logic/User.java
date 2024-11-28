package Logic;

public class User {
    private String username;
    private String masterPassword;

    // Constructor
    public User(String username, String masterPassword) {
        this.username = username;
        this.masterPassword = masterPassword; // En un sistema real, deberías cifrar esta contraseña.
    }

    // Método para autenticar al usuario
    public boolean authenticate(String password) {
        return this.masterPassword.equals(password); // Validación básica; considera hash en producción.
    }

    // Método para cambiar la contraseña maestra
    public void changeMasterPassword(String newPassword) {
        // Podrías agregar validaciones como la longitud o complejidad aquí
        this.masterPassword = newPassword; // En producción, cifra esta contraseña.
        System.out.println("Contraseña maestra actualizada con éxito.");
    }

    // Getters y Setters (si son necesarios)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

