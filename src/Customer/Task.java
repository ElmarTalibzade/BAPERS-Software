/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import java.sql.Date;

/**
 * Task which is a part of a Job.
 * @author Elmar Talibzade
 */
public class Task {
    private int id;
    private String description;
    private String shelfSlot;
    private double price;
    private String department;
    private float discountRate;
    
    private Date startTime;
    private Date endTime;

    /**
     * Constructor for Task
     * @param description Task description
     * @param shelfSlot Shelf slot for task
     * @param price Price of the task
     * @param startTime Time when this task has been started
     */
    public Task(String description, String shelfSlot, double price, Date startTime) {
        this.description = description;
        this.shelfSlot = shelfSlot;
        this.price = price;
        this.startTime = startTime;
    }
    
    /**
     * Marks this task as done
     */
    public void MarkAsDone()
    {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns Id of this Task
     * @return task id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the description of this Task
     * @return task description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description for this Task
     * @param description new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *  Gets a shelf slot this Task is associated with
     * @return shelf slot id
     */
    public String getShelfSlot() {
        return shelfSlot;
    }

    /**
     * Gets the price of this task
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns department that this task is associated with
     * @return
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Changes department of this Task
     * @param department name of a new department
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * Returns a discount rate which has been set for this Task
     * @return discount rate
     */
    public float getDiscountRate() {
        return discountRate;
    }

    /**
     * Sets a new discount rate for this Task
     * @param discountRate new discount rate
     */
    public void setDiscountRate(float discountRate) {
        this.discountRate = discountRate;
    }

    /**
     * Gets the start time of this Task
     * @return start time of this task
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * Gets the end time of this Task
     * @return end time of this Task
     */
    public Date getEndTime() {
        return endTime;
    }
}
