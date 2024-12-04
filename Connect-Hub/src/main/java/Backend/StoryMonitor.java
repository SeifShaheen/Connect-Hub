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
    Story story;
    
    Timer timer=new Timer();
    TimerTask task=new TimerTask(){
        @Override
        public void run() {
            //delete the story from the frontend and from the json file         
           // System.out.println("Stroy has been ended");
            
        }
        
    };
    public StoryMonitor(Story story)
    {
        this.story=story;
        timer.schedule(task, 24 * 60 * 60 * 1000); //to schedule for 24h
    }
    
   
}
