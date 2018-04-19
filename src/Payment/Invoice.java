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
     * Checks if the invoice is paid
     * @return true if the invoice is paid | false - otherwise
     */
    public boolean isPaid()
    {
        return datePaid != null;
    }
    
    /**
     * Returns the invoice number
     * @return an integer that represents the invoice's number
     */
    public int getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * Calculate the total amount that needs to be paid
     * @return an integer that represents the total due amount
     */
    public double calculateTotal()
    {
        double discountedTotal = subTotal - (subTotal * (discountRate/100));
        return discountedTotal + (discountedTotal * (vatRate/100));
    }
    
    /**
     * Calculate the subtotal
     * @return an integer that represents the subtotal
     */
    public double getSubTotal() {
        return subTotal;
    }

    /**
     * Gets the discount rate of the invoice
     * @return a float number that represents the discount rate
     */
    public float getDiscountRate() {
        return discountRate;
    }

    /**
     * Gets the VAT rate of the invoice
     * @return a float number that represents the VAT
     */
    public float getVatRate() {
        return vatRate;
    }

    /**
     * Gets the date when the invoice was created
     * @return a date that represents the creation date
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Gets the date when the invoice was paid
     * @return a date that represents when the invoice was paid
     */
    public Date getDatePaid() {
        return datePaid;
    }   
    
    /**
     * Gets the calendar difference between the current time and the date when the invoice was created
     * @param currentTime the current time
     * @param timeUnit It could be MINUTES | DAYS | WEEKS | etc
     * @return a number in TimeUnit that represents the difference
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