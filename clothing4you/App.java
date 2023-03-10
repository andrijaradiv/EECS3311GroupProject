package clothing4you;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static clothing4you.JDBC.createTable;
import static clothing4you.JDBC.*;


public class App {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        createTable("users", createUserTable);
        createTable("users", createCatalogTable);
        insertUser("admin", "admin@gmail.com", "admin", "admin");
        insertItem("T-shirt", "Tops", "M", 1, 20.00);
        insertItem("Hoodie", "Tops", "M", 1, 25.00);
        insertItem("Jeans", "Bottoms", "M", 1, 20.00);
        insertItem("Shorts", "Bottoms", "M", 1, 25.00);
        insertItem("Beanie", "Hats", "M", 1, 7.50);
        insertItem("Hat", "Hats", "M", 1, 7.50);

        Login myLogin = new Login(null);
    }
}