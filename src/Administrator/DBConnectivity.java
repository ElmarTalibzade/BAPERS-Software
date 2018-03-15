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

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    
    Connection connection;
    Statement stmt;
    
    /**
     * Connects to SQL database using given credentials
     * @param SQL MySQL connection
     */
    @Override
    public void connect(String SQL) {
        
        try {
            System.out.println("Connecting to database...");

            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            
            stmt = connection.createStatement();
            
            ResultSet result = stmt.executeQuery(SQL);
            
            while(result.next()) {
                int userId = result.getInt("userID");
                String role = result.getString("role");
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                
                System.out.println("ID: " + userId + " | Role: " + role + " | First Name: " + firstName + " | Last Name: " + lastName);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectivity.class.getName()).log(Level.SEVERE, null, ex);
        }
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