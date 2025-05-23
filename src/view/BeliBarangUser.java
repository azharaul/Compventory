/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JOptionPane;
import repository.Barang;
import service.DBConnectionService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BeliBarangUser extends javax.swing.JFrame {
    
    private String name;
    
    public BeliBarangUser(String name) {
        this.name = name;
        initComponents();
        try {
            Connection conn = DBConnectionService.getConnection();
            Barang barangRepo = new Barang();
            barangRepo.showTableListBarang(jTable1, conn);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menampilkan data barang: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        beliBarang = new javax.swing.JButton();
        beliBarang1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(59, 73, 93));
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
        jScrollPane1.setViewportView(jTable1);

        beliBarang.setBackground(new java.awt.Color(33, 150, 243));
        beliBarang.setForeground(new java.awt.Color(255, 255, 255));
        beliBarang.setText("Beli Barang");
        beliBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beliBarangActionPerformed(evt);
            }
        });

        beliBarang1.setBackground(new java.awt.Color(33, 150, 243));
        beliBarang1.setForeground(new java.awt.Color(255, 255, 255));
        beliBarang1.setText("Back User Menu");
        beliBarang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beliBarang1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(beliBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(beliBarang1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(beliBarang)
                    .addComponent(beliBarang1))
                .addGap(0, 12, Short.MAX_VALUE))
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

    private void beliBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliBarangActionPerformed
        Barang barangRepo = new Barang();
        Connection con;
        try {
            con = DBConnectionService.getConnection();
            barangRepo.userBeliBarang(jTable1, con);
        } catch (SQLException ex) {
            Logger.getLogger(BeliBarangUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_beliBarangActionPerformed

    private void beliBarang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliBarang1ActionPerformed
        this.setVisible(false);
        new UserDashboard(name).setVisible(true);
    }//GEN-LAST:event_beliBarang1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton beliBarang;
    private javax.swing.JButton beliBarang1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
