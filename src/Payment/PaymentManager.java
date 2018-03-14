/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Payment;

import Customer.Customer;

/**
 * Manages payments as well as keeps track on late payments.
 * @author Elmar Talibzade
 */
public class PaymentManager {
    private Customer[] lateCustomers;
    
    /**
     * Sends a payment reminder to customer of specified id
     * @param customerId id of a customer to whom reminder would be sent
     */
    public void sendReminder(String customerId)
    {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Suspends a customer
     * @param customerId Id of a customer who will be suspended
     */
    public void suspendCustomer(String customerId)
    {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Alerts a manager regarding the late payment
     */
    public void alertManager()
    {
        throw new UnsupportedOperationException();
    }
}