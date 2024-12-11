/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import com.mycompany.connect.hub.User;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amrze
 */
//This calss is used as a connection between group object and the operations performed
public class GroupsOperations implements Operations {

    private Group group;

    //CHECK IN THE DATA BASE if the user is normal, admin or primary
    @Override
    public void approveMember(String admin,String member, String groupID ) {
        try {         
            GroupsDataBase.read().get(groupID).approveMember(member);
            save(groupID);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void declineMember(String admin,String member, String groupID ) {
        try {
            GroupsDataBase.read().get(groupID).declineMember(member);
            save(groupID);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeMember(String admin,String member, String groupID) {
        try {
            GroupsDataBase.read().get(groupID).removeMember(member);
            save(groupID);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void removeAdmin(String admin,String member, String groupID)
    {
        try {
            GroupsDataBase.read().get(groupID).removeAdmin(member);
            save(groupID);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void promoteAdmin(String primaryAdmin,String admin, String groupID) {
        try {
            GroupsDataBase.read().get(groupID).promoteAdmin(admin);
            save(groupID);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void demoteAdmin(String primaryAdmin,String admin, String groupID) {
        try {
            GroupsDataBase.read().get(groupID).demoteAdmin(admin);
            save(groupID);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public void deleteGroup(String UserID, String groupID) {
        try {
            GroupsDataBase.read().remove(groupID);
            save(groupID);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void leaveGroup(String UserID, String groupID) {
        try {
            GroupsDataBase.read().get(groupID).leaveGroup(UserID);
            save(groupID);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // content handling
    @Override
    public void createPost(String UserID, String groupID, String text) {
        try {
            GroupsDataBase.read().get(groupID).createPost(UserID, text);
            save(groupID);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void createPost(String UserID, String groupID, String text, String imagePath) {
        try {
            GroupsDataBase.read().get(groupID).createPost(UserID, text,imagePath);
            save(groupID);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editPost(Post post,String UserId, String groupID, String text) {
        try {
            GroupsDataBase.read().get(groupID).editPost(post, text);
            save(groupID);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void editPost(Post post,String UserID, String groupID, String text, String imagePath) {
        try {
            GroupsDataBase.read().get(groupID).editPost(post, text, imagePath);
            save(groupID);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletePost(Post post, String UserID, String groupID) {
        try {
            GroupsDataBase.read().get(groupID).removePost(post);
            save(groupID);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void approvePost(String UserID, String groupID, Post post)  {
          
        try {
            GroupsDataBase.read().get(groupID).getWaitingPosts().remove(post);
            save(groupID);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void save(String groupId) throws IOException, NoSuchAlgorithmException
    {
        Group group=GroupsDataBase.read().get(groupId);
        GroupsDataBase.save(group);
    }
        
    

}
