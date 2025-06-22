package service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Zildjian XTO
 */
public class DBConnectionService {

    private static final String URL = "jdbc:mysql://localhost:3306/inventorydb?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    /**
     *
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC driver not found.");
            throw new SQLException("Driver JDBC tidak ditemukan.");
        } catch (SQLException e) {
            System.err.println("Failed connect to database: " + e.getMessage());
            throw e;
        }
    }
}
