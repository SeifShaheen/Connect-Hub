/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.connect.hub;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author seifs
 */

//Files problem

public class ConnectHub {

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        User u= new CreateUser().information("reem@gmail.com", "reem","000","2004-10-20");
        System.out.println(u.toString());
        NewsfeedPage nfp = new NewsfeedPage();
    }
}
