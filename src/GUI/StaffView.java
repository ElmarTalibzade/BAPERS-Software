/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Staff.*;

/**
 * Base GUI for all main operations. This is where all menu items are shown based on user's role.
 * @author Elmar Talibzade
 */
public class StaffView extends javax.swing.JFrame {

    /**
     * Creates new form StaffUI
     */
    private Staff staff;
    
    /**
     * Initializes a GUI and loads appropriate menu items based on user's role.
     * @param user Object class representing a logged in user.
     */
    public StaffView(Staff user){
        this.staff = user;
        initComponents();
        initMenuItems();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_loggedUser = new javax.swing.JLabel();
        btn_logout = new javax.swing.JButton();
        tabbedContent = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BAPERS");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(720, 480));
        setName("Staff View"); // NOI18N

        label_loggedUser.setText("Logged in as: staff-name (staff-role)");

        btn_logout.setText("Log Out");
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbedContent)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_loggedUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 437, Short.MAX_VALUE)
                        .addComponent(btn_logout)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_logout)
                    .addComponent(label_loggedUser))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabbedContent, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        this.setVisible(false);
        bapers.Bapers.loginView.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btn_logoutActionPerformed
    
    private void initMenuItems() {
        
        label_loggedUser.setText(String.format("Logged in as: %s %s (%s)", staff.getFirstName(), staff.getLastName(), staff.getRole().name()));
        
        switch (staff.getRole())
        {
            case OfficeManager:
                
                tabbedContent.addTab("Receptionists", new ReceptionistBrowserPanel());
                tabbedContent.addTab("Reports", new ReportsManagerPanel());
                tabbedContent.addTab("New Customer", new CreateCustomerPanel());
                tabbedContent.addTab("Customer Browser", new CustomerBrowserPanel());
                tabbedContent.addTab("Job Browser", new JobBrowserPanel());
                tabbedContent.addTab("Staff Browser", new StaffBrowserPanel());
                tabbedContent.addTab("Create Staff", new CreateStaffPanel());
                tabbedContent.addTab("Backups", new BackupsPanel());
                
                break;
            case Receptionist:
                
                tabbedContent.addTab("Customer Browser", new CustomerBrowserPanel());
                tabbedContent.addTab("New Customer", new CreateCustomerPanel());
                tabbedContent.addTab("Job Browser", new JobBrowserPanel());
                
                break;
            case ShiftManager:
                
                tabbedContent.addTab("Receptionists", new ReceptionistBrowserPanel());
                tabbedContent.addTab("Reports", new ReportsManagerPanel());
                tabbedContent.addTab("New Customer", new CreateCustomerPanel());
                tabbedContent.addTab("Customer Browser", new CustomerBrowserPanel());
                tabbedContent.addTab("Job Browser", new JobBrowserPanel());
                
                break;
                
            case Technician:
                
                tabbedContent.addTab("Job Browser", new JobBrowserPanel());
                
                break;
        }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_logout;
    private javax.swing.JLabel label_loggedUser;
    public javax.swing.JTabbedPane tabbedContent;
    // End of variables declaration//GEN-END:variables
}