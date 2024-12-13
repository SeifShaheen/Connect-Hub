/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.connect.hub;

import Backend.Group;
import Backend.Post;
import Backend.UserGroupConnections;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

/**
 *
 * @author seifs
 */
public class Notifications extends javax.swing.JFrame {

    /**
     * Creates new form Notifications
     */
    public Notifications() throws IOException {
        initComponents();
        setVisible(true);
        setTitle("Notifications");
        setResizable(false);
        this.setSize(new Dimension(500, 200));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainPanel.setVisible(true);
        this.setLayout(new GridLayout());
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        jLabel1.setText("Requests: " + ConnectHub.currentUser.getRequestsRecieved().size());
        FriendSpecifications friendSpecifications = ConnectHub.currentUser;
        ArrayList<String> requests = friendSpecifications.getRequestsRecieved();
        for (String f : requests) { //display friend requests
            User friend = FilesManagement.map.get(f);
            mainPanel.add(new NotificationsPanel(friend), BoxLayout.Y_AXIS);
        }
        UserGroupConnections groupsManagement = new UserGroupConnections(ConnectHub.currentUser);
        ArrayList<Group> memberGroups = groupsManagement.getMemberGroups();
        ArrayList<Group> ownerGroups = groupsManagement.getMemberGroups();
        if (ownerGroups.isEmpty() && memberGroups.isEmpty()) {
            //no notifications    
        } else if (ownerGroups.isEmpty() && !memberGroups.isEmpty()) { //if user is member not owmer 
            for (Group group : memberGroups) {
                if (!group.getAdmins().contains(ConnectHub.currentUser.getUserId())) { //if not admin
                    displayPosts(group, ConnectHub.currentUser);
                } else { //if admin
                    displayPosts(group, ConnectHub.currentUser);
                    displayrequestedPosts(group, ConnectHub.currentUser);
                    displayJoinRequests(group, ConnectHub.currentUser);
                }
            }
        } else if (!ownerGroups.isEmpty()) {
            for (Group group : ownerGroups) {
                displayPosts(group, ConnectHub.currentUser);
                displayrequestedPosts(group, ConnectHub.currentUser);
                displayJoinRequests(group, ConnectHub.currentUser);
            }
        }

        mainPanel.revalidate();
        mainPanel.update(mainPanel.getGraphics());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane1 = new java.awt.ScrollPane();
        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainPanel.setLayout(null);
        mainPanel.add(jLabel1);
        jLabel1.setBounds(0, 0, 0, 0);

        scrollPane1.add(mainPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Notifications.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notifications.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notifications.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notifications.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Notifications().setVisible(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void displayPosts(Group group, User user) throws IOException {
        for (Post post : group.getPosts()) {
            String note = "";
            String author = FilesManagement.read().get(post.getAuthorID()).getUsername();
            note += author + " has posted a post in " + group.getGroupName();
            mainPanel.add(new NotificationsPanel(note), BoxLayout.Y_AXIS);
        }
    }

    public void displayrequestedPosts(Group group, User user) throws IOException {
        for (Post post : group.getWaitingPosts()) {
            String note = "";
            String author = FilesManagement.read().get(post.getAuthorID()).getUsername();
            note += author + " requests posting a post in " + group.getGroupName();
            mainPanel.add(new NotificationsPanel(note), BoxLayout.Y_AXIS);
        }
    }

    public void displayJoinRequests(Group group, User user) throws IOException {
        for (String id : group.getRequests()) {
            String note = "";
            String name = FilesManagement.read().get(id).getUsername();
            note += name + " requests to join " + group.getGroupName();
            mainPanel.add(new NotificationsPanel(note), BoxLayout.Y_AXIS);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel mainPanel;
    private java.awt.ScrollPane scrollPane1;
    // End of variables declaration//GEN-END:variables
}
