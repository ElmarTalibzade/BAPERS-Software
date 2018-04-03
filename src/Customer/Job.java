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
    private ArrayList<Task> tasks;
    
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
     * Constructs a Job
     * @param invoiceNo Job's invoice number
     * @param code Job's code
     * @param staffCode Code of a staff member who created it
     * @param task A list of tasks that this job is associated with 
     * @param price Price of this job
     * @param discountRate Discount rate of this job
     * @param customerId Id of a customer who is associated with this job
     * @param specialInstructions Instructions associated with this job
     * @param shelf Shelf slot of this job
     * @param priority Priority for this job
     */
    public Job(int invoiceNo, String code, int staffCode, ArrayList<Task> task, float discountRate, int customerId, String specialInstructions, String shelf, int priority) {
        this.invoiceNo = invoiceNo;           
        this.staffCode = staffCode;
        this.code = code;
        this.tasks = task;
        getPrice();     // calculates the price based on all tasks
        this.discountRate = discountRate;
        this.customerId = customerId;
        this.specialInstructions = specialInstructions;
        this.shelf = shelf;
        this.status = 0;
        this.priority = priority;
    }

    /**
     * Gets the priority of this Job
     * @return job priority
     */
    public int getPriority(){
        return priority;
    }
    
    /**
     * Sets the status of this job
     * @param status new job status
     */
    public void setStatus(int status) {       
        this.status = status;
    }
    
    /**
     * Gets the status of this job
     * @return job status
     */
    public int getStatus(){
        return status;
    }          
    
    /**
     * Get the invoice number of this job
     * @return job invoice
     */
    public int getInvoiceNo(){
        return invoiceNo;
    }
    
    /**
     * Gets the staff code 
     * @return staff code
     */
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
        return tasks;
    }

    /**
     * Gets the price of the Job
     * @return price of the Job
     */
    public double getPrice() {
        
        price = 0;
        
        for (Task task : tasks)
        {
            price += task.getPrice();
        }
        
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
