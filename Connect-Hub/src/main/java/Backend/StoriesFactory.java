/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;


public class StoriesFactory {

    public static Contents createContent(String text) {
        return new Story(text);
    }

    public static Contents createContent(String text, String imagePath) {
        return new Story(text,imagePath);
    }

    
}
