package databaseConnection;

import java.sql.*;

public class DatabaseConnection {

    public static Connection getConnection() {
        System.out.println("This is the getConnection()");
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/javaprojectx_db",
                    "root",
                    "admin"
            );
        } catch (Exception e) {
            System.out.println("Error connecting to database:");
            e.printStackTrace();
        }
        return conn;
    }


}
