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
import service.CekRequestServiceImpl;

/**
 *
 * @author Zildjian XTO
 */
public class AdminCekRequest extends javax.swing.JFrame {
    private String name;
    
    /**
     *
     */
    public AdminCekRequest(){
        initComponents();
    }

    /**
     *
     * @param name
     */
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

    /**
     *
     * @param conn
     * @param table
     */
    public void ShowRequestUser(Connection conn, JTable table) {
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{"Username", "Item Name", "Item Quantity", "Status", "Approved By"}
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
            JOptionPane.showMessageDialog(null, "Failed to load item request data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        aproveBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Request Items History");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(59, 73, 93));
        jPanel1.setForeground(new java.awt.Color(153, 204, 255));
        jPanel1.setDoubleBuffered(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Item's Name", "Quantity", "Status", "Approved By"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        aproveBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        aproveBtn.setText("Approve the item");
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

        backBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        backBtn.setText("Back To Admin Menu");
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
                .addComponent(aproveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void aproveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aproveBtnActionPerformed
         try (Connection con = DBConnectionService.getConnection()) {
            new CekRequestServiceImpl().approveRequest(con, jTable1, name); 
            ShowRequestUser(con, jTable1); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Failed Connection: " + ex.getMessage());
        }
    }//GEN-LAST:event_aproveBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.setVisible(false);
        new AdminDashboard(name).setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void aproveBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aproveBtnMouseEntered
        aproveBtn.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_aproveBtnMouseEntered

    private void aproveBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aproveBtnMouseExited
        aproveBtn.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_aproveBtnMouseExited

    private void backBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseEntered
        backBtn.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_backBtnMouseEntered

    private void backBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseExited
        backBtn.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_backBtnMouseExited
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aproveBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
