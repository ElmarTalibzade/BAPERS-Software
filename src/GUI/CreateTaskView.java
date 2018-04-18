/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Customer.*;
import javax.swing.JFrame;

/**
 *
 * @author Elmar Talibzade
 */
public class CreateTaskView extends javax.swing.JDialog {

    private String jobCode;
    private int taskId;
    private Task task;      // used when editing tasks
    
    /**
     * Creates new form CreateTaskWindow
     * @param parent
     * @param modal
     * @param jobCode
     * @param taskId
     */
    public CreateTaskView(JFrame parent, boolean modal, String jobCode, int taskId) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.jobCode = jobCode;
        this.taskId = taskId;
        btn_delete.setVisible(false);
    }
    
    /**
     * Creates new form CreateTaskWindow and assigns existing task data to fields.
     * @param parent
     * @param modal
     * @param task
     */
    public CreateTaskView(JFrame parent, boolean modal, Task task)
    {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
        this.task = task;
        this.taskId = task.getId();
        this.jobCode = task.getJobCode();
        
        field_price.setText("" + task.getPrice());
        field_description.setText(task.getDescription());
        dropdown_department.setSelectedIndex(task.getDepartment().ordinal());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_price = new javax.swing.JLabel();
        field_price = new javax.swing.JTextField();
        label_department = new javax.swing.JLabel();
        dropdown_department = new javax.swing.JComboBox<>();
        label_description = new javax.swing.JLabel();
        scroll_description = new javax.swing.JScrollPane();
        field_description = new javax.swing.JTextArea();
        btn_save = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create Task");
        setAlwaysOnTop(true);
        setName("Create Task"); // NOI18N
        setResizable(false);

        label_price.setText("Price");

        label_department.setText("Department");

        dropdown_department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Copy Room", "Development", "Finishing", "Packing" }));

        label_description.setText("Description");

        field_description.setColumns(20);
        field_description.setRows(5);
        scroll_description.setViewportView(field_description);

        btn_save.setText("Save");

        btn_delete.setText("Delete");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scroll_description)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_price)
                        .addGap(55, 55, 55)
                        .addComponent(field_price))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_department)
                        .addGap(18, 18, 18)
                        .addComponent(dropdown_department, 0, 184, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_description)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_save)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_price)
                    .addComponent(field_price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dropdown_department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_department))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_description)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll_description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_save)
                    .addComponent(btn_delete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @return
     */
    public int getId()
    {
        return task.getId();
    }
    
    /**
     *
     * @return
     */
    public Task getTask()
    {
        return new Task(
            jobCode,
            taskId,
            -1,
            Status.Inactive, 
            Double.parseDouble(field_price.getText()),
            field_description.getText(),
            "shelfNo",
            DepartmentType.values()[dropdown_department.getSelectedIndex()], 0.0f, null, null);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_delete;
    public javax.swing.JButton btn_save;
    private javax.swing.JComboBox<String> dropdown_department;
    private javax.swing.JTextArea field_description;
    private javax.swing.JTextField field_price;
    private javax.swing.JLabel label_department;
    private javax.swing.JLabel label_description;
    private javax.swing.JLabel label_price;
    private javax.swing.JScrollPane scroll_description;
    // End of variables declaration//GEN-END:variables
}