
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.connect.hub;

import Backend.StoryMonitor;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author seifs
 */
public class ConnectHub {

    public static User currentUser = null;

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InterruptedException {
        new ProjectsOpening().setVisible(true);
        StoryMonitor.checkExpiredStories();
    }
}
