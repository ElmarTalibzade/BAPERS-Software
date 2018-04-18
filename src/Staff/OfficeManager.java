package Staff;

/**
 * Represents the OfficeManager class
 * @author Mihai
 */
public class OfficeManager extends Staff {

    /**
     * Constructor for OfficeManager
     * @param accountNo Account number
     * @param username Account username
     * @param firstName Staff's first name
     * @param lastName Staff's last name
     */
    public OfficeManager(int accountNo, String username, String firstName, String lastName) {
        super(accountNo, Role.OfficeManager, username, firstName, lastName);
    }
}