package view;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.SQLException;
import service.DBConnectionService;

public class AdminCheckingMember extends javax.swing.JFrame {

    private String name;
    
    public AdminCheckingMember(String name) {
        initComponents();
        try (Connection conn = DBConnectionService.getConnection()) {
            showTableListMember(conn);
            this.name = name;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Kesalahan saat Mengambil Data user: " + ex.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Username", "Role", "Waktu Registerasi"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Setting Role");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Back Admin Menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete Akun");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 683, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        updateSelectedUser();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        new AdminDashboard(name).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        deleteSelectedUser();
    }//GEN-LAST:event_jButton3ActionPerformed

    public void showTableListMember(Connection conn) {
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][] {},
            new String[]{"Username", "Role", "Register Date"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
        tb.setRowCount(0);

        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.setRowSelectionAllowed(true);
        jTable1.setColumnSelectionAllowed(false);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        String sql = "SELECT username, role, Tanggal_Register FROM akun";

        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String username = rs.getString("username");
                String role = rs.getString("role");
                java.sql.Timestamp registerDate = rs.getTimestamp("Tanggal_Register");
                tb.addRow(new Object[]{username, role, registerDate});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengambil data member: " + e.getMessage());
        }
    }

    private void updateSelectedUser() {
        int selectedRow = jTable1.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris / akun yang ingin diupdate.");
            return;
        }

        String currentUsername = jTable1.getValueAt(selectedRow, 0).toString();
        String currentRole = jTable1.getValueAt(selectedRow, 1).toString();    

        
        if (currentUsername.equalsIgnoreCase(name)) {
            JOptionPane.showMessageDialog(this, "Anda tidak bisa mengedit akun Anda sendiri.");
            return;
        }
        
        String newUsername = JOptionPane.showInputDialog(this, "Ubah Username:", currentUsername);
        if (newUsername == null || newUsername.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username tidak boleh kosong.");
            return;
        }

        String[] roles = {"user", "admin"};
        String newRole = (String) JOptionPane.showInputDialog(
                this,
                "Ubah Role:",
                "Pilih Role",
                JOptionPane.QUESTION_MESSAGE,
                null,
                roles,
                currentRole
        );

        if (newRole == null) return;

        try (Connection conn = DBConnectionService.getConnection();
             PreparedStatement stmt = conn.prepareStatement(
                     "UPDATE akun SET username = ?, role = ? WHERE username = ?")) {

            stmt.setString(1, newUsername);
            stmt.setString(2, newRole);
            stmt.setString(3, currentUsername);

            int affected = stmt.executeUpdate();

            if (affected > 0) {
                JOptionPane.showMessageDialog(this, "User berhasil diperbarui.");
                showTableListMember(conn); 
            } else {
                JOptionPane.showMessageDialog(this, "Gagal memperbarui user.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Kesalahan saat mengupdate user: " + ex.getMessage());
        }
    }

    private void deleteSelectedUser() {
        int selectedRow = jTable1.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih baris / akun yang ingin dihapus.");
            return;
        }

        String selectedUsername = jTable1.getValueAt(selectedRow, 0).toString(); // Kolom 0 = Username

        if (selectedUsername.equalsIgnoreCase(name)) {
            JOptionPane.showMessageDialog(this, "Anda tidak bisa menghapus akun Anda sendiri.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "Apakah Anda yakin ingin menghapus akun \"" + selectedUsername + "\"?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) return;

        try (Connection conn = DBConnectionService.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM akun WHERE username = ?")) {

            stmt.setString(1, selectedUsername);

            int affected = stmt.executeUpdate();

            if (affected > 0) {
                JOptionPane.showMessageDialog(this, "Akun berhasil dihapus.");
                showTableListMember(conn);
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus akun.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Kesalahan saat menghapus akun: " + ex.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
