/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Customer.*;
import Staff.Role;
import bapers.Bapers;
import static bapers.Bapers.DB;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

/**
 * Task Profile
 * @author Elmar Talibzade
 */
public class TaskProfilePanel extends javax.swing.JPanel {

    private Task task;
    
    /**
     * Creates new form TaskProfilePanel
     */
    public TaskProfilePanel() {
        initComponents();
    }

    /**
     * Makes this panel display info of a new task
     * @param task Tasks whose info will be displayed
     */
    public void setTask(Task task)
    {
        this.task = task;
        updateGUI();
    }
    
    private void updateGUI()
    {
        label_jobCode.setText("Job Code: " + task.getJobCode());
        label_taskId.setText("Task ID: " + task.getId());
        label_taskPrice.setText("Price: £" +  new DecimalFormat("0.00").format(task.getPrice()));
        field_description.setText(task.getDescription());
        dropdown_department.setSelectedIndex(task.getDepartment().ordinal());
        label_status.setText("Status: " + bapers.Utils.splitCamelCase(task.getStatus().toString()));
        
        label_endTime.setText("Time Ended: Never");
        label_startTime.setText("Time Started: Never");
        btn_setTaskStatus.setText("Start Task");
        
        btn_delete.setEnabled(Bapers.getUser().getRole() == Role.Technician && task.getStatus() != Status.InProgress);
        btn_setTaskStatus.setVisible(Bapers.getUser().getRole() == Role.Technician && task.getStatus() != Status.Completed);
        dropdown_department.setEnabled(Bapers.getUser().getRole() == Role.Technician&& task.getStatus() == Status.Inactive);
        field_description.setEnabled(Bapers.getUser().getRole() == Role.Technician && task.getStatus() == Status.Inactive);
        btn_applyChanges.setVisible(Bapers.getUser().getRole() == Role.Technician && task.getStatus() == Status.Inactive);
        btn_resetFields.setVisible(Bapers.getUser().getRole() == Role.Technician && task.getStatus() == Status.Inactive);
        
        if (task.getStatus() != Status.Inactive)
        {
            if (task.getStartTime() != null)
                label_startTime.setText(String.format("Time Started: %s", new SimpleDateFormat("dd/MM/yyyy HH:mm").format(task.getStartTime())));
        }
        
        if (task.getStatus() == Status.Completed)
        {
            if (task.getEndTime() != null)
                label_endTime.setText(String.format("Time Ended: %s", new SimpleDateFormat("dd/MM/yyyy HH:mm").format(task.getEndTime())));
        }
        
        if (task.getStatus() == Status.InProgress)
        {
            btn_setTaskStatus.setEnabled(task.getAssigneeId() == Bapers.getUser().getAccountNo());
            
            if (task.getAssigneeId() == Bapers.getUser().getAccountNo())
            {
                btn_setTaskStatus.setText("Finish Task");
            }
            else
            {
                btn_setTaskStatus.setText("Already Assigned");
            }
        }
    }
    
    private void submitChanges() {
        task.setDescription(field_description.getText());
        task.setDepartment(DepartmentType.values()[dropdown_department.getSelectedIndex()]);
        DB.updateTask(task);
        updateGUI();
    }
    
    private void beginTask()
    {
        if (Bapers.getUser().getRole() != Role.Technician) return;
        task.beginTask(Bapers.getUser().getAccountNo());
        submitChanges();
        updateGUI();
    }
    
    private void endTask()
    {
        if (Bapers.getUser().getRole() != Role.Technician) return;
        task.endTask();
        submitChanges();
        updateGUI();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_jobCode = new javax.swing.JLabel();
        label_startTime = new javax.swing.JLabel();
        label_endTime = new javax.swing.JLabel();
        label_taskId = new javax.swing.JLabel();
        label_description = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        field_description = new javax.swing.JTextArea();
        label_status = new javax.swing.JLabel();
        label_department = new javax.swing.JLabel();
        dropdown_department = new javax.swing.JComboBox<>();
        label_taskPrice = new javax.swing.JLabel();
        btn_applyChanges = new javax.swing.JButton();
        btn_resetFields = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_setTaskStatus = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(706, 398));

        label_jobCode.setText("Job Code: {job-code}");

        label_startTime.setText("Time Started: {start-time}");

        label_endTime.setText("Time Ended: {end-time}");

        label_taskId.setText("Task ID: {task-id}");

        label_description.setText("Description");

        field_description.setColumns(20);
        field_description.setRows(5);
        jScrollPane1.setViewportView(field_description);

        label_status.setText("Status : {task-status}");

        label_department.setText("Department:");

        dropdown_department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Copy Room", "Development", "Finishing", "Packing" }));

        label_taskPrice.setText("Price: {task-price}");

        btn_applyChanges.setText("Apply Changes");
        btn_applyChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_applyChangesActionPerformed(evt);
            }
        });

        btn_resetFields.setText("Reset Fields");
        btn_resetFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetFieldsActionPerformed(evt);
            }
        });

        btn_back.setText("Back");

        btn_delete.setText("Delete");

        btn_setTaskStatus.setText("Begin Task");
        btn_setTaskStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_setTaskStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_resetFields, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_description)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_jobCode)
                                    .addComponent(label_status))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_taskId)
                                    .addComponent(label_taskPrice))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_endTime)
                                    .addComponent(label_startTime)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_department)
                                .addGap(18, 18, 18)
                                .addComponent(dropdown_department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 105, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_setTaskStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_applyChanges, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_applyChanges, btn_back, btn_resetFields});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_jobCode)
                    .addComponent(label_taskId)
                    .addComponent(label_startTime))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_taskPrice)
                    .addComponent(label_endTime)
                    .addComponent(label_status))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_department)
                    .addComponent(dropdown_department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(label_description)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_applyChanges)
                    .addComponent(btn_setTaskStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btn_resetFields)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_back)
                    .addComponent(btn_delete))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_resetFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetFieldsActionPerformed
        updateGUI();
    }//GEN-LAST:event_btn_resetFieldsActionPerformed

    private void btn_applyChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_applyChangesActionPerformed
        submitChanges();
    }//GEN-LAST:event_btn_applyChangesActionPerformed

    private void btn_setTaskStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_setTaskStatusActionPerformed
        if (task.getStatus() == Status.Inactive)
        {
            beginTask();
        }
        else if (task.getStatus() == Status.InProgress)
        {
            endTask();
        }
    }//GEN-LAST:event_btn_setTaskStatusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_applyChanges;
    public javax.swing.JButton btn_back;
    public javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_resetFields;
    private javax.swing.JButton btn_setTaskStatus;
    private javax.swing.JComboBox<String> dropdown_department;
    private javax.swing.JTextArea field_description;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_department;
    private javax.swing.JLabel label_description;
    private javax.swing.JLabel label_endTime;
    private javax.swing.JLabel label_jobCode;
    private javax.swing.JLabel label_startTime;
    private javax.swing.JLabel label_status;
    private javax.swing.JLabel label_taskId;
    private javax.swing.JLabel label_taskPrice;
    // End of variables declaration//GEN-END:variables

}
