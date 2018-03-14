/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import Customer.Task;
import java.sql.Date;
import java.sql.Time;

/**
 * Used to generate Summary Performance Report
 * @author Elmar Talibzade
 */
public class SummaryPerformanceReport extends Report {
    private DateReport[] dayShift;
    private DateReport[] dayShift2;
    private DateReport[] nightShift;
    
    private Date startDate;
    private Date endDate;
    
    /**
     * Constructor for SummaryPerformanceReport
     * @param tasks List of tasks
     * @param startDate Starting date of the report
     * @param endDate Ending date of the report
     */
    public SummaryPerformanceReport(Task[] tasks, Date startDate, Date endDate)
    {
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    /**
     * Calculates the total shift time
     * @return Sum of total time
     */
    public Time getTotalShiftTime()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Gets department's total time
     * @param department Department whose total time will be get
     * @return Time
     */
    public Time getDepartmentTime(DepartmentReport department)
    {
        return department.getTotalTime();
    }   

    @Override
    public void generateReport() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}