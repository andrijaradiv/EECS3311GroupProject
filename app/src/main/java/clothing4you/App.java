package clothing4you;

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

        Login.main(null);
    }
}