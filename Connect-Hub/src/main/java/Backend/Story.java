/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author amrze
 */
public class Story implements Contents {
    private String text;
    private String imagePath;
    private String timestamp;
    private String contentID;
    @SuppressWarnings("unused")
    private String authorID;
    @SuppressWarnings("unused")
    private StoryMonitor storyMonitor;

    // overloaded constructors for stories based on the passed arguments
    public Story(String text) {
        this.text = text;
        this.timestamp = DateFormating.date(new Date());
        this.contentID = UUID.randomUUID().toString();

    }

    public Story(String text, String imagePath) {
        this.text = text;
        this.imagePath = imagePath;
        this.timestamp = DateFormating.date(new Date());
        this.contentID = UUID.randomUUID().toString();
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public String getImagePath() {
        return imagePath;
    }

    @Override
    public String getTimestamp() {
        return timestamp;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getContentID() {
        return contentID;
    }

}
