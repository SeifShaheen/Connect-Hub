/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

import java.time.LocalDate;

/**
 *
 * @author Reem
 */

/*


INCOMPLETE!!!!

*/
//This class is responsible for creating & setting the user information
public class UserBuilder {

    //User Info
    String userId;
    String email;
    String username;
    String password;
    LocalDate dateOfBirth;
    String status;

    //private constructor to be created only through the builder
    //constructor only takes mendatory attributes
    private UserBuilder(String email, String username, String password, LocalDate dateOfBirth) {

        this.email = email;
        this.username = username;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    //setters for the system setting attributes 'attributes to be set by the system itself not the user'
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //setters for changable features
    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
    
    //builder method

}
