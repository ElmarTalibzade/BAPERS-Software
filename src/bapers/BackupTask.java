/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bapers;

import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author Mihai
 */
public class BackupTask extends TimerTask{    
    public BackupTask(String saveLocation){
        try {
            String user = "root";
            String password = "";
            String database = "bloomsday";
            String pathToMySQL = "/usr/local/mysql-5.7.21-macos10.13-x86_64/bin/";
            String CMD = "";
            
            if(password.equals(""))
                CMD = pathToMySQL + "mysqldump -u " + user + " --add-drop-database -B " + database + " -r " + saveLocation;
            else
                CMD = pathToMySQL + "mysqldump -u " + user + " -p " + password + "--add-drop-database -B " + database + " -r " + saveLocation;
            System.out.println(CMD);
            
            Runtime.getRuntime().exec(CMD);
            System.out.println("[BACKUP]: Automated backup created sucesfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.println("[BACKUP]: Automated backup started.");
    }
}
