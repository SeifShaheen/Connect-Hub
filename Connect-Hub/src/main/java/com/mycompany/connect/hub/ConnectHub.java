/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.connect.hub;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author seifs
 */
//Files problem
public class ConnectHub {

    static User currentUser = null;

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        currentUser = new CreateUser().information("reem@gmail.com", "reem", "000", "2004-10-20");
        System.out.println(currentUser.toString());
        NewsfeedPage nfp = new NewsfeedPage();
    }
}
