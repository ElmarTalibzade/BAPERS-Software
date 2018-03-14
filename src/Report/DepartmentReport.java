/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import Customer.Task;
import java.sql.Time;

/**
 * Stores tasks done by a specific department.
 * @author Elmar Talibzade
 */
public class DepartmentReport {
    private String departmentName;
    private Task[] tasks;
    
    /**
     * Constructor for DepartmentReport
     * @param name Name of the department
     * @param tasks List of tasks that this department has
     */
    public DepartmentReport(String name, Task[] tasks)
    {
        departmentName = name;
        this.tasks = tasks;
    }
    
    /**
     * Gets the name of the department
     * @return String that represents a name of department
     */
    public String getName()
    {
        return departmentName;
    }
    
    /**
     * Calculates the total time spent by this department
     * @return Sum of time spent by this department
     */
    public Time getTotalTime()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
