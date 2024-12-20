/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/**
 *
 * @author Reem
 */
// This class is responsible for dealing with files

public class GroupsDataBase {

    static Map<String, Group> map = null;

    // Public method to save one new user to the file or to edit one needed to be
    // edited
    public static void save(Group group) throws NoSuchAlgorithmException, IOException {

        // Creating a map to map each ID with its properties
        map = read();

        // cheching for existing values
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(group.getGroupID(), group);
        save(map); // calling the function that saves map in file

    }

    // Amethod to save a whole map
    public static void save(Map<String, Group> map) {
        // GSON Object to be saved in the file
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(map);

        // Finally, write in the file called database.json
        try (FileWriter file = new FileWriter("groups.json")) {
            file.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // A method to read whole data from the file and returns map
    public static Map<String, Group> read() throws IOException {
        try {
            // Read the content of the file
            String content = new String(Files.readAllBytes(Paths.get("groups.json")));

            // If the file is empty it returns null
            if (content.isEmpty()) {
                return new HashMap<>();
            }

            // Use Gson to deserialize the content into a Map
            Gson gson = new Gson();
            return gson.fromJson(content, new TypeToken<Map<String, Group>>() {
            }.getType());
        } catch (IOException e) {
            return new HashMap<>();
        }
    }

}
