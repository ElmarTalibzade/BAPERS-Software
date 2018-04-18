package Staff;

/**
 *
 * @author elmar
 */
public class Receptionist extends Staff {

    /**
     * Constructor for Receptionist
     * @param accountNo Account number
     * @param username Account username
     * @param firstName Staff's first name
     * @param lastName Staff's last name
     */
    public Receptionist(int accountNo, String username, String firstName, String lastName) {
        super(accountNo, Role.Receptionist, username, firstName, lastName);
    }
}