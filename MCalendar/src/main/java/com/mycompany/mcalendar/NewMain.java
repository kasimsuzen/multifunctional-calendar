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
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ActiveTask at = new ActiveTask("aktifis", 0, 0, 0,"server", "dosya", 0);
        
        System.out.printf("%s %d %d %d %s %s %d\n",at.getDescription(),at.getTime().getHours(),at.getTime().getMinutes(),at.getTime().getSeconds(),at.getFtpServerLink(),at.getFilePath(),at.getPortNumber());
        
        at.setDescription("degisti");
        at.setFilePath("degisti1");
        at.setFtpServerLink("degisti2");
        at.setPortNumber(11);
        at.setTime(4, 4, 4);
        
        System.out.printf("%s %d %d %d %s %s %d",at.getDescription(),at.getTime().getHours(),at.getTime().getMinutes(),at.getTime().getSeconds(),at.getFtpServerLink(),at.getFilePath(),at.getPortNumber());
    }
    
}
