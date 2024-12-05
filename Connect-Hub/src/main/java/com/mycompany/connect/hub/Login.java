/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Reem
 */
//This class is responsible for the login process
public class Login {

    public static User operate(String email, String password) throws IOException, NoSuchAlgorithmException {
        //reading all files to compare email
        Map<String, User> map = FilesManagement.read();
        if (map == null) {
            return null;
        }
        //iterate for each user to check email and password
        for (Map.Entry<String, User> entry : map.entrySet()) {
            User user = entry.getValue();

            //compare email and password
            if (user.getEmail().equalsIgnoreCase(email) && PasswordHashing.checkPassword(password, user.getPassword())) {
                user.setStatus("Online");
                FilesManagement.save(user);
                JOptionPane.showMessageDialog(null, "Logged In successfully!", "Message", JOptionPane.PLAIN_MESSAGE);
                return user;
            } else if (user.getEmail().equalsIgnoreCase(email) && !PasswordHashing.checkPassword(password, user.getPassword())) {
                JOptionPane.showMessageDialog(null, "Password Wrong, please try again!", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }
        JOptionPane.showMessageDialog(null, "Invalid email!","Error", JOptionPane.PLAIN_MESSAGE);
        return null;
    }
}
