package com.wipro.filedemo;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        String inputImg = "E:\\java_img.jpg";
        String outputImg = "E:\\java_img_new.jpg";
        
        try (FileInputStream i1 = new FileInputStream(inputImg);
             FileOutputStream i2 = new FileOutputStream(outputImg)) {
            
            byte buffer[] = new byte[1024];
            int bytesRead = 0;
            
            while ((bytesRead = i1.read(buffer)) != -1) {
                i2.write(buffer, 0, bytesRead);
            }        
            System.out.println("File copied successfully.");            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
