import java.sql.*;

public class JDBC {
    static String url = "jdbc:mysql://sql9.freesqldatabase.com:3306/sql9596544";
    static String username = "sql9596544";
    static String password = "KLHarcxrhe";
    public static ResultSet query(String query, String table) {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            if(query.toLowerCase().contains("insert")) {
                int insert = statement.executeUpdate(query + table);
            }
            ResultSet resultSet = statement.executeQuery(query + table); //"select * from users"

//            while(resultSet.next()) {
//                System.out.println(resultSet.getString(1));
//            }

            return resultSet;
        } catch(Exception e) {
            System.out.println(e);
            return null;
        }

    }

    public static ResultSet queryTable(String query, String table) {
        try {
            ResultSet resultSet = query(query, table);

            return resultSet;

        } catch(Exception e) {
            return null;
        }

    }
    public static ResultSet getTable(String table) {
        try {
            ResultSet resultSet = query("select * from ", table);

            return resultSet;

        } catch(Exception e) {
            return null;
        }

    }

}