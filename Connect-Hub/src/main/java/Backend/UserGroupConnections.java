/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import com.mycompany.connect.hub.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Reem
 */
//This class created to connect the user with the groups to get the groups that the user has joined and suggest new groups
public class UserGroupConnections {

    private User currentUser = null;

    public UserGroupConnections(User currentUser) {
        this.currentUser = currentUser;
    }
    
    //this method to return a list that the user is member in it 
    public ArrayList<Group> getMemberGroups() throws IOException {
        ArrayList<Group> list = new ArrayList<>();
        Map<String, Group> map = GroupsDataBase.read();
        Operations operations = new Proxy();
        if (map.isEmpty() || map == null) {
            return list;
        } else {
                for (Map.Entry<String, Group> entry : map.entrySet()) {
                    Group group = entry.getValue();
                    if(group.getMembers().contains(currentUser.getUserId()))
                    {
                        list.add(group);
                    }
                    
                }
            }
        
        return list;
    }
    
    //this method to return a list that the user is owner in it 
    public ArrayList<Group> getOwnerGroups() throws IOException {
        ArrayList<Group> list = new ArrayList<>();
        Map<String, Group> map = GroupsDataBase.read();
        Operations operations = new Proxy();
        if (map.isEmpty() || map == null) {
            return list;
        } else {
                for (Map.Entry<String, Group> entry : map.entrySet()) {
                    Group group = entry.getValue();
                    if(group.getPrimaryAdmin().equals(currentUser.getUserId()))
                    {
                        list.add(group);
                    }
                    
                }
            }
        
        return list;
    }
    //this method to return a list that the user is admin in it 
    public ArrayList<Group> getAdminGroups() throws IOException {
        ArrayList<Group> list = new ArrayList<>();
        Map<String, Group> map = GroupsDataBase.read();
        Operations operations = new Proxy();
        if (map.isEmpty() || map == null) {
            return list;
        } else {
                for (Map.Entry<String, Group> entry : map.entrySet()) {
                    Group group = entry.getValue();
                    if(group.getAdmins().contains(currentUser.getUserId()))
                    {
                        list.add(group);
                    }
                    
                }
            }
        
        return list;
    }
    //suggest new groups for the user
    public ArrayList<Group> suggestions() throws IOException
    {
        ArrayList<Group> list = new ArrayList<>();
        Map<String, Group> map = GroupsDataBase.read();
        Operations operations = new Proxy();
        if (map.isEmpty() || map == null) {
            return list;
        } else {
                for (Map.Entry<String, Group> entry : map.entrySet()) {
                    Group group = entry.getValue();
                    //checks if the user is not in the group or has not left the group before suggestions
                    if(!group.getMembers().contains(currentUser.getUserId())&& !group.getPrimaryAdmin().equals(currentUser.getUserId())
                       &&!group.getRequests().contains(currentUser.getUserId()) && !group.getLeftUsers().contains(currentUser.getUserId()))
                    {
                        list.add(group);
                    }
                    
                }
            }
        return list;
    }
}
