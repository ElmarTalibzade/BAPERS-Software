/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customer;

/**
 * A boundary class for communicating with other packages.
 * @author Elmar Talibzade
 */
public class CustomerController {
    private String jobId;
    private String taskId;
    private String customerId;
    
    /**
     * Returns the id of the job
     * @return
     */
    public String getJobId() {
        return jobId;
    }

    /**
     * Sets the job id
     * @param jobId new job id
     */
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    /**
     * Returns the task id
     * @return task id
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Sets the task id
     * @param taskId new task id
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    /**
     * Gets customer id
     * @return customer id
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets a customer id
     * @param customerId new customer id
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    
    /**
     * Updates the job
     */
    public void updateJob()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Searches for a customer
     * @param id customerId
     */
    public void searchCustomer(int id)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Searches for a job
     * @param code job code
     */
    public void searchJob(String code)
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}