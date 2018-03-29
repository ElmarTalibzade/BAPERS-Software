package Staff;

/**
 * Represents ShiftManager class
 * @author Mihai
 */
public class ShiftManager extends Staff {

    /**
     * Constructor for Shift Manager
     * @param accountNo Account number
     * @param firstName Staff's first name
     * @param lastName Staff's last name
     * @param address Staff's physical address
     * @param phone Staff's phone number
     */
    public ShiftManager(int accountNo, String firstName, String lastName, String address, String phone) {
        super(accountNo, 2, firstName, lastName, address, phone);
    }

    /**
     * Function for searching an existing customer.
     * @param holderName customer's name
     * @param contactName
     * @param address customer's physical address
     * @param phone customer's telephone
     */
    private void searchCustomer(String holderName, String contactName, String address, String phone){

    }

    /**
     * Function for creating a new customer account
     * @param holderName Customer's name
     * @param contactName
     * @param address customer's physical address
     * @param phone customer's telephone
     */
    private void createCustomerAccount(String holderName, String contactName, String address, String phone){

    }

    /**
     * A function that print a label
     * @param labelName the label that will be printed
     */
    private void printLabel(String labelName) {

    }

    /**
     * This function prints the receipt
     */
    private void printReciept(){

    }

    /**
     * Record deadline for a specific job
     */
    private void recordDeadline(){

    }

    /**
     * Allert the Shift Manager
     * @param message The message of the alert
     */
    private void alertShiftManager(String message){

    }

    /**
     * A function that creates a new job
     * @param specialInstructions A string that represents special instructions for the job
     * @param customerId Customer's identification number
     * @return Returns true if the job was successfully created | false - otherwise
     */
    private boolean createJob(String specialInstructions, String customerId){
        return true;
    }

    /**
     * Through this function we will record all the instructions.
     * @param jobID An integer that represents job identification number.
     */
    private void recordInstructions(String jobID){

    }
}
