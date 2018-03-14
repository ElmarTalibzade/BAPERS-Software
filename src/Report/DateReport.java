/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import java.sql.Time;
import java.sql.Date;

/**
 * Stores department data for a specific date.
 * @author Elmar Talibzade
 */
public class DateReport {
    private Date date;
    private DepartmentReport[] departments;
    
    /**
     * Constructor for DateReport
     * @param date Date which this report represents
     * @param departments Departments involved
     */
    public DateReport(Date date, DepartmentReport[] departments)
    {
        this.date = date;
        this.departments = departments;
    }
    
    /**
     * Calculates the total time spent by all departments
     * @return Total effort spent
     */
    public Time getTotalEffort()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
