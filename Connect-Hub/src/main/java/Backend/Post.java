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
public class Post implements Content {
    private String text;
    private String imagePath;
    private String timestamp;
    
    
    @Override
    public Content create(String text) {
        this.text=text;   
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.timestamp = format.format(new Date());
        return (Post)this;
    }

    @Override
    public Content create(String text, String imagePath) {
        this.text=text;
        this.imagePath=imagePath;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.timestamp = format.format(new Date());
        return(Post) this;
    }
    // will be modified or deleted
    @Override
    public Content display() {
        System.out.println("created:" + text);
        return this;       
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
