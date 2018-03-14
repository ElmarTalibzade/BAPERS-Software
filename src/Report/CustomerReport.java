/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import Customer.Customer;
import Customer.Task;
import java.sql.Time;

/**
 * Represents customer's report.
 * @author Elmar Talibzade
 */
public class CustomerReport extends Report {
    private Customer customer;
    private Task[] tasks;
    
    /**
     * Constructor for a CustomerReport
     * @param customer Customer for which a report would be created
     */
    public CustomerReport(Customer customer)
    {
        this.customer = customer;
    }
    
    /**
     * Calculates the total time that was spent on jobs of this customer
     * @return Total time
     */
    public Time getTotalTime()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void generateReport() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}