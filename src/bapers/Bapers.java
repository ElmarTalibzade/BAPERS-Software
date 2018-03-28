/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bapers;

import GUI.LoginView;
import GUI.StaffView;
import Administrator.*;
import GUI.*;
import javax.swing.UIManager;
/**
 * Main class for running BAPERS software.
 *
 * @author Elmar Talibzade
 */
public class Bapers {

    /**
     * Sole connection to the database, which processes all statements and queries.
     */
    public static DBConnectivity DB;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SetWindowsLook();
        
        DB = new DBConnectivity();
        
        if (DB.connect() ){
            /* Mihai testing
            -- DB createCustomer()
            Customer customer = new Customer(1, "Holder Name", "Simon", "Peterson", false, false, false, "1st Avenue of New York", "0711 112 1124", null, "simon.peterson@yahoo.com", 0, null);
            DB.createCustomer(customer);
            */          
        }
        
        
        StaffView staffView = new StaffView();
        staffView.tabbedContent.addTab("Create Staff", new CreateStaffPanel());
        staffView.tabbedContent.addTab("Backups", new BackupsPanel());
        staffView.tabbedContent.addTab("Staff Browser", new StaffBrowserPanel());
        staffView.tabbedContent.addTab("Job Browser", new JobBrowserPanel());
        staffView.tabbedContent.addTab("Customer Browser", new CustomerBrowserPanel());
        staffView.tabbedContent.addTab("Customer Profile", new CustomerProfilePanel());
        staffView.tabbedContent.addTab("Receptionists", new ReceptionistBrowserPanel());
        staffView.tabbedContent.addTab("Create Customer", new CreateCustomerPanel());
        staffView.setVisible(true);
    }
    
    private static void SetWindowsLook()
    {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}