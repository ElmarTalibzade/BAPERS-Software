package Staff;

/**
 * Represents the Technician class
 * @author Mihai
 */
public class Technician extends Staff {

    /**
     * Constructor for Technician
     * @param accountNo Account number
     * @param firstName Staff's first name
     * @param lastName Staff's last name
     * @param address Staff's physical address
     * @param phone Staff's phone number
     */
    public Technician(int accountNo, String firstName, String lastName, String address, String phone) {
        super(accountNo, 4, firstName, lastName, address, phone);
    }

    /**
     * This function takes a taskID from a jobID and mark it as completed
     * @param jobID An integer that represents job id.
     * @param taskID An integer that represents task id.
     */
    private void markAsComplete(String jobID, String taskID) {

    }

    /**
     * This function sets the priority for a specific job ID.
     * @param jobID A string that represents job identification number.
     * @param priority An integer that represents level of priority
     */
    private void setJobPriority(String jobID, int priority) {

    }

    /**
     * This function retrieves job details
     * @param jobID A string that represents job identification number.
     */
    private void getJob(String jobID){

    }

    /**
     * This function retrieves job instructions
     * @param jobID A string that represents job identification number.
     */
    private void getJobInstructions(String jobID){

    }

    /**
     * This function retrieves a task
     * @param taskID A string that represents task identification number.
     */
    private void getTask(String taskID){

    }

    /**
     * This function sets a task to the lab
     * @param taskID A string that represents task identification number.
     */
    private void setToLab(String taskID){

    }
}
