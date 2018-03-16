/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payment;

/**
 * Stores customer's invoice.
 * @author Elmar Talibzade
 */
public class Invoice {
    private int invoiceNo;
    private String letter;
    private boolean sent;

    /**
     * Constructor for Invoice
     * @param letter Letter contents
     */
    public Invoice(String letter) {
        this.letter = letter;
    }
}