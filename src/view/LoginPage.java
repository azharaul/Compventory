package view;
import repository.AkunRepositoryImpl;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.BorderFactory;
import service.AudioService;

/**
 *
 * @author Zildjian XTO
 */
public class LoginPage extends javax.swing.JFrame {

    /**
     *
     */
    public String name;
   
    /**
     *
     */
    public LoginPage(){
        initComponents();
    }

    /**
     *
     * @param name
     */
    public LoginPage(String name) {
        this.name = name;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        passwordInput = new javax.swing.JPasswordField();
        passwordLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        usernameInput = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        registerLink = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Background = new javax.swing.JLabel();
        JPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login Page");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(passwordInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, 225, 35));

        passwordLabel.setBackground(new java.awt.Color(0, 0, 0));
        passwordLabel.setFont(new java.awt.Font("JetBrains Mono NL ExtraBold", 1, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("Password :");
        getContentPane().add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 280, 220, -1));

        usernameLabel.setBackground(new java.awt.Color(0, 0, 0));
        usernameLabel.setFont(new java.awt.Font("JetBrains Mono NL ExtraBold", 1, 14)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel.setText("Username :");
        getContentPane().add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 220, -1));

        usernameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameInputActionPerformed(evt);
            }
        });
        getContentPane().add(usernameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, 225, 35));

        loginButton.setFont(new java.awt.Font("JetBrains Mono NL", 1, 14)); // NOI18N
        loginButton.setText("Login");
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginButtonMouseExited(evt);
            }
        });
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 350, 225, 35));

        registerLink.setBackground(new java.awt.Color(0, 0, 0));
        registerLink.setFont(new java.awt.Font("JetBrains Mono NL", 1, 12)); // NOI18N
        registerLink.setForeground(java.awt.Color.white);
        registerLink.setText("Register");
        registerLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registerLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerLinkMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerLinkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerLinkMouseExited(evt);
            }
        });
        getContentPane().add(registerLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 390, 130, -1));

        jLabel1.setFont(new java.awt.Font("JetBrains Mono NL", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Don't have an account?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, 220, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/img/background/loginBackground.png"))); // NOI18N
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

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String username = usernameInput.getText().trim();
        String password = passwordInput.getText().trim();

        if (username.length() < 4) {
            JOptionPane.showMessageDialog(null,
                "Username must be at least 4 characters long.",
                "Username Input",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (password.length() < 8) {
            JOptionPane.showMessageDialog(null,
                "Password must be at least 8 characters long.",
                "Password Input",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (AkunRepositoryImpl.cekSimbolInput(username)) {
            JOptionPane.showMessageDialog(null,
                "Username contains invalid characters.",
                "Login",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (username.contains(" ")) {
            JOptionPane.showMessageDialog(null,
                "Username cannot contain spaces.",
                "Login",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        if (password.contains(" ")) {
            JOptionPane.showMessageDialog(null,
                "Password cannot contain spaces.",
                "Login",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        boolean hasEmptyField = false;
        StringBuilder errorMessage = new StringBuilder("The following fields must be filled:\n");

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

        if (hasEmptyField) {
            JOptionPane.showMessageDialog(null,
                errorMessage.toString(),
                "Login",
                JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        AkunRepositoryImpl akun = new AkunRepositoryImpl();

        if (akun.login(username, password)) {
            String role = akun.getRole(username);

            if (role.equalsIgnoreCase("admin")) {
                new AdminDashboard(username).setVisible(true);
                AudioService.play("Admin"); // gunakan versi static
            } else {
                new userDashboard(username).setVisible(true);
                AudioService.play("User");
            }
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null,
                "Login failed! Invalid username or password.",
                "Login",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void registerLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerLinkMouseClicked
        new RegisterPage().setVisible(true);
        this.setVisible(false);     
    }//GEN-LAST:event_registerLinkMouseClicked

    private void registerLinkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerLinkMouseEntered
        registerLink.setForeground(Color.cyan);
    }//GEN-LAST:event_registerLinkMouseEntered

    private void registerLinkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerLinkMouseExited
        registerLink.setForeground(Color.white);
    }//GEN-LAST:event_registerLinkMouseExited

    private void loginButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseEntered
        loginButton.setForeground(new java.awt.Color(25, 143, 216));
    }//GEN-LAST:event_loginButtonMouseEntered

    private void loginButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseExited
        loginButton.setForeground(java.awt.Color.black);
    }//GEN-LAST:event_loginButtonMouseExited

    private void usernameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameInputActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JPanel JPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel registerLink;
    private javax.swing.JTextField usernameInput;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
