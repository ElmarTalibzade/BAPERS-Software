/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Customer.*;
import static bapers.Bapers.DB;
import javax.swing.JFrame;

/**
 *
 * @author Elmar Talibzade
 */
public class AccountSettingsView extends javax.swing.JDialog {
    
    private Customer customer;
    private CustomerProfilePanel customerPanel;
    
    public AccountSettingsView(JFrame parent, boolean modal, CustomerProfilePanel customerPanel, Customer customer) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.customerPanel = customerPanel;
        this.customer = customer;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_valuedCustomer = new javax.swing.JButton();
        btn_suspendCustomer = new javax.swing.JButton();
        btn_inDefault = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Account properties");
        setResizable(false);

        btn_valuedCustomer.setText("Valued customer");
        btn_valuedCustomer.setAlignmentX(1.0F);
        btn_valuedCustomer.setAlignmentY(1.0F);
        btn_valuedCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_valuedCustomerActionPerformed(evt);
            }
        });

        btn_suspendCustomer.setText("Suspend account");
        btn_suspendCustomer.setAlignmentX(1.0F);
        btn_suspendCustomer.setAlignmentY(1.0F);
        btn_suspendCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suspendCustomerActionPerformed(evt);
            }
        });

        btn_inDefault.setText("In default account");
        btn_inDefault.setAlignmentX(1.0F);
        btn_inDefault.setAlignmentY(1.0F);
        btn_inDefault.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inDefaultActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_inDefault, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_suspendCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_valuedCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_valuedCustomer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_suspendCustomer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_inDefault))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_valuedCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_valuedCustomerActionPerformed
        customer.setValued(true);
        customer.setIsDefault(false);
        customer.setIsSuspended(false);
        customerPanel.setCustomer(customer);
        
        DB.updateCusotmerAccountType(customer.getAccountNo(), true, false, false);
        this.dispose();
    }//GEN-LAST:event_btn_valuedCustomerActionPerformed

    private void btn_suspendCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suspendCustomerActionPerformed
        customer.setValued(false);
        customer.setIsDefault(false);
        customer.setIsSuspended(true);
        customerPanel.setCustomer(customer);
        
        DB.updateCusotmerAccountType(customer.getAccountNo(), false, false, true);
        this.dispose();
    }//GEN-LAST:event_btn_suspendCustomerActionPerformed

    private void btn_inDefaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inDefaultActionPerformed
        customer.setValued(false);
        customer.setIsDefault(true);
        customer.setIsSuspended(false);
        customerPanel.setCustomer(customer);
        
        DB.updateCusotmerAccountType(customer.getAccountNo(), false, true, false);
        this.dispose();
    }//GEN-LAST:event_btn_inDefaultActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_inDefault;
    private javax.swing.JButton btn_suspendCustomer;
    private javax.swing.JButton btn_valuedCustomer;
    // End of variables declaration//GEN-END:variables
}
