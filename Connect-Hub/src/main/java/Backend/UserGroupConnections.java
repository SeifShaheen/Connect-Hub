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
public class UserGroupConnections {

    private User currentUser = null;

    public UserGroupConnections(User currentUser) {
        this.currentUser = currentUser;
    }

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
                    if(!group.getMembers().contains(currentUser.getUserId())&& !group.getPrimaryAdmin().equals(currentUser.getUserId()) &&!group.getRequests().contains(currentUser.getUserId()))
                    {
                        list.add(group);
                    }
                    
                }
            }
        return list;
    }
}
