/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 *  Bu sinif, uygulama acildigi zaman
 *  yapilmasi gereken bir aktif gorev var ise, 
 *  bu aktif gorev icin bir ip ve file path alir.
 *  Arka planda bir thread kullanarak
 *  bu aktif gorevi yani verilen dosyayi verilen ip ye gonderir.
 * @author mutlu koktemir & osman suzer
 */
public class ActiveJobThread implements Runnable{
    
    private Thread thread;
    private String ip;
    private String filePath;
    
    private String username;
    private String password;
    
    /**
     *  Thread'i baslatir.
     * @param ip  ip = 127.0.0.1:13267   şeklinde bir hostname bir de portname içermeli (ftp server adresi için)
     *  eğer ip https://127.0.0.1:13267 şeklinde alınmışsa URI objesine direkt ip yi göndermelisin
     * @param filepath  gönderilecek olan dosya
     */
    public ActiveJobThread(String ip, String filepath)
    {
        this.ip = ip;
        filePath = filepath;
        thread = new Thread(this,"other");
        thread.start();
        
    }
    
    public ActiveJobThread(String ip, String filepath, String username, String password)
    {
        this.ip = ip;
        filePath = filepath;
        this.username = username;
        this.password = password;
        thread = new Thread(this,"other");
        thread.start();
    }
    
    @Override
    public void run() {
        
        try {
        
            //to write link format
            //URI uri = new URI(ip);
            URI uri = new URI("xxx://" + ip);
            //get host of server
            String server = uri.getHost();
            //get port of the program
            int port = uri.getPort();
            
            //create a FTPClient to connect to server
            FTPClient ftpClient = new FTPClient();
            try {
                //client connects to server by using server host and port
                ftpClient.connect(server, port);
                //client logins if it is valid
                ftpClient.login(this.username, this.password);
                
                ftpClient.enterLocalPassiveMode();
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                
                File myfile = new File(this.filePath);
                InputStream inputStream = new FileInputStream(myfile);
                
                //starts uploading to server by using storeFileStream.
                System.out.println("Start uploading file : " + myfile.getName());
                OutputStream outputStream = ftpClient.storeFileStream(myfile.getName());
                byte[] bytesIn = new byte[4096];
                int read = 0;
                
                while ((read = inputStream.read(bytesIn)) != -1) {
                    outputStream.write(bytesIn, 0, read);
                }
                
                inputStream.close();
                outputStream.close();

                boolean completed = ftpClient.completePendingCommand();
                if (completed) {
                    System.out.printf("The file %s is uploaded successfully.\n", myfile.getName());
                }
                
                ftpClient.logout();
                ftpClient.disconnect();
                
            } catch (IOException ex) {
                System.out.println("Error: " + ex.getMessage());
                ex.printStackTrace();
            } finally {
                if (ftpClient.isConnected()) {
                    try {
                        ftpClient.logout();
                        ftpClient.disconnect();
                    } catch (IOException ex) {
                        Logger.getLogger(ActiveJobThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }catch (URISyntaxException ex) {
            Logger.getLogger(ActiveJobThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

