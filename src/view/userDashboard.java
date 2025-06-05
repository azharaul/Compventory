package view;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import service.DBConnectionService;

public class userDashboard extends javax.swing.JFrame {
    private final String NAME;
    
    public userDashboard(String name) {
        this.NAME = name;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        checkMemberBtn = new javax.swing.JButton();
        historyBtn = new javax.swing.JButton();
        beliBarang = new javax.swing.JButton();
        logoutBTN = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dashboardView = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        sayHi = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("(User)Dashboard Menu");
        setResizable(false);

        menu.setBackground(new java.awt.Color(59, 73, 93));
        menu.setPreferredSize(new java.awt.Dimension(180, 574));

        checkMemberBtn.setBackground(new java.awt.Color(255, 255, 255));
        checkMemberBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        checkMemberBtn.setForeground(new java.awt.Color(0, 0, 0));
        checkMemberBtn.setText("Check Request Status");
        checkMemberBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkMemberBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                checkMemberBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                checkMemberBtnMouseExited(evt);
            }
        });
        checkMemberBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMemberBtnActionPerformed(evt);
            }
        });

        historyBtn.setBackground(new java.awt.Color(255, 255, 255));
        historyBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        historyBtn.setForeground(new java.awt.Color(0, 0, 0));
        historyBtn.setText("Request Barang");
        historyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        beliBarang.setBackground(new java.awt.Color(255, 255, 255));
        beliBarang.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        beliBarang.setForeground(new java.awt.Color(0, 0, 0));
        beliBarang.setText("Beli Barang");
        beliBarang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        beliBarang.setPreferredSize(new java.awt.Dimension(125, 27));
        beliBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                beliBarangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                beliBarangMouseExited(evt);
            }
        });
        beliBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beliBarangActionPerformed(evt);
            }
        });

        logoutBTN.setBackground(java.awt.Color.white);
        logoutBTN.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        logoutBTN.setForeground(java.awt.Color.black);
        logoutBTN.setText("Logout");
        logoutBTN.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutBTNMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutBTNMouseExited(evt);
            }
        });
        logoutBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBTNActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(59, 73, 93));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("JetBrains Mono NL ExtraBold", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("COMPVENTORY");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 210, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/img/icon/54b85941-cad8-4986-9248-efd5fded01e5 (3).png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 0, 60, 50));

        jPanel3.setBackground(new java.awt.Color(59, 73, 93));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(java.awt.Color.black);
        jLabel5.setFont(new java.awt.Font("JetBrains Mono NL ExtraBold", 1, 20)); // NOI18N
        jLabel5.setForeground(java.awt.Color.black);
        jLabel5.setText("Dashboard");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 120, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/img/icon/HOME_ICON.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 10, 60, 30));

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(beliBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(historyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkMemberBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(beliBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(historyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkMemberBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
                .addComponent(logoutBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(menu, java.awt.BorderLayout.LINE_START);

        dashboardView.setBackground(new java.awt.Color(217, 217, 217));
        dashboardView.setPreferredSize(new java.awt.Dimension(840, 574));

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(33, 29, 30));
        jLabel6.setText("welcome back");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 127, -1, -1));

        sayHi.setFont(new java.awt.Font("Serif", 1, 65)); // NOI18N
        sayHi.setForeground(java.awt.Color.black);
        sayHi.setText("Hi, " + NAME);
        jPanel1.add(sayHi, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 520, -1));

        jLabel1.setBackground(new java.awt.Color(217, 217, 217));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/img/icon/banner_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 10, 770, 230));

        javax.swing.GroupLayout dashboardViewLayout = new javax.swing.GroupLayout(dashboardView);
        dashboardView.setLayout(dashboardViewLayout);
        dashboardViewLayout.setHorizontalGroup(
            dashboardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardViewLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        dashboardViewLayout.setVerticalGroup(
            dashboardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardViewLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 327, Short.MAX_VALUE))
        );

        getContentPane().add(dashboardView, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void checkMemberBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkMemberBtnMouseEntered
        checkMemberBtn.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_checkMemberBtnMouseEntered

    private void checkMemberBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkMemberBtnMouseExited
        checkMemberBtn.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_checkMemberBtnMouseExited

    private void checkMemberBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMemberBtnActionPerformed
        new UserCekRequest(NAME).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_checkMemberBtnActionPerformed

    private void historyBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyBtnMouseEntered
        historyBtn.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_historyBtnMouseEntered

    private void historyBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyBtnMouseExited
        historyBtn.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_historyBtnMouseExited

    private void historyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyBtnActionPerformed
        Connection con;
        try {
            con = DBConnectionService.getConnection();
            requestBarang(con);
        } catch (SQLException ex) {
            Logger.getLogger(BeliBarangUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_historyBtnActionPerformed

    private void beliBarangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beliBarangMouseEntered
        beliBarang.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_beliBarangMouseEntered

    private void beliBarangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_beliBarangMouseExited
        beliBarang.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_beliBarangMouseExited

    private void beliBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliBarangActionPerformed
        new BeliBarangUser(NAME).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_beliBarangActionPerformed

    private void logoutBTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBTNMouseEntered
        logoutBTN.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_logoutBTNMouseEntered

    private void logoutBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBTNMouseExited
        logoutBTN.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_logoutBTNMouseExited

    private void logoutBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBTNActionPerformed
        new LoginPage(NAME).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logoutBTNActionPerformed

    private void requestBarang(Connection con) {
        String currentUsername = NAME;

        try {
            String namaBarang = JOptionPane.showInputDialog(this, "Masukkan nama barang:");
            if (namaBarang == null || namaBarang.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama barang tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String jumlahStr = JOptionPane.showInputDialog(this, "Masukkan jumlah:");
            if (jumlahStr == null || jumlahStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Jumlah tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int jumlah;
            try {
                jumlah = Integer.parseInt(jumlahStr);
                if (jumlah <= 0) {
                    JOptionPane.showMessageDialog(this, "Jumlah harus lebih dari 0!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Jumlah harus angka!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String cekBarangSql = "SELECT * FROM barang WHERE nama = ?";
            try (PreparedStatement cekPst = con.prepareStatement(cekBarangSql)) {
                cekPst.setString(1, namaBarang);
                
                try (ResultSet rs = cekPst.executeQuery()) {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(this, "Barang sudah tersedia di stok System.", "Info", JOptionPane.INFORMATION_MESSAGE);
                        rs.close();
                        cekPst.close();
                        return;
                    }
                }
            }
            
            String sql = "INSERT INTO request_barang(username, nama_barang, jumlah) VALUES (?, ?, ?)";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, currentUsername);
                pst.setString(2, namaBarang);
                pst.setInt(3, jumlah);
                
                int inserted = pst.executeUpdate();
                if (inserted > 0) {
                    JOptionPane.showMessageDialog(this, "Request barang berhasil dikirim!");
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal mengirim request barang!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton beliBarang;
    private javax.swing.JButton checkMemberBtn;
    private javax.swing.JPanel dashboardView;
    private javax.swing.JButton historyBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton logoutBTN;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel sayHi;
    // End of variables declaration//GEN-END:variables
}
