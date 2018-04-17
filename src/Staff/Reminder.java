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
    private String subject;
    private String message;
    private int recieveNo;
    private Timestamp recieveTime;
    private int timesReminded;
    private boolean isRead;
    
    public Reminder(int id, String subject, String message, int recieveNo, Timestamp recieveTime, int timesReminded, boolean isRead){
        this.id = id;
        this.subject = subject;
        this.message = message;
        this.recieveNo = recieveNo;
        this.recieveTime = recieveTime;
        this.timesReminded = timesReminded;
        this.isRead = isRead;
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
    
    public String getSubject(){
        return subject;
    }
    
    public boolean isRead(){
        return isRead;
    }
    
    public void markAsRead(){
        isRead = true;
    }
}
