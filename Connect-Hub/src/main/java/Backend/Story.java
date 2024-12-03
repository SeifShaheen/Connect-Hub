/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author amrze
 */
public class Story implements Content {
    private String text;
    private String imagePath;
    private String timestamp;
    
    @Override
    public void create(String text) {
        this.text=text;
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.timestamp = format.format(new Date());
    }

    @Override
    public void create(String text, String imagePath) {
        this.text=text;
        this.imagePath=imagePath;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.timestamp = format.format(new Date());
    }

    @Override
    public void display() {
        System.out.println("created:" + text);
        
    }

    public String getText() {
        return text;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getTimestamp() {
        return timestamp;
    }

    
}
