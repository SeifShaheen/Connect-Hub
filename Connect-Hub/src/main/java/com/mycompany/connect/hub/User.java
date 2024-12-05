/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

import Backend.Post;
import Backend.PostsFactory;
import Backend.StoriesFactory;
import Backend.Story;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;


/**
 *
 * @author Reem
 */
//This class is responsible for creating user object using builder design pattern
public class User {

    //User personal Info
    private final String userId;
    private String email;
    private String username;
    private String password;
    private String dateOfBirth;
    private String status;
    
    //User's attriputes that are related to other operations such as friends, posts, stories,.etc
    //1-Friend management attributes:
    ArrayList<User> friends;
    ArrayList<User> requestsSent;
    ArrayList<User> requestsRecieved;
    ArrayList<User> friendSuggestions;
    ArrayList<User> blocked=new ArrayList<User>();
    //2-Contents attributes:
    ArrayList<Post> posts=new ArrayList<>();
    ArrayList<Story> stories=new ArrayList<>();
    private transient PostsFactory postsFcatory=new PostsFactory(); //transient keyword used to not serialize this attribute in the file
    private transient StoriesFactory storiesfactory=new StoriesFactory();

    //Private constructor to be accessed only be the builder
    private User(UserBuilder builder) {
        this.userId = builder.userId;
        this.email = builder.email;
        this.username = builder.username;
        this.password = builder.password;
        this.dateOfBirth = builder.dateOfBirth;
        this.status = builder.status;
    }

    //getters&Setters to be needed
    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() throws NoSuchAlgorithmException {
        return password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getStatus() {
        return status;
    }

    public String getUserId() {
        return userId;
    }

    public ArrayList<User> getFriends() {
        return friends;
    }

    public ArrayList<User> getRequestsSent() {
        return requestsSent;
    }

    public ArrayList<User> getRequestsRecieved() {
        return requestsRecieved;
    }

    public ArrayList<User> getFriendSuggestions() {
        return friendSuggestions;
    }

    public ArrayList<User> getBlocked() {
        return blocked;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }
    
    public ArrayList<Story> getStories() {
        return stories;
    }
     
    public void block(User user)
    {
        blocked.add(user);
    }
    
    public void unBlock(User user)
    {
        blocked.remove(user);
    }

    public void addFriendSuggestions(User friendSuggestions) {
        this.friendSuggestions.add(friendSuggestions);
    }
    public void addFriendSuggestions(ArrayList<User> friendSuggestions) {
        this.friendSuggestions=friendSuggestions;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = PasswordHashing.hashPassword(password);
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public void setStories(ArrayList<Story> stories) {
        this.stories = stories;
    }

    public void setPostsFcatory(PostsFactory postsFcatory) {
        this.postsFcatory = postsFcatory;
    }

    public void setStoriesfactory(StoriesFactory storiesfactory) {
        this.storiesfactory = storiesfactory;
    }
    

    public void addFriends(User friend) {
        this.friends.add(friend);
    }

    public void addRequestsSent(User requestsSent) {
        this.requestsSent.add(requestsSent);
    }

    public void addRequestsRecieved(User requestsRecieved) {
        this.requestsRecieved.add(requestsRecieved);
    }
        public void removeFriends(User friend) {
        this.friends.remove(friend);
    }

    public void removeRequestsSent(User requestsSent) {
        this.requestsSent.remove(requestsSent);
    }

    public void removeRequestsRecieved(User requestsRecieved) {
        this.requestsRecieved.remove(requestsRecieved);
    }
    //Content creation methods
    public void createPost(String text) throws IOException, NoSuchAlgorithmException
    {
        Post post=(Post) postsFcatory.createContent(text);
        post.setAuthorID(userId);
        posts.add(post);    
        FilesManagement.save(this);
    }
    public void createPost(String text,String imagePath) throws NoSuchAlgorithmException, IOException
    {  
        Post post=(Post) postsFcatory.createContent(text,imagePath);
        post.setAuthorID(userId);
        posts.add(post);    
        FilesManagement.save(this);
    }
    
    public void createStory(String text) throws NoSuchAlgorithmException, IOException
    {
        Story story=(Story)storiesfactory.createContent(text);
        story.setAuthorID(userId);
        stories.add(story);    
        FilesManagement.save(this);
    }
    
    public void createStory(String text,String imagepath) throws NoSuchAlgorithmException, IOException
    {
        Story story=(Story)storiesfactory.createContent(text,imagepath);
        story.setAuthorID(userId);
        stories.add(story);       
        FilesManagement.save(this);
    }

    @Override
    public String toString() {
        String line = "";
        line += "userId=" + userId + ",username=" + username + ",email=" + email + ",password=" + PasswordHashing.hashPassword(password) + ",dateOfBirth=" + dateOfBirth + ",status=" + status;
        return line;
    }

    //Builder class
    //This class is the builder for User class
    public static class UserBuilder {

        //User Info
        private String userId;
        private String email;
        private String username;
        private String password;
        private String dateOfBirth;
        private String status;

        //constructor for mandatory attributes
        public UserBuilder() {
            //Universally Unique Identifier method ensuring unique user ID for each user
            this.userId = UUID.randomUUID().toString();
        }

        //setters for the system setting attributes 'attributes to be set by the system itself not the user'
        public UserBuilder buildStatus(String status) {
            this.status = status;
            return this;
        }

        //setters for changable features
        public UserBuilder buildPassword(String password) {
            PasswordHashing.hashPassword(password);
            this.password = password;
            return this;
        }

        public UserBuilder buildUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder buildDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public UserBuilder buildEmail(String email) {
            this.email = email;
            return this;
        }

        //Build Method
        public User Build() {
            return new User(this);
        }
    }
}
