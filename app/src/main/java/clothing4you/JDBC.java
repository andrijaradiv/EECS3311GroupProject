package clothing4you;

import java.sql.*;
import java.util.ArrayList;

public class JDBC {
    private static String url = "jdbc:sqlite:/sqlite/clothing4you";
    public static String createUserTable = "CREATE TABLE users (" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
            "first_name TEXT," +
            "last_name TEXT," +
            "email TEXT," +
            "username TEXT," +
            "password TEXT" +
            ");";
    private static Connection establishConnection() throws SQLException, ClassNotFoundException {
        // Establishes connection with sqlite database

        Connection conn = null;

        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:clothing4you.db");

        } catch ( Exception e ) {
        }
        return conn;
    }

    public static void createTable(String table, String createTable) throws SQLException, ClassNotFoundException {
        // Creates table in sqlite database with table name input and sql create table statement

        Connection conn = establishConnection();
        Statement stmt = conn.createStatement();

        stmt.executeUpdate("drop table if exists " + table +";");
        stmt.executeUpdate(createTable);
        stmt.close();
        System.out.println("Table created successfully");
    }

   public static void insertUser(String first_name, String last_name, String email,String username, String password) throws SQLException, ClassNotFoundException {
        // Inserts user into user table to allow for data query

        Connection conn = establishConnection();
        conn.setAutoCommit(false);
        Statement stmt = conn.createStatement();
        String sqlStatement = "INSERT INTO users (first_name,last_name,email,username,password) " +
               "VALUES ('" + first_name + "','" + last_name + "','" + email + "','" +username +"','"+ password + "');";
        stmt.executeUpdate(sqlStatement);

        conn.commit();
        conn.close();
   }

    public static ArrayList query(String table, String column_name) throws SQLException, ClassNotFoundException {
        // Queries given table and returns array with data in column_name
        ArrayList result = new ArrayList<>();

        Connection conn = establishConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * from " + table);

        while(resultSet.next()) {
            result.add(resultSet.getString(column_name));
            //System.out.println(resultSet.getString("email"));
        }

        return result;
    }
    // For reference
//    public static void main(String[] args) throws SQLException, ClassNotFoundException {
//        createTable("users", createUserTable);
//        insertUser("andrija", "rad", "a@gmail.com","andrija121", "1234");
//        insertUser("willy", "lego", "willlego@gmail.com","willo1053", "1234");
//        ArrayList a = query("users", "username");
//        System.out.println(a);
//    }
}