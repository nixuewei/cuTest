package com.cucumber.framework.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LogUtil {
    private BufferedWriter bufferedWriter = null;

    ZonedDateTime date = ZonedDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHMMSS");
    String filenameformat = date.format(formatter);

    public void CreateLogFile() throws IOException {
        try{
            File dir = null;

            String os = System.getProperty("os.name").toLowerCase();

            if(os.contains("mac")){
                dir = new File(System.getProperty("user.dir") + "/logs/");
            }
            else{
                dir = new File(System.getProperty("user.dir") + "\\logs\\");
            }

            if(!dir.exists()){
                dir.mkdir();
            }
            File logfile = new File(dir +"/" + filenameformat + ".log");

            FileWriter fileWriter = new FileWriter(logfile.getAbsolutePath());
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch (Exception e){

        }
    }

    public void Write(String message){
        try {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:MM:SS");
            String dateformat = date.format(formatter);
            bufferedWriter.write("["+dateformat+"] " + message);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }catch(Exception e){

        }

    }

}
