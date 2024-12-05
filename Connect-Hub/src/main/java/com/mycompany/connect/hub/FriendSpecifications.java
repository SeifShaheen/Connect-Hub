/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Reem
 */

//this class is responsible for all friends operations
public abstract class  FriendSpecifications {
    //Friend management attributes:

    public ArrayList<String> friends = new ArrayList<>();
    public ArrayList<String> requestsSent = new ArrayList<>();
    public ArrayList<String> requestsRecieved = new ArrayList<>();
    public ArrayList<String> friendSuggestions = new ArrayList<>();
    public ArrayList<String> blocked = new ArrayList<>();
    
    
    public ArrayList<String> getFriends() {
        return friends;
    }

    public ArrayList<String> getRequestsSent() {
        return requestsSent;
    }

    public ArrayList<String> getRequestsRecieved() {
        return requestsRecieved;
    }

    public abstract ArrayList<String> getFriendSuggestions()throws IOException;

    public ArrayList<String> getBlocked() {
        return blocked;
    }

    public void block(User user) {
        blocked.add(user.getUserId());
    }

    public void unBlock(User user) {
        blocked.remove(user.getUserId());
    }

    public void addFriendSuggestions(String friendSuggestions) {
        this.friendSuggestions.add(friendSuggestions);
    }

    public void addFriendSuggestions(ArrayList<String> friendSuggestions) {
        this.friendSuggestions = friendSuggestions;
    }
    
     public void addRequestsSent(String requestsSent) {
        this.requestsSent.add(requestsSent);
    }

    public void addRequestsRecieved(String requestsRecieved) {
        this.requestsRecieved.add(requestsRecieved);
    }

    public void removeFriends(String friend) {
        this.friends.remove(friend);
    }

    public void removeRequestsSent(String requestsSent) {
        this.requestsSent.remove(requestsSent);
    }

    public void removeRequestsRecieved(String requestsRecieved) {
        this.requestsRecieved.remove(requestsRecieved);
    }
    
    public void addFriends(String friend) {
        this.friends.add(friend);
    }

}
