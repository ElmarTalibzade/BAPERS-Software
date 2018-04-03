package Administrator;

import Customer.Customer;
import Customer.DepartmentType;
import Customer.DiscountType;
import Customer.Job;
import Customer.Status;
import Customer.Task;
import Staff.*;
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

    public Staff loggedUser = null;
    
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
     * @param password
     * @return Returns true if the staff data has been successfully inserted and false otherwise.
     */
    public boolean createStaff(Staff staff, String password)
    {
        String query = String.format("INSERT INTO `staff` "
                + "(role, firstName, lastName, emailAddress, phonenumber, password) VALUES(" 
                + "'%s', '%s', '%s', '%s', '%s', '%s')", 
                staff.getRole().ordinal(), staff.getFirstName(), 
                staff.getLastName(), staff.getAddress(), 
                staff.getPhone(), password);
        
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
        
        int newInvoiceNo = createInvoice(job.getPrice());
        
        if (newInvoiceNo > -1)
        {
            String query = String.format("INSERT INTO `jobs` "
                    + "(`code`, `ownerNo`, `staffNo`, `invoiceNo`, `shelf`, `status`, "
                    + "`priority`, `discountRate`, `price`, `specialInstructions`) VALUES(" 
                    + "'%s','%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')", 
                    job.getCode(), job.getCustomerId(), job.getStaffCode(), newInvoiceNo, 
                    job.getShelf(), job.getStatus(), job.getPriority(), job.getDiscountRate(), 
                    job.getPrice(), job.getSpecialInstructions());

            if (storeData(query))
            {
                for(Task task : job.getTasks())
                {
                    if (!addTask(job.getCode(), task))
                    {
                        return false;
                    }
                }

                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
    
    private int createInvoice(double totalAmount)
    {
        String query = "INSERT INTO `invoice` (`totalAmount`) VALUES('" + totalAmount + "')";
        
        try 
        {
            if (storeData(query))
            {
                ResultSet res = retrieveData("SELECT LAST_INSERT_ID()");
                if (res != null)
                {
                    res.next();
                    return res.getInt(1);
                }
                else
                {
                    return -1;
                }
            }

            return -1;
        }
        catch (SQLException ex)
        {
            Logger.getLogger(DBConnectivity.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    private boolean addTask(String jobCode, Task task) {
        String query = String.format("INSERT INTO `tasks` "
                + "(`jobCode`, `status`, `price`, `description`, `shelfSlot`, `department`, `discountRate`) "
                + "VALUES('%s', '%d', '%,.2f', '%s', '%s', '%d', '%f')",
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
    
    public boolean updateTask(Task task) {
        String query = String.format("UPDATE `tasks` SET "
                + "`description` = '%s', " +
                "`status` = '%d', "
                + "`department` = '%d' "
                + "WHERE `taskID` = '%d' "
                + "AND `jobCode` = '%s'",
                task.getDescription(),
                task.getStatus().ordinal(),
                task.getDepartment().ordinal(),
                task.getId(),
                task.getJobCode());
        
        return storeData(query);
    }
    
    /**
     * Updates a customer
     *
     * @param customer Customer object that will be updated
     * @return Returns true if customer data has been successfully updated.
     */
    public boolean updateCustomer(Customer customer) {
        String query = String.format("UPDATE `customers` SET " +
            "`isValued` = '%b', " +
            "`isSuspended` = '%b', " +
            "`isDefault` = '%b', " +
            "`discountType` = '%i', " +
            "`debtRemindedAmount` = '%i' " +
            "WHERE `accountNo` = '%i' ", 
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
    public Staff validateLogin(String email, String password) {

        ResultSet result = retrieveData(String.format("SELECT * FROM `staff` WHERE emailAddress = '%s' AND password = '%s'", email, password));

        try {
            if(result.next()){
                int staffID = result.getInt("staffNo");
                Role role = Role.values()[result.getInt("role")];
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                String emailAddress = result.getString("emailAddress");
                String phoneNumber = result.getString("phoneNumber");
                
                switch (role) {
                    case OfficeManager:
                    {
                        loggedUser = new OfficeManager(staffID, firstName, lastName, emailAddress, phoneNumber);
                        break;
                    }
                    case ShiftManager:
                    {
                        loggedUser = new ShiftManager(staffID, firstName, lastName, emailAddress, phoneNumber);
                        break;                    
                    }
                    case Technician:
                    {
                        loggedUser = new Technician(staffID, firstName, lastName, emailAddress, phoneNumber);
                        break;                    
                    }
                    case Receptionist:
                    {
                        loggedUser = new Receptionist(staffID, firstName, lastName, emailAddress, phoneNumber);
                        break;                    
                    }
                    default:
                        break;
                }
                return loggedUser;
            }
        } catch (SQLException ex) {

            Logger.getLogger(DBConnectivity.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
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
     * Returns the list of all customers from the database if match passed values.
     * @param accountNo Customer's account number
     * @param holderName Customer's holder name
     * @param firstName Customer's first name
     * @param lastName Customer's last name
     * @param phoneNumber Customer's phone number
     * @param email Customer's email address
     * @param showDefaultOnly Whether or not we want only customers who are in default.
     * @return An array list of customers that match entries. If all values are empty, all entries are returned instead.
     */
    public ArrayList<Customer> getCustomers(String accountNo, String holderName, String firstName, String lastName, String phoneNumber, String email, boolean showDefaultOnly) {
        
        ArrayList<Customer> customers = new ArrayList<Customer>();
        
        try {
            
            String query = String.format("SELECT * FROM `customers` "
                    + "WHERE ('%1$s'='' or `accountNo`='%1$s') "
                    + "AND ('%2$s'='' or `holderName`='%2$s') "
                    + "AND ('%3$s'='' or `firstName`='%3$s') "
                    + "AND ('%4$s'='' or `lastName`='%4$s') "
                    + "AND ('%5$s'='' or `phoneNo`='%5$s') "
                    + "AND ('%6$s'='' or `emailAddress`='%6$s')"
                    + "AND ('%7$x'='9' or `isDefault`='%7$x')",
                    accountNo.trim(),
                    holderName.trim(),
                    firstName.trim(),
                    lastName.trim(),
                    phoneNumber.trim(),
                    email.trim(),
                    (showDefaultOnly) ? 1 : 9);
            
            ResultSet result = retrieveData(query);
           
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
    public ArrayList<Job> getJobs(int customerNo) {

        ArrayList<Job> jobs = new ArrayList<Job>();

        try {

            ResultSet result = retrieveData(String.format("SELECT * FROM `jobs` WHERE ownerNo = \"%s\"", customerNo));

            while (result.next()) {

                jobs.add(new Job(
                        result.getInt("invoiceNo"),
                        result.getString("code"),
                        result.getInt("staffNo"),
                        getTasks(result.getString("code")),
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
                        jobCode,
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
    
    private ArrayList<Task> getTasks(String jobCode, int departmentIndex) {

        ArrayList<Task> tasks = new ArrayList<Task>();

        try {

            String query = String.format("SELECT * FROM `tasks` "
                    + "WHERE ('%1$s'='' or `jobCode`='%1$s') "
                    + "AND ('%2$x'='9' or `department`='%2$x')",
                    jobCode.trim(), departmentIndex);
            
            ResultSet result = retrieveData(query);

            while (result.next()) {
                tasks.add(new Task(
                        jobCode,
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
    
    /**
     * Gets a list of jobs as well as their tasks
     * @param jobCode Job's code
     * @param status Job's current status
     * @param shelfNo Job's shelf number
     * @param departmentIndex Index that represents the department of a job
     * @return An array list of jobs that match entries. If all values are empty, all entries are returned instead.
     */
    public ArrayList<Job> getJobs(String jobCode, int status, String shelfNo, int departmentIndex)
    {
        ArrayList<Job> jobs = new ArrayList<Job>();
        
        try {
            
            String query = String.format("SELECT * FROM `jobs` "
                    + "WHERE ('%1$s'='' or `code`='%1$s') "
                    + "AND ('%2$x'='9' or `status`='%2$x') "
                    + "AND ('%3$s'='' or `shelf`='%3$s')",
                    jobCode.trim(), status, shelfNo.trim()
                    );
            
            ResultSet result = retrieveData(query);

            while (result.next()) {

                jobs.add(new Job(
                        result.getInt("invoiceNo"),
                        result.getString("code"),
                        result.getInt("staffNo"),
                        getTasks(result.getString("code"), departmentIndex),
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
    }