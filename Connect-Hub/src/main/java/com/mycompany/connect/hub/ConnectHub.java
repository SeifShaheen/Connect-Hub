/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import java.util.ArrayList;
import Backend.Contents;
import Backend.Creation;
import Backend.Post;
import Backend.PostsFactory;
import Backend.Story;
import Backend.StoryMonitor;
package com.mycompany.connect.hub;


/**
 *
 * @author seifs
 */
public class ConnectHub {

    static User currentUser = null;
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InterruptedException {
        //new ProjectsOpening().setVisible(true);
        StoryMonitor.checkExpiredStories();
        User x= new CreateUser().information("reem@gmail.com", "reem ibrahim", "000", "2004-10-22");
        System.out.println(x.toString());
        x.createPost("yarab satrak");
        x.createStory("ostor yarab");        
    }
}
