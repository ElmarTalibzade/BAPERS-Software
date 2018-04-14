/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;
import Administrator.DBConnectivity;
import static bapers.Bapers.DB;
import bapers.Utils;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.*;

/**
 * Responsible for generating reports
 * @author Elmar Talibzade
 */
public class ReportWizard 
{
    private final String IndividualPerformanceReport_location_xml = "/Reports/IndividualPerformanceReport.jrxml";
    private final String IndividualPerformanceReport_location_jasper = "/Reports/IndividualPerformanceReport.jasper";
    
    public static void main(String[] args) {
        Date begin = null;
        
        DB = new DBConnectivity();
        DB.connect();
        
        try {
            begin = new Date(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2017").getTime());
        } catch (ParseException ex) {
            Logger.getLogger(ReportWizard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Date end = java.sql.Date.valueOf(LocalDate.now());
        
        GenerateIndividualPerformanceReport(begin, end);
    }
    
    public static String GenerateIndividualPerformanceReport(Date period_start, Date period_end)
    {
        if (!DB.isConnected()) return null;
        
        String employeeName = "Default User";
        String employeeRole = "Default Role";
        employeeName = DB.loggedUser.getFirstName() + " " + DB.loggedUser.getLastName();
        employeeRole = Utils.splitCamelCase(DB.loggedUser.getRole().toString());
        
        HashMap params = new HashMap();
        params.put("EMPLOYEE_NAME", employeeName);
        params.put("EMPLOYEE_ROLE", employeeRole);
        params.put("DATE_START", period_start);
        params.put("DATE_END", period_end);
        
        String jasperPath = System.getProperty("user.dir") + "\\Reports\\IndividualPerformanceReport.jasper";
        String pdfPath = System.getProperty("user.dir") + "\\Generated Reports\\Individual Performance Report " + LocalDate.now().toString() + ".pdf";
        
        try {
            
            JasperPrint jprint = (JasperPrint)JasperFillManager.fillReport(jasperPath, params, DB.getConnection());
            JasperExportManager.exportReportToPdfFile(jprint, pdfPath);
            
            return pdfPath;
            
        } catch (JRException ex) {
            
            Logger.getLogger(ReportWizard.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return null;
    }
    
    public static void OpenPDF(String filePath)
    {
        try 
        {
            File file = new File(filePath);

            if (file.toString().endsWith(".pdf")) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + file);
            }
            else {
                Desktop desktop = Desktop.getDesktop();    
                desktop.open(file);
            }
        }
        catch (IOException ex)
        {
            Logger.getLogger(ReportWizard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}