/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bapers;

import Administrator.*;

/**
 * Main class for running BAPERS software.
 * @author Elmar Talibzade
 */
public class Bapers {

    private static  DBConnectivity dbConn;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        dbConn = new DBConnectivity();
        
        if (dbConn.connect())
        {
            //do the queries here
        }
    }
    
}