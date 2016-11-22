/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mcalendar;

import java.sql.Time;

/**
 *
 * @author aemin
 */
public abstract class Task {
    
    protected String description;
    protected Time scheduledTime;
    

    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String newDescription){
    
        description=newDescription;
    }
    
    public void setTime(int hour, int minute, int second){
           scheduledTime = new Time(hour, minute, second);
    }
    
    public Time getTime(){
     
        return scheduledTime;
    }
    
}
