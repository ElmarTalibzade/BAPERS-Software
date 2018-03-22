/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * A job which customer that must be fulfilled by the company. Contains tasks that must be done.
 * @author Elmar Talibzade
 */
public class Job {
    private int staffCode;
    private String code;
    private ArrayList<Task> task;
    
    private double price;
    private float discountRate;
    
    private Timestamp collectionTime;
    private Timestamp estCollectionTime;
    
    private int customerId;
    private int invoiceNo;
    private int priority;
    private int status;
    
    private String specialInstructions;
    private String shelf;

    /**
     *
     * @param invoiceNo
     * @param code
     * @param staffCode
     * @param task
     * @param price
     * @param discountRate
     * @param customerId
     * @param specialInstructions
     * @param shelf
     * @param priority
     */
    public Job(int invoiceNo, String code, int staffCode, ArrayList<Task> task, double price, float discountRate, int customerId, String specialInstructions, String shelf, int priority) {
        this.invoiceNo = invoiceNo;           
        this.staffCode = staffCode;
        this.code = code;
        this.task = task;
        this.price = price;
        this.discountRate = discountRate;
        this.customerId = customerId;
        this.specialInstructions = specialInstructions;
        this.shelf = shelf;
        this.status = 0;
        this.priority = priority;
    }

    public int getPriority(){
        return priority;
    }
    
    public void setStatus(int status) {       
        this.status = status;
    }
    
    public int getStatus(){
        return status;
    }          
    
    public int getInvoiceNo(){
        return invoiceNo;
    }
    
    public int getStaffCode(){
        return staffCode;
    }
    
    /**
     * Gets job code
     * @return job code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets tasks that are associated with this Job
     * @return array of tasks
     */
    public ArrayList<Task> getTasks() {
        return task;
    }

    /**
     * Gets the price of the Job
     * @return price of the Job
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Gets a discount rate for this Job
     * @return discount rate
     */
    public float getDiscountRate() {
        return discountRate;
    }

    /**
     * Sets a discount rate for this job
     * @param discountRate new discount rate
     */
    public void setDiscountRate(float discountRate) {
        this.discountRate = discountRate;
    }

    /**
     * Gest the collection time for this Job
     * @return
     */
    public Timestamp getCollectionTime() {
        return collectionTime;
    }

    /**
     * Estimates the collection time based on when the job has been assigned
     * @return
     */
    public Timestamp getEstCollectionTime() {
        return estCollectionTime;
    }
    
    /**
     * Gets the customer id to whom this Job has been assigned to
     * @return customer id
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Gets instructions associated to this Job
     * @return special instructions
     */
    public String getSpecialInstructions() {
        return specialInstructions;
    }

    /**
     * Sets special instructions for this Job
     * @param specialInstructions new instructions
     */
    public void setSpecialInstructions(String specialInstructions) {
        this.specialInstructions = specialInstructions;
    }

    /**
     * Gets a shelf
     * @return shelf number
     */
    public String getShelf() {
        return shelf;
    }

    /**
     * Sets a shelf
     * @param shelf
     */
    public void setShelf(String shelf) {
        this.shelf = shelf;
    }    
}
