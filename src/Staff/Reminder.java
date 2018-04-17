/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Staff;

import java.sql.Timestamp;

/**
 *
 * @author mihaimatraguna
 */
public class Reminder {
    private int id;
    private String message;
    private int recieveNo;
    private Timestamp recieveTime;
    private int timesReminded;
    
    public Reminder(int id, String message, int recieveNo, Timestamp recieveTime, int timesReminded){
        this.id = id;
        this.message = message;
        this.recieveNo = recieveNo;
        this.recieveTime = recieveTime;
        this.timesReminded = timesReminded;
    }
    
    public int getID(){
        return id;
    }
    
    public String getMessage(){
        return message;
    }
    
    public int getReciever(){
        return recieveNo;
    }
    
    public Timestamp getTime(){
        return recieveTime;
    }
    
    public int getTimesReminded(){
        return timesReminded;
    }
}
