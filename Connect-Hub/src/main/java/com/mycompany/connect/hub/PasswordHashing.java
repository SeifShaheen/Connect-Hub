/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author Reem
 */
//This class is responsible for password hashing management
public class PasswordHashing {

    /*//hashing
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashed = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder string = new StringBuilder();
        for (byte b : hashed) {
            string.append(String.format("%02x", b));
        }
        return string.toString();
    }

    //check entered password
    public static boolean checkPassword(String password, String hashedPassword) throws NoSuchAlgorithmException {
        String hashedEnteredPassword = hashPassword(password);
        return hashedEnteredPassword.equals(hashedPassword);

    }*/
    public static String hashPassword(String password) {
        // Generate a salt and hash the password
        String salt = BCrypt.gensalt();  // Default log_rounds is 10
        return BCrypt.hashpw(password, salt);
    }

    // Check if a plain password matches the hashed password
    public static boolean checkPassword(String password, String hashedPassword) {
        // Compare the entered password with the stored hash
        return BCrypt.checkpw(password, hashedPassword);
    }
}
