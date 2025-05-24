package repository;

import java.awt.Component;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import service.DBConnectionService;

public class Barang {

    public void showTableListBarang(JTable table, Connection conn) {
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"Nama Barang", "Harga", "Stok", "Deskripsi"} 
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        });

        DefaultTableModel tb = (DefaultTableModel) table.getModel();
        tb.setRowCount(0);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        String sql = """
            SELECT b.nama, b.harga, IFNULL(s.jumlah, 0) AS stok, b.deskripsi
            FROM barang b
            LEFT JOIN stok s ON b.id = s.barang_id
        """;

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String nama = rs.getString("nama");
                int harga = rs.getInt("harga");
                int stok = rs.getInt("stok");
                String deskripsi = rs.getString("deskripsi");

                tb.addRow(new Object[]{nama, harga, stok, deskripsi});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil data barang: " + e.getMessage());
        }
    }
    
    public void tambahBarangStock(Component parentComponent, JTable table) {
        String namaBarang = JOptionPane.showInputDialog(parentComponent, "Masukkan nama barang:");
        if (namaBarang == null || namaBarang.isBlank()) {
            JOptionPane.showMessageDialog(parentComponent, "Nama barang tidak boleh kosong!");
            return;
        }

        String jumlahStr = JOptionPane.showInputDialog(parentComponent, "Masukkan jumlah barang masuk:");
        if (jumlahStr == null || jumlahStr.isBlank()) {
            JOptionPane.showMessageDialog(parentComponent, "Jumlah barang tidak boleh kosong!");
            return;
        }

        int jumlahMasuk;
        try {
            jumlahMasuk = Integer.parseInt(jumlahStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parentComponent, "Jumlah harus berupa angka!");
            return;
        }

        try (Connection conn = DBConnectionService.getConnection()) {
            conn.setAutoCommit(false);

            int barangId = -1;
            String sqlCariId = "SELECT id FROM barang WHERE nama = ?";
            try (PreparedStatement psCari = conn.prepareStatement(sqlCariId)) {
                psCari.setString(1, namaBarang);
                ResultSet rs = psCari.executeQuery();
                if (rs.next()) {
                    barangId = rs.getInt("id");
                } else {
                    JOptionPane.showMessageDialog(parentComponent, "Barang tidak ditemukan!");
                    return;
                }
            }

            String insertMasuk = "INSERT INTO barang_masuk (barang_id, jumlah, tanggal_masuk) VALUES (?, ?, NOW())";
            try (PreparedStatement psMasuk = conn.prepareStatement(insertMasuk)) {
                psMasuk.setInt(1, barangId);
                psMasuk.setInt(2, jumlahMasuk);
                psMasuk.executeUpdate();
            }

            String updateStok = "UPDATE stok SET jumlah = jumlah + ? WHERE barang_id = ?";
            try (PreparedStatement psUpdate = conn.prepareStatement(updateStok)) {
                psUpdate.setInt(1, jumlahMasuk);
                psUpdate.setInt(2, barangId);
                int affectedRows = psUpdate.executeUpdate();

                if (affectedRows == 0) {
                    String insertStok = "INSERT INTO stok (barang_id, jumlah) VALUES (?, ?)";
                    try (PreparedStatement psInsert = conn.prepareStatement(insertStok)) {
                        psInsert.setInt(1, barangId);
                        psInsert.setInt(2, jumlahMasuk);
                        psInsert.executeUpdate();
                    }
                }
            }

            conn.commit();
            showTableListBarang(table, DBConnectionService.getConnection());
            JOptionPane.showMessageDialog(parentComponent, "Barang berhasil ditambahkan!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parentComponent, "Kesalahan database: " + e.getMessage());
            try {
                DBConnectionService.getConnection().rollback();
            } catch (SQLException rollbackEx) {
                JOptionPane.showMessageDialog(parentComponent, "Gagal rollback: " + rollbackEx.getMessage());
            }
        }
    }

    
    public void KurangiStockBarang(Component parentComponent, JTable table) {
        String namaBarang = JOptionPane.showInputDialog(parentComponent, "Masukkan nama barang:");
        if (namaBarang == null || namaBarang.isBlank()) {
            JOptionPane.showMessageDialog(parentComponent, "Nama barang tidak boleh kosong!");
            return;
        }

        String jumlahStr = JOptionPane.showInputDialog(parentComponent, "Masukkan jumlah barang yang dikurangi:");
        if (jumlahStr == null || jumlahStr.isBlank()) {
            JOptionPane.showMessageDialog(parentComponent, "Jumlah barang tidak boleh kosong!");
            return;
        }

        int jumlahKeluar;
        try {
            jumlahKeluar = Integer.parseInt(jumlahStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parentComponent, "Jumlah harus berupa angka!");
            return;
        }

        Connection conn = null;
        try {
            conn = DBConnectionService.getConnection();
            conn.setAutoCommit(false);

            int barangId = -1;
            String sqlCariId = "SELECT id FROM barang WHERE nama = ?";
            try (PreparedStatement psCari = conn.prepareStatement(sqlCariId)) {
                psCari.setString(1, namaBarang);
                ResultSet rs = psCari.executeQuery();
                if (rs.next()) {
                    barangId = rs.getInt("id");
                } else {
                    JOptionPane.showMessageDialog(parentComponent, "Barang tidak ditemukan!");
                    return;
                }
            }

            int stokSaatIni = 0;
            String sqlCekStok = "SELECT jumlah FROM stok WHERE barang_id = ?";
            try (PreparedStatement psCekStok = conn.prepareStatement(sqlCekStok)) {
                psCekStok.setInt(1, barangId);
                ResultSet rs = psCekStok.executeQuery();
                if (rs.next()) {
                    stokSaatIni = rs.getInt("jumlah");
                } else {
                    JOptionPane.showMessageDialog(parentComponent, "Barang belum memiliki stok!");
                    return;
                }
            }

            if (jumlahKeluar > stokSaatIni) {
                JOptionPane.showMessageDialog(parentComponent, "Jumlah barang keluar melebihi stok yang tersedia! (" + stokSaatIni + " tersedia)");
                return;
            }

            String insertKeluar = "INSERT INTO barang_keluar (barang_id, jumlah, tanggal_keluar) VALUES (?, ?, NOW())";
            try (PreparedStatement psKeluar = conn.prepareStatement(insertKeluar)) {
                psKeluar.setInt(1, barangId);
                psKeluar.setInt(2, jumlahKeluar);
                psKeluar.executeUpdate();
            }

            String updateStok = "UPDATE stok SET jumlah = jumlah - ? WHERE barang_id = ?";
            try (PreparedStatement psUpdate = conn.prepareStatement(updateStok)) {
                psUpdate.setInt(1, jumlahKeluar);
                psUpdate.setInt(2, barangId);
                psUpdate.executeUpdate();
            }

            conn.commit();
            showTableListBarang(table, DBConnectionService.getConnection());
            JOptionPane.showMessageDialog(parentComponent, "Barang berhasil dikurangi!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parentComponent, "Kesalahan database: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException rollbackEx) {
                JOptionPane.showMessageDialog(parentComponent, "Gagal rollback: " + rollbackEx.getMessage());
            }
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(parentComponent, "Gagal menutup koneksi: " + e.getMessage());
            }
        }
    }
    
    public void tambahBarangBaru(Component parentComponent, JTable table) {
        String nama = JOptionPane.showInputDialog(parentComponent, "Masukkan nama barang:");

        if (nama == null || nama.isBlank()) {
            JOptionPane.showMessageDialog(parentComponent, "Nama barang tidak boleh kosong!");
            return;
        }

        String hargaStr = JOptionPane.showInputDialog(parentComponent, "Masukkan harga per barang:");
        if (hargaStr == null || hargaStr.isBlank()) {
            JOptionPane.showMessageDialog(parentComponent, "Harga tidak boleh kosong!");
            return;
        }

        int harga;
        try {
            harga = Integer.parseInt(hargaStr);
            if (harga < 0) {
                JOptionPane.showMessageDialog(parentComponent, "Harga tidak boleh negatif!");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parentComponent, "Harga harus berupa angka!");
            return;
        }

        String deskripsi = JOptionPane.showInputDialog(parentComponent, "Masukkan deskripsi barang:");
        if (deskripsi == null || deskripsi.isBlank()) {
            JOptionPane.showMessageDialog(parentComponent, "Deskripsi tidak boleh kosong!");
            return;
        }
        
        

        try (Connection conn = DBConnectionService.getConnection()) {
            conn.setAutoCommit(false);
            
            
            String cekNama = "SELECT COUNT(*) FROM barang WHERE LOWER(nama) = LOWER(?)";
            try (PreparedStatement psCek = conn.prepareStatement(cekNama)) {
                psCek.setString(1, nama);
                ResultSet rs = psCek.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(parentComponent, "Nama barang sudah ada di database! Tidak boleh duplikat.");
                    return;
                }
            }
            String insertBarang = "INSERT INTO barang (nama, harga, deskripsi) VALUES (?, ?, ?)";
            int barangId;
            try (PreparedStatement ps = conn.prepareStatement(insertBarang, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, nama);
                ps.setInt(2, harga);
                ps.setString(3, deskripsi);
                ps.executeUpdate();

                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    barangId = generatedKeys.getInt(1);
                } else {
                    conn.rollback();
                    JOptionPane.showMessageDialog(parentComponent, "Gagal mendapatkan ID barang!");
                    return;
                }
            }

            String insertStok = "INSERT INTO stok (barang_id, jumlah) VALUES (?, ?)";
            try (PreparedStatement psStok = conn.prepareStatement(insertStok)) {
                psStok.setInt(1, barangId);
                psStok.setInt(2, 0);
                psStok.executeUpdate();
            }

            String insertBarangMasuk = "INSERT INTO barang_masuk (barang_id, jumlah, tanggal_masuk) VALUES (?, ?, NOW())";
            try (PreparedStatement psMasuk = conn.prepareStatement(insertBarangMasuk)) {
                psMasuk.setInt(1, barangId);
                psMasuk.setInt(2, 0);
                psMasuk.executeUpdate();
            }

            conn.commit(); 
            JOptionPane.showMessageDialog(parentComponent, "Barang berhasil ditambahkan!");

            showTableListBarang(table, DBConnectionService.getConnection());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parentComponent, "Kesalahan database: " + e.getMessage());
        }
    }
    
    public void lihatRiwayatBarang(JTable table, Component parentComponent, JButton button, JButton button2) {
        String namaBarang = JOptionPane.showInputDialog(parentComponent, "Masukkan nama barang:");
        if (namaBarang == null || namaBarang.isBlank()) {
            JOptionPane.showMessageDialog(parentComponent, "Nama barang tidak boleh kosong!");
            return;
        }

        try (Connection conn = DBConnectionService.getConnection()) {
            int barangId = -1;
            String sqlCariId = "SELECT id FROM barang WHERE nama = ?";
            try (PreparedStatement psCari = conn.prepareStatement(sqlCariId)) {
                psCari.setString(1, namaBarang);
                ResultSet rs = psCari.executeQuery();
                if (rs.next()) {
                    barangId = rs.getInt("id");
                } else {
                    JOptionPane.showMessageDialog(parentComponent, "Barang tidak ditemukan!");
                    return;
                }
            }

            table.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{},
                    new String[]{"Tipe", "Jumlah", "Tanggal"}
            ) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            });

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            table.getTableHeader().setReorderingAllowed(false);
            table.getTableHeader().setResizingAllowed(false);
            table.setRowSelectionAllowed(true);
            table.setColumnSelectionAllowed(false);
            table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

            String sql = """
                SELECT 'Masuk' AS tipe, jumlah, tanggal_masuk AS tanggal
                FROM barang_masuk WHERE barang_id = ?
                UNION ALL
                SELECT 'Keluar' AS tipe, jumlah, tanggal_keluar AS tanggal
                FROM barang_keluar WHERE barang_id = ?
                ORDER BY tanggal ASC
            """;

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, barangId);
                ps.setInt(2, barangId);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    String tipe = rs.getString("tipe");
                    int jumlah = rs.getInt("jumlah");
                    Timestamp tanggal = rs.getTimestamp("tanggal");

                    model.addRow(new Object[]{tipe, jumlah, tanggal});
                    button.setVisible(true);
                    button2.setVisible(false);
                }

                if (model.getRowCount() == 0) {
                    JOptionPane.showMessageDialog(parentComponent, "Belum ada riwayat barang masuk/keluar untuk barang ini.");
                }

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parentComponent, "Kesalahan database: " + e.getMessage());
        }
    }
    
    public void userBeliBarang(JTable table, Connection conn) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Pilih baris / Barang yang ingin dibeli.");
            return;
        }

        String namaBarang = table.getValueAt(selectedRow, 0).toString(); // kolom Nama Barang
        int harga = Integer.parseInt(table.getValueAt(selectedRow, 1).toString());
        int stok = Integer.parseInt(table.getValueAt(selectedRow, 2).toString());

        if (stok == 0) {
            JOptionPane.showMessageDialog(null, "Stok barang kosong.");
            return;
        }

        String inputJumlah = JOptionPane.showInputDialog("Masukkan jumlah yang ingin dibeli:");
        if (inputJumlah == null || inputJumlah.isEmpty()) return;

        int jumlah;
        try {
            jumlah = Integer.parseInt(inputJumlah);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Masukkan jumlah yang valid.");
            return;
        }

        if (jumlah <= 0) {
            JOptionPane.showMessageDialog(null, "Jumlah harus lebih dari 0.");
            return;
        }

        if (jumlah > stok) {
            JOptionPane.showMessageDialog(null, "Stok tidak mencukupi. Stok tersedia: " + stok);
            return;
        }

        int totalHarga = harga * jumlah;

        int confirm = JOptionPane.showConfirmDialog(null,
            "Beli " + jumlah + " " + namaBarang + " dengan total harga Rp" + totalHarga + "?",
            "Konfirmasi Pembelian",
            JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) return;

        try {
            int barangId = -1;
            String getIdQuery = "SELECT id FROM barang WHERE nama = ?";
            try (PreparedStatement ps = conn.prepareStatement(getIdQuery)) {
                ps.setString(1, namaBarang);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    barangId = rs.getInt("id");
                } else {
                    JOptionPane.showMessageDialog(null, "Barang tidak ditemukan di database.");
                    return;
                }
            }

            conn.setAutoCommit(false);

            String updateStok = "UPDATE stok SET jumlah = jumlah - ? WHERE barang_id = ?";
            try (PreparedStatement ps = conn.prepareStatement(updateStok)) {
                ps.setInt(1, jumlah);
                ps.setInt(2, barangId);
                ps.executeUpdate();
            }

            String insertKeluar = "INSERT INTO barang_keluar (barang_id, jumlah, tanggal_keluar) VALUES (?, ?, NOW())";
            try (PreparedStatement ps = conn.prepareStatement(insertKeluar)) {
                ps.setInt(1, barangId);
                ps.setInt(2, jumlah);
                ps.executeUpdate();
            }

            conn.commit();
            JOptionPane.showMessageDialog(null, "Pembelian berhasil.\nTotal: Rp" + totalHarga);
            table.setValueAt(stok - jumlah, selectedRow, 2); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Kesalahan: " + e.getMessage());
            try {
                conn.rollback();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Rollback Gagal" + ex.getMessage());
            }
        }
    }
}
