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
            /* Mihai testing
            -- DB createCustomer()
            Customer customer = new Customer(1, "Holder Name", "Simon", "Peterson", false, false, false, "1st Avenue of New York", "0711 112 1124", null, "simon.peterson@yahoo.com", 0, null);
            DB.createCustomer(customer);
            */          
            LoginUI homepage = new LoginUI();
            homepage.setVisible(true);
        }
    }
}