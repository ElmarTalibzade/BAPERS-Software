/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Customer.*;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
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
    public CustomerProfilePanel() {
        initComponents();
    }
    
    public void setCustomer(Customer customer)
    {
        this.customer = customer;
        assignValues();
    }
    
    private void assignValues()
    {
        label_fullName.setText(String.format("%s %s", customer.getFirstName(), customer.getLastName()));
        label_accountNo.setText(String.format("ACC%03d", customer.getAccountNo()));
        label_holderName.setText("Holder Name: " + customer.getHolderName());
        label_email.setText("Email: " + customer.getEmailAddress());
        label_phone.setText("Phone Number: " + customer.getPhoneNumber());
        
        int cardNumber = customer.getLast4Digit();
        String cardLabel = bapers.Bapers.DB.isCardInserted(customer.getAccountNo()) ? "Card ending in " + cardNumber : "Cash";
        label_paymentType.setText("Payment Type: " + cardLabel);
        
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
    
    private void addListener(CreateJobView jobView)
    {
        jobView.btn_create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateJob(jobView.getJob());
                jobView.dispose();
                assignValues();
            }
        });
    }
    
    private void CreateJob(Job newJob)
    {
        customer.getJobs().add(newJob);
        bapers.Bapers.DB.createJob(newJob);
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
        btn_back = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        label_stat_suspended = new javax.swing.JLabel();
        label_stat_inDefault = new javax.swing.JLabel();
        label_stat_valued = new javax.swing.JLabel();
        label_paymentType = new javax.swing.JLabel();

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
        btn_createJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_createJobActionPerformed(evt);
            }
        });

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

        btn_back.setText("Back");
        btn_back.setMaximumSize(new java.awt.Dimension(92, 32));
        btn_back.setMinimumSize(new java.awt.Dimension(92, 32));

        label_stat_suspended.setForeground(new java.awt.Color(255, 51, 51));
        label_stat_suspended.setText("Suspended");

        label_stat_inDefault.setText("In Default");

        label_stat_valued.setBackground(new java.awt.Color(0, 51, 255));
        label_stat_valued.setForeground(new java.awt.Color(0, 153, 204));
        label_stat_valued.setText("Valued");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_stat_valued)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_stat_suspended)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_stat_inDefault)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_stat_valued)
                    .addComponent(label_stat_suspended)
                    .addComponent(label_stat_inDefault))
                .addContainerGap())
        );

        label_paymentType.setText("Payment Type: {payment-type}");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(table_jobs)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_accountNo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_jobCode)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(field_jobCode, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(dropdown_department, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(btn_applyFilters))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_holderName)
                                    .addComponent(label_email)
                                    .addComponent(label_phone))
                                .addGap(57, 57, 57)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_paymentType)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label_discountRate)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(field_discountRate, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label_discountType)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dropdown_discountType, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_save, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_createJob, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_setPayment, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_print_receipt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_print_reminder, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_fullName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_fullName)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_accountNo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_holderName, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_discountType)
                            .addComponent(dropdown_discountType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(label_discountRate)
                                .addComponent(field_discountRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label_email)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_print_receipt, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(btn_print_reminder, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_setPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label_paymentType))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_createJob, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_applyFilters)
                            .addComponent(dropdown_department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(field_jobCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label_jobCode)))
                    .addComponent(label_phone))
                .addGap(8, 8, 8)
                .addComponent(table_jobs, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_setPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_setPaymentActionPerformed
        PaymentSettingsView paymentView = new PaymentSettingsView((JFrame) SwingUtilities.getWindowAncestor(this), true, customer.getAccountNo());
        paymentView.setVisible(true);
    }//GEN-LAST:event_btn_setPaymentActionPerformed

    private void btn_createJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_createJobActionPerformed
        CreateJobView createJobView = new CreateJobView((JFrame) SwingUtilities.getWindowAncestor(this), true, customer.getAccountNo());
        addListener(createJobView);
        createJobView.setVisible(true);
    }//GEN-LAST:event_btn_createJobActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_applyFilters;
    public javax.swing.JButton btn_back;
    private javax.swing.JButton btn_createJob;
    private javax.swing.JButton btn_print_receipt;
    private javax.swing.JButton btn_print_reminder;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_setPayment;
    private javax.swing.JComboBox<String> dropdown_department;
    private javax.swing.JComboBox<String> dropdown_discountType;
    private javax.swing.JTextField field_discountRate;
    private javax.swing.JTextField field_jobCode;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel label_accountNo;
    private javax.swing.JLabel label_discountRate;
    private javax.swing.JLabel label_discountType;
    private javax.swing.JLabel label_email;
    private javax.swing.JLabel label_fullName;
    private javax.swing.JLabel label_holderName;
    private javax.swing.JLabel label_jobCode;
    private javax.swing.JLabel label_paymentType;
    private javax.swing.JLabel label_phone;
    private javax.swing.JLabel label_stat_inDefault;
    private javax.swing.JLabel label_stat_suspended;
    private javax.swing.JLabel label_stat_valued;
    private javax.swing.JScrollPane table_jobs;
    private javax.swing.JTable table_tasks;
    // End of variables declaration//GEN-END:variables
}
