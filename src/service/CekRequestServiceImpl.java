/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import repository.BarangRepositoryImpl;
import repository.KeuanganRepositoryImpl;

/**
 *
 * @author auliazhar
 */
public class CekRequestServiceImpl implements CekRequestService{
    public void approveRequest(Connection conn, JTable table, String adminUsername) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Pilih request yang ingin di-approve!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String username = table.getValueAt(selectedRow, 0).toString();
        String namaBarang = table.getValueAt(selectedRow, 1).toString();
        int jumlahBarang = Integer.parseInt(table.getValueAt(selectedRow, 2).toString());
        String status = table.getValueAt(selectedRow, 3).toString();

        if (!status.equalsIgnoreCase("pending")) {
            JOptionPane.showMessageDialog(null, "Request ini sudah di-" + status + ".", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null,
            "Yakin ingin menyetujui dan menambahkan barang \"" + namaBarang + "\" dari user \"" + username + "\"?",
            "Konfirmasi Approve",
            JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) return;

        try {
            conn.setAutoCommit(false);

            String sql = "UPDATE request_barang SET status = 'approved', approved_by = ? " +
                         "WHERE username = ? AND nama_barang = ? AND status = 'pending'";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, adminUsername);
                pst.setString(2, username);
                pst.setString(3, namaBarang);
                int updated = pst.executeUpdate();
                if (updated <= 0) {
                    conn.rollback();
                    JOptionPane.showMessageDialog(null, "Gagal approve request.");
                    return;
                }
            }

            String hargaStr = JOptionPane.showInputDialog(null, "Masukkan harga untuk barang \"" + namaBarang + "\":");
            if (hargaStr == null || hargaStr.trim().isEmpty()) {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Harga tidak boleh kosong.");
                return;
            }

            int harga = Integer.parseInt(hargaStr);
            int totalUangKeluar = harga * jumlahBarang;

            int saldo = new KeuanganRepositoryImpl().getSaldo();
            if (saldo < totalUangKeluar) {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Saldo tidak mencukupi untuk menyetujui request ini!\n" +
                    "Saldo saat ini: " + saldo + "\nDibutuhkan: " + totalUangKeluar);
                return;
            }

            String deskripsi = JOptionPane.showInputDialog(null, "Masukkan deskripsi untuk barang \"" + namaBarang + "\":");
            if (deskripsi == null || deskripsi.trim().isEmpty()) {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Deskripsi tidak boleh kosong.");
                return;
            }

            int barangId;
            String insertBarang = "INSERT INTO barang (nama, harga, deskripsi) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(insertBarang, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, namaBarang);
                ps.setInt(2, harga);
                ps.setString(3, deskripsi);
                ps.executeUpdate();

                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    barangId = generatedKeys.getInt(1);
                } else {
                    conn.rollback();
                    JOptionPane.showMessageDialog(null, "Gagal mendapatkan ID barang!");
                    return;
                }
            }

            String insertStok = "INSERT INTO stok (barang_id, jumlah) VALUES (?, ?)";
            try (PreparedStatement psStok = conn.prepareStatement(insertStok)) {
                psStok.setInt(1, barangId);
                psStok.setInt(2, jumlahBarang);
                psStok.executeUpdate();
            }

            String insertMasuk = "INSERT INTO barang_masuk (barang_id, jumlah, tanggal_masuk) VALUES (?, ?, NOW())";
            try (PreparedStatement psMasuk = conn.prepareStatement(insertMasuk)) {
                psMasuk.setInt(1, barangId);
                psMasuk.setInt(2, jumlahBarang);
                psMasuk.executeUpdate();
            }

            BarangRepositoryImpl a = new BarangRepositoryImpl();
            a.catatTransaksiKeuangan("pengeluaran", totalUangKeluar,
                "Approve request barang \"" + namaBarang + "\" dari user \"" + username + "\" sebanyak " + jumlahBarang,
                adminUsername, 2);

            conn.commit();
            JOptionPane.showMessageDialog(null, "Request disetujui dan barang berhasil ditambahkan ke stok.");
        } catch (SQLException | NumberFormatException ex) {
            try {
                conn.rollback();
            } catch (SQLException rollbackEx) {
            }
            JOptionPane.showMessageDialog(null, "Kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
