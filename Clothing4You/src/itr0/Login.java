package itr0;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JDialog{


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

    public static void main(String[] args) {
        int themeIndex = 4;
        try {
            if (themeIndex == 1){
                UIManager.setLookAndFeel( new FlatLightLaf() );
            }
            else if(themeIndex == 2){
                UIManager.setLookAndFeel( new FlatDarkLaf() );
            }
            else if(themeIndex == 3){
                UIManager.setLookAndFeel( new FlatIntelliJLaf() );
            }
            else if(themeIndex == 4){
                UIManager.setLookAndFeel( new FlatDarculaLaf() );
            }
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        Login myLogin = new Login(null);
    }

}
