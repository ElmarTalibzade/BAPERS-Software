/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payment;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Stores customer's invoice.
 * @author Elmar Talibzade
 */
public class Invoice {
    
    private int invoiceNo;
    private double subTotal;
    private float discountRate;
    private float vatRate;
    
    private Date dateCreated;
    private Date datePaid;

    /**
     *
     * @param invoiceNo
     * @param subTotal
     * @param discountRate
     * @param vatRate
     * @param dateCreated
     * @param datePaid
     */
    public Invoice(int invoiceNo, double subTotal, float discountRate, float vatRate, Date dateCreated, Date datePaid) {
        this.invoiceNo = invoiceNo;
        this.subTotal = subTotal;
        this.discountRate = discountRate;
        this.vatRate = vatRate;
        this.dateCreated = dateCreated;
        this.datePaid = datePaid;
    }

    /**
     *
     * @return
     */
    public boolean isPaid()
    {
        return datePaid != null;
    }
    
    /**
     *
     * @return
     */
    public int getInvoiceNo() {
        return invoiceNo;
    }

    /**
     *
     * @return
     */
    public double calculateTotal()
    {
        double discountedTotal = subTotal - (subTotal * (discountRate/100));
        return discountedTotal + (discountedTotal * (vatRate/100));
    }
    
    /**
     *
     * @return
     */
    public double getSubTotal() {
        return subTotal;
    }

    /**
     *
     * @return
     */
    public float getDiscountRate() {
        return discountRate;
    }

    /**
     *
     * @return
     */
    public float getVatRate() {
        return vatRate;
    }

    /**
     *
     * @return
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     *
     * @return
     */
    public Date getDatePaid() {
        return datePaid;
    }   
    
    /**
     *
     * @param currentTime
     * @param timeUnit
     * @return
     */
    public long getDateDiff(Timestamp currentTime, TimeUnit timeUnit)
    {
        long diffInMillies = Math.abs(currentTime.getTime() - dateCreated.getTime());
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
    
    /**
     * Mark the current invoice as Paid
     */
    public void markPaid(){
        datePaid = new Timestamp(System.currentTimeMillis());
    }
}