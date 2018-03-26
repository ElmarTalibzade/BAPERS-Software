package Administrator;

import Customer.Customer;
import Customer.DepartmentType;
import Customer.DiscountType;
import Customer.Job;
import Customer.Status;
import Customer.Task;
import Staff.Staff;
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
    static final String PASS = "";

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
     *
     * @param query Query which will be submitted
     * @return Returns true if the query was successful
     */
    @Override
    public boolean storeData(String query) {

        try {

            Statement st = connection.createStatement();
            st.execute(query);
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
     * Creates a new staff member
     * @param staff Staff object that will be inserted
     * @return Returns true if the staff data has been successfully inserted and false otherwise.
     */
    public boolean createStaff(Staff staff)
    {
        String query = String.format("INSERT INTO `staff` "
                + "(role, firstName, lastName, emailAddress, phonenumber, password) VALUES(" 
                + "'%d', '%s', '%s', '%s', '%s', '%s')", 
                staff.getRole(), staff.getFirstName(), staff.getLastName(), staff.getAddress(), staff.getPhone(), staff.getPassword());
        return storeData(query);
    }
    
    /**
     * UNDER CONSTRUCTION!
     * Creates a new job
     * 
     * @param job Job object that will be inserted
     * @return Returns true if the job data has been successfully inserted.
     */
    public boolean createJob(Job job) {
        String query = String.format("INSERT INTO `jobs` "
                + "(code, ownerNo, staffNo, invoiceNo, shelf, status, "
                + "priority, discountRate, price, specialInstructions) VALUES(" 
                + "'%s','%d', '%d', '%d', '%s', '%d', '%d', '%f', '%f', '%s')", 
                job.getCode(), job.getCustomerId(), job.getStaffCode(), job.getInvoiceNo(), 
                job.getShelf(), job.getStatus(), job.getPriority(), job.getDiscountRate(), 
                job.getPrice(), job.getSpecialInstructions());
        
        for(Task task : job.getTasks())
        {
            addTask(job.getCode(), task);
        }
        
        return storeData(query);
    }
    
    private boolean addTask(String jobCode, Task task) {
        String query = String.format("INSERT INTO `tasks` "
                + "(jobCode, status, price, description, shelfSlot, department, discountRate) "
                + "VALUES('%s, '%i', '%d', '%s', '%s', '%i', '%f')",
                jobCode, task.getStatus().ordinal(), task.getPrice(), task.getDescription(), 
                task.getShelfSlot(), task.getDepartment().ordinal(), task.getDiscountRate());
        
        return storeData(query);
    }
    
    /**
     * Creates a new customer
     * @param customer Customer object that will be inserted
     * @return Returns true if the job data has been successfully inserted and false otherwise.
     */
    public boolean createCustomer(Customer customer){
        String query = String.format("INSERT INTO `customers` "
                + "(holderName, firstName, lastName, isValued, isSuspended, "
                + "isDefault, address, phoneNo, discountType, emailAddress, debtRemindedAmount) VALUES(" 
                + "'%s', '%s', '%s', '%d', '%d', "
                + "'%d', '%s', '%s', '%d', '%s', '%d')", 
                customer.getHolderName(), customer.getFirstName(), customer.getLastName(), 
                customer.isValued() ? 1 : 0,
                customer.isSuspended() ? 1 : 0,
                customer.isDefault() ? 1 : 0,
                customer.getAddress(), customer.getPhoneNumber(), 0, customer.getEmailAddress(), customer.getDebtReminded());
        
        return storeData(query);
    }
    
    /**
     * Updates a customer
     *
     * @param customer Customer object that will be updated
     * @return Returns true if customer data has been successfully updated.
     */
    public boolean updateCustomer(Customer customer) {
        String query = String.format("UPDATE `customers` SET" +
            " `isValued` = '%b'," +
            " `isSuspended` = '%b'," +
            " `isDefault` = '%b'," +
            " `discountType` = '%i'," +
            " `debtRemindedAmount` = '%i'" +
            " WHERE `accountNo` = '%i'", 
            customer.isValued() ? 1 : 0,
            customer.isSuspended() ? 1 : 0,
            customer.isDefault() ? 1 : 0,
            customer.getDebtReminded(),
            customer.getAccountNo());
        
        return storeData(query);
    }

    /**
     * Checks whether or not the credentials are valid
     *
     * @param email Email
     * @param password Password
     * @return Returns true if credentials are valid. Returns false if either
     * credentials are invalid or there is an issue with the database.
     */
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
     *
     * @return Array list of customers
     */
    public ArrayList<Customer> getCustomers() {
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

        } catch (SQLException ex) {

            Logger.getLogger(DBConnectivity.class.getName()).log(Level.SEVERE, null, ex);

        }

        return customers;
    }

    /**
     * Retrieves jobs of a customer
     *
     * @param customerNo Customer's number whose jobs will be retrieved
     * @return Array list of jobs
     */
    private ArrayList<Job> getJobs(int customerNo) {

        ArrayList<Job> jobs = new ArrayList<Job>();

        try {

            ResultSet result = retrieveData(String.format("SELECT * FROM `jobs` WHERE ownerNo = \"%s\"", customerNo));

            while (result.next()) {

                jobs.add(new Job(
                        result.getInt("invoiceNo"),
                        result.getString("code"),
                        result.getInt("staffNo"),
                        getTasks(result.getString("code")),
                        result.getDouble("price"),
                        result.getFloat("discountRate"),
                        result.getInt("ownerNo"),
                        result.getString("specialInstructions"),
                        result.getString("shelf"),
                        result.getInt("priority")
                ));

            }

        } catch (SQLException ex) {

            Logger.getLogger(DBConnectivity.class.getName()).log(Level.SEVERE, null, ex);

        }

        return jobs;
    }

    /**
     * Fetches all tasks that match a specific job code.
     *
     * @param jobCode All tasks that belong to the job of this code will be
     * retrieved.
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
