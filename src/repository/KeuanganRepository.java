/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import service.DBConnectionService;

/**
 *
 * @author auliazhar
 */
public interface KeuanganRepository {
    public int getSaldo();
    public void setSaldo(int saldoBaru);
    public static void tambahSaldo(int jumlah) {
        try (Connection conn = DBConnectionService.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE keuangan SET saldo = saldo + ? WHERE id = 1")) {

            ps.setInt(1, jumlah);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Gagal menambah saldo: " + e.getMessage());
        }
    }
    public static void kurangiSaldo(int jumlah) {
        try (Connection conn = DBConnectionService.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE keuangan SET saldo = saldo - ? WHERE id = 1")) {

            ps.setInt(1, jumlah);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Gagal mengurangi saldo: " + e.getMessage());
        }
    }
}
