package PACKAGE_NAME.Logic;

    public class User {
        private String username;
        private String masterPassword;

        // Constructor
        public User(String username, String masterPassword) {
            this.username = username;
            this.masterPassword = masterPassword;
        }

        //
        public boolean authenticate(String password) {
            return this.masterPassword.equals(password);
        }


        public void changeMasterPassword(String newPassword) {

            this.masterPassword = newPassword;
            System.out.println("Contraseña maestra actualizada.");
        }


        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

    }

