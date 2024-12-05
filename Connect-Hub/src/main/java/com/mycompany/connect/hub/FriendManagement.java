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
                save(from,to); //update database
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
                save(from,to);
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
                save(from,to);
                return true;//indication
            }
            return false;
        }

        //a methos that unfriend two users
        public static boolean unFriend(User from, User to) {
            //check that they are already fiends
            if (from.getFriends().contains(to)) {
                //remove both users from eachothers lists
                from.removeFriends(to);
                to.removeFriends(from);
                save(from,to);
                return true;
            }
            return false;
        }

        //a method to block users
        public static boolean block(User from, User to) {
            //check that both users exist
            if (from == null || to == null) {
                return false;
            } else {
                from.block(to); //add user to block list
                save(from);
                return true;
            }
        }

        //a method to unblock
        public static boolean unBlock(User from, User to) {
            //check that both users exist
            if (from == null || to == null) {
                return false;
            } else {
                from.unBlock(to); //remove user from block list
                save(from);
                return true;
            }
        }

        //method to save the list if both users needs update
        public static void save(User from, User to) {
            FilesManagement.map.put(from.getUserId(), from);
            FilesManagement.map.put(to.getUserId(), to);
        }
        //method to save the list if only one changed 
        public static void save(User from) {
            FilesManagement.map.put(from.getUserId(), from);
        }

    }

    /*
    
    
    INCOMPLETE
    
     */
    //inner class that is responsible for friend suggestions
    public static class FriendSuggestions {

        //a method to retrieve a list of friends of the friends as suggestions
        public static boolean common(User user) throws IOException {
            Map<String, User> users = FilesManagement.read();
            //check all possible states of database
            if (users.isEmpty() || users == null) {
                //This means that no users on the system 
                //no suggestions
                JOptionPane.showMessageDialog(null, "No users found in the system.", "Info", JOptionPane.INFORMATION_MESSAGE);
                return false;
            } else if (user.getFriends().isEmpty() || user.getFriends() == null) {
                //this means that user does not have any friends
                //suggest random accounts. Max 10
                ArrayList<User> allUsers = new ArrayList<>(users.values());
                allUsers.removeIf(u -> u.getUserId().equals(user.getUserId())); //execluds current user
                //shuffle the list 
                java.util.Collections.shuffle(allUsers);
                user.addFriendSuggestions(new ArrayList<>(allUsers.subList(0, Math.min(10, allUsers.size())))); //suggest 10 users max
                return true;
            } else {
                //It is the condition that user have friends and i want system to suggest him friends of friends
                for (User friend : user.getFriends()) {
                    //checks friend existance
                    if (friend != null && friend.getFriends() != null) {
                        //check for the friend's friends
                        for (User friendOfFriend : friend.getFriends()) {
                            //exclude the current user and his friends and block list
                            if (!friendOfFriend.getUserId().equals(user.getUserId()) && !user.getFriends().contains(friendOfFriend) && !user.getBlocked().contains(friendOfFriend)) {
                                User suggestedUser = users.get(friendOfFriend);
                                if (suggestedUser != null) { //check for existance and then add to suggestions
                                    user.addFriendSuggestions(suggestedUser);
                                }
                            }
                        }
                    }

                }
                return true;
            }
        }
    }
}
