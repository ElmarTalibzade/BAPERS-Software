/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Customer.Task;
import Staff.Role;
import Staff.Staff;
import static bapers.Bapers.DB;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Elmar Talibzade
 */
public class StaffBrowserPanel extends javax.swing.JPanel {
    
    private ArrayList<Staff> staff;
    
    /**
     * Creates new form StaffBrowserPanel
     */
    public StaffBrowserPanel() {
        initComponents();
        staff = new ArrayList<Staff>();
        getStaff();
    }

    private void getStaff()
    {
        staff  = DB.getStaff(
                !field_accountNo.getText().trim().isEmpty() ? Integer.parseInt(field_accountNo.getText().trim()) : -1,
                field_firstName.getText(), 
                field_lastName.getText(), 
                dropdown_role.getSelectedIndex() > 0 ? Role.values()[dropdown_role.getSelectedIndex() - 1] : null
        );
        
        updateTable();
    }
    
    private void updateTable()
    {
       DefaultTableModel model = (DefaultTableModel)table_staff.getModel();
       
        while (model.getRowCount() > 0)
        {
            model.removeRow(0);
        }
        
        for (Staff employee : staff)
        {
            model.addRow(new Object[] {
                employee.getAccountNo(),
                employee.getFirstName(),
                employee.getLastName(),
                bapers.Utils.splitCamelCase(employee.getRole().toString())
            });
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

        label_accountNo = new javax.swing.JLabel();
        field_accountNo = new javax.swing.JTextField();
        label_firstName = new javax.swing.JLabel();
        field_firstName = new javax.swing.JTextField();
        label_lastName = new javax.swing.JLabel();
        field_lastName = new javax.swing.JTextField();
        dropdown_role = new javax.swing.JComboBox<>();
        label_role = new javax.swing.JLabel();
        btn_findMember = new javax.swing.JButton();
        scrol_staff = new javax.swing.JScrollPane();
        table_staff = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(706, 398));

        label_accountNo.setText("Account NO");

        field_accountNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_accountNoActionPerformed(evt);
            }
        });

        label_firstName.setText("First Name");

        field_firstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_firstNameActionPerformed(evt);
            }
        });

        label_lastName.setText("Last Name");

        field_lastName.setPreferredSize(new java.awt.Dimension(15, 24));
        field_lastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                field_lastNameActionPerformed(evt);
            }
        });

        dropdown_role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Any", "OfficeManager", "ShiftManager", "Technician", "Receptionist" }));
        dropdown_role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dropdown_roleActionPerformed(evt);
            }
        });

        label_role.setText("Role");

        btn_findMember.setText("Find Member");
        btn_findMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_findMemberActionPerformed(evt);
            }
        });

        table_staff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Account NO", "First Name", "Last Name", "Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrol_staff.setViewportView(table_staff);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(field_accountNo)
                            .addComponent(label_accountNo))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_firstName)
                            .addComponent(field_firstName))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(field_lastName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label_lastName))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dropdown_role, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label_role)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_findMember))
                    .addComponent(scrol_staff))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_accountNo)
                    .addComponent(label_firstName)
                    .addComponent(label_lastName)
                    .addComponent(label_role))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field_firstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_accountNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_lastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dropdown_role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_findMember)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrol_staff)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_findMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_findMemberActionPerformed
        getStaff();
    }//GEN-LAST:event_btn_findMemberActionPerformed

    private void field_accountNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_accountNoActionPerformed
        getStaff();
    }//GEN-LAST:event_field_accountNoActionPerformed

    private void field_firstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_firstNameActionPerformed
        getStaff();
    }//GEN-LAST:event_field_firstNameActionPerformed

    private void field_lastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_field_lastNameActionPerformed
        getStaff();
    }//GEN-LAST:event_field_lastNameActionPerformed

    private void dropdown_roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dropdown_roleActionPerformed
        getStaff();
    }//GEN-LAST:event_dropdown_roleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_findMember;
    private javax.swing.JComboBox<String> dropdown_role;
    private javax.swing.JTextField field_accountNo;
    private javax.swing.JTextField field_firstName;
    private javax.swing.JTextField field_lastName;
    private javax.swing.JLabel label_accountNo;
    private javax.swing.JLabel label_firstName;
    private javax.swing.JLabel label_lastName;
    private javax.swing.JLabel label_role;
    private javax.swing.JScrollPane scrol_staff;
    private javax.swing.JTable table_staff;
    // End of variables declaration//GEN-END:variables
}
