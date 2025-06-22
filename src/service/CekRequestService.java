package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zildjian XTO
 */
public interface CekRequestService {

    /**
     *
     * @param conn
     * @param table
     * @param adminUsername
     */
    public void approveRequest(Connection conn, JTable table, String adminUsername);
    
    /**
     *
     * @param conn
     * @param table
     * @param username
     */
    public default void ShowRequestUser(Connection conn, JTable table, String username) {
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Username", "Item's name", "Quantity", "Status", "Approved By"}
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

        String sql = "SELECT username, nama_barang, jumlah, status, IFNULL(approved_by, '-') AS approved_by " +
                     "FROM request_barang WHERE username = ? ORDER BY tanggal_request DESC";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Object[] row = {
                    rs.getString("username"),
                    rs.getString("nama_barang"),
                    rs.getInt("jumlah"),
                    rs.getString("status"),
                    rs.getString("approved_by")
                };
                tb.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to load item request data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
