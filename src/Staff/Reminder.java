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
    
    /**
     *
     * @param id Reminder's id
     * @param subject Reminder's subject
     * @param message Reminder's message
     * @param recieveNo The staff id who will recieve the reminder
     * @param recieveTime The time when the reminder was generated
     * @param timesReminded Number of times when the user pressed "Read Later"
     * @param isRead ture - if the reminder was read | false - otherwise
     */
    public Reminder(int id, String subject, String message, int recieveNo, Timestamp recieveTime, int timesReminded, boolean isRead){
        this.id = id;
        this.subject = subject;
        this.message = message;
        this.recieveNo = recieveNo;
        this.recieveTime = recieveTime;
        this.timesReminded = timesReminded;
        this.isRead = isRead;
    }
    
    /**
     * Returns id of the reminder
     * @return An integer that represents the reminder's id
     */
    public int getID(){
        return id;
    }
    
    /**
     * Returns the main message of the reminder
     * @return A string that represents the reminder's main message
     */
    public String getMessage(){
        return message;
    }
    
    /**
     * Returns the staff id who will receive the reminder
     * @return An integer that represents  the staff id who will receive the reminder
     */
    public int getReciever(){
        return recieveNo;
    }
    
    /**
     * Returns the date when the reminder was generated
     * @return A date that represents when the reminder was generated
     */
    public Timestamp getTime(){
        return recieveTime;
    }
    
    /**
     * Returns the number of times when staff pressed "Read Later"
     * @return An integer that represents number of times the staff pressed "Read Later"
     */
    public int getTimesReminded(){
        return timesReminded;
    }
    
    /**
     * Increments the times reminded by one
     */
    public void incrementTimesReminded(){
        timesReminded++;
    }
    
    /**
     * Returns the main subject of the message
     * @return A string that represents the subject of the reminder
     */
    public String getSubject(){
        return subject;
    }
    
    /**
     * Returns the state of the reminder
     * @return true - if the reminder was read | false - otherwise
     */
    public boolean isRead(){
        return isRead;
    }
    
    /**
     * Marks the reminder as read
     */
    public void markAsRead(){
        isRead = true;
    }
}
