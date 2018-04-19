package Staff;

import Customer.DepartmentType;

/**
 * The main class for all types of Staff users
 * @author Mihai
 */
public class Staff {

    /**
     * Role of the staff
     */
    protected Role role;
    
    /**
     * Department this staff member is operating at
     */
    protected DepartmentType assignedDepartment;
    
    /**
     * Determines whether or not this staff member is currently assigned with a job
     */
    protected boolean isAssigned = false;
    
    /**
     * Account Number of this staff member
     */
    protected int accountNo;

    /**
     * Staff username used to log into BAPERS system
     */
    protected String username;
    
    /**
     * First Name of this staff member
     */
    protected String firstName;

    /**
     * Last Name of this staff member
     */
    protected String lastName;

    /**
     * Determines whether or not this staff member is currently interacting with BAPERS
     */
    protected boolean isActive;
    
    /**
     * Constructor for Staff
     * @param accountNo Account number
     * @param role Staff's access level
     * @param username Staff's username
     * @param firstName Staff's first name
     * @param lastName
     */
    public Staff(int accountNo, Role role, String username, String firstName, String lastName) {
        this.accountNo = accountNo;
        this.role = role;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        setDepartment(null);
    }

    /**
     * Constructor for Staff
     * @param accountNo Account number
     * @param role Staff's access level
     * @param assignedDepartment Staff's department where its operating
     * @param username Staff's username
     * @param firstName Staff's first name
     * @param lastName Staff's last name
     */
    public Staff(int accountNo, Role role, DepartmentType assignedDepartment, String username, String firstName, String lastName) {
        this.accountNo = accountNo;
        this.role = role;
        this.assignedDepartment = assignedDepartment;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
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
     * Gets Staff operating department
     * @return An object that represents where the staff is operating
     */
    public DepartmentType getDepartment() {
        return assignedDepartment;
    }
    
    /**
     * Sets a new operating department to the staff
     * @param newDepartment An object that represents the new operating department
     */
    public void setDepartment(DepartmentType newDepartment) {
        assignedDepartment = newDepartment;
        isAssigned = (assignedDepartment != null);
    }
    
    /**
     * Determines whether or not the staff is assigned to a department
     * @return true - if the staff is assigned to a department | false - otherwise
     */
    public boolean isAssigned()
    {
        return isAssigned;
    }
    
    /**
     * Returns the staff full name
     * @return A string that represents the staff full name
     */
    public String getFullName()
    {
        return firstName + " " + lastName;
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
     * Gets Staff username
     * @return A string that represents account username
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Returns employee's role
     * @return An object that represents the role of the staff
     */
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
    
    /**
     * Sets Staff role
     * @param role Represents the new role that the staff will have
     */
    public void setRole(Role role){
        this.role = role;
    }
}