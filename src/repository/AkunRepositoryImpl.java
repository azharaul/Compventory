package repository;
import service.DBConnectionService;
import java.sql.*;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

/**
 *
 * @author Zildjian XTO
 */
public class AkunRepositoryImpl implements AkunRepository {

    /**
     *
     */
    public static final String ROLE_ADMIN = "admin";

    /**
     *
     */
    public static final String ROLE_USER = "user";

    /**
     *
     * @param username
     * @param password
     * @param role
     * @param gender
     * @return
     */
    @Override
    public boolean register(String username, String password, String role, String gender) {
        String query = "INSERT INTO akun (username, password, role, gender) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnectionService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, hashPassword(password));
            stmt.setString(3, role);
            stmt.setString(4, gender);

            int affected = stmt.executeUpdate();
            return affected > 0;
        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage(), "Registration", ERROR_MESSAGE);
            return false;
        }
    }

    /**
     *
     * @param username
     * @return
     */
    public boolean isUsernameTaken(String username) {
        String query = "SELECT COUNT(*) FROM akun WHERE username = ?";
        try (Connection conn = DBConnectionService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Registration", ERROR_MESSAGE);
        }
        return false;
    }

    /**
     *
     * @param password
     * @return
     */
    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(hasingError(), e);
        }
    }
    
    /**
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public boolean login(String username, String password) {
        String query = "SELECT * FROM akun WHERE username = ? AND password = ?";
        try (Connection conn = DBConnectionService.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, hashPassword(password));
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println(AkunRepository.showEror() + e.getMessage());
            return false;
        }
    }

    /**
     *
     * @param username
     * @return
     */
    @Override
    public String getRole(String username) {
        String query = "SELECT role FROM akun WHERE username = ?";
        try (Connection conn = DBConnectionService.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("role");
            }
        } catch (SQLException e) {
            System.err.println(AkunRepository.showEror() + e.getMessage());
        }
        return null;
    }
    
    /**
     *
     * @param input
     * @return
     */
    public static boolean cekSimbolInput(String input) {
        for (char c : input.toCharArray()) {
            if ("!@#$%^&*()".indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}