
package Backend;

import com.mycompany.connect.hub.ConnectHub;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.UUID;


public class Group {
    private String groupName;
    private String groupID;
    private String description;
    private String imagePath;
    private ArrayList<String> members;
    private ArrayList<String> admins;
    private ArrayList<String> requests;
    private ArrayList<Post> posts;
    private ArrayList<Post> waitingPosts;
    private String primaryAdmin;
    
    public Group(String groupName, String userID ) throws NoSuchAlgorithmException, IOException {
        this.groupID= UUID.randomUUID().toString();
        this.groupName=groupName;
        this.members=new ArrayList<>();
        this.admins=new ArrayList<>();
        this.requests=new ArrayList<>();
        this.posts=new ArrayList<>();
        this.waitingPosts=new ArrayList<>();
        this.primaryAdmin=userID;
        GroupsDataBase.save(this);
    }

    public String getGroupName() {
        return groupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<String> members) {
        this.members = members;
    }

    public void approveMember(String userId)
    {
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
    
    public ArrayList<String> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<String> admins) {
        this.admins = admins;
    }
    
    public void promoteAdmin(String userId)
    {
        this.admins.add(userId);
    }
    public void demoteAdmin(String userId)
    {
        this.admins.remove(userId);
    }

    public String getPrimaryAdmin() {
        return primaryAdmin;
    }
    
    public String getGroupID(){
        return this.groupID;
    }

    public ArrayList<String> getRequests() {
        return requests;
    }

    public void addRequest(String UserID) {
        this.requests.add(UserID);
    }
    
    //content handling
    public void approvePost(Post post)
    {
        posts.add(post);
        waitingPosts.remove(post);
    }
    public void editPost(Post post,String text)
    {
        post.setText(text);
    }
    public void editPost(Post post,String text,String imagePath)
    {
        post.setText(text);
        post.setImagePath(imagePath);
    }
    public void removePost(Post post)
    {
        posts.remove(post);
    }
    public void createPost(String member, String text)  {
        Post post = (Post) PostsFactory.createContent(text,ConnectHub.currentUser);
        post.setAuthorID(member);
        waitingPosts.add(post); 
    }

    public void createPost(String member, String text, String imagePath)  {
        Post post = (Post) PostsFactory.createContent(text, imagePath,ConnectHub.currentUser);
        post.setAuthorID(member);
        waitingPosts.add(post);
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public ArrayList<Post> getWaitingPosts() {
        return waitingPosts;
    }

    public void setWaitingPosts(ArrayList<Post> waitingPosts) {
        this.waitingPosts = waitingPosts;
    }
    
   
    // we have to remove the group from the user newsfeed and from group suggestions
    public void leaveGroup(String userId)
    {
        this.members.remove(userId);
        if(this.admins.contains(userId))
        {
            this.admins.remove(userId);
        }
        
    }
        
    public void requestJoin(String member, String groupID)
    {
        this.requests.add(member);
    }
    
    
}
