/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payment;

/**
 * Stores Customer's card details.
 * @author Elmar Talibzade
 */
public class CardDetails {
    
    private CardType cardType;
    
    private int lastDigits;
    
    /**
     * Type of card
     */
    public enum CardType
    {

        /**
         * Debit Card
         */
        Debit,

        /**
         * Credit Card
         */
        Credit
    }

    /**
     * Constructor for CardDetails
     * @param cardType type of card
     */
    public CardDetails(CardType cardType) {
        this.cardType = cardType;
    }
}