package Staff;

/**
 * Represents the OfficeManager class
 * @author Mihai
 */
public class OfficeManager extends Staff {

    /**
     * Constructor for OfficeManager
     * @param accountNo Account number
     * @param firstName Staff's first name
     * @param lastName Staff's last name
     */
    public OfficeManager(int accountNo, String username, String firstName, String lastName) {
        super(accountNo, Role.OfficeManager, username, firstName, lastName);
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
     * A function that retrieves all customers.
     */
    private void getCustomers() {

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
    private void printReceipt(){

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
     * Upgrade customer's account
     * @return true if upgraded successfully | false - otherwise
     */
    private boolean upgradeCustomer() { return true; }

    /**
     * Downgrade customer's account
     * @return true if upgraded successfully | false - otherwise
     */
    private boolean downgradeCustomer(){
        return true;
    }

    /**
     * Through this function we select a single discount for the Customer
     */
    private void selectSingleDiscount(){

    }

    /**
     * Throught this function, the Office Manager gets access to the Receptionst functions
     */
    private void accessReceptionistFunction(){

    }

    /**
     * Print invoice for a specific job
     */
    private void printInvoice(){

    }

    /**
     * Reactivate a customer's account
     * @param accountNo A number that represents account number.
     */
    private void reactivateAccount(int accountNo){

    }

    /**
     * Prints a reminder
     */
    private void printReminder(){

    }

    /**
     * Prints all reminders sent.
     * @param reminders This array of strings represents the reminders that will be printed
     */
    private void printReminders(String[] reminders){

    }

    /**
     * Sets the receptionst access level to an account number.
     * @param accountNo An integer that represents staff acc. no.
     */
    private void setReceptionst(int accountNo){

    }

    /**
     * Through this function we will record all the instructions.
     * @param jobID An integer that represents job identification number.
     */
    private void recordInstructions(String jobID){

    }
}
