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
    private int accountNo;
    private String holderName;
    private String firstName;
    private String lastName;
    private boolean isValued;
    private boolean isSuspended;
    private boolean isDefault;
    private String address;
    private String phoneNumber;
    private DiscountType agreedDiscount;
    private String emailAddress;
    private int debtReminded;
    
    private Job[] jobs;
    
    /**
     * Constructor for Customer 
     * @param holderName Account holder name
     * @param accountNo Account number
     * @param firstName Customer's first name
     * @param lastName Customer's last name
     * @param address Customer's physical address
     * @param phone Customer's phone number
     */
    public Customer(String holderName, int accountNo, String firstName, String lastName, String address, String phone) {
        this.holderName = holderName;
        this.accountNo = accountNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phone;
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
     * Gets the first name of the customer
     * @return string
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name of the customer
     * @return string
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the phone number of the customer
     * @return string
     */
    public String getPhoneNumber() {
        return phoneNumber;
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
     * Gets account number of the customer
     * @return string
     */
    public int getAccountNo() {
        return accountNo;
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