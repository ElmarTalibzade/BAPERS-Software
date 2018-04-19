/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Staff;

import GUI.AlertView;
import java.util.TimerTask;
import static bapers.Bapers.DB;
import java.util.ArrayList;

/**
 * Functions that runs everytime the timer is called
 * @author Mihai
 */
public class RetrieveReminders extends TimerTask {    
    private Staff currentUser;

    @Override
    public void run() {
        currentUser = DB.loggedUser;
        if(currentUser != null) {
            ArrayList<Reminder> reminders = DB.getReminders();
            for (Reminder reminder : reminders) {
                AlertView alert = new AlertView(null, true, reminder, currentUser);
                alert.setVisible(true);
            }
        }
    }
    
}
