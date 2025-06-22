package view;
import repository.AkunRepositoryImpl;
import service.AudioService;

/**
 *
 * @author Zildjian XTO
 */
public class AdminDashboard extends javax.swing.JFrame {
    private String name;

    /**
     *
     */
    public AkunRepositoryImpl akun = new AkunRepositoryImpl();
    
    /**
     *
     */
    public AdminDashboard(){
        initComponents();
    }
    
    /**
     *
     * @param name
     */
    public AdminDashboard(String name) {
        this.name = name;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dashboardView = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        sayHi = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
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
        cekRequest2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard Admin");
        setResizable(false);
        setSize(new java.awt.Dimension(1020, 574));

        dashboardView.setBackground(new java.awt.Color(217, 217, 217));
        dashboardView.setMaximumSize(new java.awt.Dimension(0, 0));

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(33, 29, 30));
        jLabel6.setText("welcome back");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 127, -1, -1));

        sayHi.setFont(new java.awt.Font("Serif", 1, 65)); // NOI18N
        sayHi.setText("Hi, " + name);
        jPanel1.add(sayHi, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 520, -1));

        jLabel1.setBackground(new java.awt.Color(217, 217, 217));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/img/icon/banner_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 770, 220));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Credit :");

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

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Deskripsi Program :");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("- Dosen Pengampu : Herika Hayurani, S.Kom., M.Kom.");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("- Zild Jian X To – Full Stack Developer");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("- Azhar Aulia Priatna – Back End");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("- Aditnya Wijaya Putra – Frontend  ");

        javax.swing.GroupLayout dashboardViewLayout = new javax.swing.GroupLayout(dashboardView);
        dashboardView.setLayout(dashboardViewLayout);
        dashboardViewLayout.setHorizontalGroup(
            dashboardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardViewLayout.createSequentialGroup()
                .addGap(20, 20, 20)
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dashboardViewLayout.setVerticalGroup(
            dashboardViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardViewLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGap(16, 16, 16))
        );

        getContentPane().add(dashboardView, java.awt.BorderLayout.CENTER);

        laporanKeuangan.setBackground(new java.awt.Color(59, 73, 93));
        laporanKeuangan.setPreferredSize(new java.awt.Dimension(180, 574));

        checkMemberBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        checkMemberBtn.setText("Setting Member");
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

        historyBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        historyBtn.setText("Check item History");
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

        viewItemBtn.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        viewItemBtn.setText("View Items");
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

        cekRequest.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        cekRequest.setText("Check Request By User");
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

        cekRequest1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        cekRequest1.setText("Financial Report");
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

        cekRequest2.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        cekRequest2.setText("Sound On / Off");
        cekRequest2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cekRequest2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cekRequest2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cekRequest2MouseExited(evt);
            }
        });
        cekRequest2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekRequest2ActionPerformed(evt);
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
                .addGroup(laporanKeuanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(viewItemBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(historyBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(checkMemberBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cekRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cekRequest1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cekRequest2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutBTN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        laporanKeuanganLayout.setVerticalGroup(
            laporanKeuanganLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, laporanKeuanganLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewItemBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(historyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkMemberBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cekRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cekRequest1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cekRequest2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logoutBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        AudioService.stop();
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

    private void cekRequest2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cekRequest2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_cekRequest2MouseEntered

    private void cekRequest2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cekRequest2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_cekRequest2MouseExited

    private void cekRequest2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekRequest2ActionPerformed
        AudioService.toggleMusic("Admin");
    }//GEN-LAST:event_cekRequest2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cekRequest;
    private javax.swing.JButton cekRequest1;
    private javax.swing.JButton cekRequest2;
    private javax.swing.JButton checkMemberBtn;
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
    private javax.swing.JPanel laporanKeuangan;
    private javax.swing.JButton logoutBTN;
    private javax.swing.JLabel sayHi;
    private javax.swing.JButton viewItemBtn;
    // End of variables declaration//GEN-END:variables
}
