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
public class ActiveTask extends Task {

    private String ftpServerLink;
    private String  filePath;
    private int portNumber;
    
    public ActiveTask(String _description,int hour,int minute,int second,String _ftpServerLink,String _filePath,int _portNumber) {
        
       description=_description;
        
       setTime(hour, minute, second);
        
        ftpServerLink=_ftpServerLink;
        filePath=_filePath;
        portNumber=_portNumber;
        
    }
    
    public String getFilePath(){
      return filePath;
    }
    
    public void setFilePath(String _newFilePath){
        filePath=_newFilePath;
    }

    public String getFtpServerLink(){
        
        return ftpServerLink; 
    }
    
    public void setFtpServerLink(String newFtpSL){
        ftpServerLink=newFtpSL;
    }
    
    public int getPortNumber(){
        return portNumber;
    }
    
    public void setPortNumber(int _newPortNumber){
        portNumber=_newPortNumber;
    }
}
