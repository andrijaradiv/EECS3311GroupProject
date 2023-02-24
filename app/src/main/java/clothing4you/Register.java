package clothing4you;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Register extends JDialog {

    private JPanel registerPanel;
    private JTextField tfName;
    private JTextField tfUsername;
    private JTextField tfEmail;
    private JPasswordField pfPassword;
    private JPasswordField pfConfirmPass;
    private JButton btnRegister;
    private JButton btnBack;

    public Register(JFrame parent) {
        super(parent);
        setTitle("Register");
        setContentPane(registerPanel);
        setMinimumSize(new Dimension(600, 600));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setLocationRelativeTo(parent);
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tfName.getText();
                String username = tfUsername.getText();
                String email = tfEmail.getText();
                char[] password = pfPassword.getPassword();
                char[] confirmPassword = pfConfirmPass.getPassword();

                if (Arrays.equals(password, confirmPassword)) {
                    User user = new User(name, username, email, password);
                    dispose();
                    Login myLogin = new Login(null);
                } else {
                    JOptionPane.showMessageDialog(registerPanel, "Password do not match", "Erorr", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Login myLogin = new Login(null);
            }
        });
        setVisible(true);
    }
}



