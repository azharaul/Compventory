package repository;
import java.awt.Component;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import service.DBConnectionService;

/**
 *
 * @author Zildjian XTO
 * @author Azhar Aulia
 */
public class BarangRepositoryImpl implements BarangRepository{
    
    /**
     *
     * @param table
     * @param conn
     */
    @Override
    public void showTableListBarang(JTable table, Connection conn) {
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {},
            new String [] {"Item's name", "Price", "Stock", "Description"} 
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
            JOptionPane.showMessageDialog(null, "Failed to take item's data: " + e.getMessage());
        }
    }
    
    /**
     *
     * @param parentComponent
     * @param table
     * @param username
     */
    @Override
    public void tambahBarangStock(Component parentComponent, JTable table, String username) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(parentComponent, "Please select an item from the table.");
            return;
        }

        String namaBarang = table.getValueAt(selectedRow, 0).toString(); 

        String jumlahStr = JOptionPane.showInputDialog(parentComponent, "Enter incoming item quantity:");
        
        if(jumlahStr == null) {
            return;
        }
        
        if (jumlahStr.isBlank()) {
            JOptionPane.showMessageDialog(parentComponent, "Item quantity can't be empty!");
            return;
        }

        int jumlahMasuk;
        try {
            jumlahMasuk = Integer.parseInt(jumlahStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parentComponent, "Quantity must be a number!");
            return;
        }

        Connection conn = null;
        try {
            conn = DBConnectionService.getConnection();
            conn.setAutoCommit(false);

            int barangId = -1;
            int hargaBarang = 0;

            String sqlCariId = "SELECT id, harga FROM barang WHERE nama = ?";
            try (PreparedStatement psCari = conn.prepareStatement(sqlCariId)) {
                psCari.setString(1, namaBarang);
                ResultSet rs = psCari.executeQuery();
                if (rs.next()) {
                    barangId = rs.getInt("id");
                    hargaBarang = rs.getInt("harga");
                } else {
                    JOptionPane.showMessageDialog(parentComponent, "Item not found!");
                    return;
                }
            }

            int totalUangKeluar = hargaBarang * jumlahMasuk;
            int saldoSekarang = new KeuanganRepositoryImpl().getSaldo();

            if (saldoSekarang < totalUangKeluar) {
                JOptionPane.showMessageDialog(parentComponent, "Not enough balance to increase stock!\n" +
                    "Current balance: " + saldoSekarang + "\nYou need: " + totalUangKeluar);
                return;
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

            catatTransaksiKeuangan("Expense", totalUangKeluar,
                "Stock addition: " + namaBarang + " a total of " + jumlahMasuk, username, 2);

            conn.commit();
            showTableListBarang(table, DBConnectionService.getConnection());
            JOptionPane.showMessageDialog(parentComponent, "Item successfully added!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parentComponent, "Database error: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException rollbackEx) {
                JOptionPane.showMessageDialog(parentComponent, "Failed to rollback: " + rollbackEx.getMessage());
            }
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(parentComponent, "Failed to close the connection: " + e.getMessage());
            }
        }
    }
     
    /**
     *
     * @param parentComponent
     * @param table
     * @param username
     */
    @Override
    public void KurangiStockBarang(Component parentComponent, JTable table, String username) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(parentComponent, "Please select an item from the table.");
            return;
        }

        String namaBarang = table.getValueAt(selectedRow, 0).toString(); 

        String jumlahStr = JOptionPane.showInputDialog(parentComponent, "Enter the quantity of items to be reduced!:");
        
        if(jumlahStr == null) {
            return;
        }
        
        if (jumlahStr.isBlank()) {
            JOptionPane.showMessageDialog(parentComponent, "Item quantity can't be empty!");
            return;
        }

        int jumlahKeluar;
        try {
            jumlahKeluar = Integer.parseInt(jumlahStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parentComponent, "Quantity must be a number!");
            return;
        }

        Connection conn = null;
        try {
            conn = DBConnectionService.getConnection();
            conn.setAutoCommit(false);

            int barangId = -1;
            int hargaBarang = 0;
            String sqlCari = "SELECT id, harga FROM barang WHERE nama = ?";
            try (PreparedStatement psCari = conn.prepareStatement(sqlCari)) {
                psCari.setString(1, namaBarang);
                ResultSet rs = psCari.executeQuery();
                if (rs.next()) {
                    barangId = rs.getInt("id");
                    hargaBarang = rs.getInt("harga");
                } else {
                    JOptionPane.showMessageDialog(parentComponent, "Item not found!");
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
                    JOptionPane.showMessageDialog(parentComponent, "There's no stock available!");
                    return;
                }
            }

            if (jumlahKeluar > stokSaatIni) {
                JOptionPane.showMessageDialog(parentComponent, "The number of items to be removed exceeds current stock! (" + stokSaatIni + " Available)");
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

            int totalUangKeluar = hargaBarang * jumlahKeluar;
            catatTransaksiKeuangan("Income", totalUangKeluar, "Item stock reduction: " + namaBarang + " a total of " + jumlahKeluar, username, 1);

            conn.commit();
            showTableListBarang(table, DBConnectionService.getConnection());
            JOptionPane.showMessageDialog(parentComponent, "Item successfully reduced!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parentComponent, "Database error: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException rollbackEx) {
                JOptionPane.showMessageDialog(parentComponent, "Failed to rollback: " + rollbackEx.getMessage());
            }
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(parentComponent, "Failed to close the connection: " + e.getMessage());
            }
        }
    }
    
    /**
     *
     * @param parentComponent
     * @param table
     */
    @Override
    public void tambahBarangBaru(Component parentComponent, JTable table) {
        String nama = JOptionPane.showInputDialog(parentComponent, "Input item name:");
        String hargaStr = JOptionPane.showInputDialog(parentComponent, "Input item price:");
        
        if(nama == null || hargaStr == null) {
            return;
        }
        
        if (nama.isBlank()) {
            JOptionPane.showMessageDialog(parentComponent, "Item name can't be empty!");
            return;
        }

        if (hargaStr.isBlank()) {
            JOptionPane.showMessageDialog(parentComponent, "Price can't be empty!");
            return;
        }

        int harga;
        try {
            harga = Integer.parseInt(hargaStr);
            if (harga < 0) {
                JOptionPane.showMessageDialog(parentComponent, "Price can't be negative!");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parentComponent, "Price must be a number!");
            return;
        }

        String deskripsi = JOptionPane.showInputDialog(parentComponent, "Input item description:");
        if (deskripsi == null || deskripsi.isBlank()) {
            JOptionPane.showMessageDialog(parentComponent, "Description can't be empty!");
            return;
        }
        
        try (Connection conn = DBConnectionService.getConnection()) {
            conn.setAutoCommit(false);
            
            
            String cekNama = "SELECT COUNT(*) FROM barang WHERE LOWER(nama) = LOWER(?)";
            try (PreparedStatement psCek = conn.prepareStatement(cekNama)) {
                psCek.setString(1, nama);
                ResultSet rs = psCek.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(parentComponent, "Item name already exists, duplicates are not allowed.");
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
                    JOptionPane.showMessageDialog(parentComponent, "Failed to get item's ID!");
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
            JOptionPane.showMessageDialog(parentComponent, "Item successfully added!");

            showTableListBarang(table, DBConnectionService.getConnection());

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parentComponent, "Database error: " + e.getMessage());
        }
    }
    
    /**
     *
     * @param table
     * @param parentComponent
     * @param button
     * @param button2
     */
    @Override
    public void lihatRiwayatBarang(JTable table, Component parentComponent, JButton button, JButton button2) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(parentComponent, "Please select an item from the table.");
            return;
        }
        
        String namaBarang = table.getValueAt(selectedRow, 0).toString();
        
        if (namaBarang.isBlank()) {
            JOptionPane.showMessageDialog(parentComponent, "Item name can't be empty!");
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
                    JOptionPane.showMessageDialog(parentComponent, "Item not found!");
                    return;
                }
            }

            table.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{},
                    new String[]{"Type", "Quantity", "Date"}
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
                    JOptionPane.showMessageDialog(parentComponent, "There is no history for this item yet.");
                }

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(parentComponent, "Database Error: " + e.getMessage());
        }
    }
    
    /**
     *
     * @param table
     * @param conn
     * @param username
     */
    @Override
    public void userBeliBarang(JTable table, Connection conn, String username) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Select the row or item you want to purchase");
            return;
        }

        String namaBarang = table.getValueAt(selectedRow, 0).toString();
        int harga = Integer.parseInt(table.getValueAt(selectedRow, 1).toString());
        int stok = Integer.parseInt(table.getValueAt(selectedRow, 2).toString());

        if (stok == 0) {
            JOptionPane.showMessageDialog(null, "No stock available.");
            return;
        }

        String inputJumlah = JOptionPane.showInputDialog("Enter the number of items to purchase:");
        if (inputJumlah == null || inputJumlah.isEmpty()) return;

        int jumlah;
        try {
            jumlah = Integer.parseInt(inputJumlah);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Input a valid number.");
            return;
        }

        if (jumlah <= 0) {
            JOptionPane.showMessageDialog(null, "The number of items must be more than 0.");
            return;
        }

        if (jumlah > stok) {
            JOptionPane.showMessageDialog(null, "Not enough stock. Stock Available: " + stok);
            return;
        }

        int totalHarga = harga * jumlah;

        int confirm = JOptionPane.showConfirmDialog(null,
            "Buy " + jumlah + " " + namaBarang + " with a total price of Rp" + totalHarga + "?",
            "Confirm your purchase",
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
                    JOptionPane.showMessageDialog(null, "Item not found in the database.");
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

            catatTransaksiKeuangan("Income", totalHarga,
                "Item purchase \"" + namaBarang + "\" a total of " + jumlah + " by \"" + username + "\"",
                username, 1);

            conn.commit();
            JOptionPane.showMessageDialog(null, "Purchase successfully.\nTotal: Rp" + totalHarga);
            table.setValueAt(stok - jumlah, selectedRow, 2);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            try {
                conn.rollback();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Failed to rollback: " + ex.getMessage());
            }
        }
    }
    
    /**
     *
     * @param jenis
     * @param jumlah
     * @param keterangan
     * @param username
     * @param status
     */
    @Override
    public void catatTransaksiKeuangan(String jenis, int jumlah, String keterangan, String username, int status) {
        String sql = "INSERT INTO transaksi_keuangan (jenis, jumlah, keterangan, username) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnectionService.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, jenis); 
                ps.setInt(2, jumlah);
                ps.setString(3, keterangan);

                if (username != null && !username.isBlank()) {
                    ps.setString(4, username);
                } else {
                    ps.setNull(4, java.sql.Types.VARCHAR);
                }
                
                if(status == 1) {
                    KeuanganRepository.tambahSaldo(jumlah);
                } else if(status == 2) {
                    KeuanganRepository.kurangiSaldo(jumlah);
                }
                
                ps.executeUpdate();
                conn.commit();

                System.out.println("Transaction successfully recordedt: Type=" + jenis + ", Quantity=" + jumlah + ", by=" + username);

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Transaction recording failed: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Failed database connection: " + e.getMessage());
        }
    }
}
