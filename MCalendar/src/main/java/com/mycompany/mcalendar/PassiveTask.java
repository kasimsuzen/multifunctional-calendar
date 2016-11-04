/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mcalendar;

/**
 *
 * @author aemin
 */
public class PassiveTask extends Task {
    
    
     public PassiveTask(String _description,int hour,int minute,int second){
     
         setDescription(_description);
         setTime(hour, minute, second);
     
     }
     
}
