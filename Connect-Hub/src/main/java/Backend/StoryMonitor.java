/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import com.mycompany.connect.hub.FilesManagement;
import com.mycompany.connect.hub.User;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class StoryMonitor {

    public static void checkExpiredStories() {
        try {
            Map<String, User> users = FilesManagement.read();
            if (users != null) {
                for (User user : users.values()) {
                    ArrayList<Story> stories = user.getStories();
                    for (int i = 0; i < stories.size(); i++) {
                        if (isStoryExpired(stories.get(i).getTimestamp()))
                            stories.remove(i);
                    }
                }
                FilesManagement.save(users);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isStoryExpired(String timestamp) {
        String currentTime = DateFormating.date(new Date()); // Get formatted current date-time
        // Use SimpleDateFormat to parse both the current time and the story's timestamp
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date storyDate = format.parse(timestamp); // Parse story's timestamp
            Date currentDate = format.parse(currentTime); // Parse current time

            // Check if the story is more than 24 hours old
            return storyDate.getTime() + 24 * 60 * 60 * 1000 <= currentDate.getTime(); // 24 hours in milliseconds
        } catch (Exception e) {
            e.printStackTrace();
            return false; // If parsing fails
        }
    }

}
