package mysqldatabase;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    final String DB_URL = "jdbc:mysql://localhost:3306/classroom_management?allowMultiQueries=true";
    final String PASSWORD = "";
    final String USER_NAME = "root";

    public Connection getConnection() {
        return getConnection(DB_URL, USER_NAME, PASSWORD);
    }

    public static Connection getConnection(String dbURL, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("Connect successfully!");
        } catch (Exception ex) {
            System.out.println("Connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}
