package Administrator;

import Customer.Customer;
import Customer.DepartmentType;
import Customer.DiscountType;
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

    /**
     * Connects to a MySQL database
     *
     * @return Returns true if connection was successful
     */
    @Override
    public boolean connect() {

        try {

            connection = DriverManager.getConnection(DB_URL, USER, PASS);

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

            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(query);
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

            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(query);
            return res;

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
    
    public boolean validateLogin(String email, String password) {
        
        ResultSet result = retrieveData(String.format("SELECT * FROM `staff` WHERE emailAddress = '%s' AND password = '%s'", email, password));
        
        try {
            
            return result.next();
            
        } catch (SQLException ex) {
            
            Logger.getLogger(DBConnectivity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    /**
     * Returns the list of all customers from the database
     * @return Array list of customers
     */
    public ArrayList<Customer> getCustomers()
    {
        ArrayList<Customer> customers = new ArrayList<Customer>();
        
        try {
            
            ResultSet result = retrieveData("SELECT * FROM `customers`");
            
            while (result.next()) {
                
                customers.add(new Customer(
                        result.getInt("accountNo"),
                        result.getString("holderName"),
                        result.getString("firstName"),
                        result.getString("lastName"),
                        result.getBoolean("isValued"),
                        result.getBoolean("isSuspended"),
                        result.getBoolean("isDefault"),
                        result.getString("address"),
                        result.getString("phoneNo"),
                        DiscountType.values()[result.getInt("discountType")],
                        result.getString("emailAddress"),
                        result.getInt("debtRemindedAmount"),
                        getJobs(result.getInt("accountNo"))
                ));
            }
            
        }
        catch (SQLException ex) {
            
            Logger.getLogger(DBConnectivity.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return customers;
    }
    
    /**
     * Retrieves jobs of a customer
     * @param customerNo Customer's number whose jobs will be retrieved
     * @return Array list of jobs
     */
    private ArrayList<Job> getJobs(int customerNo) {
        
        ArrayList<Job> jobs = new ArrayList<Job>();
        
        try {
            
            ResultSet result = retrieveData(String.format("SELECT * FROM `jobs` WHERE ownerNo = \"%s\"", customerNo));
            
            while (result.next()) {
                
                jobs.add(new Job(
                        result.getString("code"),
                        getTasks(result.getString("code")),
                        result.getDouble("price"),
                        result.getFloat("discountRate"),
                        result.getString("ownerNo"),
                        result.getString("specialInstructions"),
                        result.getString("shelf")
                ));
                
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
    private ArrayList<Task> getTasks(String jobCode) {
        
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