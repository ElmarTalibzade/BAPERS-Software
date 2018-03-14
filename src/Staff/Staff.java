package Staff;

/**
 * The main class for all types of Staff users
 * @author Mihai
 */
public abstract class Staff {
    protected int accountNo;
    protected String firstName;
    protected String lastName;
    protected String address;
    protected String phone;
    protected boolean isActive;

    public Staff(int accountNo, String firstName, String lastName, String address, String phone) {
        this.accountNo = accountNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    private void login(String email, String password) {

    }

    public int getAccountNo(){
        return accountNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void setAccountNo(int accountNo){
        this.accountNo = accountNo;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
