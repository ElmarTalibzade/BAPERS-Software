/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 *
 * @author Elmar Talibzade
 */
public class BackupsPanel extends javax.swing.JPanel {

    private String saveLocation;
    private String openLocation;
    private String backupLocation;
    
    /**
     * Creates new form BackupsPanel
     */
    public BackupsPanel() {
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

        label_backup = new javax.swing.JLabel();
        field_saveLocation = new javax.swing.JTextField();
        label_saveLocation = new javax.swing.JLabel();
        btn_browse_saveLocation = new javax.swing.JButton();
        btn_backup = new javax.swing.JButton();
        label_restore = new javax.swing.JLabel();
        label_backupLocation = new javax.swing.JLabel();
        field_backupLocation = new javax.swing.JTextField();
        btn_browse_backupLocation = new javax.swing.JButton();
        btn_restore = new javax.swing.JButton();
        label_restore1 = new javax.swing.JLabel();
        label_backupLocation1 = new javax.swing.JLabel();
        field_backupLocation1 = new javax.swing.JTextField();
        btn_browse_backupLocation1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(706, 398));

        label_backup.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label_backup.setText("Backup");

        label_saveLocation.setText("Export Location");

        btn_browse_saveLocation.setText("Browse...");
        btn_browse_saveLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_browse_saveLocationActionPerformed(evt);
            }
        });

        btn_backup.setText("Backup");
        btn_backup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backupActionPerformed(evt);
            }
        });

        label_restore.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label_restore.setText("Restore");

        label_backupLocation.setText("Backup Location");

        btn_browse_backupLocation.setText("Browse...");
        btn_browse_backupLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_browse_backupLocationActionPerformed(evt);
            }
        });

        btn_restore.setText("Restore");
        btn_restore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_restoreActionPerformed(evt);
            }
        });

        label_restore1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label_restore1.setText("Settings");

        label_backupLocation1.setText("Backup Location");

        btn_browse_backupLocation1.setText("Browse...");
        btn_browse_backupLocation1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_browse_backupLocation1ActionPerformed(evt);
            }
        });

        jButton1.setText("Save Changes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Frequency");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hour", "Day", "Week", "Month", "Year" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_saveLocation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(field_saveLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_browse_saveLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_backup, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label_backupLocation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(field_backupLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_browse_backupLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_restore, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_backup)
                            .addComponent(label_restore)
                            .addComponent(label_restore1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_backupLocation1)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(field_backupLocation1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_browse_backupLocation1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_backup)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_saveLocation)
                    .addComponent(field_saveLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_browse_saveLocation)
                    .addComponent(btn_backup))
                .addGap(42, 42, 42)
                .addComponent(label_restore)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_backupLocation)
                    .addComponent(field_backupLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_browse_backupLocation)
                    .addComponent(btn_restore))
                .addGap(42, 42, 42)
                .addComponent(label_restore1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_backupLocation1)
                    .addComponent(field_backupLocation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_browse_backupLocation1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btn_backupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backupActionPerformed
        try {
            String user = "root";
            String password = "";
            String database = "bloomsday";
            String pathToMySQL = "/usr/local/mysql-5.7.21-macos10.13-x86_64/bin/";
            String CMD = "";
            
            if(password.equals(""))
                CMD = pathToMySQL + "mysqldump -u " + user + " --add-drop-database -B " + database + " -r " + saveLocation;
            else
                CMD = pathToMySQL + "mysqldump -u " + user + " -p " + password + "--add-drop-database -B " + database + " -r " + saveLocation;
            System.out.println(CMD);
            
            Runtime.getRuntime().exec(CMD);
            JOptionPane.showMessageDialog(this, "Backup File Created.", "Done", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_backupActionPerformed
 
    private void btn_browse_saveLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_browse_saveLocationActionPerformed
        JFileChooser chooser = new JFileChooser();
        int option = chooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            if(chooser.getSelectedFile() != null)
            {
                saveLocation = chooser.getCurrentDirectory() + "/" + chooser.getSelectedFile().getName() + ".blmbackup";
                field_saveLocation.setText(saveLocation);
            }
        }
    }//GEN-LAST:event_btn_browse_saveLocationActionPerformed

    private void btn_browse_backupLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_browse_backupLocationActionPerformed
        JFileChooser chooser = new JFileChooser();
        int option = chooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            if(chooser.getSelectedFile() != null)
            {
                openLocation = chooser.getCurrentDirectory() + "/" + chooser.getSelectedFile().getName();
                field_backupLocation.setText(openLocation);
            }
        }
    }//GEN-LAST:event_btn_browse_backupLocationActionPerformed

    private void btn_restoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_restoreActionPerformed
        try {
            String user = "root";
            String password = "";
            String database = "bloomsday";
            String pathToMySQL = "/usr/local/mysql-5.7.21-macos10.13-x86_64/bin/";
            
            String arrayCommand[] = new String[]{pathToMySQL + "mysql", database, "-u", user, "-e", " source " + openLocation};
            String arrayCommand2[] = new String[]{pathToMySQL + "mysql", database, "-u", user, "-p" + password, "-e", " source " + openLocation};
            
            Process runtimeProcess;
            if(password.equals(""))
            {
                runtimeProcess = Runtime.getRuntime().exec(arrayCommand);
                System.out.println(Arrays.toString(arrayCommand));
            }
            else
            {
                runtimeProcess = Runtime.getRuntime().exec(arrayCommand2);
                System.out.println(Arrays.toString(arrayCommand2));
            }
            
            int processStatus = runtimeProcess.waitFor();
            if (processStatus == 1)
                System.out.println("failed");
            else if (processStatus == 0)
                System.out.println("success");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_restoreActionPerformed

    private void btn_browse_backupLocation1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_browse_backupLocation1ActionPerformed
        JFileChooser chooser = new JFileChooser();
        int option = chooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            if(chooser.getSelectedFile() != null)
            {
                backupLocation = chooser.getCurrentDirectory() + "/" + chooser.getSelectedFile().getName() + ".blmbackup";
                field_backupLocation1.setText(saveLocation);
            }
        }
    }//GEN-LAST:event_btn_browse_backupLocation1ActionPerformed

    public static boolean isInteger(String str) {
    try {
        Integer.parseInt(str);
        return true;
    } catch (NumberFormatException nfe) {
        return false;
    }
}
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(isInteger(jTextField1.getText())){
            int number = Integer.parseInt(jTextField1.getText());
            int option = jComboBox1.getSelectedIndex();
            if(option == 0)
                option = 3600; // one hour
            else if(option == 1)
                option = 86400; // one day
            else if(option == 2)
                option = 604800; // one week
            else if(option == 3) 
                option = 86400 * 30; // one month
            else if(option == 4)
                option = 86400 * 30 * 365; // one year
            
            
            
            Timer t = new Timer();
            bapers.BackupTask backupTask = new bapers.BackupTask(backupLocation);

            int oneSecond = 1000;

            t.scheduleAtFixedRate(backupTask, 0, oneSecond * option * number);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_backup;
    private javax.swing.JButton btn_browse_backupLocation;
    private javax.swing.JButton btn_browse_backupLocation1;
    private javax.swing.JButton btn_browse_saveLocation;
    private javax.swing.JButton btn_restore;
    private javax.swing.JTextField field_backupLocation;
    private javax.swing.JTextField field_backupLocation1;
    private javax.swing.JTextField field_saveLocation;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel label_backup;
    private javax.swing.JLabel label_backupLocation;
    private javax.swing.JLabel label_backupLocation1;
    private javax.swing.JLabel label_restore;
    private javax.swing.JLabel label_restore1;
    private javax.swing.JLabel label_saveLocation;
    // End of variables declaration//GEN-END:variables
}
