package view;
import repository.AkunRepositoryImpl;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import java.awt.Color;

public class RegisterPage extends javax.swing.JFrame {

    public RegisterPage() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        registerButton = new javax.swing.JButton();
        passwordInput = new javax.swing.JPasswordField();
        confirmPwInput = new javax.swing.JPasswordField();
        passwordLabel = new javax.swing.JLabel();
        passwordLabel1 = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        usernameInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        loginLink1 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        JPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("COMPVENTORY register page");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registerButton.setBackground(new java.awt.Color(255, 255, 255));
        registerButton.setFont(new java.awt.Font("JetBrains Mono NL", 1, 14)); // NOI18N
        registerButton.setForeground(new java.awt.Color(0, 0, 0));
        registerButton.setText("Register");
        registerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, 225, 35));

        passwordInput.setBackground(new java.awt.Color(255, 255, 255));
        passwordInput.setForeground(new java.awt.Color(0, 0, 0));
        passwordInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordInputActionPerformed(evt);
            }
        });
        getContentPane().add(passwordInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 340, 225, 35));

        confirmPwInput.setBackground(new java.awt.Color(255, 255, 255));
        confirmPwInput.setForeground(new java.awt.Color(0, 0, 0));
        confirmPwInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPwInputActionPerformed(evt);
            }
        });
        getContentPane().add(confirmPwInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 280, 225, 35));

        passwordLabel.setBackground(new java.awt.Color(0, 0, 0));
        passwordLabel.setFont(new java.awt.Font("JetBrains Mono NL ExtraBold", 1, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Confirm password :");
        getContentPane().add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 320, 220, 20));

        passwordLabel1.setBackground(new java.awt.Color(0, 0, 0));
        passwordLabel1.setFont(new java.awt.Font("JetBrains Mono NL ExtraBold", 1, 14)); // NOI18N
        passwordLabel1.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel1.setText("Password :");
        getContentPane().add(passwordLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, 220, -1));

        usernameLabel.setBackground(new java.awt.Color(0, 0, 0));
        usernameLabel.setFont(new java.awt.Font("JetBrains Mono NL ExtraBold", 1, 14)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel.setText("Username :");
        getContentPane().add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 200, 220, -1));

        usernameInput.setBackground(new java.awt.Color(255, 255, 255));
        usernameInput.setForeground(new java.awt.Color(0, 0, 0));
        usernameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameInputActionPerformed(evt);
            }
        });
        getContentPane().add(usernameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 225, 35));

        jLabel1.setFont(new java.awt.Font("JetBrains Mono NL", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Already have an account?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 430, 330, -1));

        loginLink1.setBackground(new java.awt.Color(0, 0, 0));
        loginLink1.setFont(new java.awt.Font("JetBrains Mono NL", 1, 12)); // NOI18N
        loginLink1.setForeground(java.awt.Color.cyan);
        loginLink1.setText("Login");
        loginLink1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginLink1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginLink1MouseClicked(evt);
            }
        });
        getContentPane().add(loginLink1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 430, 160, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/background/registerBackground.png"))); // NOI18N
        Background.setText("jLabel1");
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, -1));

        JPanel.setBackground(new java.awt.Color(255, 255, 255));
        JPanel.setMaximumSize(new java.awt.Dimension(1061, 574));
        JPanel.setMinimumSize(new java.awt.Dimension(1061, 574));

        javax.swing.GroupLayout JPanelLayout = new javax.swing.GroupLayout(JPanel);
        JPanel.setLayout(JPanelLayout);
        JPanelLayout.setHorizontalGroup(
            JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1061, Short.MAX_VALUE)
        );
        JPanelLayout.setVerticalGroup(
            JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );

        getContentPane().add(JPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 574));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        String username = usernameInput.getText().trim();
        String password = passwordInput.getText();
        String confirmPassword = confirmPwInput.getText();

        
        if(AkunRepositoryImpl.cekSimbolInput(username)){
            JOptionPane.showMessageDialog(null,
                "Dalam input Username terdapat simbol yang tidak diperbolehkan",
                "Registrasi",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
        if (username.contains(" ")) {
            JOptionPane.showMessageDialog(null,
                "Dalam input Username jangan gunakan spasi!",
                "Registrasi",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (password.contains(" ")) {
            JOptionPane.showMessageDialog(null,
                "Dalam input Password jangan gunakan spasi!",
                "Registrasi",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        boolean hasEmptyField = false;
        StringBuilder errorMessage = new StringBuilder("Field berikut harus diisi:\n");

        if (username.isEmpty()) {
            usernameInput.setBorder(BorderFactory.createLineBorder(Color.RED));
            errorMessage.append("- Username\n");
            hasEmptyField = true;
        } else {
            usernameInput.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }

        if (password.isEmpty()) {
            passwordInput.setBorder(BorderFactory.createLineBorder(Color.RED));
            errorMessage.append("- Password\n");
            hasEmptyField = true;
        } else {
            passwordInput.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }

        if (confirmPassword.isEmpty()) {
            confirmPwInput.setBorder(BorderFactory.createLineBorder(Color.RED));
            errorMessage.append("- Konfirmasi Password\n");
            hasEmptyField = true;
        } else {
            confirmPwInput.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }

        if (hasEmptyField) {
            JOptionPane.showMessageDialog(null,
                errorMessage.toString(),
                "Registrasi",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (!confirmPassword.equals(password)) {
            confirmPwInput.setBorder(BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null,
                "Konfirmasi password tidak sesuai!",
                "Registrasi",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        } else {
            confirmPwInput.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        }

        AkunRepositoryImpl akun = new AkunRepositoryImpl();

        if (akun.isUsernameTaken(username)) {
            usernameInput.setBorder(BorderFactory.createLineBorder(Color.RED));
            JOptionPane.showMessageDialog(null,
                "Username sudah digunakan!",
                "Registrasi",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        boolean sukses = akun.register(username, password, "Admin");

        if (sukses) {
            JOptionPane.showMessageDialog(null,
                "Registrasi berhasil!",
                "Registrasi",
                JOptionPane.INFORMATION_MESSAGE
            );
            new LoginPage("t").setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null,
                "Registrasi gagal!",
                "Registrasi",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_registerButtonActionPerformed

    private void usernameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameInputActionPerformed

    }//GEN-LAST:event_usernameInputActionPerformed

    private void confirmPwInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPwInputActionPerformed

    }//GEN-LAST:event_confirmPwInputActionPerformed

    private void passwordInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordInputActionPerformed

    }//GEN-LAST:event_passwordInputActionPerformed

    private void loginLink1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginLink1MouseClicked

        new LoginPage("t").setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_loginLink1MouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JPanel JPanel;
    private javax.swing.JPasswordField confirmPwInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel loginLink1;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField usernameInput;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
