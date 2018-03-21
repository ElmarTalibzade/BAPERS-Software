/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bapers;

import Administrator.*;
import Customer.Customer;
import Customer.Job;
import Customer.Task;
import GUI.LoginUI;
import java.util.ArrayList;

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

        DB = new DBConnectivity();

        if (DB.connect()) {
            
            LoginUI homepage = new LoginUI();
            homepage.setVisible(true);
        }
    }
}