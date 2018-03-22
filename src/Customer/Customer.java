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
    
    private ArrayList<Job> jobs;

    /**
     *
     * @param accountNo
     * @param holderName
     * @param firstName
     * @param lastName
     * @param isValued
     * @param isSuspended
     * @param isDefault
     * @param address
     * @param phoneNumber
     * @param agreedDiscount
     * @param emailAddress
     * @param debtReminded
     * @param jobs
     */
    public Customer(int accountNo, String holderName, String firstName, String lastName, boolean isValued, boolean isSuspended, boolean isDefault, String address, String phoneNumber, DiscountType agreedDiscount, String emailAddress, int debtReminded, ArrayList<Job> jobs) {
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
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DiscountType getAgreedDiscount() {
        return agreedDiscount;
    }

    public void setAgreedDiscount(DiscountType agreedDiscount) {
        this.agreedDiscount = agreedDiscount;
    }

    public int getDebtReminded() {
        return debtReminded;
    }

    public void setDebtReminded(int debtReminded) {
        this.debtReminded = debtReminded;
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

    public boolean isValued() {
        return isValued;
    }
    
    public boolean isDefault() {
        return isDefault;
    }
}