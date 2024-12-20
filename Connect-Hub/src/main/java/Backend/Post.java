/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import com.mycompany.connect.hub.User;
import java.util.Date;
import java.util.UUID;

public class Post implements Contents {
    private String text;
    private String imagePath;
    private String timestamp;
    @SuppressWarnings("unused")
    private String contentID;
    @SuppressWarnings("unused")
    private String authorID;

    // overloaded constructors for posts based on the passed arguments
    public Post(String text,User author) {
        this.text = text;
        this.timestamp = DateFormating.date(new Date());
        this.contentID = UUID.randomUUID().toString();
        this.authorID = author.getUserId();
    }

    public Post(String text, String imagePath,User author) {
        this.text = text;
        this.imagePath = imagePath;
        this.timestamp = DateFormating.date(new Date());
        this.contentID = UUID.randomUUID().toString();
        this.authorID = author.getUserId();
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

    public String getAuthorID() {
        return this.authorID;

    }

    public void setText(String text) {
        this.text = text;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    
    

}
