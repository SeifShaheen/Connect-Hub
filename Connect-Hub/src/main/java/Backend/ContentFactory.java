/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author amrze
 */
public class ContentFactory {
    public static Content createContent(String type) {
        if (type.equalsIgnoreCase("post")) {
            return new Post();
        } else if (type.equalsIgnoreCase("story")) {
            return new Story();
        }
        throw new IllegalArgumentException("Unknown content type");
    }
       
}
