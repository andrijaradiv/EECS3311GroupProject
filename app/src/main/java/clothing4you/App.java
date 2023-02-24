package clothing4you;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;


public class App {
    public static void main(String[] args){
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "EECS3311");
            System.out.println(con + "\n" + "Connection successful!");
        }
        catch(Exception e){
            System.out.println("Connection failed!");
        }

        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        Login myLogin = new Login(null);
    }
}