package view;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import repository.KeuanganRepositoryImpl;
import service.DBConnectionService;
import service.KeuanganServiceImpl;

/**
 *
 * @author Zildjian XTO
 */
public class AdminCekKeuangan extends javax.swing.JFrame {
    private String name;
    KeuanganRepositoryImpl keuanganRepo = new KeuanganRepositoryImpl(); 
    KeuanganServiceImpl KeuanganService = new KeuanganServiceImpl();
    
    /**
     *
     */
    public AdminCekKeuangan(){
        initComponents();
    }
    
    /**
     *
     * @param name
     */
    public AdminCekKeuangan(String name) {
        initComponents();
        this.name = name;
        saldo.setText("Rp. " + keuanganRepo.getSaldo());
        Connection con;
        try {
            con = DBConnectionService.getConnection();
            KeuanganService.ShowKeuanganLogs(con, jTable1);
        } catch (SQLException ex) {
            Logger.getLogger(BeliBarangUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        saldo = new javax.swing.JLabel();
        backBtn1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Financial History Form");
        setFocusable(false);
        setFocusableWindowState(false);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(59, 73, 93));
        jPanel1.setForeground(new java.awt.Color(153, 204, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item's Name", "Quantity", "Date", "Description", "Username"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

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

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Current Balance :");

        saldo.setBackground(new java.awt.Color(255, 255, 255));
        saldo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saldo.setForeground(new java.awt.Color(255, 255, 255));
        saldo.setText("Rp. 500000000");

        backBtn1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        backBtn1.setText("Balance Setting");
        backBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backBtn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backBtn1MouseExited(evt);
            }
        });
        backBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtn1ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Financial History");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backBtn)
                .addGap(468, 468, 468))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1093, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(174, 174, 174)
                                .addComponent(jLabel2)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(saldo)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(backBtn)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        this.setVisible(false);
        new AdminDashboard(name).setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void backBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseEntered
        backBtn.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_backBtnMouseEntered

    private void backBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseExited
        backBtn.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_backBtnMouseExited

    private void backBtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtn1MouseEntered
        backBtn1.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_backBtn1MouseEntered

    private void backBtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtn1MouseExited
        backBtn1.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_backBtn1MouseExited

    private void backBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtn1ActionPerformed
        String input = JOptionPane.showInputDialog(null, "Enter the new balance amount:");

        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Input cannot be empty!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int newBalance = Integer.parseInt(input.trim());

            if (newBalance < 0) {
                JOptionPane.showMessageDialog(null, "Balance cannot be negative!", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }

            keuanganRepo.setSaldo(newBalance);
            saldo.setText("Rp. " + keuanganRepo.getSaldo());
            JOptionPane.showMessageDialog(null, "Balance successfully updated to: " + newBalance, "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Input must be a number!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_backBtn1ActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton backBtn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel saldo;
    // End of variables declaration//GEN-END:variables
}
