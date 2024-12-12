/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author Reem
 */
// This class is responsible for friends operations
public class FriendManagement {

    // inner class that represents the friend requests
    public static class Request {

        // a method that sends request from user to other
        public static boolean send(User from, User to) throws NoSuchAlgorithmException, IOException {
            if (!from.getRequestsRecieved().contains(to.getUserId()) && !from.getRequestsSent().contains(to.getUserId())
                    && !from.getFriends().contains(to.getUserId())) {
                // send the request
                from.addRequestsSent(to.getUserId());
                to.addRequestsRecieved(from.getUserId());
                save(from, to); // update database
                return true; // indication
            }
            return false;
        }

        // a method that approves the request
        public static boolean approve(User from, User to) throws NoSuchAlgorithmException, IOException {
            // check that the request already exists
            if (from.getRequestsSent().contains(to.getUserId())
                    && to.getRequestsRecieved().contains(from.getUserId())) {
                from.removeRequestsSent(to.getUserId());
                to.removeRequestsRecieved(from.getUserId());
                // remove the request from requests and move users to be friends
                from.addFriends(to.getUserId());
                to.addFriends(from.getUserId());
                save(from, to);
                
                return true;// indication
            }
            return false;
        }

        // a method to decline the request
        public static boolean decline(User from, User to) throws NoSuchAlgorithmException, IOException {
            // check that the request already exists
            if (from.getRequestsSent().contains(to.getUserId())
                    && to.getRequestsRecieved().contains(from.getUserId())) {
                from.removeRequestsSent(to.getUserId());
                to.removeRequestsRecieved(from.getUserId());
                // remove the request from requests only
                save(from, to);
                return true;// indication
            }
            return false;
        }

        // a methos that unfriend two users
        public static boolean unFriend(User from, User to) throws IOException, NoSuchAlgorithmException {
            // check that they are already fiends
            if (from.getFriends().contains(to.getUserId())) {
                // remove both users from eachothers lists
                from.removeFriends(to.getUserId());
                to.removeFriends(from.getUserId());
                save(from, to);
                return true;
            }
            return false;
        }

        // a method to block users
        public static boolean block(User from, User to) throws NoSuchAlgorithmException, IOException {
            // check that both users exist
            if (from == null || to == null) {
                return false;
            } else {
                if (from.getFriends().contains(to.getUserId())) {
                    from.removeFriends(to.getUserId());
                    to.removeFriends(from.getUserId());
                } else if (from.getRequestsSent().contains(to.getUserId())) {
                    from.removeRequestsSent(to.getUserId());
                    to.removeRequestsRecieved(from.getUserId());
                } else if (to.getRequestsSent().contains(from.getUserId())) {
                    to.removeRequestsSent(from.getUserId());
                    from.removeRequestsRecieved(to.getUserId());
                }
                from.block(to); // add user to block list
                to.setBlockedBy(from);
                save(from, to);
                return true;
            }
        }

        // a method to unblock
        public static boolean unBlock(User from, User to) throws NoSuchAlgorithmException, IOException {
            // check that both users exist
            if (from == null || to == null) {
                return false;
            } else {
                from.unBlock(to); // remove user from block list
                to.removeBlockedBy(from);
                save(from);
                return true;
            }
        }
    }

    /*
     * 
     * 
     * INCOMPLETE
     * 
     */
    // inner class that is responsible for friend suggestions
    public static class FriendSuggestions {

        // a method to retrieve a list of friends of the friends as suggestions
        public static boolean common(User user) throws IOException {
            user.addFriendSuggestions(new ArrayList<>());
            Map<String, User> users = FilesManagement.read();
            // check all possible states of database
            if (users.isEmpty() || users == null) {
                // This means that no users on the system
                // no suggestions
                JOptionPane.showMessageDialog(null, "No users found in the system.", "Info",
                        JOptionPane.INFORMATION_MESSAGE);
                return false;
            } else if (user.getFriends().isEmpty() || user.getFriends() == null) {
                // this means that user does not have any friends 
                // suggest random accounts. Max 10
                ArrayList<User> allUsers = new ArrayList<>(users.values());
                allUsers.removeIf(u -> u.getUserId().equals(user.getUserId())); // execluds current user
                allUsers.removeIf(u -> u.getBlockedBy().contains(user.getUserId())); // execluds blocked by user
                // shuffle the list
                java.util.Collections.shuffle(allUsers);
                allUsers.removeIf(u -> user.getBlocked().contains(u.getUserId())); // exclude if blocked user
                allUsers.removeIf(u -> user.getRequestsSent().contains(u.getUserId())); //execlude if user send request
                allUsers.removeIf(u -> user.getRequestsRecieved().contains(u.getUserId()));//execlude if user recieve request
                ArrayList<String> userIds = allUsers.subList(0, Math.min(10, allUsers.size())).stream()
                        .map(User::getUserId).collect(Collectors.toCollection(ArrayList::new)); // collect as a List
                user.addFriendSuggestions(userIds);
                return true;
            } else {
                // It is the condition that user have friends and i want system to suggest him
                // friends of friends
                for (String friendId : user.getFriends()) {
                    // checks friend existance
                    if (friendId != null && FilesManagement.read().containsKey(friendId)) {
                        // check for the friend's friends
                        for (String friendOfFriendId : FilesManagement.read().get(friendId).getFriends()) {
                            // exclude the current user and his friends and block list
                            if (!friendOfFriendId.equals(user.getUserId())
                                    && !user.getFriends().contains(friendOfFriendId)
                                    && !user.getBlocked().contains(friendOfFriendId) && !user.getRequestsRecieved().contains(friendOfFriendId) && !user.getRequestsSent().contains(friendOfFriendId)) {
                                User suggestedUser = users.get(friendOfFriendId);
                                if (suggestedUser != null) { // check for existance and then add to suggestions
                                    user.addFriendSuggestions(suggestedUser.getUserId());
                                }
                            }
                        }
                    }
                }
                return true;
            }
        }
    }

    // method to save the list if both users needs update
    public static void save(User from, User to) throws NoSuchAlgorithmException, IOException {
        FilesManagement.save(from);
        FilesManagement.save(to);
    }

    // method to save the list if only one changed
    public static void save(User from) throws NoSuchAlgorithmException, IOException {
        FilesManagement.save(from);
    }
}
