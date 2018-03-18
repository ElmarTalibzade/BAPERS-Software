package Administrator;

import Customer.Customer;
import Customer.DepartmentType;
import Customer.Job;
import Customer.Status;
import Customer.Task;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Here we realize connection with our database. This class it's responsible for
 * connecting to the database, storing an retrieving the data.
 *
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
     *
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
     *
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
     *
     * @param query Query which will be submitted
     * @return Returns the data obtained from the query submitted. If the query
     * failed, null is returned
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
    // Updates customer. If such customer does not exist, a new one is created

    /**
     *
     * @param customer
     * @return
     */
    public boolean updateCustomer(Customer customer) {
        String query = String.format("INSERT INTO customers(`accountNo`, `firstName`, `lastName`, `phoneNo`) VALUES(10, \"%s\", \"%s\", \"%d\")",
                customer.getAccountNo(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getPhoneNumber()
        );

        return storeData(query);
    }

    private ArrayList<Job> getJobs(int customerNo) {
        
        ArrayList<Job> jobs = new ArrayList<Job>();
        
        try {
            
            ResultSet result = retrieveData(String.format("SELECT * FROM `jobs` WHERE ownerNo = \"%s\"", customerNo));
            
            while (result.next()) {
                
                    
                
            }
            
        }
        catch (SQLException ex) {

            Logger.getLogger(DBConnectivity.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        return jobs;
    }

    /**
     * Fetches all tasks that match a specific job code.
     * @param jobCode All tasks that belong to the job of this code will be retrieved.
     * @return An array list of Task objects.
     */
    public ArrayList<Task> getTasks(String jobCode) {
        
        ArrayList<Task> tasks = new ArrayList<Task>();
        
        try {

            ResultSet result = retrieveData(String.format("SELECT * FROM `tasks` WHERE jobCode = \"%s\"", jobCode));

            while (result.next()) {
                tasks.add(new Task(
                        result.getInt("taskID"),
                        Status.values()[result.getInt("status")],
                        result.getDouble("price"),
                        result.getString("description"),
                        result.getString("shelfSlot"),
                        DepartmentType.values()[result.getInt("department")],
                        result.getFloat("discountRate"),
                        result.getTimestamp("startTime"),
                        result.getTimestamp("endTime")
                ));
                
            }

        } catch (SQLException ex) {

            Logger.getLogger(DBConnectivity.class.getName()).log(Level.SEVERE, null, ex);

        }

        return tasks;
    }
}