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
     * @param id
     * @param subject
     * @param message
     * @param recieveNo
     * @param recieveTime
     * @param timesReminded
     * @param isRead
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
     *
     * @return
     */
    public int getID(){
        return id;
    }
    
    /**
     *
     * @return
     */
    public String getMessage(){
        return message;
    }
    
    /**
     *
     * @return
     */
    public int getReciever(){
        return recieveNo;
    }
    
    /**
     *
     * @return
     */
    public Timestamp getTime(){
        return recieveTime;
    }
    
    /**
     *
     * @return
     */
    public int getTimesReminded(){
        return timesReminded;
    }
    
    /**
     *
     */
    public void incrementTimesReminded(){
        timesReminded++;
    }
    
    /**
     *
     * @return
     */
    public String getSubject(){
        return subject;
    }
    
    /**
     *
     * @return
     */
    public boolean isRead(){
        return isRead;
    }
    
    /**
     *
     */
    public void markAsRead(){
        isRead = true;
    }
}
