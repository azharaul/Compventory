package view;
import repository.BarangRepositoryImpl;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import service.DBConnectionService;

/**
 *
 * @author Zildjian XTO
 */
public class LihatRiwayatBarangAdmin extends javax.swing.JFrame {

    private String name;

    /**
     *
     */
    public LihatRiwayatBarangAdmin(){
        initComponents();
    }

    /**
     *
     * @param name
     */
    public LihatRiwayatBarangAdmin(String name) {
        try {
            Connection conn = DBConnectionService.getConnection();
            BarangRepositoryImpl barangRepo = new BarangRepositoryImpl();
            initComponents();
            barangRepo.showTableListBarang(jTable1, conn);
            bckListBarangBtn.setVisible(false);
            historyBtn.setVisible(true);
            this.name = name;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed To Show Item`s Data: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        historyBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        bckListBarangBtn = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Item History");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(59, 73, 93));
        jPanel1.setForeground(new java.awt.Color(153, 204, 255));

        jTable1.setBackground(new java.awt.Color(245, 245, 245));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item's name", "Price", "Stock", "Description"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        historyBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        historyBtn.setText("Check History");
        historyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        historyBtn.setMinimumSize(new java.awt.Dimension(105, 27));
        historyBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                historyBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                historyBtnMouseExited(evt);
            }
        });
        historyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyBtnActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        backBtn.setText("Back To Admin Menu");
        backBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn.setMinimumSize(new java.awt.Dimension(105, 27));
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

        bckListBarangBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        bckListBarangBtn.setText("Back To Items List");
        bckListBarangBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bckListBarangBtn.setPreferredSize(new java.awt.Dimension(105, 27));
        bckListBarangBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bckListBarangBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bckListBarangBtnMouseExited(evt);
            }
        });
        bckListBarangBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bckListBarangBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bckListBarangBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(historyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bckListBarangBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(historyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.setVisible(false);
        new AdminDashboard(name).setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void historyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyBtnActionPerformed
       BarangRepositoryImpl barangRepo = new BarangRepositoryImpl(); 
       barangRepo.lihatRiwayatBarang(jTable1, this, bckListBarangBtn, historyBtn);
       
    }//GEN-LAST:event_historyBtnActionPerformed

    private void bckListBarangBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bckListBarangBtnActionPerformed
        try {
            Connection conn = DBConnectionService.getConnection();
            BarangRepositoryImpl barangRepo = new BarangRepositoryImpl();
            barangRepo.showTableListBarang(jTable1, conn);
            bckListBarangBtn.setVisible(false);
            historyBtn.setVisible(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed To Show Item`s Data: " + e.getMessage());
        }
    }//GEN-LAST:event_bckListBarangBtnActionPerformed

    private void bckListBarangBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bckListBarangBtnMouseEntered
        bckListBarangBtn.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_bckListBarangBtnMouseEntered

    private void bckListBarangBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bckListBarangBtnMouseExited
        bckListBarangBtn.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_bckListBarangBtnMouseExited

    private void historyBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyBtnMouseEntered
        historyBtn.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_historyBtnMouseEntered

    private void historyBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyBtnMouseExited
        historyBtn.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_historyBtnMouseExited

    private void backBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseEntered
        backBtn.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_backBtnMouseEntered

    private void backBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseExited
        backBtn.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_backBtnMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton bckListBarangBtn;
    private javax.swing.JButton historyBtn;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
