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
     */
    public Technician(int accountNo, String username, String firstName, String lastName) {
        super(accountNo, Role.Technician, username, firstName, lastName);
    }
}