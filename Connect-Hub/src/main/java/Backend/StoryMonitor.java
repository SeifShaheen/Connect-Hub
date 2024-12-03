/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author amrze
 */
public class StoryMonitor {
    
    Timer timer=new Timer();
    TimerTask task=new TimerTask(){
        @Override
        public void run() {
            System.out.println("Stroy has been ended");
            //delete the story
        }
        
    };
    public StoryMonitor()
    {
        timer.schedule(task, 24 * 60 * 60 * 1000);
    }
    
   
}
