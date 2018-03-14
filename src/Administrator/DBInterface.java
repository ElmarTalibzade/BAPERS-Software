package Administrator;

/**
 * Here is the interface for our connection.
 * @author Mihai
 */
public interface DBInterface {
    
    /**
     * Connects to SQL database using given credentials
     * @param SQL MySQL connection
     */
    public void connect(String SQL);
    
    /**
     * Stores data
     * @param SQL MySQL connection
     */
    public void storeData(String SQL);
    
    /**
     * Retrieves data
     * @param SQL MySQL connection
     */
    public void retrieveData(String SQL);
    
    /**
     * Closes SQL connection
     */
    public void closeConnection();
}