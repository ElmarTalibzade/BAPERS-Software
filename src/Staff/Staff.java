package Staff;

/**
 * The main class for all types of Staff users
 * @author Mihai
 */
public abstract class Staff {

    protected Role role;
    
    /**
     * Account Number of this staff member
     */
    protected int accountNo;

    /**
     * First Name of this staff member
     */
    protected String firstName;

    /**
     * Last Name of this staff member
     */
    protected String lastName;

    /**
     * Address of this staff member
     */
    protected String address;

    /**
     * Phone number of this staff member
     */
    protected String phone;

    /**
     * Determines whether or not this staff member is currently interacting with BAPERS
     */
    protected boolean isActive;
    
    /**
     * Constructor for Staff
     * @param accountNo Account number
     * @param role Staff's access level
     * @param firstName Staff's first name
     * @param lastName Staff's last name
     * @param address Staff's physical address
     * @param phone Staff's phone number
     */
    public Staff(int accountNo, Role role, String firstName, String lastName, String address, String phone) {
        this.accountNo = accountNo;
        this.role = role;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
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
     * @return A string that represents the phone number of the Staff
     */
    public String getPhone() {
        return phone;
    }

    public Role getRole(){
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
    
    public void setRole(Role role){
        this.role = role;
    }
}