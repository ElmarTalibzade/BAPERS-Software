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
public class ReportsManagerPanel extends javax.swing.JPanel {

    /**
     * Creates new form ReportsManagerPanel
     */
    public ReportsManagerPanel() {
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

        label_generateReport = new javax.swing.JLabel();
        label_reportType = new javax.swing.JLabel();
        dropdown_reportType = new javax.swing.JComboBox<>();
        label_accountNO = new javax.swing.JLabel();
        field_accountNO = new javax.swing.JTextField();
        btn_generateReport = new javax.swing.JButton();
        label_dateStart = new javax.swing.JLabel();
        datePicker_dateStart = new org.jdesktop.swingx.JXDatePicker();
        datePicker_dateEnd = new org.jdesktop.swingx.JXDatePicker();
        label_dateEnd = new javax.swing.JLabel();
        label_reportSettings = new javax.swing.JLabel();
        label_frequency = new javax.swing.JLabel();
        dropdown_timing = new javax.swing.JComboBox<>();
        field_timing = new javax.swing.JTextField();
        label_frequencyTiming = new javax.swing.JLabel();
        btn_saveSettings = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(706, 398));

        label_generateReport.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label_generateReport.setText("Generate Report");

        label_reportType.setText("Type");

        dropdown_reportType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Customer Report", "Individual Performance Report", "Summary Performance Report" }));

        label_accountNO.setText("Customer Account NO");

        btn_generateReport.setText("Generate");

        label_dateStart.setText("Start");

        label_dateEnd.setText("End");

        label_reportSettings.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label_reportSettings.setText("Report Settings");

        label_frequency.setText("Frequency");

        dropdown_timing.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Minute", "Hour", "Day", "Week", "Month", "Year" }));

        label_frequencyTiming.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        label_frequencyTiming.setText("Report is generated every {time} {frequency}.");

        btn_saveSettings.setText("Save Changes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_accountNO)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(field_accountNO))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label_reportType)
                                .addGap(43, 43, 43)
                                .addComponent(dropdown_reportType, 0, 231, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_generateReport))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(label_dateStart)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datePicker_dateStart, javax.swing.GroupLayout.PREFERRED_SIZE, 106, Short.MAX_VALUE)
                                .addGap(70, 70, 70)
                                .addComponent(label_dateEnd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(datePicker_dateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 106, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_generateReport)
                            .addComponent(label_reportSettings)
                            .addComponent(label_frequency)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dropdown_timing, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(field_timing, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(label_frequencyTiming))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_saveSettings)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_generateReport)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_reportType)
                    .addComponent(dropdown_reportType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_dateStart)
                    .addComponent(datePicker_dateStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_dateEnd)
                    .addComponent(datePicker_dateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_accountNO)
                    .addComponent(field_accountNO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_generateReport))
                .addGap(53, 53, 53)
                .addComponent(label_reportSettings)
                .addGap(18, 18, 18)
                .addComponent(label_frequency)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dropdown_timing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(field_timing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(label_frequencyTiming)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btn_saveSettings)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_generateReport;
    private javax.swing.JButton btn_saveSettings;
    private org.jdesktop.swingx.JXDatePicker datePicker_dateEnd;
    private org.jdesktop.swingx.JXDatePicker datePicker_dateStart;
    private javax.swing.JComboBox<String> dropdown_reportType;
    private javax.swing.JComboBox<String> dropdown_timing;
    private javax.swing.JTextField field_accountNO;
    private javax.swing.JTextField field_timing;
    private javax.swing.JLabel label_accountNO;
    private javax.swing.JLabel label_dateEnd;
    private javax.swing.JLabel label_dateStart;
    private javax.swing.JLabel label_frequency;
    private javax.swing.JLabel label_frequencyTiming;
    private javax.swing.JLabel label_generateReport;
    private javax.swing.JLabel label_reportSettings;
    private javax.swing.JLabel label_reportType;
    // End of variables declaration//GEN-END:variables
}