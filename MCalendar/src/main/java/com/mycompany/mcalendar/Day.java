/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mcalendar;

import java.util.ArrayList;

/**
 *
 * @author aemin
 */
public class Day {
    
    private ArrayList<PassiveTask> passiveTasks;
    private ArrayList<ActiveTask> activeTasks;
    private int dayNumber;
    private int month;
    private int year;
    
    public Day(int _dayNumber,int _month,int _year){
        
        passiveTasks = new ArrayList<PassiveTask>();
        
            dayNumber=_dayNumber;
            month=_month;
            year=_year;
            
    
    }
    
    public void addActiveTask(String _description,int hour,int minute,int second,String _ftpServerLink,String _filePath,int _portNumber){
        
        activeTasks.add(new ActiveTask(_description, hour, minute, second, _ftpServerLink, _filePath, _portNumber));
    
    }
    
    public void addPassiveTask(String _description,int hour,int minute,int second){
    
        passiveTasks.add(new PassiveTask(_description,hour,minute,second));
    }
    
    
    
}
