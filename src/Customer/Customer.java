/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import static bapers.Bapers.DB;
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
    private int discountRate;
    private String emailAddress;
    private int debtReminded;
    
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
     * @param discountRate
     * @param emailAddress Customer's email address
     * @param debtReminded Times the debt has been reminded to this customer
     * @param jobs A list of jobs that are associated with this customer
     */
    public Customer(int accountNo, String holderName, String firstName, String lastName, boolean isValued, boolean isSuspended, boolean isDefault, String address, String phoneNumber, DiscountType agreedDiscount, int discountRate, String emailAddress, int debtReminded, ArrayList<Job> jobs) {
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
        this.discountRate = discountRate;
        this.emailAddress = emailAddress;
        this.debtReminded = debtReminded;
        this.jobs = jobs;
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
     * Gets customer's discount rate
     * @return discount rate
     */
    public int getDiscountValue() {
        return discountRate;
    }
    
    /**
     * Updates the discount rate
     * @param discountRate discount rate
     */
    public void setDiscountValue(int discountRate){
        this.discountRate = discountRate;
    }
    
    /**
     * Gets discount type
     * @return discount type
     */
    public DiscountType getAgreedDiscount() {
        return agreedDiscount;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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
     * Suspend customer's account
     * @param isSuspended true - if customer is suspended | false - otherwise
     */
    public void setIsSuspended(boolean isSuspended){
        this.isSuspended = isSuspended;
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

    public String getFullName() {
        return firstName + " " + lastName;
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
     * Gets customer's last 4 digit of the card
     * @return An integer between 1000 and 9999 that represents customer's last 4 digit of the card
     */
    public int getLast4Digit() {
        return DB.last4Digit(accountNo);
    }
    
    /**
     * Gets customer's month expiration date
     * @return An integer between 00 and 12 that represents the month when customer's card is expired
     */
    public int getMonthExpiry(){
        return DB.getMonthExpiry(accountNo);
    }
    
    /**
     * Gets customer's year expiration date
     * @return An integer between 00 and 99 that represents the year when customer's card is expired
     */
    public int getYearExpiry(){
        return DB.getYearExpiry(accountNo);
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
     * Gets account type of a customer
     * @return ture - if the customer is valued | false - otherwise
     */
    public boolean isValued() {
        return isValued;
    }
    
    /**
     * Sets the cusotmer's account type
     * @param isValued true - if the customer is valued | false - otherwise
     */
    public void setValued(boolean isValued){
        this.isValued = isValued;
    }
    
    /**
     * Gets the customer account type
     * @return true - if the customer is "in default" state | false - otherwise
     */
    public boolean isDefault() {
        return isDefault;
    }
}
