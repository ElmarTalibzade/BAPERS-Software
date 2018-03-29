/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Elmar Talibzade
 */
public class PaymentSettingsWindow extends javax.swing.JFrame {

    /**
     * Creates new form PaymentSettingsWindow
     */
    public PaymentSettingsWindow() {
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        label_paymentMethod.setText("Payment Method");

        dropbox_paymentMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cash", "Card" }));
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

        btn_save.setText("Save");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
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
                .addGap(32, 32, 32)
                .addComponent(label_csv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(field_csv, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_save)
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

    private void dropbox_paymentMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropbox_paymentMethodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dropbox_paymentMethodActionPerformed

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
