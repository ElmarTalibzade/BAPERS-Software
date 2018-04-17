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
     */
    public ShiftManager(int accountNo, String username, String firstName, String lastName) {
        super(accountNo, Role.ShiftManager, username, firstName, lastName);
    }
}
    