package view;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.DBConnectionService;

public class AdminCekRequest extends javax.swing.JFrame {
    private String name;
    
    public AdminCekRequest(String name) {
        initComponents();
        this.name = name;
        Connection con;
        try {
            con = DBConnectionService.getConnection();
            ShowRequestUser(con, jTable1);
        } catch (SQLException ex) {
            Logger.getLogger(BeliBarangUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ShowRequestUser(Connection conn, JTable table) {
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Username", "Nama Barang", "Jumlah Barang", "Status", "Approved By"}
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
                     "FROM request_barang ORDER BY tanggal_request DESC";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
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
            JOptionPane.showMessageDialog(null, "Gagal memuat data request barang: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        aproveBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("(Admin)Check Request");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(59, 73, 93));
        jPanel1.setForeground(new java.awt.Color(153, 204, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Nama Barang", "Jumlah Barang", "Status", "Aproved By"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        aproveBtn.setBackground(java.awt.Color.white);
        aproveBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        aproveBtn.setForeground(java.awt.Color.black);
        aproveBtn.setText("Aproved Barang");
        aproveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        aproveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aproveBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aproveBtnMouseExited(evt);
            }
        });
        aproveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aproveBtnActionPerformed(evt);
            }
        });

        backBtn.setBackground(java.awt.Color.white);
        backBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        backBtn.setForeground(java.awt.Color.black);
        backBtn.setText("Back Admin Menu");
        backBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backBtnMouseExited(evt);
            }
        });
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(aproveBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backBtn)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aproveBtn)
                    .addComponent(backBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void aproveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aproveBtnActionPerformed
         try (Connection con = DBConnectionService.getConnection()) {
            approveRequest(con, jTable1, name); 
            ShowRequestUser(con, jTable1); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Koneksi gagal: " + ex.getMessage());
        }
    }//GEN-LAST:event_aproveBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.setVisible(false);
        new AdminDashboard(name).setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void aproveBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aproveBtnMouseEntered
        // TODO add your handling code here:
                aproveBtn.setForeground(new java.awt.Color(25, 143, 216));

    }//GEN-LAST:event_aproveBtnMouseEntered

    private void aproveBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aproveBtnMouseExited
        // TODO add your handling code here:
                aproveBtn.setForeground(java.awt.Color.black);

    }//GEN-LAST:event_aproveBtnMouseExited

    private void backBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseEntered
        // TODO add your handling code here:
                backBtn.setForeground(new java.awt.Color(25, 143, 216));

    }//GEN-LAST:event_backBtnMouseEntered

    private void backBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseExited
        // TODO add your handling code here:
                backBtn.setForeground(java.awt.Color.black);

    }//GEN-LAST:event_backBtnMouseExited

    public void approveRequest(Connection conn, JTable table, String adminUsername) {
        int selectedRow = table.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null, "Pilih request yang ingin di-approve!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String username = table.getValueAt(selectedRow, 0).toString();
        String namaBarang = table.getValueAt(selectedRow, 1).toString();
        String status = table.getValueAt(selectedRow, 3).toString();

        if (!status.equalsIgnoreCase("pending")) {
            JOptionPane.showMessageDialog(null, "Request ini sudah di-" + status + ".", "Informasi", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null,
            "Yakin ingin menyetujui request barang \"" + namaBarang + "\" dari user \"" + username + "\"?",
            "Konfirmasi Approve",
            JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) return;

        String sql = "UPDATE request_barang SET status = 'approved', approved_by = ? " +
                     "WHERE username = ? AND nama_barang = ? AND status = 'pending'";

        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, adminUsername);
            pst.setString(2, username);
            pst.setString(3, namaBarang);

            int updated = pst.executeUpdate();
            if (updated > 0) {
                JOptionPane.showMessageDialog(null, "Request berhasil di-approve.");
            } else {
                JOptionPane.showMessageDialog(null, "Gagal approve request.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kesalahan database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aproveBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
