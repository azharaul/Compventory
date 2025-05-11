/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;
import service.DBConnectionService;
/**
 *
 * @author Zildjian XTO
 */

import java.sql.*;

public class Barang {
    private int id;
    private String nama;
    private int jumlah;
    private Timestamp tanggalMasuk;
    private Timestamp tanggalKeluar;

    public Barang(String nama, int jumlah) {
        this.nama = nama;
        this.jumlah = jumlah;
    }

    public Barang(int id, String nama, int jumlah, Timestamp tanggalMasuk, Timestamp tanggalKeluar) {
        this.id = id;
        this.nama = nama;
        this.jumlah = jumlah;
        this.tanggalMasuk = tanggalMasuk;
        this.tanggalKeluar = tanggalKeluar;
    }

    public static Barang[] getAllBarang() {
        String countQuery = "SELECT COUNT(*) AS total FROM barang";
        String dataQuery = "SELECT b.id, b.nama, s.jumlah FROM barang b LEFT JOIN stok s ON b.id = s.barang_id";

        try (Connection conn = DBConnectionService.getConnection(); 
             Statement stmt = conn.createStatement()) {

            ResultSet rsCount = stmt.executeQuery(countQuery);
            int total = 0;
            if (rsCount.next()) {
                total = rsCount.getInt("total");
            }

            Barang[] barangArray = new Barang[total];
            ResultSet rs = stmt.executeQuery(dataQuery);

            int index = 0;
            while (rs.next() && index < total) {
                barangArray[index] = new Barang(
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getInt("jumlah"),
                        null, null
                );
                index++;
            }

            return barangArray;

        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan saat mengambil data barang: " + e.getMessage());
            return new Barang[0];
        }
    }

    public static void tambahBarang(String nama, int jumlah, int harga) {
        if (jumlah <= 0 || harga <= 0) {
            System.out.println("Jumlah dan harga harus lebih dari 0.");
            return;
        }

        String insertBarang = "INSERT INTO barang (nama, harga) VALUES (?, ?)";
        String insertStok = "INSERT INTO stok (barang_id, jumlah) VALUES (?, ?)";
        String insertMasuk = "INSERT INTO barang_masuk (barang_id, jumlah, tanggal_masuk) VALUES (?, ?, ?)";

        try (Connection conn = DBConnectionService.getConnection();
             PreparedStatement stmtBarang = conn.prepareStatement(insertBarang, Statement.RETURN_GENERATED_KEYS)) {

            stmtBarang.setString(1, nama);
            stmtBarang.setInt(2, harga);
            stmtBarang.executeUpdate();

            ResultSet generatedKeys = stmtBarang.getGeneratedKeys();
            if (generatedKeys.next()) {
                int barangId = generatedKeys.getInt(1);

                try (PreparedStatement stmtStok = conn.prepareStatement(insertStok)) {
                    stmtStok.setInt(1, barangId);
                    stmtStok.setInt(2, jumlah);
                    stmtStok.executeUpdate();
                }

                try (PreparedStatement stmtMasuk = conn.prepareStatement(insertMasuk)) {
                    stmtMasuk.setInt(1, barangId);
                    stmtMasuk.setInt(2, jumlah);
                    stmtMasuk.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                    stmtMasuk.executeUpdate();
                }

                System.out.println("Barang berhasil ditambahkan.");
            } else {
                System.out.println("Gagal menambahkan barang baru.");
            }

        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan saat menambah barang: " + e.getMessage());
        }
    }

    public static void barangMasuk(String nama, int jumlah) {
        if (jumlah <= 0) {
            System.out.println("Jumlah harus lebih dari 0.");
            return;
        }

        String updateStok = "UPDATE stok SET jumlah = jumlah + ? WHERE barang_id = (SELECT id FROM barang WHERE nama = ?)";
        String insertMasuk = "INSERT INTO barang_masuk (barang_id, jumlah, tanggal_masuk) VALUES ((SELECT id FROM barang WHERE nama = ?), ?, ?)";

        try (Connection conn = DBConnectionService.getConnection();
             PreparedStatement stmtUpdate = conn.prepareStatement(updateStok)) {

            stmtUpdate.setInt(1, jumlah);
            stmtUpdate.setString(2, nama);
            int affected = stmtUpdate.executeUpdate();

            if (affected > 0) {
                try (PreparedStatement stmtMasuk = conn.prepareStatement(insertMasuk)) {
                    stmtMasuk.setString(1, nama);
                    stmtMasuk.setInt(2, jumlah);
                    stmtMasuk.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                    stmtMasuk.executeUpdate();
                }
                System.out.println("Barang masuk berhasil.");
            } else {
                System.out.println("Barang tidak ditemukan atau update stok gagal.");
            }

        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan saat memproses barang masuk: " + e.getMessage());
        }
    }

    public static void barangKeluar(String nama, int jumlah) {
        if (jumlah <= 0) {
            System.out.println("Jumlah harus lebih dari 0.");
            return;
        }

        String updateStok = "UPDATE stok SET jumlah = jumlah - ? "
                + "WHERE barang_id = (SELECT id FROM barang WHERE nama = ?) AND jumlah >= ?";
        String insertKeluar = "INSERT INTO barang_keluar (barang_id, jumlah, tanggal_keluar) "
                + "VALUES ((SELECT id FROM barang WHERE nama = ?), ?, ?)";

        try (Connection conn = DBConnectionService.getConnection();
             PreparedStatement stmtUpdate = conn.prepareStatement(updateStok)) {

            stmtUpdate.setInt(1, jumlah);
            stmtUpdate.setString(2, nama);
            stmtUpdate.setInt(3, jumlah);
            int affected = stmtUpdate.executeUpdate();

            if (affected == 0) {
                System.out.println("Stok tidak mencukupi atau barang tidak ditemukan.");
                return;
            }

            try (PreparedStatement stmtKeluar = conn.prepareStatement(insertKeluar)) {
                stmtKeluar.setString(1, nama);
                stmtKeluar.setInt(2, jumlah);
                stmtKeluar.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
                stmtKeluar.executeUpdate();
            }

            System.out.println("Barang keluar berhasil.");

        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan saat memproses barang keluar: " + e.getMessage());
        }
    }

    public static void tampilkanRiwayatBarang(int barangId) {
        System.out.println("\n=== Riwayat Barang Masuk ===");
        String queryMasuk = "SELECT jumlah, tanggal_masuk FROM barang_masuk WHERE barang_id = ?";

        try (Connection conn = DBConnectionService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(queryMasuk)) {

            stmt.setInt(1, barangId);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Tidak ada riwayat barang masuk.");
            } else {
                do {
                    System.out.println("Jumlah: " + rs.getInt("jumlah") + ", Tanggal: " + rs.getTimestamp("tanggal_masuk"));
                } while (rs.next());
            }

        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan saat mengambil riwayat barang masuk: " + e.getMessage());
        }

        System.out.println("\n=== Riwayat Barang Keluar ===");
        String queryKeluar = "SELECT jumlah, tanggal_keluar FROM barang_keluar WHERE barang_id = ?";

        try (Connection conn = DBConnectionService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(queryKeluar)) {

            stmt.setInt(1, barangId);
            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {
                System.out.println("Tidak ada riwayat barang keluar.");
            } else {
                do {
                    System.out.println("Jumlah: " + rs.getInt("jumlah") + ", Tanggal: " + rs.getTimestamp("tanggal_keluar"));
                } while (rs.next());
            }

        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan saat mengambil riwayat barang keluar: " + e.getMessage());
        }

        System.out.println("\n=== Sisa Stok Barang ===");
        String queryStok = "SELECT jumlah FROM stok WHERE barang_id = ?";

        try (Connection conn = DBConnectionService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(queryStok)) {

            stmt.setInt(1, barangId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Sisa stok barang: " + rs.getInt("jumlah"));
            } else {
                System.out.println("Barang tidak ditemukan atau stok tidak tersedia.");
            }

        } catch (SQLException e) {
            System.err.println("Terjadi kesalahan saat mengambil data stok: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Nama Barang: " + nama + ", Stok: " + jumlah + ", Tanggal Masuk: " + tanggalMasuk + ", Tanggal Keluar: " + tanggalKeluar;
    }
}
