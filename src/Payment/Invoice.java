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

    public Invoice(int invoiceNo, double subTotal, float discountRate, float vatRate, Date dateCreated, Date datePaid) {
        this.invoiceNo = invoiceNo;
        this.subTotal = subTotal;
        this.discountRate = discountRate;
        this.vatRate = vatRate;
        this.dateCreated = dateCreated;
        this.datePaid = datePaid;
    }

    public int getInvoiceNo() {
        return invoiceNo;
    }

    public double calculateTotal()
    {
        double discountedTotal = subTotal - (subTotal * (discountRate/100));
        return discountedTotal + (discountedTotal * (vatRate/100));
    }
    
    public double getSubTotal() {
        return subTotal;
    }

    public float getDiscountRate() {
        return discountRate;
    }

    public float getVatRate() {
        return vatRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getDatePaid() {
        return datePaid;
    }   
    
    public long getDateDiff(Timestamp currentTime, TimeUnit timeUnit)
    {
        long diffInMillies = Math.abs(currentTime.getTime() - dateCreated.getTime());
        return timeUnit.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
    
    public void markPaid(){
        datePaid = new Timestamp(System.currentTimeMillis());
    }
}