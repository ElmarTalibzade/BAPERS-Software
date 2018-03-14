/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

/**
 * Represents a Customer's information.
 * @author Elmar Talibzade
 */
public class Customer {
    private String holderName;
    private String accountNo;
    private String contactName;
    private String address;
    private String phone;
    private String emailAddress;
    
    private float discountRate;
    private Job[] jobs;
    private boolean isSuspended;
    private boolean isDefault;
    private int debtReminded;
    
    /**
     * Constructor for Customer 
     * @param holderName Holder's name
     * @param accountNo Account number
     * @param contactName Customer's full name
     * @param address Customer's physical address
     * @param phone Customer's phone number
     */
    public Customer(String holderName, String accountNo, String contactName, String address, String phone) {
        this.holderName = holderName;
        this.accountNo = accountNo;
        this.contactName = contactName;
        this.address = address;
        this.phone = phone;
    }
    
    /**
     * Returns discount
     * @return discount rate
     */
    public float getDiscount()
    {
        return discountRate;
    }
    
    /**
     * Gets whether this customer is suspended or not
     * @return Returns true if this customer has been suspended
     */
    public boolean isSuspended()
    {
        return isSuspended;
    }

    /**
     * Set customer's isDefault state
     * @param isDefault Set to true, if the customer is in default
     */
    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * Gets jobs associated with this customer
     * @return An array of jobs
     */
    public Job[] getJobs() {
        return jobs;
    }

    /**
     * Gets email address
     * @return String that represents an email address
     */
    public String getEmailAddress() {
        return emailAddress;
    }
    
    /**
     * Generates customer's invoice
     * @return Text that represents an invoice
     */
    public String getInvoice()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Suspends this Customer's account
     */
    public void suspendAccount()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Restores this Customer's account if it's suspended
     */
    public void restoreAccount()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Makes a payment for customer's of specific id
     * @param jobId Id of a job for which customer is paying for
     * @return Returns true if the payment was successful
     */
    public boolean makePyament(String jobId)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}