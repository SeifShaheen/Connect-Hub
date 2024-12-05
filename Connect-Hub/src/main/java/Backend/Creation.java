/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

//An interface for the the factories of contents to inherit from 
public interface Creation {

    Contents createContent(String text);
    Contents createContent(String text, String imagePath);
}
