/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Customer.Customer;
import Payment.Invoice;
import Payment.Payment;
import static bapers.Bapers.DB;
import java.sql.Timestamp;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Payment Settings Window
 * @author Elmar Talibzade
 */
public class PaymentSettingsView extends javax.swing.JDialog {
    
    private Customer customer;
    private Invoice invoice;
    private int customerNo;
    
    /**
     * Constructor for payment settings
     * @param parent parent window
     * @param modal is modal?
     * @param customer customer associated with payment settings
     * @param invoice invoice which will be paid
     */
    public PaymentSettingsView(JFrame parent, boolean modal, Customer customer, Invoice invoice) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.customer = customer;
        this.invoice = invoice;
        customerNo = customer.getAccountNo();
        updateBody();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_paymentMethod = new javax.swing.JLabel();
        dropbox_paymentMethod = new javax.swing.JComboBox<>();
        label_cardType = new javax.swing.JLabel();
        dropdown_cardType = new javax.swing.JComboBox<>();
        label_cardNumber = new javax.swing.JLabel();
        field_cardNumber = new javax.swing.JTextField();
        label_csv = new javax.swing.JLabel();
        field_csv = new javax.swing.JTextField();
        label_expirationDate = new javax.swing.JLabel();
        field_expirationDate = new javax.swing.JTextField();
        btn_save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Payment Method");
        setResizable(false);

        label_paymentMethod.setText("Payment Method");

        dropbox_paymentMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Card", "Cash" }));
        dropbox_paymentMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropbox_paymentMethodActionPerformed(evt);
            }
        });

        label_cardType.setText("Card Type");

        dropdown_cardType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Visa", "Master Card", "Amex" }));

        label_cardNumber.setText("Card Number");

        label_csv.setText("CSV");

        label_expirationDate.setText("Expiration Date");

        btn_save.setText("Confirm Payment");
        btn_save.setAlignmentX(1.0F);
        btn_save.setAlignmentY(1.0F);
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_paymentMethod)
                                    .addComponent(label_cardType)
                                    .addComponent(label_cardNumber))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(dropbox_paymentMethod, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(dropdown_cardType, 0, 151, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(field_cardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_expirationDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(field_expirationDate)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_csv)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(field_csv, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_save)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_paymentMethod)
                    .addComponent(dropbox_paymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_cardType)
                    .addComponent(dropdown_cardType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_cardNumber)
                    .addComponent(field_cardNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_csv)
                    .addComponent(field_csv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_expirationDate)
                    .addComponent(field_expirationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_save)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateBody()
    {
        boolean hasCard = DB.isCardInserted(customerNo);
 
        dropbox_paymentMethod.setSelectedIndex(hasCard ? 0 : 1);
        
        boolean showCardSettings = dropbox_paymentMethod.getSelectedIndex() == 0;
        
        label_cardType.setEnabled(showCardSettings); 
        label_cardNumber.setEnabled(showCardSettings);
        label_csv.setEnabled(showCardSettings); 
        label_expirationDate.setEnabled(showCardSettings);
        field_cardNumber.setEnabled(showCardSettings); 
        dropdown_cardType.setEnabled(showCardSettings);
        field_csv.setEnabled(showCardSettings); 
        field_expirationDate.setEnabled(showCardSettings);
        
        if(hasCard){
            field_cardNumber.setText("************" + customer.getLast4Digit());
            field_expirationDate.setText("" +   String.format("%02d", customer.getMonthExpiry()) + "/" + 
                                                String.format("%02d", customer.getYearExpiry()));
        }
    }
    
    private void dropbox_paymentMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropbox_paymentMethodActionPerformed
        
        boolean showCardSettings = dropbox_paymentMethod.getSelectedIndex() == 0;
        
        label_cardType.setEnabled(showCardSettings); 
        label_cardNumber.setEnabled(showCardSettings);
        label_csv.setEnabled(showCardSettings); 
        label_expirationDate.setEnabled(showCardSettings);
        field_cardNumber.setEnabled(showCardSettings); 
        dropdown_cardType.setEnabled(showCardSettings);
        field_csv.setEnabled(showCardSettings); 
        field_expirationDate.setEnabled(showCardSettings);
    }//GEN-LAST:event_dropbox_paymentMethodActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if(dropbox_paymentMethod.getSelectedIndex() == 1) { 
            JOptionPane.showMessageDialog(this, "Payment recorded succesfully",  "Customer paid using cash.", JOptionPane.INFORMATION_MESSAGE);
            Payment payment = new Payment(invoice.calculateTotal(), 0, new Timestamp(System.currentTimeMillis()), 0, invoice.getInvoiceNo());
            DB.recordPayment(payment);
            
            if(DB.isCardInserted(customerNo) == true)
                DB.deleteCard(customerNo);
        }
        else if(dropbox_paymentMethod.getSelectedIndex() == 0) {
            if(field_csv.getText() == "") {
                JOptionPane.showMessageDialog(this, "ERROR",  "No CSV was provided.", JOptionPane.WARNING_MESSAGE);
            }
            else {
                int last4Digit = Integer.parseInt(field_cardNumber.getText().substring(12, 16));
                String cardType = dropdown_cardType.getItemAt(dropdown_cardType.getSelectedIndex());

                String expDate = field_expirationDate.getText();
                int monthExpiry = Integer.parseInt(expDate.substring(0, 2));
                int yearExpiry = Integer.parseInt(expDate.substring(3, 5));

                if(DB.isCardInserted(customerNo) == false) {
                    DB.insertCard(customerNo, cardType, last4Digit, monthExpiry, yearExpiry, 0);
                    
                    Payment payment = new Payment(invoice.calculateTotal(), 0, new Timestamp(System.currentTimeMillis()), 0, invoice.getInvoiceNo());
                    DB.recordPayment(payment);
                    
                    JOptionPane.showMessageDialog(this, "Payment recorded succesfully",  "Customer paid using a card.\nThe card will be saved for future transactions.", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    DB.updateCard(customerNo, cardType, last4Digit, monthExpiry, yearExpiry, 0);
                    
                    Payment payment = new Payment(invoice.calculateTotal(), 0, new Timestamp(System.currentTimeMillis()), 0, invoice.getInvoiceNo());
                    DB.recordPayment(payment);
                    JOptionPane.showMessageDialog(this, "Payment recorded succesfully",  "Customer paid using a card.\nThe card will be saved for future transactions.", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox<String> dropbox_paymentMethod;
    private javax.swing.JComboBox<String> dropdown_cardType;
    private javax.swing.JTextField field_cardNumber;
    private javax.swing.JTextField field_csv;
    private javax.swing.JTextField field_expirationDate;
    private javax.swing.JLabel label_cardNumber;
    private javax.swing.JLabel label_cardType;
    private javax.swing.JLabel label_csv;
    private javax.swing.JLabel label_expirationDate;
    private javax.swing.JLabel label_paymentMethod;
    // End of variables declaration//GEN-END:variables
}
