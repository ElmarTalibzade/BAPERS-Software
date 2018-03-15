package Administrator;

/**
 * Here we realize connection with our database.
 * This class it's responsible for connecting to the database, storing an retrieving the data.
 * @author Mihai
 */
public class DBConectivity implements DBInterface {

    /**
     * Connects to SQL database using given credentials
     * @param SQL MySQL connection
     */
    @Override
    public void connect(String SQL) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Stores data
     * @param SQL MySQL connection
     */
    @Override
    public void storeData(String SQL) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Retrieves data
     * @param SQL MySQL connection
     */
    @Override
    public void retrieveData(String SQL) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Closes SQL connection
     */
    @Override
    public void closeConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
