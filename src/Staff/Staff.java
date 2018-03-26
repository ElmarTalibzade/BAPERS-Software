package Staff;

/**
 * The main class for all types of Staff users
 * @author Mihai
 */
public abstract class Staff {

    protected int role;
    
    /**
     *
     */
    protected int accountNo;

    /**
     *
     */
    protected String firstName;

    /**
     *
     */
    protected String lastName;

    /**
     *
     */
    protected String address;

    /**
     *
     */
    protected String phone;

    /**
     *
     */
    protected boolean isActive;

    protected String password;
    /**
     * Constructor for Staff
     * @param accountNo Account number
     * @param role Staff's access level
     * @param firstName Staff's first name
     * @param lastName Staff's last name
     * @param address Staff's physical address
     * @param phone Staff's phone number
     */
    public Staff(int accountNo, int role, String firstName, String lastName, String address, String phone) {
        this.accountNo = accountNo;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public String getPassword(){
        return password;
    }
    
    /**
     * Returns if the staff is logged in or not
     * @return true - if it's logged in | false - otherwise
     */
    public boolean getIsActive() {
        return isActive;
    }

    /**
     * Set staff availability status
     * @param isActive the new status of the account
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Through login function, the staff will get access to the GUI
     * @param email staff's user email
     * @param password staff's password
     * @return true - if the credentials are correct | false - otherwise
     */
    private boolean login(String email, String password) {
        return true;
    }

    /**
     * Gets Staff account number.
     * @return A number that represents account number
     */
    public int getAccountNo(){
        return accountNo;
    }

    /**
     * Gets Staff first name;
     * @return A string that represents account first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets Staff last name
     * @return A string that represents account last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets Staff physical address
     * @return A string that represents a physical address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets Staff phone
     * @return An int that represents the phone number of the Staff
     */
    public String getPhone() {
        return phone;
    }

    public int getRole(){
        return role;       
    }
    
    /**
     * Sets Staff account number
     * @param accountNo Represents the value that will be set
     */
    public void setAccountNo(int accountNo){
        this.accountNo = accountNo;
    }

    /**
     * Sets Staff first name
     * @param firstName Represents the name that will be set
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * Sets Staff last name
     * @param lastName Represents the name that will be set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setRole(int role){
        this.role = role;
    }
}
