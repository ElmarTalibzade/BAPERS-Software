/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Administrator.DBConnectivity;
import Customer.Customer;
import Customer.DiscountType;
import static bapers.Bapers.DB;

/**
 *
 * @author Elmar Talibzade
 */
public class CreateCustomerPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateCustomerPanel
     */
    public CreateCustomerPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_holderName = new javax.swing.JLabel();
        field_holderName = new javax.swing.JTextField();
        field_firstName = new javax.swing.JTextField();
        field_lastName = new javax.swing.JTextField();
        label_firstName = new javax.swing.JLabel();
        label_lastName = new javax.swing.JLabel();
        label_email = new javax.swing.JLabel();
        field_email = new javax.swing.JTextField();
        field_phone = new javax.swing.JTextField();
        label_phone = new javax.swing.JLabel();
        field_address = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        label_address = new javax.swing.JLabel();
        btn_createCustomer = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(706, 398));

        label_holderName.setText("Holder Name");

        label_firstName.setText("First Name");

        label_lastName.setText("Last Name");

        label_email.setText("Email");

        label_phone.setText("Phone Number");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        field_address.setViewportView(jTextArea1);

        label_address.setText("Address");

        btn_createCustomer.setText("Create Customer");
        btn_createCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_holderName)
                            .addComponent(label_firstName)
                            .addComponent(label_lastName))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(field_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_address))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(field_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_phone))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(field_holderName, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_email)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(field_phone, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(field_address, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                            .addComponent(field_email)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_createCustomer)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_holderName)
                    .addComponent(field_holderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_email))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_firstName)
                    .addComponent(field_phone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_phone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(field_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_lastName)
                        .addComponent(label_address))
                    .addComponent(field_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211, Short.MAX_VALUE)
                .addComponent(btn_createCustomer)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_createCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createCustomerActionPerformed
        int accNo = 1;
        String holderName = field_holderName.getText();
        String firstName = field_firstName.getText();
        String lastName = field_lastName.getText();
        String email = field_email.getText();
        String phoneNumber = field_phone.getText();
        String address = jTextArea1.getText();
        
        DB = new DBConnectivity();
        if (DB.connect()) {
            Customer newCustomer = new Customer(accNo, holderName, firstName, lastName, false, false, false, address, phoneNumber, DiscountType.values()[0], email, 0, DB.getJobs(accNo));
            System.out.println(DB.createCustomer(newCustomer));
        }
    }//GEN-LAST:event_btn_createCustomerActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_createCustomer;
    private javax.swing.JScrollPane field_address;
    private javax.swing.JTextField field_email;
    private javax.swing.JTextField field_firstName;
    private javax.swing.JTextField field_holderName;
    private javax.swing.JTextField field_lastName;
    private javax.swing.JTextField field_phone;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel label_address;
    private javax.swing.JLabel label_email;
    private javax.swing.JLabel label_firstName;
    private javax.swing.JLabel label_holderName;
    private javax.swing.JLabel label_lastName;
    private javax.swing.JLabel label_phone;
    // End of variables declaration//GEN-END:variables
}
