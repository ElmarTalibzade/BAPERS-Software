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
     * The main constructor for Payment objects
     * @param amountPaid a number that represents the total amount of the payment
     * @param method an integer that represents method used for the payment
     * @param date the date when payment was made
     * @param cardDetailsID a number that represents the id of card used for payment
     * @param invoiceID invoice id attached to the payment
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
     * Returns a number that represents the amount paid
     * @return a number that represents the amount paid
     */
    public double getAmountPaid(){
        return amountPaid;
    }
    
    /**
     * Returns the method used
     * @returnn a number that represents the method used for payment
     */
    public int getMethod(){
        return method;
    }
    
    /**
     * Returns the date when payment was made
     * @return a timestamp that represents a date when the payment was made
     */
    public Timestamp getDate(){
        return date;
    }
    
    /**
     * Returns the id of the card used for payment
     * @return a number that represents the card id used for payment
     */
    public int getCardDetailsID(){
        return cardDetailsID;
    }
    
    /**
     * Returns the id of the invoice
     * @return a number that represents the invoiceID attached to payment
     */
    public int getInvoiceID(){
        return invoiceID;
    }
}
