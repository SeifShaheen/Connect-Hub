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
        User u= new CreateUser().information("reem@gmail.com", "rm","000","2004-10-20");
        User x= new CreateUser().information("reem@gmail.com", "r","000","2004-10-22");
    }
}
