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
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Reem
 */
// This class is responsible for creating user object with all its attriputes
// using builder design pattern
public class User extends FriendSpecifications {

    // User personal Info
    private final String userId;
    private String email;
    private String username;
    private String password;
    private String dateOfBirth;
    private String status;

    // User's attriputes that are related to other operations such as friends,
    // posts, stories,.etc
    // Contents attributes:
    ArrayList<Post> posts;
    ArrayList<Story> stories;

    // Info such as photos and bio relates profile properties
    public String bio;
    public String profilePhotoPath;
    public String coverPhotoPath;

    // Private constructor to be accessed only be the builder
    private User(UserBuilder builder) {
        this.userId = builder.userId;
        this.email = builder.email;
        this.username = builder.username;
        this.password = builder.password;
        this.dateOfBirth = builder.dateOfBirth;
        this.status = builder.status;
        this.stories = new ArrayList<>();
        this.posts = new ArrayList<>();
        friends = new ArrayList<>();
        requestsSent = new ArrayList<>();
        requestsRecieved = new ArrayList<>();
        friendSuggestions = new ArrayList<>();
        blocked = new ArrayList<>();
    }

    // getters&Setters to be needed
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

    @Override // overridden bec. it needs the user obj.
    public ArrayList<String> getFriendSuggestions() throws IOException {
        FriendManagement.FriendSuggestions.common(this);
        return friendSuggestions;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public ArrayList<Story> getStories() {
        return stories;
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
    }

    public void setStoriesfactory(StoriesFactory storiesfactory) {
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfilePhotoPath() {
        return profilePhotoPath;
    }

    public void setProfilePhotoPath(String profilePhotoPath) {
        this.profilePhotoPath = profilePhotoPath;
    }

    public String getCoverPhotoPath() {
        return coverPhotoPath;
    }

    public void setCoverPhotoPath(String coverPhotoPath) {
        this.coverPhotoPath = coverPhotoPath;
    }

    // Content creation methods
    public void createPost(String text) throws IOException, NoSuchAlgorithmException {
        Post post = (Post) PostsFactory.createContent(text);
        post.setAuthorID(userId);
        posts.add(post);
        FilesManagement.save(this);
    }

    public void createPost(String text, String imagePath) throws NoSuchAlgorithmException, IOException {
        Post post = (Post) PostsFactory.createContent(text, imagePath);
        post.setAuthorID(userId);
        posts.add(post);
        FilesManagement.save(this);
    }

    public void createStory(String text) throws NoSuchAlgorithmException, IOException {
        Story story = (Story) StoriesFactory.createContent(text);
        story.setAuthorID(userId);
        stories.add(story);
        FilesManagement.save(this);
    }

    public void createStory(String text, String imagepath) throws NoSuchAlgorithmException, IOException {
        Story story = (Story) StoriesFactory.createContent(text, imagepath);
        story.setAuthorID(userId);
        stories.add(story);
        FilesManagement.save(this);
    }

    @Override
    public String toString() {
        String line = "";
        line += "userId=" + userId + ",username=" + username + ",email=" + email + ",password=" + password
                + ",dateOfBirth=" + dateOfBirth + ",status=" + status;
        return line;
    }

    // Builder class
    // This class is the builder for User class
    public static class UserBuilder {

        // User Info
        private String userId;
        private String email;
        private String username;
        private String password;
        private String dateOfBirth;
        private String status;

        // constructor for mandatory attributes
        public UserBuilder() {
            // Universally Unique Identifier method ensuring unique user ID for each user
            this.userId = UUID.randomUUID().toString();
        }

        // setters for the system setting attributes 'attributes to be set by the system
        // itself not the user'
        public UserBuilder buildStatus(String status) {
            this.status = status;
            return this;
        }

        // setters for changable features
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

        // Build Method
        public User Build() {
            return new User(this);
        }
    }
}
