package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnectionService {

    private static final String URL = "jdbc:mysql://localhost:3306/inventorydb?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC tidak ditemukan.");
            throw new SQLException("Driver JDBC tidak ditemukan.");
        } catch (SQLException e) {
            System.err.println("Gagal terkoneksi ke database: " + e.getMessage());
            throw e;
        }
    }
}
