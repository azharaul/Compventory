package view;
public class UserMenu extends javax.swing.JFrame {
    private String name;
    
    public UserMenu(String name) {
        this.name = name;
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        checkMemberBtn = new javax.swing.JButton();
        historyBtn = new javax.swing.JButton();
        logoutBTN = new javax.swing.JButton();
        viewItemBtn = new javax.swing.JButton();
        sayHi = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        checkMemberBtn.setBackground(new java.awt.Color(255, 255, 255));
        checkMemberBtn.setFont(new java.awt.Font("JetBrains Mono NL", 1, 10)); // NOI18N
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
        jPanel3.add(checkMemberBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 160, 30));

        historyBtn.setBackground(new java.awt.Color(255, 255, 255));
        historyBtn.setFont(new java.awt.Font("JetBrains Mono NL", 1, 10)); // NOI18N
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
        jPanel3.add(historyBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 160, 30));

        logoutBTN.setBackground(java.awt.Color.white);
        logoutBTN.setFont(new java.awt.Font("JetBrains Mono NL", 1, 12)); // NOI18N
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
        jPanel3.add(logoutBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 150, 30));

        viewItemBtn.setBackground(new java.awt.Color(255, 255, 255));
        viewItemBtn.setFont(new java.awt.Font("JetBrains Mono NL", 1, 10)); // NOI18N
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
        jPanel3.add(viewItemBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 160, 30));

        sayHi.setFont(new java.awt.Font("Serif", 1, 65)); // NOI18N
        sayHi.setForeground(java.awt.Color.black);
        sayHi.setText("Hi, " + name);
        jPanel3.add(sayHi, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 45, 500, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background/Menu BG.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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
        new AdminCheckingMember(name).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_checkMemberBtnActionPerformed

    private void historyBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyBtnMouseEntered
        historyBtn.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_historyBtnMouseEntered

    private void historyBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyBtnMouseExited
        historyBtn.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_historyBtnMouseExited

    private void historyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyBtnActionPerformed
        new LihatRiwayatBarangAdmin(name).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_historyBtnActionPerformed

    private void logoutBTNMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBTNMouseEntered
        logoutBTN.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_logoutBTNMouseEntered

    private void logoutBTNMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBTNMouseExited
        logoutBTN.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_logoutBTNMouseExited

    private void logoutBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBTNActionPerformed
        new LoginPage(name).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_logoutBTNActionPerformed

    private void viewItemBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewItemBtnMouseEntered
        viewItemBtn.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_viewItemBtnMouseEntered

    private void viewItemBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewItemBtnMouseExited
        viewItemBtn.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_viewItemBtnMouseExited

    private void viewItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewItemBtnActionPerformed
        new LihatBarangAdmin(name).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_viewItemBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkMemberBtn;
    private javax.swing.JButton historyBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton logoutBTN;
    private javax.swing.JLabel sayHi;
    private javax.swing.JButton viewItemBtn;
    // End of variables declaration//GEN-END:variables
}
