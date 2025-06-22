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
public class KeuanganServiceImpl implements KeuanganService{

    /**
     *
     * @param conn
     * @param table
     */
    @Override
    public void ShowKeuanganLogs(Connection conn, JTable table) {
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Type", "Quantity", "Date", "Description", "Username"}
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

        String sql = "SELECT jenis, jumlah, tanggal, keterangan, username FROM transaksi_keuangan ORDER BY tanggal DESC";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Object[] row = {
                    rs.getString("jenis"),
                    rs.getInt("jumlah"),
                    rs.getTimestamp("tanggal"),
                    rs.getString("keterangan"),
                    rs.getString("username")
                };
                tb.addRow(row);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to load financial data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
