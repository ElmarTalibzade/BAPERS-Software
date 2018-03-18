/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bapers;

import Administrator.*;
import Customer.Task;
import java.util.ArrayList;

/**
 * Main class for running BAPERS software.
 *
 * @author Elmar Talibzade
 */
public class Bapers {

    private static DBConnectivity dbConn;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        dbConn = new DBConnectivity();

        if (dbConn.connect()) {
            ArrayList<Task> tasks = dbConn.getTasks("BC001");

            if (tasks != null) {
                for (Task task : tasks) {
                    if (task != null)
                    {                    
                        System.out.println(task.getDescription());
                    }
                    else
                    {
                        System.out.println("NOPE");
                    }
                }
            }
            else
            {
                System.out.println("Array empty");
            }
                    
        }
        else
        {
            System.out.println("No SQL connection");
        }
    }
}