package view;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import service.AudioService;
import service.DBConnectionService;

/**
 *
 * @author Zildjian XTO
 */
public class userDashboard extends javax.swing.JFrame {
    private final String NAME;
    
    /**
     *
     * @param name
     */
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
        checkMemberBtn1 = new javax.swing.JButton();
        dashboardView = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        sayHi = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard User");
        setResizable(false);

        menu.setBackground(new java.awt.Color(59, 73, 93));
        menu.setPreferredSize(new java.awt.Dimension(180, 574));

        checkMemberBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        checkMemberBtn.setText("Check Request Status");
        checkMemberBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkMemberBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMemberBtnActionPerformed(evt);
            }
        });

        historyBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        historyBtn.setText("Request item");
        historyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        historyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyBtnActionPerformed(evt);
            }
        });

        beliBarang.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        beliBarang.setText("Purchase item");
        beliBarang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        beliBarang.setPreferredSize(new java.awt.Dimension(125, 27));
        beliBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beliBarangActionPerformed(evt);
            }
        });

        logoutBTN.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/img/icon/Comvpentory_Icon.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-5, 0, 60, 50));

        jPanel3.setBackground(new java.awt.Color(59, 73, 93));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setBackground(java.awt.Color.black);
        jLabel5.setFont(new java.awt.Font("JetBrains Mono NL ExtraBold", 1, 20)); // NOI18N
        jLabel5.setText("Dashboard");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 120, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/img/icon/HOME_ICON.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 10, 60, 30));

        checkMemberBtn1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        checkMemberBtn1.setText("Sound Off / On");
        checkMemberBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        checkMemberBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMemberBtn1ActionPerformed(evt);
            }
        });

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
                    .addComponent(logoutBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkMemberBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 271, Short.MAX_VALUE)
                .addComponent(checkMemberBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
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
        sayHi.setText("Hi, " + NAME);
        jPanel1.add(sayHi, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 520, -1));

        jLabel1.setBackground(new java.awt.Color(217, 217, 217));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/img/icon/banner_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 770, 230));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Deskripsi Program :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Program ini dibuat menggunakan Java NetBeans untuk membantu pengelolaan stok barang pada toko elektronik. ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Aplikasi ini dirancang agar admin dan user dapat memantau barang dengan efisien. Fitur utama meliputi:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("1. Menampilkan daftar barang elektronik yang tersedia.");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("2. Menambah atau mengurangi stok (restock) serta melihat riwayat barang.");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("3. Melakukan pembelian dan permintaan barang baru.");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("4. Menyediakan laporan keuangan keluar dan masuk.");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("5. Menyediakan efek suara/audio khusus untuk user dan admin.");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("6. Mengatur hak akses (role) antara user dan admin.");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Credit :");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("- Dosen Pengampu : Herika Hayurani, S.Kom., M.Kom.");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("- Azhar Aulia Priatna – Back End");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("- Aditnya Wijaya Putra – Frontend  ");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("- Zild Jian X To – Full Stack Developer");

        javax.swing.GroupLayout dashboardViewLayout = new javax.swing.GroupLayout(dashboardView);
        dashboardView.setLayout(dashboardViewLayout);
        dashboardViewLayout.setHorizontalGroup(
            dashboardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardViewLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(dashboardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel16)
                    .addComponent(jLabel9)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dashboardViewLayout.setVerticalGroup(
            dashboardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardViewLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel18)
                .addGap(14, 14, 14))
        );

        getContentPane().add(dashboardView, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void checkMemberBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMemberBtnActionPerformed
        new UserCekRequest(NAME).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_checkMemberBtnActionPerformed

    private void historyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyBtnActionPerformed
        Connection con;
        try {
            con = DBConnectionService.getConnection();
            requestBarang(con);
        } catch (SQLException ex) {
            Logger.getLogger(BeliBarangUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_historyBtnActionPerformed

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
        AudioService.stop();
    }//GEN-LAST:event_logoutBTNActionPerformed

    private void checkMemberBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMemberBtn1ActionPerformed
        AudioService.toggleMusic("User");
    }//GEN-LAST:event_checkMemberBtn1ActionPerformed

    private void requestBarang(Connection con) {
        String currentUsername = NAME;

        try {
            String namaBarang = JOptionPane.showInputDialog(this, "Input item name:");
            if (namaBarang == null) {
                return;
            }
            namaBarang = namaBarang.trim();
            if (namaBarang.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Item name can't be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String jumlahStr = JOptionPane.showInputDialog(this, "Enter the amount:");
            if (jumlahStr == null) {
                return;
            }
            jumlahStr = jumlahStr.trim();
            if (jumlahStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Amount can't be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int jumlah;
            try {
                jumlah = Integer.parseInt(jumlahStr);
                if (jumlah <= 0) {
                    JOptionPane.showMessageDialog(this, "Amount must be more than 0!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Amount must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String cekBarangSql = "SELECT * FROM barang WHERE nama = ?";
            try (PreparedStatement cekPst = con.prepareStatement(cekBarangSql)) {
                cekPst.setString(1, namaBarang);

                try (ResultSet rs = cekPst.executeQuery()) {
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(this, "This item already exists in the system stock.", "Info", JOptionPane.INFORMATION_MESSAGE);
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
                    JOptionPane.showMessageDialog(this, "Item request successfully sent!");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to sent item request!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton beliBarang;
    private javax.swing.JButton checkMemberBtn;
    private javax.swing.JButton checkMemberBtn1;
    private javax.swing.JPanel dashboardView;
    private javax.swing.JButton historyBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton logoutBTN;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel sayHi;
    // End of variables declaration//GEN-END:variables
}
