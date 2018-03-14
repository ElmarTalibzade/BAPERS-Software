/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

/**
 * Used to generate reports at a specific frequency.
 * @author Elmar Talibzade
 */
public class ReportManager {
    private int reportGenMinute;
    private int reportGenHour;
    private int reportGenDay;
    private int reportGenWeek;
    private int reportGenMonth;
    private int reportGenYear;
    
    private Report[] reports;
    
    /**
     * Constructor for ReportManager
     */
    public ReportManager()
    {
        
    }
    
    /**
     * Generates the reports
     */
    public void generateReports()
    {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    /**
     * Returns all reports
     * @return List of reports
     */
    public Report[] getReports()
    {
        return reports;
    }
    
    /**
     * Sets the frequency of the report generation
     * @param min Minute
     * @param h Hour
     * @param d Day
     * @param w Week
     * @param m Month
     * @param y Year
     */
    public void setFrequency(int min, int h, int d, int w, int m, int y)
    {
        reportGenMinute = min;
        reportGenHour = h;
        reportGenDay = d;
        reportGenWeek = w;
        reportGenMonth = m;
        reportGenYear = y;
    }
}