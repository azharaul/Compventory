package view;
import repository.AkunRepositoryImpl;
import service.AudioService;

public class AdminDashboard extends javax.swing.JFrame {
    private String name;
    AkunRepositoryImpl akun = new AkunRepositoryImpl();
    
    public AdminDashboard(){
        initComponents();
    }
    
    public AdminDashboard(String name) {
        this.name = name;
        String role = akun.getRole(name);
        initComponents();
   
        AudioService audio = new AudioService();  // new AudioAdmin(); 
        audio.play(role);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dashboardView = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        sayHi = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        laporanKeuangan = new javax.swing.JPanel();
        checkMemberBtn = new javax.swing.JButton();
        historyBtn = new javax.swing.JButton();
        logoutBTN = new javax.swing.JButton();
        viewItemBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cekRequest = new javax.swing.JButton();
        cekRequest1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("(Admin)Dashboard Menu");
        setResizable(false);
        setSize(new java.awt.Dimension(1020, 574));

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
        sayHi.setText("Hi, " + name);
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

        laporanKeuangan.setBackground(new java.awt.Color(59, 73, 93));
        laporanKeuangan.setPreferredSize(new java.awt.Dimension(180, 574));

        checkMemberBtn.setBackground(new java.awt.Color(255, 255, 255));
        checkMemberBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        checkMemberBtn.setForeground(new java.awt.Color(0, 0, 0));
        checkMemberBtn.setText("Checking Member");
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
        historyBtn.setText("Cek Riwayat Barang");
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

        viewItemBtn.setBackground(new java.awt.Color(255, 255, 255));
        viewItemBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        viewItemBtn.setForeground(new java.awt.Color(0, 0, 0));
        viewItemBtn.setText("Lihat Barang");
        viewItemBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        viewItemBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewItemBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewItemBtnMouseExited(evt);
            }
        });
        viewItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewItemBtnActionPerformed(evt);
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

        cekRequest.setBackground(new java.awt.Color(255, 255, 255));
        cekRequest.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        cekRequest.setForeground(new java.awt.Color(0, 0, 0));
        cekRequest.setText("Check Request User");
        cekRequest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cekRequest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cekRequestMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cekRequestMouseExited(evt);
            }
        });
        cekRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekRequestActionPerformed(evt);
            }
        });

        cekRequest1.setBackground(new java.awt.Color(255, 255, 255));
        cekRequest1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        cekRequest1.setForeground(new java.awt.Color(0, 0, 0));
        cekRequest1.setText("Laporan Keuangan");
        cekRequest1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cekRequest1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cekRequest1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cekRequest1MouseExited(evt);
            }
        });
        cekRequest1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekRequest1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout laporanKeuanganLayout = new javax.swing.GroupLayout(laporanKeuangan);
        laporanKeuangan.setLayout(laporanKeuanganLayout);
        laporanKeuanganLayout.setHorizontalGroup(
            laporanKeuanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(laporanKeuanganLayout.createSequentialGroup()
                .addGroup(laporanKeuanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(laporanKeuanganLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(laporanKeuanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cekRequest1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(checkMemberBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutBTN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(historyBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(viewItemBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cekRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        laporanKeuanganLayout.setVerticalGroup(
            laporanKeuanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, laporanKeuanganLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(historyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkMemberBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cekRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cekRequest1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, Short.MAX_VALUE)
                .addComponent(logoutBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(laporanKeuangan, java.awt.BorderLayout.LINE_START);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void viewItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewItemBtnActionPerformed
        new LihatBarangAdmin(name).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_viewItemBtnActionPerformed

    private void viewItemBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewItemBtnMouseExited
        viewItemBtn.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_viewItemBtnMouseExited

    private void viewItemBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewItemBtnMouseEntered
        viewItemBtn.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_viewItemBtnMouseEntered

    private void logoutBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBTNActionPerformed
        new LoginPage(name).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logoutBTNActionPerformed

    private void logoutBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBTNMouseExited
        logoutBTN.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_logoutBTNMouseExited

    private void logoutBTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBTNMouseEntered
        logoutBTN.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_logoutBTNMouseEntered

    private void historyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyBtnActionPerformed
        new LihatRiwayatBarangAdmin(name).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_historyBtnActionPerformed

    private void historyBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyBtnMouseExited
        historyBtn.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_historyBtnMouseExited

    private void historyBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyBtnMouseEntered
        historyBtn.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_historyBtnMouseEntered

    private void checkMemberBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMemberBtnActionPerformed
        new AdminCheckingMember(name).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_checkMemberBtnActionPerformed

    private void checkMemberBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkMemberBtnMouseExited
        checkMemberBtn.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_checkMemberBtnMouseExited

    private void checkMemberBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkMemberBtnMouseEntered
        checkMemberBtn.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_checkMemberBtnMouseEntered

    private void cekRequestMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cekRequestMouseEntered
        cekRequest.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_cekRequestMouseEntered

    private void cekRequestMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cekRequestMouseExited
        cekRequest.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_cekRequestMouseExited

    private void cekRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekRequestActionPerformed
        new AdminCekRequest(name).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cekRequestActionPerformed

    private void cekRequest1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cekRequest1MouseEntered
        cekRequest1.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_cekRequest1MouseEntered

    private void cekRequest1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cekRequest1MouseExited
        cekRequest1.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_cekRequest1MouseExited

    private void cekRequest1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekRequest1ActionPerformed
        this.setVisible(false);
        new AdminCekKeuangan(name).setVisible(true);
    }//GEN-LAST:event_cekRequest1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cekRequest;
    private javax.swing.JButton cekRequest1;
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
    private javax.swing.JPanel laporanKeuangan;
    private javax.swing.JButton logoutBTN;
    private javax.swing.JLabel sayHi;
    private javax.swing.JButton viewItemBtn;
    // End of variables declaration//GEN-END:variables
}
