/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payment;

import java.sql.Timestamp;

/**
 * Represents a payment which was done by a customer, the amount and card details used.
 * @author Elmar Talibzade
 */
public class Payment {
    private int recordID;
    private double amountPaid;
    private int method;
    private Timestamp date;
    private int cardDetailsID;
    private int invoiceID;
    
    /**
     *
     * @param amountPaid
     * @param method
     * @param date
     * @param cardDetailsID
     * @param invoiceID
     */
    public Payment(double amountPaid, int method, Timestamp date, int cardDetailsID, int invoiceID){
        this.recordID = recordID;
        this.amountPaid = amountPaid;
        this.method = method;
        this.date = date;
        this.cardDetailsID = cardDetailsID;
        this.invoiceID = invoiceID;
    }
    
    /**
     *
     * @return
     */
    public double getAmountPaid(){
        return amountPaid;
    }
    
    /**
     *
     * @return
     */
    public int getMethod(){
        return method;
    }
    
    /**
     *
     * @return
     */
    public Timestamp getDate(){
        return date;
    }
    
    /**
     *
     * @return
     */
    public int getCardDetailsID(){
        return cardDetailsID;
    }
    
    /**
     *
     * @return
     */
    public int getInvoiceID(){
        return invoiceID;
    }
}
