/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

/**
 *
 * @author amrze
 */
public interface Operations {
    //group members handling methods
    public void approveMember(String admin,String member, String groupID );
    public void declineMember(String admin,String member, String groupID);
    public void removeMember(String admin,String member, String groupID);
   public void removeAdmin(String admin,String member, String groupID);
    public void promoteAdmin(String primaryAdmin,String admin, String groupID);
    public void demoteAdmin(String primaryAdmin,String admin, String groupID);
    //content handling methods
    public void createPost(String UserID, String groupID , String text);
    public void createPost(String UserID, String groupID, String text, String imagePath);
    public void approvePost(String UserID, String groupID,Post post);
    public void editPost(Post post, String UserID, String groupID ,String text);
    public void editPost(Post post, String UserID, String groupID, String text, String imagePath);
    public void deletePost(Post post,String UserID, String groupID); 
    //
    public void deleteGroup(String UserID, String groupID);
    public void leaveGroup(String UserID, String groupID);
  
}
