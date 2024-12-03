/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Reem
 */
//This class is made to validate all user inputs
public class Validation {

    //Method to validate email using class InternetAddress which is included in javax.mail library
    //Jakarta Mail (JavaMail) Library was downloaded for the library to work
    public static boolean validateEmail(String email) {
        try {
            if (email.substring(0, email.indexOf('@')) == null) {
                return false;
            } else if (email.substring(email.indexOf('@'), email.indexOf('.')) == null) {
                return false;
            } else if (email.substring(email.indexOf('.')) == null) {
                return false;
            } else if (email.contains(" ")|| email.indexOf('@') <= 0 || email.indexOf('.') == -1 || email.indexOf('.') == email.length() - 1) {
                return false;
            }
            return true;
        } catch (StringIndexOutOfBoundsException e) {
            return false;
        }
    }

    //Method to validate the letters entered in name
    public static boolean validateUserName(String username) {
        for (char c : username.toCharArray()) {
            if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || c == ' ')) {
                return false;
            }
        }
        return true;
    }

    //Method to ensure user is greater than 18 YO
    public static boolean validateAge(LocalDate dateOfBirth) {
        //calc user age
        Period age = Period.between(dateOfBirth, LocalDate.now());
        if (age.getYears() >= 18) {
            return true;
        }
        return false;
    }
}
