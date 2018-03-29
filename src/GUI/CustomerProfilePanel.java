/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Customer.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Elmar Talibzade
 */
public class CustomerProfilePanel extends javax.swing.JPanel {

    private Customer customer;
    
    /**
     * Creates new form CustomerProfilePanel
     * @param customer Customer whose profile is based on
     */
    public CustomerProfilePanel(Customer customer) {
        this.customer = customer;
        initComponents();
        assignValues();
    }
    
    private void assignValues()
    {
        label_accountNo.setText("" + customer.getAccountNo());
        label_holderName.setText("Holder Name: " + customer.getHolderName());
        label_email.setText("Email: " + customer.getEmailAddress());
        label_phone.setText("Phone Number: " + customer.getPhoneNumber());
        
        label_stat_inDefault.setVisible(customer.isDefault());
        label_stat_suspended.setVisible(customer.isSuspended());
        label_stat_valued.setVisible(customer.isValued());
        
        // set discount type
        DefaultTableModel model = (DefaultTableModel)table_tasks.getModel();
        
        while (model.getRowCount() > 0)
        {
            model.removeRow(0);
        }
        
        for (Job job : customer.getJobs())
        {
            for (Task task : job.getTasks())
            {
                model.addRow(new Object[] {job.getCode(), task.getId(), task.getDepartment(), "NULL", task.getDescription()});
            }
        }
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        label_fullName = new javax.swing.JLabel();
        label_stat_valued = new javax.swing.JLabel();
        label_stat_suspended = new javax.swing.JLabel();
        label_stat_inDefault = new javax.swing.JLabel();
        label_accountNo = new javax.swing.JLabel();
        label_holderName = new javax.swing.JLabel();
        label_email = new javax.swing.JLabel();
        label_phone = new javax.swing.JLabel();
        dropdown_discountType = new javax.swing.JComboBox<>();
        label_discountType = new javax.swing.JLabel();
        label_discountRate = new javax.swing.JLabel();
        field_discountRate = new javax.swing.JTextField();
        btn_print_receipt = new javax.swing.JButton();
        btn_print_reminder = new javax.swing.JButton();
        btn_setPayment = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_createJob = new javax.swing.JButton();
        table_jobs = new javax.swing.JScrollPane();
        table_tasks = new javax.swing.JTable();
        label_jobCode = new javax.swing.JLabel();
        field_jobCode = new javax.swing.JTextField();
        dropdown_department = new javax.swing.JComboBox<>();
        btn_applyFilters = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setPreferredSize(new java.awt.Dimension(706, 398));

        label_fullName.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        label_fullName.setText("{Customer-Full-Name}");

        label_stat_valued.setForeground(new java.awt.Color(0, 153, 204));
        label_stat_valued.setText("Valued");

        label_stat_suspended.setForeground(new java.awt.Color(255, 51, 51));
        label_stat_suspended.setText("Suspended");

        label_stat_inDefault.setText("In Default");

        label_accountNo.setText("{account-number}");

        label_holderName.setText("Holder Name: {holder-name}");

        label_email.setText("Email: {email}");

        label_phone.setText("Phone Number: {phone-number}");

        dropdown_discountType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None (Default)", "Flexible", "Fixed", "Variable" }));

        label_discountType.setText("Discount Type");

        label_discountRate.setText("Discount Rate");

        btn_print_receipt.setText("Print Receipt");
        btn_print_receipt.setMaximumSize(new java.awt.Dimension(115, 32));
        btn_print_receipt.setMinimumSize(new java.awt.Dimension(115, 32));
        btn_print_receipt.setPreferredSize(new java.awt.Dimension(115, 32));

        btn_print_reminder.setText("Print Reminder");

        btn_setPayment.setText("Set Payment");
        btn_setPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_setPaymentActionPerformed(evt);
            }
        });

        btn_save.setText("Save Changes");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_createJob.setText("Create Job");

        table_tasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job Code", "Task ID", "Department", "Time Started", "Special Instructions"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_jobs.setViewportView(table_tasks);

        label_jobCode.setText("Job Code");

        dropdown_department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Any", "Copy Room", "Development", "Finishing", "Packing" }));

        btn_applyFilters.setText("Apply Filters");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_fullName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label_stat_valued)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_stat_suspended)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(label_stat_inDefault)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_holderName)
                                    .addComponent(label_email))
                                .addGap(80, 80, 80)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label_discountRate)
                                        .addGap(18, 18, 18)
                                        .addComponent(field_discountRate, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label_discountType)
                                        .addGap(18, 18, 18)
                                        .addComponent(dropdown_discountType, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(label_phone)
                            .addComponent(label_accountNo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_jobCode)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(field_jobCode, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dropdown_department, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_applyFilters)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_createJob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_print_reminder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_setPayment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_print_receipt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(table_jobs)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_fullName)
                    .addComponent(label_stat_valued)
                    .addComponent(label_stat_suspended)
                    .addComponent(label_stat_inDefault))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_accountNo)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_holderName)
                            .addComponent(dropdown_discountType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_discountType)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_print_receipt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_print_reminder)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_setPayment)
                        .addGap(15, 15, 15)
                        .addComponent(btn_save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_createJob))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(field_discountRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_discountRate)
                            .addComponent(label_email))
                        .addGap(12, 12, 12)
                        .addComponent(label_phone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_jobCode)
                            .addComponent(field_jobCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dropdown_department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_applyFilters))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(table_jobs, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_setPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_setPaymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_setPaymentActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_applyFilters;
    private javax.swing.JButton btn_createJob;
    private javax.swing.JButton btn_print_receipt;
    private javax.swing.JButton btn_print_reminder;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_setPayment;
    private javax.swing.JComboBox<String> dropdown_department;
    private javax.swing.JComboBox<String> dropdown_discountType;
    private javax.swing.JTextField field_discountRate;
    private javax.swing.JTextField field_jobCode;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label_accountNo;
    private javax.swing.JLabel label_discountRate;
    private javax.swing.JLabel label_discountType;
    private javax.swing.JLabel label_email;
    private javax.swing.JLabel label_fullName;
    private javax.swing.JLabel label_holderName;
    private javax.swing.JLabel label_jobCode;
    private javax.swing.JLabel label_phone;
    private javax.swing.JLabel label_stat_inDefault;
    private javax.swing.JLabel label_stat_suspended;
    private javax.swing.JLabel label_stat_valued;
    private javax.swing.JScrollPane table_jobs;
    private javax.swing.JTable table_tasks;
    // End of variables declaration//GEN-END:variables
}