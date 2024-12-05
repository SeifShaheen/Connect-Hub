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
//This class is responsible for the signing process
public class SignIn {

    //A method to sign in by creating user account;
    public static User operate(User user, String email, String username, String password, String dateOfBirth) throws IOException, NoSuchAlgorithmException {

        if (!checkDuplicated(email)) {
            user = new CreateUser().information(email, username, password, dateOfBirth);
            if (user != null) {
                ConnectHub.currentUser = user;
                JOptionPane.showMessageDialog(null, "Signed up successfully!", "Message", JOptionPane.PLAIN_MESSAGE);
            }
        } else if (checkDuplicated(email)) {
            JOptionPane.showMessageDialog(null, "Email is already used! please try another one.", "Message", JOptionPane.ERROR_MESSAGE);
            user = null;

        } else {
            ConnectHub.currentUser = user;
            JOptionPane.showMessageDialog(null, "Signed up successfully!", "Message", JOptionPane.PLAIN_MESSAGE);
        }
        return user;
    }

    private static boolean checkDuplicated(String email) throws IOException {
        //Making sure that the email is not duplicated
        Map<String, User> map = FilesManagement.read();
        if (map != null && !map.isEmpty()) {
            for (User user : map.values()) {
                if (user.getEmail().equalsIgnoreCase(email)) {
                    return true; //email is duplicated
                }
            }
        }
        return false;
    }

}
