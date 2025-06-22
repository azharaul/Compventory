package view;
import repository.BarangRepositoryImpl;
import service.DBConnectionService;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author Zildjian XTO
 */
public class LihatBarangAdmin extends javax.swing.JFrame {
    private String name;

    /**
     *
     */
    public LihatBarangAdmin(){
        initComponents();
    }

    /**
     *
     * @param name
     */
    public LihatBarangAdmin(String name) {
        
        initComponents();
        this.name = name;

        try {
            Connection conn = DBConnectionService.getConnection();
            BarangRepositoryImpl barangRepo = new BarangRepositoryImpl();
            barangRepo.showTableListBarang(jTable1, conn);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to display item data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        kurangiStokBtn = new javax.swing.JButton();
        tambahStokBtn = new javax.swing.JButton();
        barangBaruBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        jCheckBox1.setText("jCheckBox1");

        setTitle("View Item");
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
        jTable1.setGridColor(new java.awt.Color(221, 221, 221));
        jTable1.setSelectionBackground(new java.awt.Color(33, 150, 243));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        kurangiStokBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        kurangiStokBtn.setText("Decrease Stock");
        kurangiStokBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kurangiStokBtn.setPreferredSize(new java.awt.Dimension(76, 27));
        kurangiStokBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                kurangiStokBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                kurangiStokBtnMouseExited(evt);
            }
        });
        kurangiStokBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kurangiStokBtnActionPerformed(evt);
            }
        });

        tambahStokBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tambahStokBtn.setText("Add Stock");
        tambahStokBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tambahStokBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tambahStokBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tambahStokBtnMouseExited(evt);
            }
        });
        tambahStokBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahStokBtnActionPerformed(evt);
            }
        });

        barangBaruBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        barangBaruBtn.setText("New Item");
        barangBaruBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        barangBaruBtn.setPreferredSize(new java.awt.Dimension(76, 27));
        barangBaruBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                barangBaruBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                barangBaruBtnMouseExited(evt);
            }
        });
        barangBaruBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barangBaruBtnActionPerformed(evt);
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(barangBaruBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(kurangiStokBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tambahStokBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addComponent(backBtn)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(barangBaruBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kurangiStokBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tambahStokBtn)
                    .addComponent(backBtn))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kurangiStokBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kurangiStokBtnActionPerformed
        BarangRepositoryImpl barangRepo = new BarangRepositoryImpl();
        barangRepo.KurangiStockBarang(this, jTable1, name);
    }//GEN-LAST:event_kurangiStokBtnActionPerformed

    private void tambahStokBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahStokBtnActionPerformed
        BarangRepositoryImpl barangRepo = new BarangRepositoryImpl();
        barangRepo.tambahBarangStock(this, jTable1, name);
    }//GEN-LAST:event_tambahStokBtnActionPerformed

    private void barangBaruBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barangBaruBtnActionPerformed
        BarangRepositoryImpl barangRepo = new BarangRepositoryImpl();
        barangRepo.tambahBarangBaru(this, jTable1);
    }//GEN-LAST:event_barangBaruBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.setVisible(false);
        new AdminDashboard(name).setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void barangBaruBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barangBaruBtnMouseEntered
        barangBaruBtn.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_barangBaruBtnMouseEntered

    private void barangBaruBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barangBaruBtnMouseExited
        barangBaruBtn.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_barangBaruBtnMouseExited

    private void kurangiStokBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kurangiStokBtnMouseEntered
        kurangiStokBtn.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_kurangiStokBtnMouseEntered

    private void kurangiStokBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kurangiStokBtnMouseExited
        kurangiStokBtn.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_kurangiStokBtnMouseExited

    private void tambahStokBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahStokBtnMouseEntered
        tambahStokBtn.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_tambahStokBtnMouseEntered

    private void tambahStokBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahStokBtnMouseExited
        tambahStokBtn.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_tambahStokBtnMouseExited

    private void backBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseEntered
        backBtn.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_backBtnMouseEntered

    private void backBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseExited
        backBtn.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_backBtnMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton barangBaruBtn;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton kurangiStokBtn;
    private javax.swing.JButton tambahStokBtn;
    // End of variables declaration//GEN-END:variables
}
