/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;
import Backend.Content;
import Backend.Post;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author amrze
 */
public class StoringContent {
    
    public static void store(Content content )
    {
        JSONObject contentData=new JSONObject();
        contentData.put("contentID", 0); // put a unique content id
        contentData.put("authorId", 1); //get user id who create it
        contentData.put("content", content instanceof Post? ((Post)content).getText() : ((Story)content).getText());
        contentData.put("timestamp",content instanceof Post?((Post)content).getTimestamp():((Story)content).getTimestamp() );  
              
        JSONObject existingData =readExistingData("data.json");
        JSONArray posts=existingData.optJSONArray("posts");
        
        
        if(posts==null)
        {
            posts=new JSONArray();
            existingData.put("posts", posts);
        }
        posts.put(contentData);
        try{
            
            FileWriter writer=new FileWriter("data.json");
            writer.write(existingData.toString(4));
            writer.close(); 
        }
        catch(IOException e){
                        
        }
    }
    private static JSONObject readExistingData(String filename)
    {
        try{
            File file=new File(filename);
            if(file.exists())
            {
                String data=new String(Files.readAllBytes(Paths.get(filename)));
                return new JSONObject(data);
                
            }
            
        }
        catch(IOException e)
        {
        }
        return new JSONObject();
    }
    
    
}
