/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amrze
 */
// This calss is used as a connection between group object and the operations
// performed
public class GroupsOperations implements Operations {

    @SuppressWarnings("unused")
    private Group group;

    // CHECK IN THE DATA BASE if the user is normal, admin or primary
    @Override
    public void approveMember(String admin, String member, String groupID) {
        try {
            Group group = GroupsDataBase.read().get(groupID);
            group.approveMember(member);
            save(group);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void declineMember(String admin, String member, String groupID) {
        try {
            Group group = GroupsDataBase.read().get(groupID);
            group.declineMember(member);
            save(group);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removeMember(String admin, String member, String groupID) {
        try {
            Group group = GroupsDataBase.read().get(groupID);
            group.removeMember(member);
            save(group);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeAdmin(String admin, String member, String groupID) {
        try {
            Group group = GroupsDataBase.read().get(groupID);
            group.removeAdmin(member);
            save(group);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void promoteAdmin(String primaryAdmin, String admin, String groupID) {
        try {
            Group group = GroupsDataBase.read().get(groupID);
            group.promoteAdmin(admin);
            save(group);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void demoteAdmin(String primaryAdmin, String admin, String groupID) {
        try {
            Group group = GroupsDataBase.read().get(groupID);
            group.demoteAdmin(admin);
            save(group);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteGroup(String UserID, String groupID) {
        try {
            Map<String, Group> map = GroupsDataBase.read();
            map.remove(groupID);
            save(map);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void leaveGroup(String UserID, String groupID) {
        try {
            Group group = GroupsDataBase.read().get(groupID);
            group.leaveGroup(UserID);
            save(group);
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
            Group group = GroupsDataBase.read().get(groupID);

            group.createPost(UserID, text);
            save(group);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void createPost(String UserID, String groupID, String text, String imagePath) {
        try {
            Group group = GroupsDataBase.read().get(groupID);

            group.createPost(UserID, text, imagePath);
            save(group);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editPost(Post post, String UserId, String groupID, String text) {
        try {
            Group group = GroupsDataBase.read().get(groupID);
            group.editPost(post, text);
            save(group);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void editPost(Post post, String UserID, String groupID, String text, String imagePath) {
        try {
            Group group = GroupsDataBase.read().get(groupID);
            group.editPost(post, text, imagePath);
            save(group);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletePost(Post post, String UserID, String groupID) {
        try {
            Group group = GroupsDataBase.read().get(groupID);
            group.removePost(post);
            save(group);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void save(Group group) throws IOException, NoSuchAlgorithmException {
        GroupsDataBase.save(group);
    }

    public void save(Map<String, Group> map) throws IOException, NoSuchAlgorithmException {
        GroupsDataBase.save(map);
    }

    @Override
    public void requestJoin(String member, String groupID) {

        try {
            Group group = GroupsDataBase.read().get(groupID);
            group.requestJoin(member, groupID);
            save(group);
        } catch (IOException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GroupsOperations.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
