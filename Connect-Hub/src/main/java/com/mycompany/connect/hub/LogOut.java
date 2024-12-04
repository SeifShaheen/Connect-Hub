/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

/**
 *
 * @author Reem
 */
//This class is responsible for the logout process
public class LogOut {

    public static void operate(User user) throws IOException, NoSuchAlgorithmException {
        user.setStatus("Offline");
        FilesManagement.save(user);
        JOptionPane.showMessageDialog(null, "Logged out successfully!", "Message", JOptionPane.PLAIN_MESSAGE);
        user = null;
    }
}
