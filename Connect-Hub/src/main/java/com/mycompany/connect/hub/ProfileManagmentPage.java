/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.connect.hub;

import Backend.Post;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Etijah
 */
public class ProfileManagmentPage extends javax.swing.JFrame {

        /**
         * Creates new form ProfileManagmentPage
         */
        public ProfileManagmentPage() throws IOException {
                initComponents();
                this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setVisible(true);
                setResizable(false);
                setTitle(ConnectHub.currentUser.getUsername());
                partOfFriends.setVisible(true);
                setSize(new Dimension(390, 643));
                // ..............add cover Photo..............
                String coverPath = ConnectHub.currentUser.getCoverPhotoPath();
                if (coverPath != null) {
                        coverPh.setIcon(EditProfilePage.section(coverPath, null, coverPh.getWidth(),
                                        coverPh.getHeight()));
                }

                // ............add profile photo..............
                String profilePhoPath = ConnectHub.currentUser.getProfilePhotoPath();
                if (profilePhoPath != null) {
                        profilePh.setIcon(
                                        EditProfilePage.section(profilePhoPath, null, profilePh.getWidth(),
                                                        profilePh.getHeight()));
                } else {
                        profilePh.setIcon(EditProfilePage.section("src\\main\\java\\icons\\profile-user.png", null,
                                        profilePh.getWidth(), profilePh.getHeight()));

                }
                // ...................add user name......................
                String use = ConnectHub.currentUser.getUsername();
                userName.setText(use);
                // ............add the current bio..............
                String bio = ConnectHub.currentUser.getBio();
                if (bio != null) {
                        currentBio.setText(bio);
                }
                currentBio.setEnabled(false);
                currentBio.setDisabledTextColor(Color.black);
                currentBio.setLineWrap(true);
                currentBio.setWrapStyleWord(true);
                currentBio.setRows(0);
                // ....................add friends ..................
                ArrayList<String> friends = ConnectHub.currentUser.getFriends();
                partOfFriends.setLayout(new BoxLayout(partOfFriends, BoxLayout.X_AXIS));
                for (int i = 0; i < 3 && i < ConnectHub.currentUser.getFriends().size(); i++) {
                        User friend = FilesManagement.map.get(friends.get(i));
                        JPanel newpanel = new JPanel();
                        newpanel.setLayout(new BoxLayout(newpanel, BoxLayout.Y_AXIS));
                        newpanel.setBackground(Color.white);
                        newpanel.setPreferredSize(new Dimension(150, 200));
                        newpanel.setLayout(new FlowLayout());
                        JLabel friendImage = new JLabel();
                        if (friend.getProfilePhotoPath() != null) {
                                friendImage.setIcon(EditProfilePage.section(friend.getProfilePhotoPath(), null,
                                                profilePh.getWidth(),
                                                profilePh.getHeight()));
                        } else {
                                friendImage.setIcon(EditProfilePage.section("src\\main\\java\\icons\\profile-user.png",
                                                null,
                                                profilePh.getWidth(), profilePh.getHeight()));

                        }
                        friendImage.setPreferredSize(new Dimension(20, 20));
                        JLabel friendUserName = new JLabel();
                        String userf = friend.getUsername();
                        friendUserName.setText(userf);
                        JLabel friendStatus = new JLabel();
                        String statusF = friend.getStatus();
                        friendStatus.setText(statusF);
                        newpanel.add(friendImage);
                        newpanel.add(friendUserName);
                        newpanel.add(friendStatus);
                        partOfFriends.add(newpanel);

                }
                // ...............add Posts...................
                ArrayList<Post> posts = ConnectHub.currentUser.getPosts();
                postsPanel.setLayout(new BoxLayout(postsPanel, BoxLayout.Y_AXIS));
                for (Post post : posts) {
                        postsPanel.add(new postPanel(post, ConnectHub.currentUser));
                }
                setVisible(false);
                setVisible(true);
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                scrollPane1 = new java.awt.ScrollPane();
                jPanel1 = new javax.swing.JPanel();
                jScrollPane2 = new javax.swing.JScrollPane();
                postsPanel = new javax.swing.JPanel();
                jLabel4 = new javax.swing.JLabel();
                userName = new javax.swing.JLabel();
                jButton1 = new javax.swing.JButton();
                jLabel3 = new javax.swing.JLabel();
                jButton2 = new javax.swing.JButton();
                partOfFriends = new javax.swing.JPanel();
                jPanel2 = new javax.swing.JPanel();
                profilePh = new javax.swing.JLabel();
                coverPh = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                currentBio = new javax.swing.JTextArea();
                jLabel4 = new javax.swing.JLabel();
                jLabel4 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                scrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

                jPanel1.setBackground(new java.awt.Color(255, 255, 255));

                javax.swing.GroupLayout postsPanelLayout = new javax.swing.GroupLayout(postsPanel);
                postsPanel.setLayout(postsPanelLayout);
                postsPanelLayout.setHorizontalGroup(
                                postsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 306, Short.MAX_VALUE));
                postsPanelLayout.setVerticalGroup(
                                postsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 214, Short.MAX_VALUE));

                jScrollPane2.setViewportView(postsPanel);

                jLabel4.setBackground(new java.awt.Color(255, 255, 255));
                jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
                jLabel4.setForeground(new java.awt.Color(153, 153, 153));
                jLabel4.setText("Posts");
                jLabel4.setOpaque(true);

                userName.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N

                jButton1.setBackground(new java.awt.Color(0, 204, 255));
                jButton1.setForeground(new java.awt.Color(255, 255, 255));
                jButton1.setText("EditProfile");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
                jLabel3.setForeground(new java.awt.Color(153, 153, 153));
                jLabel3.setText("Friends");

                jButton2.setBackground(new java.awt.Color(0, 204, 255));
                jButton2.setForeground(new java.awt.Color(255, 255, 255));
                jButton2.setText("See all Friends");
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });

                partOfFriends.setBackground(new java.awt.Color(204, 204, 204));

                javax.swing.GroupLayout partOfFriendsLayout = new javax.swing.GroupLayout(partOfFriends);
                partOfFriends.setLayout(partOfFriendsLayout);
                partOfFriendsLayout.setHorizontalGroup(
                                partOfFriendsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 281, Short.MAX_VALUE));
                partOfFriendsLayout.setVerticalGroup(
                                partOfFriendsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGap(0, 100, Short.MAX_VALUE));

                jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                profilePh.setBackground(new java.awt.Color(204, 204, 204));
                profilePh.setOpaque(true);
                jPanel2.add(profilePh, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 45, 66, 64));
                jPanel2.add(coverPh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 110));

                currentBio.setColumns(20);
                currentBio.setRows(5);
                jScrollPane1.setViewportView(currentBio);

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(181, 181, 181)
                                                                                                .addComponent(jButton1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                100,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(12, 12, 12)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                false)
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                                                false)
                                                                                                                                .addComponent(userName,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                153,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(jLabel3,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                                83,
                                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addComponent(jPanel2,
                                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                                275,
                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                .addComponent(jScrollPane1))
                                                                                                                .addComponent(jButton2,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                281,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jLabel4,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                97,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(partOfFriends,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jScrollPane2,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                0,
                                                                                                                                Short.MAX_VALUE))))
                                                                .addContainerGap(46, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(4, 4, 4)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(userName,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                33,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jButton1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                33,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                43, Short.MAX_VALUE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel3,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                26,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(partOfFriends,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButton2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                29,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jScrollPane2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(26, 26, 26)));

                scrollPane1.add(jPanel1);

                jLabel4.setBackground(new java.awt.Color(255, 255, 255));
                jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
                jLabel4.setForeground(new java.awt.Color(153, 153, 153));
                jLabel4.setText("Posts");
                jLabel4.setOpaque(true);

                jLabel4.setBackground(new java.awt.Color(255, 255, 255));
                jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
                jLabel4.setForeground(new java.awt.Color(153, 153, 153));
                jLabel4.setText("Posts");
                jLabel4.setOpaque(true);

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(47, Short.MAX_VALUE)
                                                                .addComponent(scrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                338,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(56, Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 648,
                                                                Short.MAX_VALUE));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
                new EditProfilePage();
        }// GEN-LAST:event_jButton1ActionPerformed

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
                FriendsPage FriendsPage = new FriendsPage();
                FriendsPage.setVisible(true);
        }// GEN-LAST:event_jButton2ActionPerformed

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
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(ProfileManagmentPage.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(ProfileManagmentPage.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(ProfileManagmentPage.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(ProfileManagmentPage.class.getName()).log(
                                        java.util.logging.Level.SEVERE,
                                        null, ex);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                                try {
                                        new ProfileManagmentPage().setVisible(true);
                                } catch (IOException ex) {
                                        Logger.getLogger(ProfileManagmentPage.class.getName()).log(Level.SEVERE, null,
                                                        ex);
                                }
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel coverPh;
        private javax.swing.JTextArea currentBio;
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JPanel partOfFriends;
        private javax.swing.JPanel postsPanel;
        private javax.swing.JLabel profilePh;
        private java.awt.ScrollPane scrollPane1;
        private javax.swing.JLabel userName;
        // End of variables declaration//GEN-END:variables
}
