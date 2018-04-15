/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import java.util.ArrayList;

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
    private boolean usingCard;
    
    private ArrayList<Job> jobs;

    /**
     * Constructs a customer object
     * @param accountNo Customer's account number
     * @param holderName Customer's holder name
     * @param firstName Customer's first name
     * @param lastName Customer's last name
     * @param isValued Is Customer valued by the company?
     * @param isSuspended Is Customer suspended?
     * @param isDefault Is Customer in default?
     * @param address Customer's address
     * @param phoneNumber Customer's phone number
     * @param agreedDiscount Type of a discount this customer is getting
     * @param emailAddress Customer's email address
     * @param debtReminded Times the debt has been reminded to this customer
     * @param jobs A list of jobs that are associated with this customer
     */
    public Customer(int accountNo, String holderName, String firstName, String lastName, boolean isValued, boolean isSuspended, boolean isDefault, String address, String phoneNumber, DiscountType agreedDiscount, String emailAddress, int debtReminded, ArrayList<Job> jobs, boolean usingCard) {
        this.accountNo = accountNo;
        this.holderName = holderName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isValued = isValued;
        this.isSuspended = isSuspended;
        this.isDefault = isDefault;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.agreedDiscount = agreedDiscount;
        this.emailAddress = emailAddress;
        this.debtReminded = debtReminded;
        this.jobs = jobs;
        this.usingCard = usingCard;
    }

    /**
     * Gets the holder name
     * @return holder name
     */
    public String getHolderName() {
        return holderName;
    }

    /**
     * Gets customer's address
     * @return address
     */
    public String getAddress() {
        return address;
    }
    
    /**
     * Gets discount type
     * @return discount type
     */
    public DiscountType getAgreedDiscount() {
        return agreedDiscount;
    }

    /**
     * Updates the discount type
     * @param agreedDiscount new discount type
     */
    public void setAgreedDiscount(DiscountType agreedDiscount) {
        this.agreedDiscount = agreedDiscount;
    }

    /**
     * Returns the number of times this customer has been reminded of the debt
     * @return debt counter
     */
    public int getDebtReminded() {
        return debtReminded;
    }
    
    /**
     * Increments debt reminder counter by 1
     */
    public void incrementDebtReminder()
    {
        debtReminded++;
    }   
    
    /**
     * Resets the debt reminder to 0
     */
    public void resetDebtReminder()
    {
        debtReminded = 0;
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
    public ArrayList<Job> getJobs() {
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

    public boolean getCard() {
        return usingCard;
    }
    /**
     * Gets account number of the customer
     * @return string
     */
    public int getAccountNo() {
        return accountNo;
    }
    
    public int getLast4Digit() {
        return bapers.Bapers.DB.last4Digit(accountNo);
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
    public boolean makePayment(String jobId)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     *
     * @return
     */
    public boolean isValued() {
        return isValued;
    }
    
    /**
     *
     * @return
     */
    public boolean isDefault() {
        return isDefault;
    }
}
