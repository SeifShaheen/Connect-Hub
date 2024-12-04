/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import org.json.JSONObject;
import java.util.Map;

/**
 *
 * @author Reem
 */
//This class is responsible for dealing with files
public class FilesManagement {

    //Public method to save to the file
    public static void save(User user) throws NoSuchAlgorithmException, IOException {

        //Creating a map to map each ID with its properties
        Map<String, Object> map;

        //cheching for existing values
        if (read() != null) {
            map = read();
        } else {
            map = new HashMap<>();
        }

        map.put(user.getUserId(), user);

        //JSONObject to be saved in the file
        JSONObject obj = new JSONObject(map); 

        //Finally, write in the file called database.json
        try (FileWriter file = new FileWriter("database.json")) {
            file.write(obj.toString(4));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Public method to read data from file
    public static Map<String, Object> read() throws IOException {
    String content = new String(Files.readAllBytes(Paths.get("database.json")));
        //checking if file is empty
        if (content.isEmpty()) {
            return null;
        }
        JSONObject obj = new JSONObject(content);
        return obj.toMap();
    }

}
