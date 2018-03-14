/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

/**
 * Used to browse jobs.
 * @author Elmar Talibzade
 */
public class JobBrowser {
    private Customer customer;

    /**
     * Returns a customer to whom this browser is associated with
     * @return
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Changes customer to browse different jobs
     * @param customer new Customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}