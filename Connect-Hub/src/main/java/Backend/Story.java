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
public class Story implements Contents {
    private String text;
    private String imagePath;
    private String timestamp;
    
    public Story(String text)
    {
      this.text=text;
      this.timestamp=DateFormating.date(new Date());
    }
    public Story(String text, String imagePath)
    {
      this.text=text;
      this.imagePath=imagePath;
      this.timestamp=DateFormating.date(new Date());
    }
        
    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }

    @Override
    public String getTimestamp() {
        return timestamp;
    }

    
}
