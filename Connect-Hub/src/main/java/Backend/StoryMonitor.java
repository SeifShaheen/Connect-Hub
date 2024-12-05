/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.Timer;
import java.util.TimerTask;


public class StoryMonitor {
    private Story story;
    private Timer timer=new Timer();
    
    public StoryMonitor(Story story) {
        this.story = story;
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                deleteStory();
            }
        }, 24 * 60 * 60 * 1000); // Schedule for 24 hours
    }
    
    private void deleteStory() {
        // remove from JSON and newsfeed page
        System.out.println("Story has expired and has been deleted.");
    }
   
}
