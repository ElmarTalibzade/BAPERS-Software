/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

import java.sql.Timestamp;

/**
 * Task which is a part of a Job.
 * @author Elmar Talibzade
 */
public class Task {
    
    private String jobCode;
    private int id;
    private Status status;
    private double price;
    private String description;
    private String shelfSlot;
    private DepartmentType department;
    private float discountRate;
    
    private Timestamp startTime;
    private Timestamp endTime;

    /**
     * Constructs a Task
     * @param jobCode Code of a job associated with this task
     * @param id ID of a Task
     * @param status Task current status
     * @param price Price of a task
     * @param description Description of a task
     * @param shelfSlot Shelf slot of a task
     * @param department Department of a task
     * @param discountRate Discount rate of a task
     * @param startTime Time task has started
     * @param endTime Time task was finished
     */
    public Task(String jobCode, int id, Status status, double price, String description, String shelfSlot, DepartmentType department, float discountRate, Timestamp startTime, Timestamp endTime) {
        this.jobCode = jobCode;
        this.id = id;
        this.status = status;
        this.price = price;
        this.description = description;
        this.shelfSlot = shelfSlot;
        this.department = department;
        this.discountRate = discountRate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Marks this task as done
     */
    public void MarkAsDone()
    {
        status = Status.Completed;
    }
    
    /**
     * Gets job code of this task
     * @return job code
     */
    public String getJobCode() {
        return jobCode;
    }
    
    /**
     * Returns Id of this Task
     * @return task id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the current status of a task
     * @return task status
     */
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
     * Gets the department of this task
     * @return department of this task
     */
    public DepartmentType getDepartment() {
        return department;
    }

    /**
     * Changes the department of this task
     * @param department New department
     */
    public void setDepartment(DepartmentType department) {
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
}