/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author amrze
 */
public class StoriesFactory implements Creation{

    @Override
    public Content createContent() 
    {
            return new Story();
    }   
}
