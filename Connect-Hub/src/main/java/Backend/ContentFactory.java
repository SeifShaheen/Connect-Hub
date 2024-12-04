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
/*

this approach does not support the open close principle
so make an abstarct class to create any thing and make a factory for each thing u wanna create
to make abstract factory: objects should be related to esach others 
The abstract factory responsible for creating more than one object, nevertheless the factory create one objrect from one type 
 

make a buider for creating a posts for entering text and photo optional 
*/
