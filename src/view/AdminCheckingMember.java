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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        editRoleBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("(Admin)View Member");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(59, 73, 93));

        jTable1.setBackground(new java.awt.Color(245, 245, 245));
        jTable1.setForeground(java.awt.Color.black);
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

        editRoleBtn.setBackground(java.awt.Color.white);
        editRoleBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        editRoleBtn.setForeground(java.awt.Color.black);
        editRoleBtn.setText("Setting Role");
        editRoleBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editRoleBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editRoleBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editRoleBtnMouseExited(evt);
            }
        });
        editRoleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editRoleBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(java.awt.Color.white);
        deleteBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        deleteBtn.setForeground(java.awt.Color.black);
        deleteBtn.setText("Back Admin Menu");
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteBtnMouseExited(evt);
            }
        });
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        backBtn.setBackground(java.awt.Color.white);
        backBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        backBtn.setForeground(java.awt.Color.black);
        backBtn.setText("Delete Akun");
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
                .addComponent(editRoleBtn)
                .addGap(18, 18, 18)
                .addComponent(backBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteBtn)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(editRoleBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void editRoleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editRoleBtnActionPerformed
        updateSelectedUser();
    }//GEN-LAST:event_editRoleBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        this.setVisible(false);
        new AdminDashboard(name).setVisible(true);
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        deleteSelectedUser();
    }//GEN-LAST:event_backBtnActionPerformed

    private void editRoleBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editRoleBtnMouseEntered
        // TODO add your handling code here:
        editRoleBtn.setForeground(new java.awt.Color(25, 143, 216));

    }//GEN-LAST:event_editRoleBtnMouseEntered

    private void editRoleBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editRoleBtnMouseExited
        // TODO add your handling code here:
        editRoleBtn.setForeground(java.awt.Color.black);

    }//GEN-LAST:event_editRoleBtnMouseExited

    private void backBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseEntered
        // TODO add your handling code here:
        backBtn.setForeground(new java.awt.Color(25, 143, 216));

    }//GEN-LAST:event_backBtnMouseEntered

    private void backBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseExited
        // TODO add your handling code here:
        backBtn.setForeground(java.awt.Color.black);

    }//GEN-LAST:event_backBtnMouseExited

    private void deleteBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseEntered
        // TODO add your handling code here:
        deleteBtn.setForeground(new java.awt.Color(25, 143, 216));

    }//GEN-LAST:event_deleteBtnMouseEntered

    private void deleteBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseExited
        // TODO add your handling code here:
        deleteBtn.setForeground(java.awt.Color.black);

    }//GEN-LAST:event_deleteBtnMouseExited

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
    private javax.swing.JButton backBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editRoleBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
