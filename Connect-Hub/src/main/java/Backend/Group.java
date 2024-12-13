
package Backend;

import com.mycompany.connect.hub.FilesManagement;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.UUID;

//This Class responsible for the main components of the group
public class Group {
    private String groupName;
    private String groupID;
    private String description;
    private String imagePath;
    private ArrayList<String> members;
    private ArrayList<String> admins;
    private ArrayList<String> requests;
    private ArrayList<Post> posts;
    private String primaryAdmin;
    private ArrayList<String> leftUsers;

    public Group(String groupName, String userID) throws NoSuchAlgorithmException, IOException {
        this.groupID = UUID.randomUUID().toString();
        this.groupName = groupName;
        this.members = new ArrayList<>();
        this.admins = new ArrayList<>();
        this.requests = new ArrayList<>();
        this.posts = new ArrayList<>();
        this.leftUsers = new ArrayList<>();
        this.primaryAdmin = userID;
        GroupsDataBase.save(this);
    }

    // getters and setters that will be used
    public String getGroupName() {
        return groupName;
    }

    public String getDescription() {
        return description;
    }
    
    public String getImagePath() {
        return imagePath;
    }
    
    public ArrayList<String> getMembers() {
        return members;
    }
    
    public ArrayList<String> getAdmins() {
        return admins;
    }
    
    public ArrayList<Post> getPosts() {
        return posts;
    }
    
    public String getPrimaryAdmin() {
        return primaryAdmin;
    }

    public String getImagePath() {
        return imagePath;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public ArrayList<String> getAdmins() {
        return admins;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public String getPrimaryAdmin() {
        return primaryAdmin;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGroupID() {

        return this.groupID;
    }
    
    public ArrayList<String> getRequests() {
        return requests;
    }
    
    public ArrayList<String> getLeftUsers() {
        return leftUsers;
    }  

    public ArrayList<String> getRequests() {
        return requests;
    }

    public ArrayList<String> getLeftUsers() {
        return leftUsers;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setMembers(ArrayList<String> members) {
        this.members = members;
    }
    
    public void setAdmins(ArrayList<String> admins) {
        this.admins = admins;
    }
    
    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    //Groups management methods

    public void setAdmins(ArrayList<String> admins) {
        this.admins = admins;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    // Groups management methods

    public void approveMember(String userId) {

        this.requests.remove(userId);
        this.members.add(userId);
    }
    public void declineMember(String userId)
    {
        this.requests.remove(userId);
    } 
    public void removeMember(String userID)
    {
        this.members.remove(userID);
    }
    public void removeAdmin(String userID)
    {
        this.admins.remove(userID);
        this.members.remove(userID);
    }

    public void promoteAdmin(String userId) {

        this.admins.add(userId);
    }
    public void demoteAdmin(String userId)
    {
        this.admins.remove(userId);
    }

    public void addRequest(String UserID) {
        this.requests.add(UserID);
    }

    // content handling

    public void editPost(Post post, String text) {
        posts.remove(post);

        post.setText(text);
        posts.add(post);
    }

    public void editPost(Post post, String text, String imagePath) {
        posts.remove(post);

        post.setText(text);
        post.setImagePath(imagePath);
        posts.add(post);
    }
    
    public void removePost(Post post)
    {
        posts.remove(post);
    }

    public void createPost(String member, String text) throws IOException {
        Post post = (Post) PostsFactory.createContent(text, FilesManagement.read().get(member));
        posts.add(post);
    }

    public void createPost(String member, String text, String imagePath) throws IOException {
        Post post = (Post) PostsFactory.createContent(text, imagePath, FilesManagement.read().get(member));
        post.setAuthorID(member);
        posts.add(post);
    }

    public void leaveGroup(String userId) {

        this.members.remove(userId);
        if(this.admins.contains(userId))
        {
            this.admins.remove(userId);
        }
        addLeftUser(userId);

    }
        
    public void requestJoin(String member, String groupID)
    {
        this.requests.add(member);
    } 

    public void addLeftUser(String userID) {
        this.leftUsers.add(userID);
    }

}
