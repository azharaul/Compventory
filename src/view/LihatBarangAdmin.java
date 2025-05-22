package view;

import java.awt.Color;
import repository.Barang;
import service.DBConnectionService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;


import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
public class LihatBarangAdmin extends javax.swing.JFrame {
    private String name;
    
    public LihatBarangAdmin(String name) {
        
        initComponents();
        this.name = name;

        try {
            Connection conn = DBConnectionService.getConnection();
            Barang barangRepo = new Barang();
            barangRepo.showTableListBarang(jTable1, conn);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menampilkan data barang: " + e.getMessage());
        }
        
        
    }
    
    private void setCustomTableRenderer() {
  
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

        setTitle("(Admin)Lihat Barang");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(153, 204, 255));

        jTable1.setBackground(new java.awt.Color(245, 245, 245));
        jTable1.setForeground(java.awt.Color.black);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nama Barang", "Harga", "Stock", "Deskripsi"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(221, 221, 221));
        jTable1.setSelectionBackground(new java.awt.Color(33, 150, 243));
        jTable1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        kurangiStokBtn.setBackground(new java.awt.Color(33, 150, 243));
        kurangiStokBtn.setForeground(java.awt.Color.white);
        kurangiStokBtn.setText("Kurangi Stock");
        kurangiStokBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kurangiStokBtnActionPerformed(evt);
            }
        });

        tambahStokBtn.setBackground(new java.awt.Color(33, 150, 243));
        tambahStokBtn.setForeground(new java.awt.Color(255, 255, 255));
        tambahStokBtn.setText("Tambah Stock");
        tambahStokBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahStokBtnActionPerformed(evt);
            }
        });

        barangBaruBtn.setBackground(new java.awt.Color(33, 150, 243));
        barangBaruBtn.setForeground(new java.awt.Color(255, 255, 255));
        barangBaruBtn.setText("Barang Baru");
        barangBaruBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                barangBaruBtnMouseEntered(evt);
            }
        });
        barangBaruBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barangBaruBtnActionPerformed(evt);
            }
        });

        backBtn.setBackground(new java.awt.Color(33, 150, 243));
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Back Admin Menu");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(barangBaruBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kurangiStokBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tambahStokBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 180, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(barangBaruBtn)
                    .addComponent(kurangiStokBtn)
                    .addComponent(tambahStokBtn)
                    .addComponent(backBtn))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kurangiStokBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kurangiStokBtnActionPerformed
        Barang barangRepo = new Barang();
        barangRepo.KurangiStockBarang(this, jTable1);
    }//GEN-LAST:event_kurangiStokBtnActionPerformed

    private void tambahStokBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahStokBtnActionPerformed
        Barang barangRepo = new Barang();
        barangRepo.tambahBarangStock(this, jTable1);
    }//GEN-LAST:event_tambahStokBtnActionPerformed

    private void barangBaruBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barangBaruBtnActionPerformed
        Barang barangRepo = new Barang();
        barangRepo.tambahBarangBaru(this, jTable1);
    }//GEN-LAST:event_barangBaruBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.setVisible(false);
        new AdminDashboard(name).setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void barangBaruBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barangBaruBtnMouseEntered
        // TODO add your handling code here:
        barangBaruBtn.setForeground(new java.awt.Color(0,188,212));
    }//GEN-LAST:event_barangBaruBtnMouseEntered


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
