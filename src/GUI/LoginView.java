/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Staff.Staff;
import static bapers.Bapers.DB;
import javax.swing.JOptionPane;

/**
 *
 * @author Elmar Talibzade
 */
public class LoginView extends javax.swing.JFrame {

    private boolean canLogin = false;
    
    /**
     * Creates new form LoginUI
     */
    public LoginView() {
        initComponents();
        canLogin = DB.isConnected();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        field_username = new javax.swing.JTextField();
        label_username = new javax.swing.JLabel();
        label_password = new javax.swing.JLabel();
        btn_login = new javax.swing.JButton();
        label_bapers = new javax.swing.JLabel();
        field_password = new javax.swing.JPasswordField();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setAlwaysOnTop(true);
        setName("Login"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        field_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_usernameActionPerformed(evt);
            }
        });

        label_username.setText("Username");

        label_password.setText("Password");

        btn_login.setText("Login");
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });

        label_bapers.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        label_bapers.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_bapers.setText("B.A.P.E.R.S");

        field_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_passwordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(114, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(label_bapers, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(btn_login)
                    .addComponent(label_password, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(field_username)
                    .addComponent(label_username, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(field_password))
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(label_bapers, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(label_username)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(field_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(label_password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(field_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btn_login)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed
        attemptLogin();
    }//GEN-LAST:event_btn_loginActionPerformed

    private void field_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_passwordActionPerformed
        btn_loginActionPerformed(evt);
    }//GEN-LAST:event_field_passwordActionPerformed

    private void field_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_usernameActionPerformed
        btn_loginActionPerformed(evt);
    }//GEN-LAST:event_field_usernameActionPerformed
    
    /**
     *
     * @param enabled
     */
    public void toggleLogin(boolean enabled) {
        canLogin = enabled;
        btn_login.setEnabled(enabled);
    }
    
    private void attemptLogin() {
        if (!canLogin) return;
        
        String username = field_username.getText();
        String password = String.valueOf(field_password.getPassword());
        Staff user = DB.validateLogin(username, password);
        toggleLogin(false);         // used to avoid duplicate sessions
        
        if(user != null) {
            StaffView staffView = new StaffView(user);
            staffView.setVisible(true);
            this.setVisible(false);
        }
        else {
            JOptionPane.showMessageDialog(this, "Invalid username or password",  "Could not log in", JOptionPane.WARNING_MESSAGE);
            toggleLogin(true);      // allow user to user login functionality if credentials are invalid
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_login;
    private javax.swing.JPasswordField field_password;
    private javax.swing.JTextField field_username;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel label_bapers;
    private javax.swing.JLabel label_password;
    private javax.swing.JLabel label_username;
    // End of variables declaration//GEN-END:variables
}
