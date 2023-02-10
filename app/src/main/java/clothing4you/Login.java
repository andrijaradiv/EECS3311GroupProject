package clothing4you;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;


public class Login extends JDialog {


    private JPanel loginPanel;
    private JTextField tfUsername;
    private JButton btnLogin;
    private JButton btnRegister;
    private JPasswordField pfPassword;
    private JButton btnGuest;

    public Login(JFrame parent) {
        super(parent);
        setTitle("Login");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(600, 600));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setLocationRelativeTo(parent);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = tfUsername.getText();
                char[] password = pfPassword.getPassword();
                dispose();
                Catalog myCatalog = new Catalog(null);
            }
        });
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Register myRegister = new Register(null);
            }
        });
        btnGuest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Catalog myCatalog = new Catalog(null);
            }
        });

        setVisible(true);
    }

}
