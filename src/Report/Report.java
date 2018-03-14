/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import java.sql.Date;

/**
 * A superclass for all type of reports.
 * @author Elmar Talibzade
 */
public abstract class Report {

    /**
     * Date that this report represents
     */
    protected Date date;

    /**
     * Period of this this report represents
     */
    protected Date period;
    
    /**
     * Constructor for Report
     */
    public Report()
    {
        
    }
    
    /**
     * Generates a report
     */
    public abstract void generateReport();
}