/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Customer.Customer;
import static bapers.Bapers.DB;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * GUI for looking through the customer fields
 * @author Elmar Talibzade
 */
public class CustomerBrowserPanel extends javax.swing.JPanel {

    private ArrayList<Customer> customers;
    
    private CustomerProfilePanel pane_customerProfile;
    private CardLayout cardLayout;
    
    /**
     * Creates new form CustomerBrowserPanel
     */
    public CustomerBrowserPanel() {
        initComponents();
        initCardLayout();
        getAllCustomers();
        addListener();
    }

    private void initCardLayout()
    {
        pane_customerProfile = new CustomerProfilePanel(this);
        card.setLayout(new CardLayout());
        cardLayout = (CardLayout)card.getLayout();
        card.add(pane_customerProfile, "profile");
        card.add(pane_customerBrowser, "browser");
        cardLayout.show(card, "browser");
    }
    
    private void addListener()
    {
        pane_customerProfile.btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggleProfile(false);
                getAllCustomers();
            }
        });
    }
    
    /**
     * Deletes this customer
     * @param customer
     */
    public void deleteCustomer(Customer customer)
    {
        if (!DB.deleteCustomer(customer.getAccountNo())) return;
        toggleProfile(false);
        getCustomers();
    }
    
    private void toggleProfile(boolean state)
    {
        String cardName = state ? "profile" : "browser";
        cardLayout.show(card, cardName);   
        
        this.validate();
        this.repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        card = new javax.swing.JPanel();
        pane_customerBrowser = new javax.swing.JPanel();
        label_holderName = new javax.swing.JLabel();
        btn_findCustomer = new javax.swing.JButton();
        label_email = new javax.swing.JLabel();
        label_accountNo = new javax.swing.JLabel();
        field_firstName = new javax.swing.JTextField();
        field_phoneNumber = new javax.swing.JTextField();
        scroll_customers = new javax.swing.JScrollPane();
        table_customers = new javax.swing.JTable();
        field_holderName = new javax.swing.JTextField();
        field_email = new javax.swing.JTextField();
        label_firstName = new javax.swing.JLabel();
        field_lastName = new javax.swing.JTextField();
        box_showDefault = new javax.swing.JCheckBox();
        field_accountNo = new javax.swing.JTextField();
        label_lastName = new javax.swing.JLabel();
        label_phoneNumber = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(706, 398));

        label_holderName.setText("Holder Name");

        btn_findCustomer.setText("Find Customer");
        btn_findCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_findCustomerActionPerformed(evt);
            }
        });

        label_email.setText("Email");

        label_accountNo.setText("Account NO");

        field_firstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_firstNameActionPerformed(evt);
            }
        });

        field_phoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_phoneNumberActionPerformed(evt);
            }
        });

        table_customers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Account", "Holder Name", "First Name", "Last Name", "Email", "Phone Number", "In Default"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_customers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_customersMouseClicked(evt);
            }
        });
        scroll_customers.setViewportView(table_customers);

        field_holderName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_holderNameActionPerformed(evt);
            }
        });

        field_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_emailActionPerformed(evt);
            }
        });

        label_firstName.setText("First Name");

        field_lastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_lastNameActionPerformed(evt);
            }
        });

        box_showDefault.setText("Show Default Accounts Only");

        field_accountNo.setMinimumSize(new java.awt.Dimension(96, 24));
        field_accountNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_accountNoActionPerformed(evt);
            }
        });
        field_accountNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                field_accountNoKeyTyped(evt);
            }
        });

        label_lastName.setText("Last Name");

        label_phoneNumber.setText("Phone Number");

        javax.swing.GroupLayout pane_customerBrowserLayout = new javax.swing.GroupLayout(pane_customerBrowser);
        pane_customerBrowser.setLayout(pane_customerBrowserLayout);
        pane_customerBrowserLayout.setHorizontalGroup(
            pane_customerBrowserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_customerBrowserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pane_customerBrowserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll_customers)
                    .addGroup(pane_customerBrowserLayout.createSequentialGroup()
                        .addGroup(pane_customerBrowserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pane_customerBrowserLayout.createSequentialGroup()
                                .addGroup(pane_customerBrowserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(field_phoneNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                    .addComponent(label_accountNo, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(field_accountNo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(35, 35, 35))
                            .addGroup(pane_customerBrowserLayout.createSequentialGroup()
                                .addComponent(label_phoneNumber)
                                .addGap(87, 87, 87)))
                        .addGroup(pane_customerBrowserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pane_customerBrowserLayout.createSequentialGroup()
                                .addGroup(pane_customerBrowserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pane_customerBrowserLayout.createSequentialGroup()
                                        .addGroup(pane_customerBrowserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(label_holderName, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(field_holderName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                                        .addGap(35, 35, 35))
                                    .addGroup(pane_customerBrowserLayout.createSequentialGroup()
                                        .addComponent(field_email)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(pane_customerBrowserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pane_customerBrowserLayout.createSequentialGroup()
                                        .addGroup(pane_customerBrowserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(label_firstName)
                                            .addGroup(pane_customerBrowserLayout.createSequentialGroup()
                                                .addComponent(field_firstName, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                                .addGap(21, 21, 21)))
                                        .addGroup(pane_customerBrowserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(field_lastName, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                                            .addComponent(label_lastName)))
                                    .addGroup(pane_customerBrowserLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(box_showDefault)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_findCustomer))))
                            .addComponent(label_email))))
                .addContainerGap())
        );
        pane_customerBrowserLayout.setVerticalGroup(
            pane_customerBrowserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pane_customerBrowserLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pane_customerBrowserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_accountNo)
                    .addComponent(label_holderName)
                    .addComponent(label_firstName)
                    .addComponent(label_lastName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pane_customerBrowserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_accountNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_holderName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pane_customerBrowserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_phoneNumber)
                    .addComponent(label_email))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pane_customerBrowserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_findCustomer)
                    .addComponent(field_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(box_showDefault, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_customers, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout cardLayout = new javax.swing.GroupLayout(card);
        card.setLayout(cardLayout);
        cardLayout.setHorizontalGroup(
            cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pane_customerBrowser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cardLayout.setVerticalGroup(
            cardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pane_customerBrowser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(card, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(card, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void field_accountNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_field_accountNoKeyTyped
        char enter = evt.getKeyChar();
        if(!(Character.isDigit(enter))){
            evt.consume();
        }
    }//GEN-LAST:event_field_accountNoKeyTyped

    private void btn_findCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_findCustomerActionPerformed
        getCustomers();
    }//GEN-LAST:event_btn_findCustomerActionPerformed

    private void field_holderNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_holderNameActionPerformed
        getCustomers();
    }//GEN-LAST:event_field_holderNameActionPerformed

    private void field_lastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_lastNameActionPerformed
        getCustomers();
    }//GEN-LAST:event_field_lastNameActionPerformed

    private void field_firstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_firstNameActionPerformed
        getCustomers();
    }//GEN-LAST:event_field_firstNameActionPerformed

    private void field_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_emailActionPerformed
        getCustomers();
    }//GEN-LAST:event_field_emailActionPerformed

    private void field_phoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_phoneNumberActionPerformed
        getCustomers();
    }//GEN-LAST:event_field_phoneNumberActionPerformed

    private void field_accountNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_accountNoActionPerformed
        getCustomers();
    }//GEN-LAST:event_field_accountNoActionPerformed

    private void table_customersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_customersMouseClicked
        if (evt.getClickCount() == 2)
        {
            JTable targetTable = (JTable)evt.getSource();
            Customer customer = customers.get(targetTable.getSelectedRow());
            
            pane_customerProfile.setCustomer(customer);
            toggleProfile(true);
        }
    }//GEN-LAST:event_table_customersMouseClicked

    private void getAllCustomers() {
        customers = DB.getCustomers();
        updateTable();
    }

    private void getCustomers() {
        customers = DB.searchCustomers(
                field_accountNo.getText(), 
                field_holderName.getText(), 
                field_firstName.getText(), 
                field_lastName.getText(), 
                field_phoneNumber.getText(), 
                field_email.getText(), 
                box_showDefault.isSelected());
        
        updateTable();
    }
    
    private void updateTable() {
        DefaultTableModel model = (DefaultTableModel)table_customers.getModel();
        
        while (model.getRowCount() > 0)
        {
            model.removeRow(0);
        }
        
        for (Customer customer : customers) {
            model.addRow(new Object[]{
                customer.getAccountNo(), 
                customer.getHolderName(), 
                customer.getFirstName(), 
                customer.getLastName(), 
                customer.getEmailAddress(), 
                customer.getPhoneNumber(),
                customer.isDefault() ? "Yes" : "No"
            });
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox box_showDefault;
    private javax.swing.JButton btn_findCustomer;
    private javax.swing.JPanel card;
    private javax.swing.JTextField field_accountNo;
    private javax.swing.JTextField field_email;
    private javax.swing.JTextField field_firstName;
    private javax.swing.JTextField field_holderName;
    private javax.swing.JTextField field_lastName;
    private javax.swing.JTextField field_phoneNumber;
    private javax.swing.JLabel label_accountNo;
    private javax.swing.JLabel label_email;
    private javax.swing.JLabel label_firstName;
    private javax.swing.JLabel label_holderName;
    private javax.swing.JLabel label_lastName;
    private javax.swing.JLabel label_phoneNumber;
    private javax.swing.JPanel pane_customerBrowser;
    private javax.swing.JScrollPane scroll_customers;
    private javax.swing.JTable table_customers;
    // End of variables declaration//GEN-END:variables
}
