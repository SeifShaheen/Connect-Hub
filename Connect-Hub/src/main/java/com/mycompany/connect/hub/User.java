/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Reem
 */
//This class is responsible for creating user object using builder design pattern
public class User {

    //User Info
    private final String userId;
    private String email;
    private String username;
    private String password;
    private LocalDate dateOfBirth;
    private String status;

    //Private constructor to be accessed only be the builder
    private User(UserBuilder builder) {
        this.userId = builder.userId;
        this.email = builder.email;
        this.username = builder.username;
        this.password = builder.password;
        this.dateOfBirth = builder.dateOfBirth;
        this.status = builder.status;
    }

    //getters to be needed
    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getStatus() {
        return status;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        String line = "";
        try {
            line += "userId=" + userId + ",username=" + username + ",email=" + email + ",password=" + PasswordHashing.hashPassword(password) + ",dateOfBirth=" + dateOfBirth + ",status=" + status;
        } catch (NoSuchAlgorithmException ex) {
        }
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
        private LocalDate dateOfBirth;
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
            this.password = password;
            return this;
        }

        public UserBuilder buildUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder buildDateOfBirth(LocalDate dateOfBirth) {
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
