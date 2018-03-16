package Administrator;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Here we realize connection with our database.
 * This class it's responsible for connecting to the database, storing an retrieving the data.
 * @author Mihai
 */
public class DBConnectivity implements DBInterface {

    static final String DB_URL = "jdbc:mysql://localhost:3306/bloomsday?autoReconnect=true&useSSL=false";

    static final String USER = "root";
    static final String PASS = "root";
    
    private Connection connection;
    private Statement stmt;
    private ResultSet result;
    
    /**
     * Connects to a MySQL database
     * @return Returns true if connection was successful
     */
    @Override
    public boolean connect() {
        
        try {
            
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = connection.createStatement();
            
            return true;
            
        } catch (SQLException ex) {
            
            Logger.getLogger(DBConnectivity.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            
        }
    }

    /**
     * Sends a query for updating MySQL database
     * @param query Query which will be submitted
     * @return Returns true if the query was successful
     */
    @Override
    public boolean storeData(String query) {
        
        try {
            
            result = stmt.executeQuery(query);
            return true;
            
        } catch (SQLException ex) {
            
            Logger.getLogger(DBConnectivity.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            
        }
    }

    /**
     * Sends a query for retrieving data from MySQL database
     * @param query Query which will be submitted
     * @return Returns the data obtained from the query submitted. If the query failed, null is returned
     */
    @Override
    public ResultSet retrieveData(String query) {
        
        try {
            
            result = stmt.executeQuery(query);
            return result;
            
        } catch (SQLException ex) {
            
            Logger.getLogger(DBConnectivity.class.getName()).log(Level.SEVERE, null, ex);
            return null;
            
        }
    }

    /**
     * Closes SQL connection
     */
    @Override
    public void closeConnection() {
        
        try {
            
            connection.close();
            
        } catch (SQLException ex) {
            
            Logger.getLogger(DBConnectivity.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    // To-do:
    // I/O Customers, Job, Tasks, Payment for existing entries
    // Create Job, Tasks, Customers, Staff
}