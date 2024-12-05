/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Reem
 */
//This class is responsible for friends operations
public class FriendManagement {

    //inner class that represents the friend requests
    public static class Request {

        // a method that sends request from user to other
        public static boolean send(User from, User to) {
            if (!from.getRequestsRecieved().contains(to) && !from.getRequestsSent().contains(to) && !from.getFriends().contains(to)) {
                //send the request
                from.addRequestsSent(to);
                to.addRequestsRecieved(from);
                return true; //indication
            }
            return false;
        }

        //a method that approves the request
        public static boolean approve(User from, User to) {
            //check that the request already exists
            if (from.getRequestsSent().contains(to) && to.getRequestsRecieved().contains(from)) {
                from.removeRequestsSent(to);
                to.removeRequestsRecieved(from);
                //remove the request from requests and move users to be friends
                from.addFriends(to);
                to.addFriends(from);
                return true;//indication
            }
            return false;
        }

        //a method to decline the request
        public static boolean decline(User from, User to) {
            //check that the request already exists
            if (from.getRequestsSent().contains(to) && to.getRequestsRecieved().contains(from)) {
                from.removeRequestsSent(to);
                to.removeRequestsRecieved(from);
                //remove the request from requests only
                return true;//indication
            }
            return false;
        }

        //a methos that unfriend two users
        public static boolean unFriend(User from, User to) {
            //check that they are already fiends
            if(from.getFriends().contains(to))
            {
                //remove both users from eachothers lists
                from.removeFriends(to);
                to.removeFriends(from);
                return true;
            }
            return false;
        }

    }
    
    /*
    
    
    INCOMPLETE
    
    */
    //inner class that is responsible for friend suggestions
    public static class FriendSuggestions{
        
        //a method to retrieve a list of friends of the friends
        public static ArrayList<User> common (User user) throws IOException
        {
            return null;
        }
    }
}