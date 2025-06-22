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
 * @author Zildjian XTO
 */
public class CekRequestServiceImpl implements CekRequestService{

    /**
     *
     * @param conn
     * @param table
     * @param adminUsername
     */
    @Override
    public void approveRequest(Connection conn, JTable table, String adminUsername) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Select the request you want to approve!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String username = table.getValueAt(selectedRow, 0).toString();
        String namaBarang = table.getValueAt(selectedRow, 1).toString();
        int jumlahBarang = Integer.parseInt(table.getValueAt(selectedRow, 2).toString());
        String status = table.getValueAt(selectedRow, 3).toString();

        if (!status.equalsIgnoreCase("pending")) {
            JOptionPane.showMessageDialog(null, "This request has been-" + status + ".", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null,
            "Are you sure you want to approve and add the item \"" + namaBarang + "\" by \"" + username + "\"?",
            "Confirm your approval",
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
                    JOptionPane.showMessageDialog(null, "Failed to approve the request.");
                    return;
                }
            }

            String hargaStr = JOptionPane.showInputDialog(null, "Input price for item \"" + namaBarang + "\":");
            if (hargaStr == null || hargaStr.trim().isEmpty()) {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Price can't be empty.");
                return;
            }

            int harga = Integer.parseInt(hargaStr);
            int totalUangKeluar = harga * jumlahBarang;

            int saldo = new KeuanganRepositoryImpl().getSaldo();
            if (saldo < totalUangKeluar) {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Cannot approve this request due to insufficient balance!\n" +
                    "Current balance: " + saldo + "\nYou need: " + totalUangKeluar);
                return;
            }

            String deskripsi = JOptionPane.showInputDialog(null, "Input item description \"" + namaBarang + "\":");
            if (deskripsi == null || deskripsi.trim().isEmpty()) {
                conn.rollback();
                JOptionPane.showMessageDialog(null, "Description can't be empty.");
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
                    JOptionPane.showMessageDialog(null, "Failed to get Item ID!");
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
            a.catatTransaksiKeuangan("Expense", totalUangKeluar,
                "Approve request item \"" + namaBarang + "\" by \"" + username + "\" a total of " + jumlahBarang,
                adminUsername, 2);

            conn.commit();
            JOptionPane.showMessageDialog(null, "Request Approved and item successfully added to stock.");
        } catch (SQLException | NumberFormatException ex) {
            try {
                conn.rollback();
            } catch (SQLException rollbackEx) {
            }
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
