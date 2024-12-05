/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.connect.hub;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import java.util.ArrayList;
import Backend.Contents;
import Backend.Creation;
import Backend.Post;
import Backend.PostsFactorty;
import Backend.Story;
import java.util.Map;

/**
 *
 * @author seifs
 */
//Files problem
public class ConnectHub {

     public static User currentUser;

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InterruptedException {
        //new ProjectsOpening().setVisible(true);
        /*currentUser = null;*/
        System.out.println(FilesManagement.read().get("92b4103c-74f4-425f-8575-46fdfd0ed5b8").getFriendSuggestions());

    }
}
