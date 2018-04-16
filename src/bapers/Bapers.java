/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bapers;

import GUI.LoginView;
import Administrator.*;
import Staff.Staff;

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
     * Reusable login window through which the user logs in.
     */
    public static LoginView loginView;
    
    public static Staff getUser()
    {
        return DB.loggedUser;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SetWindowsLook();
        
        DB = new DBConnectivity();
        
        if (DB.connect())
        {
            loginView = new LoginView();
            loginView.setVisible(true);       
        }
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