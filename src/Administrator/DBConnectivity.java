package Administrator;

import Customer.Customer;
import Customer.DepartmentType;
import Customer.DiscountType;
import Customer.Job;
import Customer.Status;
import Customer.Task;
import Payment.Invoice;
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

    /**
     * Stores info about a logged user
     */
    public Staff loggedUser = null;
    
    /**
     * Returns a currently active connection
     * 
     * @return Connection object
     */
    public Connection getConnection() {
        return connection;
    }
    
    /**
     * Returns true if there is an active connection
     * @return true if connection is active
     */
    public boolean isConnected() {
        return connection != null;
    }
    
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
    
    /**
     * Updates customer's discount plan
     * @param customerID Account number of a customer whose discount plan will be affected
     * @param discountType new type of discount
     * @param discountRate new discount rate
     * @return true if updating customer discount was successful
     */
    public boolean updateCustomerDiscount(int customerID, int discountType, int discountRate){
        String query = String.format("UPDATE `customers` SET `discountType` = '%d', `discountRate` = '%d' WHERE `accountNo` = '%d'", discountType, discountRate, customerID);
        return storeData(query);
    }
    
    /**
     * Updates a reminder
     * @param reminder reminder object
     * @return true if reminder was successfully updated
     */
    public boolean updateReminder(Reminder reminder){
        String query = String.format("UPDATE `reminders` SET `timesReminded` = '%d', `isRead` = '%d' WHERE `id` = '%d'", reminder.getTimesReminded(), reminder.isRead() ? 1 : 0, reminder.getID());
        return storeData(query);
    }
    
    /**
     * Updates customer account type
     * @param customerID Account number of a customer which will be affected
     * @param isValued Whether or not the customer is now valued
     * @param isSuspended Whether or not the customer is suspended
     * @param isInDefault Whether or not the customer is in default
     * @return true if updating data was successful
     */
    public boolean updateCustomerAccountType(int customerID, boolean isValued, boolean isSuspended, boolean isInDefault){
        String query = String.format("UPDATE `customers` SET `isValued` = '%d', `isSuspended` = '%d', `isDefault` = '%d' WHERE `accountNo` = '%d'", 
                (isValued) ? 1 : 0, 
                (isSuspended) ? 1 : 0, 
                (isInDefault) ? 1 : 0, 
                customerID);
        
        return storeData(query);
    }
    
    public boolean deleteCustomer(Customer customer)
    {
        String query = String.format("DELETE FROM `customers` WHERE `accountNo`='%s'", customer.getAccountNo());
        
        return storeData(query);
    }
    
    /**
     * Updates card details
     * @param customerID Account number of a customer which will be affected
     * @param cardType Card type
     * @param last4Digit Last 4 digits of a card
     * @param monthExpiry Month expiry of the card
     * @param yearExpiry Year expiry of the card
     * @param cardDetailsId Id of card details
     * @return true if data was successfully updated
     */
    public boolean insertCard(int customerID, String cardType, int last4Digit, int monthExpiry, int yearExpiry, int cardDetailsId){
        String query = String.format("INSERT INTO `carddetails` "
                + "(cardType, last4Digits, monthExpiry, yearExpiry, ownerAccountNo, cardDetailsId) VALUES(" 
                + "'%s', '%d', '%d', '%d', '%d', '%d')", 
                cardType, last4Digit, monthExpiry, yearExpiry, customerID, cardDetailsId);
        
        return storeData(query);
    }
    
    /**
     * Updates card type of a customer
     * @param customerID Account number of a customer which will be updated
     * @param cardType Card type
     * @param last4Digit Last 4 digits of a card
     * @param monthExpiry Month expiry of the card
     * @param yearExpiry Year expiry of the card
     * @param cardDetailsId Id of card details
     * @return true if data was successfully updated
     */
    public boolean updateCard(int customerID, String cardType, int last4Digit, int monthExpiry, int yearExpiry, int cardDetailsId){
        String query = String.format("UPDATE `carddetails` SET `cardType` = '%s', "
                + "`last4Digits` = '%d', "
                + "`monthExpiry` = '%d', "
                + "`yearExpiry` = '%d', "
                + "`cardDetailsId` = '%d' "
                + "WHERE `ownerAccountNo` = '%d'",
                cardType,
                last4Digit,
                monthExpiry,
                yearExpiry,
                cardDetailsId,
                customerID);
        
        return storeData(query);
    }
    
    /**
     * Returns last 4 digits of a card of a customer
     * @param customerID Customer number
     * @return integer representing last 4 digits of a card
     */
    public int last4Digit(int customerID){
        try {
            ResultSet result = retrieveData(String.format("SELECT last4Digits FROM `carddetails` WHERE ownerAccountNo = '%d'", customerID));
            if(result.next())
                return result.getInt("last4Digits");
            else
                return 0;        
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectivity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    /**
     * Removes the card from the database
     * @param customerID account number of a customer whose card details will be removed
     * @return true if data was successfully updated
     */
    public boolean deleteCard(int customerID) {
        String query = String.format("DELETE FROM `carddetails` WHERE ownerAccountNo = '%d' ", customerID);
        return storeData(query);
    }
    
    /**
     * Checks whether customer's card details are present
     * @param customerID account number of a customer to check
     * @return true if card is inserted of a customer
     */
    public boolean isCardInserted(int customerID) {
        try {
            ResultSet result = retrieveData(String.format("SELECT * FROM `carddetails` WHERE ownerAccountNo = '%d'", customerID));
            if(result.next())
                return true;
            else
                return false;        
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectivity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    /**
     * Creates a new staff member
     * @param staff Staff object that will be inserted
     * @param password
     * @return Returns true if the staff data has been successfully inserted and false otherwise.
     */
    public boolean createStaff(Staff staff, String password)
    {
        String query = String.format("INSERT INTO `staff` "
                + "(role, departmentRole, firstName, lastName, username, password) VALUES(" 
                + "'%s', '%s', '%s', '%s', '%s', '%s')", 
                staff.getRole().ordinal(), staff.isAssigned() ? staff.getDepartment().ordinal() : "-1", staff.getFirstName(), staff.getLastName(), staff.getUsername(), password);
        
        return storeData(query);
    }
    
    /**
     * Creates a new job
     * 
     * @param job Job object that will be inserted
     * @return Returns true if the job data has been successfully inserted.
     */
    public boolean createJob(Job job) {
        
        String query = String.format("INSERT INTO `jobs` "
                + "(`code`, `ownerNo`, `staffNo`, `invoiceNo`, `shelf`, `status`, "
                + "`priority`, `discountRate`, `price`, `specialInstructions`, `dateCreated`) VALUES(" 
                + "'%s','%s', '%s', null, '%s', '%s', '%s', '%s', '%s', '%s', '%s')", 
                job.getCode(), job.getCustomerId(), job.getStaffCode(), 
                job.getShelf(), job.getStatus(), job.getPriority(), job.getDiscountRate(), 
                job.getPrice(), job.getSpecialInstructions(), job.getDateCreated());

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
        
        return false;
    }
    
    private int createInvoice(int customerNo, double subTotal, float discountRate)
    {
        String query = String.format("INSERT INTO bloomsday.invoices "
                + "(`customerNo`, `subTotal`, `discountRate`) "
                + "VALUES (%s, %s, %s)",
                customerNo, subTotal, discountRate
            );
        
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
    
    public ArrayList<Invoice> getInvoices(int customerNo)
    {
        ArrayList<Invoice> invoices = new ArrayList<>();
        
        String query = String.format("select * from `invoices` WHERE invoices.`customerNo` = '%s'",
                customerNo
                );
        
        ResultSet result = retrieveData(query);
                        
        try {
            while (result.next()) {
                
                invoices.add(new Invoice(
                        result.getInt("invoiceNo"),
                        result.getDouble("subTotal"),
                        result.getFloat("discountRate"),
                        result.getFloat("vatRate"),
                        result.getDate("dateCreated"),
                        result.getDate("datePaid")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectivity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return invoices;
    }
    
    public boolean markInvoicePaid(int invoiceNo)
    {
        String query = String.format("UPDATE `invoices` "
                + "SET datePaid = CURRENT_TIMESTAMP(), isPaid = '1' "
                + "WHERE `invoiceNo`=%s",
                    invoiceNo
                );
        
        return storeData(query);
    }
    
    public Invoice generateInvoiceForJobs(Customer customer)
    {
        ArrayList<Job> unpaidJobs = getUnpaidJobs(customer.getAccountNo());
        double subTotal = 0.00;
        float discountRate = customer.getDiscountValue();
        
        if (unpaidJobs.size() == 0) return null;
        
        for (Job job : unpaidJobs)
        {
            subTotal += job.getPrice();
        }
        
        int invoiceNo = createInvoice(customer.getAccountNo(), subTotal, discountRate);
        
        for (Job job : unpaidJobs)
        {
            job.setInvoiceNo(invoiceNo);
            
            String query = String.format("UPDATE `jobs` SET `invoiceNo` = '%s' WHERE `code`='%s'",
                invoiceNo, job.getCode()
            );
            
            storeData(query);
        }
        
        return new Invoice(invoiceNo, subTotal, discountRate, 20f, new java.util.Date(), null);
    }
    
    private boolean addTask(String jobCode, Task task) {
        String query = String.format("INSERT INTO `tasks` "
                + "(`jobCode`, `status`, `price`, `description`, `department`, `discountRate`) "
                + "VALUES('%s', '%d', '%,.2f', '%s', '%d', '%f')",
                jobCode, task.getStatus().ordinal(), task.getPrice(), task.getDescription(), 
                task.getDepartment().ordinal(), task.getDiscountRate());
        
        return storeData(query);
    }
        
    /**
     * Deletes task from the database
     * @param task Task object which will be deleted
     * @return true if task was successfully deleted
     */
    public boolean deleteTask(Task task) {
        String query = String.format("DELETE FROM `tasks` WHERE `taskID` = '%s'", task.getId());
        
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
     * Updates task
     * @param task task object
     * @return true if task was successfully updated
     */
    public boolean updateTask(Task task) {
        String query = String.format("UPDATE `tasks` SET "
                + "`description` = '%s', " +
                "`status` = '%d', "
                + "`department` = '%s', "
                + "`assigneeId` = '%s', "
                + "`startTime` = %s, "
                + "`endTime` = %s "
                + "WHERE `taskID` = '%s' "
                + "AND `jobCode` = '%s'",
                task.getDescription(),
                task.getStatus().ordinal(),
                task.getDepartment().ordinal(),
                task.getAssigneeId(),
                task.getStartTime() != null ? "'" + task.getStartTime() + "'" : "NULL",
                task.getEndTime() != null ? "'" + task.getEndTime() + "'" : "NULL",
                task.getId(),
                task.getJobCode()
        );
        
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
            "`isValued` = '%s', " +
            "`isSuspended` = '%s', " +
            "`isDefault` = '%s', " +
            "`holderName` = '%s', " +
            "`firstName` = '%s', " +
            "`lastName` = '%s', " +
            "`emailAddress` = '%s', " +
            "`address` = '%s', " +
            "`phoneNo` = '%s' " +
            "WHERE `accountNo` = '%s'", 
            customer.isValued() ? 1 : 0,
            customer.isSuspended() ? 1 : 0,
            customer.isDefault() ? 1 : 0,
            customer.getHolderName(),
            customer.getFirstName(),
            customer.getLastName(),
            customer.getEmailAddress(),
            customer.getAddress(),
            customer.getPhoneNumber(),
            customer.getAccountNo()
        );
        
        return storeData(query);
    }
    
    public boolean reactivateCustomerAccount(int customerNo)
    {
        String query = String.format("UPDATE `customers` SET `isDefault`='0' WHERE `accountNo`='%s'",
                customerNo
        );
        return storeData(query);
    }
    
    /**
     * Checks whether or not the credentials are valid
     *
     * @param username Username of the user
     * @param password User's password
     * @return Returns true if credentials are valid. Returns false if either
     * credentials are invalid or there is an issue with the database.
     */
    public Staff validateLogin(String username, String password) {

        ResultSet result = retrieveData(String.format("SELECT * FROM `staff` WHERE username = '%s' AND password = '%s'", username, password));

        try {
            if(result.next()){
                int staffID = result.getInt("staffNo");
                Role role = Role.values()[result.getInt("role")];
                String firstName = result.getString("firstName");
                String lastName = result.getString("lastName");
                int departmentIndex = result.getInt("departmentRole");
                
                switch (role) {
                    case OfficeManager:
                    {
                        loggedUser = new OfficeManager(staffID, username, firstName, lastName);
                        break;
                    }
                    case ShiftManager:
                    {
                        loggedUser = new ShiftManager(staffID, username, firstName, lastName);
                        break;                    
                    }
                    case Technician:
                    {
                        loggedUser = new Technician(staffID, username, firstName, lastName);
                        break;                    
                    }
                    case Receptionist:
                    {
                        loggedUser = new Receptionist(staffID, username, firstName, lastName);
                        break;                    
                    }
                    default:
                        break;
                }
                
                if (departmentIndex >= 0)
                {
                    DepartmentType department = DepartmentType.values()[departmentIndex];
                    loggedUser.setDepartment(department);
                }
                else
                {
                    loggedUser.setDepartment(null);
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
                        result.getInt("discountRate"),
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
    public ArrayList<Customer> searchCustomers(String accountNo, String holderName, String firstName, String lastName, String phoneNumber, String email, boolean showDefaultOnly) {
        
        ArrayList<Customer> customers = new ArrayList<Customer>();
        
        try {
            
            String query = String.format("SELECT * FROM `customers` "
                    + "WHERE ('%1$s'='' or `accountNo` like '%1$s%%') "
                    + "AND ('%2$s'='' or `holderName` like '%2$s%%') "
                    + "AND ('%3$s'='' or `firstName` like '%3$s%%') "
                    + "AND ('%4$s'='' or `lastName` like '%4$s%%') "
                    + "AND ('%5$s'='' or `phoneNo` like '%5$s%%') "
                    + "AND ('%6$s'='' or `emailAddress` like '%6$s%%')"
                    + "AND ('%7$s'='' or `isDefault`='%7$s')",
                    accountNo.trim(),
                    holderName.trim(),
                    firstName.trim(),
                    lastName.trim(),
                    phoneNumber.trim(),
                    email.trim(),
                    showDefaultOnly ? 1 : "");
            
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
                        result.getInt("discountRate"),
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
    
    private ArrayList<Job> getUnpaidJobs(int customerNo)
    {
       ArrayList<Job> jobs = new ArrayList<Job>();

        try {

            ResultSet result = retrieveData(String.format("SELECT * FROM `jobs` WHERE ownerNo = \"%s\" AND invoiceNo IS NULL", customerNo));

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
                        result.getInt("priority"),
                        result.getTimestamp("dateCreated")
                ));

            }

        } catch (SQLException ex) {

            Logger.getLogger(DBConnectivity.class.getName()).log(Level.SEVERE, null, ex);

        }

        return jobs;
    }
    
    public ArrayList<Job> getJobsByInvoice(int invoiceNo)
    {
        ArrayList<Job> jobs = new ArrayList<Job>();
        
        try {

            ResultSet result = retrieveData(String.format("SELECT * FROM `jobs` WHERE `invoiceNo` = \"%s\"", invoiceNo));

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
                        result.getInt("priority"),
                        result.getTimestamp("dateCreated")
                ));

            }

        } catch (SQLException ex) {

            Logger.getLogger(DBConnectivity.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        return jobs;
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
                        result.getInt("priority"),
                        result.getTimestamp("dateCreated")
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
                        result.getInt("assigneeId"),
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
     * Searches for tasks that match or begin with supplied parameters. Returns all entries if all parameters are empty/null
     * @param jobCode Job code that is associated with this task
     * @param status Current status of a task
     * @param department Department to which this task belongs to
     * @return Array List of tasks that match parameters supplied
     */
    public ArrayList<Task> searchTasks(String jobCode, Status status, DepartmentType department) {

        ArrayList<Task> tasks = new ArrayList<Task>();

        try {

            String query = String.format("SELECT * FROM `tasks` INNER JOIN `jobs` ON tasks.jobCode = jobs.code "
                    + "WHERE ('%1$s'='' or tasks.jobCode like '%1$s%%') "
                    + "AND ('%2$s'='' or department='%2$s') "
                    + "AND ('%3$s'='' or tasks.status='%3$s')",
                    jobCode.trim(), 
                    department != null ? department.ordinal() : "",
                    status != null ? status.ordinal() : ""
            );
            
            ResultSet result = retrieveData(query);

            while (result.next()) {
                tasks.add(new Task(
                        result.getString("jobCode"),
                        result.getInt("taskID"),
                        result.getInt("assigneeId"),
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
     * Searches for staff that match or begin with supplied parameters. Returns all entries if all parameters are empty/null
     * @param accountNo Staff account number
     * @param firstName First name of staff
     * @param lastName Last name of the staff
     * @param staffRole Staff role
     * @return Array List of staff that match parameters supplied
     */
    public ArrayList<Staff> searchStaff(int accountNo, String firstName, String lastName, Role staffRole)
    {
        ArrayList<Staff> staff = new ArrayList<Staff>();
        
        String query = String.format("SELECT * FROM `staff` "
            + "WHERE ('%1$s'='' or `staffNo` like '%1$s%%') "
            + "AND ('%2$s'='' or `firstName` like '%2$s%%') "
            + "AND ('%3$s'='' or `lastName` like '%3$s%%') "
            + "AND ('%4$s'='' or `role`='%4$s') ",
            accountNo != -1 ? accountNo : "", 
            firstName.trim(), 
            lastName.trim(), 
            staffRole != null ? staffRole.ordinal() : ""
        );
            
        ResultSet result = retrieveData(query);
        
        try {
            while (result.next()) {
                
                staff.add(new Staff(
                    result.getInt("staffNo"),
                    Role.values()[result.getInt("role")],
                    result.getString("username"),
                    result.getString("firstName"),
                    result.getString("lastName")
                ));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnectivity.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return staff;
    }

    /**
     * Gets all reminders of a currently logged user
     * @return Array List of reminders
     */
    public ArrayList<Reminder> getReminders() {
        ArrayList<Reminder> reminders = new ArrayList<Reminder>();
        try {
            String query = String.format("SELECT * FROM `reminders` "
                    + "WHERE `receiveNo`='%s' AND `isRead` = '0' ORDER BY receiveTime DESC",
                    loggedUser.getAccountNo());

            ResultSet result = retrieveData(query);

            while (result.next()) {
                reminders.add(new Reminder(
                        result.getInt("id"),
                        result.getString("subject"),
                        result.getString("message"),
                        result.getInt("receiveNo"),
                        result.getTimestamp("receiveTime"),
                        result.getInt("timesReminded"),
                        result.getBoolean("isRead")
                ));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnectivity.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reminders;
    }
}