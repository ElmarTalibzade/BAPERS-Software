package Administrator;

import java.sql.ResultSet;

/**
 * Here is the interface for our connection.
 * @author Mihai
 */
public interface DBInterface {
    
    /**
     * Connects to a MySQL database
     * @return Returns true if connection was successful
     */
    public boolean connect();
    
    /**
     * Sends a query for updating MySQL database
     * @param query Query which will be submitted
     * @return Returns true if the query was successful
     */
    public boolean storeData(String query);
    
    /**
     * Sends a query for retrieving data from MySQL database
     * @param query Query which will be submitted
     * @return Returns the data obtained from the query submitted
     */
    public ResultSet retrieveData(String query);
    
    /**
     * Closes SQL connection
     */
    public void closeConnection();
}