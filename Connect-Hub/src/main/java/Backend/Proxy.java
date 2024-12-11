package Backend;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Proxy implements Operations {

    private Operations operations = new GroupsOperations();
    
    //this function checks if the current user is admin
    public boolean isAdmin(String userID, String groupID) throws IOException {
        Map<String, Group> map = GroupsDataBase.read();
        if (map.keySet().contains(groupID)) {
            Group group = map.get(groupID);
            if (group.getAdmins().contains(userID)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPrimaryAdmin(String userID, String groupID) throws IOException {
        Map<String, Group> map = GroupsDataBase.read();
        if (map.keySet().contains(groupID)) {
            Group group = map.get(groupID);
            if (group.getPrimaryAdmin().equals(userID)) {
                return true;
            }
        }
        return false;
    }

    public boolean isMember(String userID, String groupID) throws IOException {
        Map<String, Group> map = GroupsDataBase.read();
        if (map.keySet().contains(groupID)) {
            Group group = map.get(groupID);
            if (group.getMembers().contains(userID)) {

                return true;
            }
        }
        return false;
    }

    @Override
    public void approveMember(String admin, String member, String groupID) {
        try {
            if ((isAdmin(admin, groupID) || isPrimaryAdmin(admin, groupID))) {

                operations.approveMember(admin, member, groupID);
            }

        } catch (IOException ex) {
            Logger.getLogger(Proxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void declineMember(String admin, String member, String groupID) {
        try {
            if ((isAdmin(admin, groupID) || isPrimaryAdmin(admin, groupID))) {

                operations.declineMember(admin, member, groupID);
            }
        } catch (IOException ex) {
            Logger.getLogger(Proxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeMember(String admin, String member, String groupID) {
        try {
            //admin or primary admin try to remove a member that is not in the admins list
            if ((isAdmin(admin, groupID) || isPrimaryAdmin(admin, groupID)) && isMember(member, groupID) && !isAdmin(member, groupID)) {
                operations.removeMember(admin, member, groupID);
            }
        } catch (IOException ex) {
            Logger.getLogger(Proxy.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @Override
    public void removeAdmin(String admin, String member, String groupID) {
        //primary admin try to remove admins
        try {
            if (isPrimaryAdmin(admin, groupID) && isAdmin(member, groupID)) {
                operations.removeAdmin(admin, member, groupID);
            }
        } catch (IOException ex) {
            Logger.getLogger(Proxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void promoteAdmin(String primaryAdmin, String admin, String groupID) {
        try {
            if (isPrimaryAdmin(admin, groupID) && isMember(admin, groupID) && !isAdmin(admin, groupID)) {

                operations.promoteAdmin(primaryAdmin, admin, groupID);
            }

        } catch (IOException ex) {
            Logger.getLogger(Proxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void demoteAdmin(String primaryAdmin, String admin, String groupID) {
        try {
            if (isPrimaryAdmin(admin, groupID) && isMember(admin, groupID) && !isAdmin(admin, groupID)) {

                operations.demoteAdmin(primaryAdmin, admin, groupID);
            }

        } catch (IOException ex) {
            Logger.getLogger(Proxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    public void deleteGroup(String UserID, String groupID) {
        try {
            if(isPrimaryAdmin(UserID, groupID))
            {
                operations.deleteGroup(UserID, groupID);
            }
        } catch (IOException ex) {
            Logger.getLogger(Proxy.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    @Override
    public void leaveGroup(String UserID, String groupID) {
        try {
            if(!isPrimaryAdmin(UserID, groupID))
            {
                operations.leaveGroup(UserID, groupID);
            }
        } catch (IOException ex) {
            Logger.getLogger(Proxy.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }

    @Override
    public void createPost(String UserID, String groupID, String text) {
        try {
            if(isPrimaryAdmin(UserID,groupID)|| isAdmin(UserID, groupID)||isMember(UserID, groupID)){
                operations.createPost(UserID, groupID, text);
            }
        } catch (IOException ex) {
            Logger.getLogger(Proxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void createPost(String UserID, String groupID, String text, String imagePath) {
        try {
            if(isPrimaryAdmin(UserID,groupID)|| isAdmin(UserID, groupID)||isMember(UserID, groupID)){
                operations.createPost(UserID, groupID, text,imagePath);
            }
        } catch (IOException ex) {
            Logger.getLogger(Proxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editPost(Post post, String UserID, String groupID, String text) {
        try {
            if(isPrimaryAdmin(UserID,groupID)|| isAdmin(UserID, groupID)||isMember(UserID, groupID)){
                operations.editPost(post,UserID, groupID, text);
            }
        } catch (IOException ex) {
            Logger.getLogger(Proxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void editPost(Post post, String UserID, String groupID, String text, String imagePath) {
        try {
            if(isPrimaryAdmin(UserID,groupID)|| isAdmin(UserID, groupID)||isMember(UserID, groupID)){
                operations.editPost(post,UserID, groupID, text, imagePath);
            }
        } catch (IOException ex) {
            Logger.getLogger(Proxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletePost(Post post,String UserID, String groupID) {
        try {
            if(isPrimaryAdmin(UserID, groupID)||isAdmin(UserID, groupID))
            {
                operations.deletePost(post,UserID,groupID);
            }
        } catch (IOException ex) {
            Logger.getLogger(Proxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void approvePost(String UserID, String groupID, Post post) {
        try {
            if(isPrimaryAdmin(UserID, groupID)||isAdmin(UserID, groupID))
            {
                operations.approvePost(UserID, groupID, post);
            }
        } catch (IOException ex) {
            Logger.getLogger(Proxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}
