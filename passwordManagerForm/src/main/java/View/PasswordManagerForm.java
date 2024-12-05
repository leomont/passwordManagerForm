package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordManagerForm {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JButton viewButton;
    private JButton deleteButton;
    private JPanel mainPanel;

    public PasswordManagerForm() {
        // Action for Register Button
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (!username.isEmpty() && !password.isEmpty()) {
                    JOptionPane.showMessageDialog(mainPanel, "User Registered: " + username);
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Action for View Button
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainPanel, "Feature not implemented yet.");
            }
        });

        // Action for Delete Button
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainPanel, "Feature not implemented yet.");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Password Manager");
        frame.setContentPane(new PasswordManagerForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
