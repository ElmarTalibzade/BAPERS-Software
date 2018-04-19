/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Customer.Customer;
import Customer.Job;
import Payment.Invoice;
import Report.ReportWizard;
import static bapers.Bapers.DB;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import bapers.Bapers;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Elmar Talibzade
 */
public class InvoicePanel extends javax.swing.JPanel {

    private Customer customer;
    private Invoice invoice;
    private ArrayList<Job> jobs;
    
    /**
     * Creates new form InvoicePanel
     */
    public InvoicePanel(Customer customer) {
        this.customer = customer;
        initComponents();
    }

    public void setInvoice(Invoice invoice)
    {
        this.invoice = invoice;
        getJobs();
    }
    
    private void getJobs()
    {
        jobs = DB.getJobsByInvoice(invoice.getInvoiceNo());
        updateGUI();
    }
    
    private void updateGUI()
    {
        label_jobs.setText(String.format("Jobs (%s):", jobs.size()));
        
        label_invoiceNo.setText(String.format("Invoice No: %05d", invoice.getInvoiceNo()));
        label_subTotal.setText("Sub-total: " + new DecimalFormat("£0.00").format(invoice.getSubTotal()));
        label_discountRate.setText("Discount Rate: " + new DecimalFormat("%0.00").format(invoice.getDiscountRate()));
        label_vatRate.setText("VAT: " + new DecimalFormat("%0.00").format(invoice.getVatRate()));
        label_total.setText("Total: " + new DecimalFormat("£0.00").format(invoice.calculateTotal()));
        
        btn_pay.setEnabled(!invoice.isPaid());
        btn_pay.setText(invoice.isPaid() ? "Paid" : "Pay");
        
        updateTable();
    }
    
    private void updateTable() {
        DefaultTableModel model = (DefaultTableModel)table_jobs.getModel();
        
        while (model.getRowCount() > 0)
        {
            model.removeRow(0);
        }
        
        for (Job job : jobs) {
            model.addRow(new Object[]{
                job.getCode(),
                job.getSpecialInstructions(),
                new DecimalFormat("£0.00").format(job.getPrice())
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

        btn_back = new javax.swing.JButton();
        label_invoiceNo = new javax.swing.JLabel();
        pane_jobs = new javax.swing.JScrollPane();
        table_jobs = new javax.swing.JTable();
        label_jobs = new javax.swing.JLabel();
        btn_pay = new javax.swing.JButton();
        btn_printInvoice = new javax.swing.JButton();
        label_subTotal = new javax.swing.JLabel();
        label_discountRate = new javax.swing.JLabel();
        label_vatRate = new javax.swing.JLabel();
        label_total = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(582, 423));

        btn_back.setText("Back");

        label_invoiceNo.setText("Invoice No: {invoice-no}");

        table_jobs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Job Code", "Description", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_jobs.getTableHeader().setReorderingAllowed(false);
        pane_jobs.setViewportView(table_jobs);
        if (table_jobs.getColumnModel().getColumnCount() > 0) {
            table_jobs.getColumnModel().getColumn(0).setResizable(false);
            table_jobs.getColumnModel().getColumn(1).setResizable(false);
            table_jobs.getColumnModel().getColumn(2).setResizable(false);
        }

        label_jobs.setText("Jobs ({jobs-n})");

        btn_pay.setText("Pay");
        btn_pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_payActionPerformed(evt);
            }
        });

        btn_printInvoice.setText("Print Invoice");
        btn_printInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printInvoiceActionPerformed(evt);
            }
        });

        label_subTotal.setText("Sub-total: {sub-total}");

        label_discountRate.setText("Discount Rate: {rate}");

        label_vatRate.setText("VAT: {vat-rate}");

        label_total.setText("Total: {total}");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pane_jobs, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
                    .addComponent(label_subTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_discountRate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_vatRate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_pay, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_invoiceNo)
                            .addComponent(label_jobs))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_printInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label_invoiceNo)
                .addGap(24, 24, 24)
                .addComponent(label_jobs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pane_jobs, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_subTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_discountRate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_vatRate)
                .addGap(18, 18, 18)
                .addComponent(label_total)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_pay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_printInvoice)
                    .addComponent(btn_back))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_printInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printInvoiceActionPerformed
        ReportWizard.OpenPDF(ReportWizard.GenerateCustomerInvoice(invoice.getInvoiceNo()));
    }//GEN-LAST:event_btn_printInvoiceActionPerformed

    private void btn_payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_payActionPerformed
        //long daysLater = invoice.getDateDiff(new Timestamp(System.currentTimeMillis()), TimeUnit.DAYS);
        //System.out.println(daysLater);
        //btn_pay.setEnabled(false); - TO DO
        
        PaymentSettingsView paymentView = new PaymentSettingsView(null, true, customer, invoice);
        paymentView.setVisible(true);
        
        invoice.markPaid();
        DB.markInvoicePaid(invoice.getInvoiceNo());
    }//GEN-LAST:event_btn_payActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_back;
    private javax.swing.JButton btn_pay;
    private javax.swing.JButton btn_printInvoice;
    private javax.swing.JLabel label_discountRate;
    private javax.swing.JLabel label_invoiceNo;
    private javax.swing.JLabel label_jobs;
    private javax.swing.JLabel label_subTotal;
    private javax.swing.JLabel label_total;
    private javax.swing.JLabel label_vatRate;
    private javax.swing.JScrollPane pane_jobs;
    private javax.swing.JTable table_jobs;
    // End of variables declaration//GEN-END:variables
}
