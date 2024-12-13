/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import com.mycompany.connect.hub.User;

public class PostsFactory {

    public static Contents createContent(String text,User author) {
        return new Post(text,author);
    }

    public static Contents createContent(String text, String imagePath,User author) {
        return new Post(text, imagePath,author);
    }

}
