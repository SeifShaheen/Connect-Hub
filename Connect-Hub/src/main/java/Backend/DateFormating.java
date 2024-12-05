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
public class DateFormating {
    //the format we want to assign to contrents
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 

    public static String date(Date date)
    {
        return format.format(date);
    }
    
}
