/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author Zildjian XTO
 */
import java.sql.*;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

interface AkunInterface {
    boolean register(String username, String password, String role);
    boolean login(String username, String password);
    String getRole(String username);
}

public class Akun implements AkunInterface {

    public static final String ROLE_ADMIN = "admin";
    public static final String ROLE_USER = "user";

    @Override
    public boolean register(String username, String password, String role) {
        String query = "INSERT INTO akun (username, password, role) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, role);
            int affected = stmt.executeUpdate();
            return affected > 0;
        } catch (SQLException e) {
            showMessageDialog(null, e.getMessage(), "Registeration", ERROR_MESSAGE);
            return false;
        }
    }

    @Override
    public boolean login(String username, String password) {
        String query = "SELECT * FROM akun WHERE username = ? AND password = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Login error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public String getRole(String username) {
        String query = "SELECT role FROM akun WHERE username = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("role");
            }
        } catch (SQLException e) {
            System.err.println("Gagal mengambil role: " + e.getMessage());
        }
        return null;
    }
}