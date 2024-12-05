/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.connect.hub;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import java.util.ArrayList;
import Backend.Content;
import Backend.Creation;
import Backend.Post;
import Backend.PostsFactorty;
import Backend.Story;

/**
 *
 * @author seifs
 */
//Files problem
public class ConnectHub {

    static User currentUser = null;

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InterruptedException {
        new ProjectsOpening().setVisible(true);
    }
}
