/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Customer.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * GUI for creating a new job as well as adding new tasks to it
 * @author Elmar Talibzade
 */
public class CreateJobView extends javax.swing.JDialog {

    private ArrayList<Task> tasks;
    private int customerNo;
    
    /**
     * Creates new form CreateJobView
     * @param parent parent window
     * @param modal is modal?
     * @param customerNo account number of a customer with whom a new job will be associated with
     */
    public CreateJobView(JFrame parent, boolean modal, int customerNo) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
        tasks = new ArrayList<Task>();
        this.customerNo = customerNo;
        label_accountNo.setText("Customer No: " + String.format("ACC%04d", customerNo));
    }
    
    /**
     * Creates a Job object based on supplied info
     * @return Job object
     */
    public Job getJob()
    {        
        return new Job(1, 
                field_jobCode.getText(), 
                bapers.Bapers.getUser().getAccountNo(), 
                tasks, 
                0.0f, 
                customerNo, 
                field_instructions.getText(),
                field_shelf.getText(),
                0,
                new java.sql.Timestamp(new java.util.Date().getTime())
            );
    }
    
    private void listener_addCreateTask(CreateTaskView taskView)
    {
        taskView.btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTask(taskView.getTask());
                taskView.dispose();
            }
        });
    }
    
    private void listener_editTask(CreateTaskView taskView)
    {
        taskView.btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeTask(taskView.getId());
                taskView.dispose();
            }
        });
        
        taskView.btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTask(taskView.getId(), taskView.getTask());
                taskView.dispose();
            }
        });
    }
    
    private void updateTask(int index, Task task)
    {
        tasks.set(index, task);
        updateTable();
    }
    
    private void addTask(Task newTask)
    {
        tasks.add(newTask);
        updateTable();
    }
    
    private void removeTask(int index)
    {
        tasks.remove(index);
        updateTable();
    }
    
    private void updateTable()
    {
        DefaultTableModel model = (DefaultTableModel)table_tasks.getModel();
        
        while (model.getRowCount() > 0)
        {
            model.removeRow(0);
        }
        
        for (Task task : tasks)
        {
            model.addRow(new Object[] {task.getId(), bapers.Utils.splitCamelCase(task.getDepartment().toString()), task.getPrice(), task.getDescription()});
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
        label_jobCode = new javax.swing.JLabel();
        field_jobCode = new javax.swing.JTextField();
        label_instructions = new javax.swing.JLabel();
        pane_instructions = new javax.swing.JScrollPane();
        field_instructions = new javax.swing.JTextArea();
        label_tasks = new javax.swing.JLabel();
        pane_tasks = new javax.swing.JScrollPane();
        table_tasks = new javax.swing.JTable();
        btn_addTask = new javax.swing.JButton();
        btn_create = new javax.swing.JButton();
        label_accountNo1 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        label_shelf = new javax.swing.JLabel();
        field_shelf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create Job");
        setResizable(false);

        label_accountNo.setText("Customer No: {acc-no}");

        label_jobCode.setText("Job Code");

        label_instructions.setText("Special Instructions");

        field_instructions.setColumns(20);
        field_instructions.setRows(5);
        pane_instructions.setViewportView(field_instructions);

        label_tasks.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label_tasks.setText("Tasks");

        table_tasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Department", "Price", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_tasks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_tasksMouseClicked(evt);
            }
        });
        pane_tasks.setViewportView(table_tasks);
        if (table_tasks.getColumnModel().getColumnCount() > 0) {
            table_tasks.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        btn_addTask.setText("Add New");
        btn_addTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addTaskActionPerformed(evt);
            }
        });

        btn_create.setText("Create Job");

        label_accountNo1.setText("Est. collection time");

        jSpinner1.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR));

        label_shelf.setText("Shelf");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pane_tasks, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(label_tasks)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_addTask))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pane_instructions))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_create))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_accountNo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_jobCode))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_instructions)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_accountNo1)
                                .addGap(12, 12, 12)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label_shelf)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(field_jobCode)
                            .addComponent(field_shelf, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_accountNo)
                    .addComponent(label_jobCode)
                    .addComponent(field_jobCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(label_accountNo1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_shelf)
                        .addComponent(field_shelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_instructions)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pane_instructions, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_tasks)
                    .addComponent(btn_addTask))
                .addGap(6, 6, 6)
                .addComponent(pane_tasks, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_create)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addTaskActionPerformed
        createTask();
    }//GEN-LAST:event_btn_addTaskActionPerformed

    private void table_tasksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_tasksMouseClicked
        if (evt.getClickCount() == 2)
        {
            JTable targetTable = (JTable)evt.getSource();
            Task task = tasks.get(targetTable.getSelectedRow());
            editTask(task.getId());
        }
    }//GEN-LAST:event_table_tasksMouseClicked

    private void editTask(int id)
    {
        CreateTaskView taskView = new CreateTaskView((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, getParent()), true, tasks.get(id));
        listener_editTask(taskView);
        taskView.setVisible(true);
    }
    
    private void createTask()
    {
        CreateTaskView taskView = new CreateTaskView((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, getParent()), true, field_jobCode.getText(), tasks.size());
        listener_addCreateTask(taskView);
        taskView.setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addTask;
    public javax.swing.JButton btn_create;
    private javax.swing.JTextArea field_instructions;
    private javax.swing.JTextField field_jobCode;
    private javax.swing.JTextField field_shelf;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JLabel label_accountNo;
    private javax.swing.JLabel label_accountNo1;
    private javax.swing.JLabel label_instructions;
    private javax.swing.JLabel label_jobCode;
    private javax.swing.JLabel label_shelf;
    private javax.swing.JLabel label_tasks;
    private javax.swing.JScrollPane pane_instructions;
    private javax.swing.JScrollPane pane_tasks;
    private javax.swing.JTable table_tasks;
    // End of variables declaration//GEN-END:variables
}
