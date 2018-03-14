/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import java.sql.Time;

/**
 * A job which customer that must be fulfilled by the company. Contains tasks that must be done.
 * @author Elmar Talibzade
 */
public class Job {
    private String code;
    private Task[] task;
    
    private double price;
    private float discountRate;
    
    private Time collectionTime;
    private Time estCollectionTime;
    
    private String customerId;
    private String specialInstructions;
    private String shelfOnCompletion;

    /**
     * Constructor for a Job
     * @param code Job code
     * @param price Job price
     * @param collectionTime Job's collection time
     * @param customerId Id of a customer to whom this Job belongs to
     * @param specialInstructions Job's special instructions
     * @param shelfOnCompletion Shelf in which Job will be placed
     */
    public Job(String code, double price, Time collectionTime, String customerId, String specialInstructions, String shelfOnCompletion) {
        this.code = code;
        this.price = price;
        this.collectionTime = collectionTime;
        this.customerId = customerId;
        this.specialInstructions = specialInstructions;
        this.shelfOnCompletion = shelfOnCompletion;
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
    public Task[] getTask() {
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
    public Time getCollectionTime() {
        return collectionTime;
    }

    /**
     * Estimates the collection time based on when the job has been assigned
     * @return
     */
    public Time getEstCollectionTime() {
        return estCollectionTime;
    }
    
    /**
     * Gets the customer id to whom this Job has been assigned to
     * @return customer id
     */
    public String getCustomerId() {
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
    public String getShelfOnCompletion() {
        return shelfOnCompletion;
    }

    /**
     * Sets a shelf
     * @param shelfOnCompletion new shelf number
     */
    public void setShelfOnCompletion(String shelfOnCompletion) {
        this.shelfOnCompletion = shelfOnCompletion;
    }

    
}
