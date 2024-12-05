/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Reem
 */
//This class is responsible for getting the input from the user [if validated --> return object] [if errors --> print error message]
public class CreateUser {

    private User.UserBuilder builder = new User.UserBuilder();

    public CreateUser() {
    }

    //Method that gets information from the user and sent the data to validation function if needed to be validated or just assign
    public User information(String email, String username, String password, String dateOfBirth) throws NoSuchAlgorithmException, IOException {
        if (validateEmail(email) && validateUserName(username) && validateAge(LocalDate.parse(dateOfBirth))) {
            builder.buildPassword(PasswordHashing.hashPassword(password)).buildStatus("Online");
            User user= builder.Build();
            FilesManagement.save(user);
            return user;
        }
        return null;
    }

    public boolean validateEmail(String email) {
        boolean valid = Validation.validateEmail(email);
        if (valid) {
            builder.buildEmail(email);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Email Format! please enter a valid mail", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return valid;
    }

    public boolean validateUserName(String username) {
        boolean valid = Validation.validateUserName(username);
        if (valid) {
            builder.buildUsername(username);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid User Name! Only letters and spaces are allowed.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return valid;
    }

    public boolean validateAge(LocalDate dateOfBirth) {
        boolean valid = Validation.validateAge(dateOfBirth);
        if (valid) {
            builder.buildDateOfBirth(dateOfBirth.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Sorry, You must be at least 18 years old to create account!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return valid;
    }
}
