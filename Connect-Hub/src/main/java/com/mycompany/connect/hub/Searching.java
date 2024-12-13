/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

/**
 *
 * @author Etijah
 */
public class Searching {

    public Searching() {

    }

    public User getUser(String UserName) {

        for (String key : FilesManagement.map.keySet()) {
            User acct = FilesManagement.map.get(key);

            if (acct.getUsername().equals(UserName))
                return acct;
        }
        return null;
    }

}
