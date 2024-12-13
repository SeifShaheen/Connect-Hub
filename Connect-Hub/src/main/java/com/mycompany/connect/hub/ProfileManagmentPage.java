/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.connect.hub;

import Backend.Post;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.lang.model.util.ElementScanner14;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Etijah
 */
public class ProfileManagmentPage extends javax.swing.JFrame {
        static User user;

        /**
         * Creates new form ProfileManagmentPage
         */
        public ProfileManagmentPage(User user) throws IOException {
                initComponents();
                ProfileManagmentPage.user = user;
                this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setVisible(true);
                // setResizable(false);
                setTitle(user.getUsername());
                partOfFriends1.setVisible(true);
                setSize(new Dimension(420, 643));
                // ..............add cover Photo..............
                String coverPath = user.getCoverPhotoPath();
                if (coverPath != null) {
                        coverPh1.setIcon(EditProfilePage.section(coverPath, null, coverPh1.getWidth(),
                                        coverPh1.getHeight()));
                }

                // ............add profile photo..............
                String profilePhoPath = user.getProfilePhotoPath();
                if (profilePhoPath != null) {
                        profilePh1.setIcon(
                                        EditProfilePage.section(profilePhoPath, null, profilePh1.getWidth(),
                                                        profilePh1.getHeight()));
                } else {
                        profilePh1.setIcon(EditProfilePage.section("src\\main\\java\\icons\\profile-user.png", null,
                                        profilePh1.getWidth() + 1, profilePh1.getHeight() + 1));
        }
        // ...................add user name......................
        String use = user.getUsername();
        userName1.setText(use);
        // ............add the current bio..............
        String bio = user.getBio();
        if (bio != null) {
            currentBio1.setText(bio);
        }
        currentBio1.setEnabled(false);
        currentBio1.setDisabledTextColor(Color.black);
        currentBio1.setLineWrap(true);
        currentBio1.setWrapStyleWord(true);
        currentBio1.setRows(0);
        // ....................add friends ..................
        ArrayList<String> friends = user.getFriends();
        partOfFriends1.setLayout(new BoxLayout(partOfFriends1, BoxLayout.X_AXIS));
        for (int i = 0; i < 3 && i < user.getFriends().size(); i++) {
            User friend = FilesManagement.map.get(friends.get(i));
            JPanel newpanel = new JPanel();
            newpanel.setLayout(new BoxLayout(newpanel, BoxLayout.Y_AXIS));
            newpanel.setBackground(Color.white);
            newpanel.setPreferredSize(new Dimension(150, 200));
            newpanel.setLayout(new FlowLayout());
            JLabel friendImage = new JLabel();
            if (friend.getProfilePhotoPath() != null) {
                friendImage.setIcon(EditProfilePage.section(friend.getProfilePhotoPath(), null, profilePh1.getWidth(),
                        profilePh1.getHeight()));
            } else {
                friendImage.setIcon(EditProfilePage.section("src\\main\\java\\icons\\profile-user.png", null,
                        profilePh1.getWidth() + 1, profilePh1.getHeight() + 1));

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
            partOfFriends1.add(newpanel);
        }
        // ...............add Posts...................
        ArrayList<Post> posts = user.getPosts();
        postsPanel3.setLayout(new BoxLayout(postsPanel3, BoxLayout.Y_AXIS));
        for (Post post : posts) {
            postsPanel3.add(new postPanel(post, user));
        }
        // ............change the profile...
        newPanel3.setLayout(new BoxLayout(newPanel3, BoxLayout.X_AXIS));
        newPanel3.setVisible(false);
        changePanel1.setVisible(false);
        if(user.getUserId().equals(ConnectHub.currentUser.getUserId())){
            changePanel1.setVisible(true);
        }
        else if (ConnectHub.currentUser.getRequestsRecieved().contains(user)) {
            JButton accept = new JButton("accept");
            accept.setForeground(new Color(255,255,255));
            accept.setBackground(new Color(0,204,255));
             JButton  decline = new JButton(" decline");
             decline.setForeground(new Color(255,255,255));
             decline.setBackground(new Color(0,204,255));
             accept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean acc = FriendManagement.Request.approve(user, ConnectHub.currentUser);
                    if (acc) {
                        JOptionPane.showMessageDialog(null, user.getUsername() + " became a friend", "Message",
                                JOptionPane.INFORMATION_MESSAGE);
                        ConnectHub.currentUser.friendSuggestions.remove(user.getUserId());
                        user.friendSuggestions.remove(ConnectHub.currentUser.getUserId());
                        FilesManagement.map.put(ConnectHub.currentUser.getUserId(), ConnectHub.currentUser);
                        FilesManagement.map.put(user.getUserId(), user);
                        FilesManagement.save(FilesManagement.map);
                    } else {
                        JOptionPane.showMessageDialog(null, "There was an error.", "Message",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NoSuchAlgorithmException | IOException ex) {
                    Logger.getLogger(NotificationsPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        decline.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean dec = FriendManagement.Request.decline(user, ConnectHub.currentUser);
                    if (dec) {
                        JOptionPane.showMessageDialog(null, user.getUsername() + " was declined", "Message",
                                JOptionPane.INFORMATION_MESSAGE);
                        ConnectHub.currentUser.friendSuggestions.remove(user.getUserId());
                        user.friendSuggestions.remove(ConnectHub.currentUser.getUserId());
                        FilesManagement.map.put(ConnectHub.currentUser.getUserId(), ConnectHub.currentUser);
                        FilesManagement.map.put(user.getUserId(), user);
                        FilesManagement.save(FilesManagement.map);
                    } else {
                        JOptionPane.showMessageDialog(null, "There was an error.", "Message",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NoSuchAlgorithmException | IOException ex) {
                    Logger.getLogger(NotificationsPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
         newPanel3.add(accept);
         newPanel3.add(Box.createHorizontalStrut(30));
            newPanel3.add( decline);
            newPanel3.setVisible(true);

        } else if (ConnectHub.currentUser.getFriends().contains(user.getUserId())) {
            JButton block = new JButton("Block");
            block.setForeground(new Color(255,255,255));
            block.setBackground(new Color(0,204,255));
            block.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        boolean sen = FriendManagement.Request.block(ConnectHub.currentUser, user);
                        if (sen) {
                            JOptionPane.showMessageDialog(null, "Blocked " + user.getUsername(),
                                    "Message",
                                    JOptionPane.INFORMATION_MESSAGE);
                            FilesManagement.map.put(ConnectHub.currentUser.getUserId(),
                                    ConnectHub.currentUser);
                            FilesManagement.map.put(user.getUserId(), user);
                            FilesManagement.save(FilesManagement.map);
                        } else {
                            JOptionPane.showMessageDialog(null, "There was an error.", "Message",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NoSuchAlgorithmException | IOException ex) {
                        Logger.getLogger(NotificationsPanel.class.getName()).log(Level.SEVERE, null,
                                ex);
                    }
                }
            });
            JButton remove = new JButton("Remove");
            remove.setForeground(new Color(255,255,255));
            remove.setBackground(new Color(0,204,255));
            remove.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        boolean sen = FriendManagement.Request.unFriend(ConnectHub.currentUser,
                                user);
                        if (sen) {
                            JOptionPane.showMessageDialog(null, "Removed " + user.getUsername(),
                                    "Message",
                                    JOptionPane.INFORMATION_MESSAGE);
                            FilesManagement.map.put(ConnectHub.currentUser.getUserId(),
                                    ConnectHub.currentUser);
                            FilesManagement.map.put(user.getUserId(), user);
                            FilesManagement.save(FilesManagement.map);
                        } else {
                            JOptionPane.showMessageDialog(null, "There was an error.", "Message",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NoSuchAlgorithmException | IOException ex) {
                        Logger.getLogger(NotificationsPanel.class.getName()).log(Level.SEVERE, null,
                                ex);
                    }
                }
            });
            newPanel3.add(remove);
           newPanel3.add(Box.createHorizontalStrut(30));
            newPanel3.add(block);
            remove.setVisible(true);
            newPanel3.setVisible(true);
        } else if (!(ConnectHub.currentUser.getFriends().contains(user.getUserId()))
                && !(user.getBlockedBy().contains(ConnectHub.currentUser.getUserId()))) {
            JButton add = new JButton("Add ");
            add.setForeground(new Color(255,255,255));
            add.setBackground(new Color(0,204,255));
            add.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        boolean sen = FriendManagement.Request.send(ConnectHub.currentUser, user);
                        if (sen) {
                            JOptionPane.showMessageDialog(null, "Sent a request to " +
                                    user.getUsername(), "Message",
                                    JOptionPane.INFORMATION_MESSAGE);
                            ConnectHub.currentUser.friendSuggestions.remove(user.getUserId());
                            user.friendSuggestions.remove(ConnectHub.currentUser.getUserId());
                            FilesManagement.map.put(ConnectHub.currentUser.getUserId(),
                                    ConnectHub.currentUser);
                            FilesManagement.map.put(user.getUserId(), user);
                            FilesManagement.save(FilesManagement.map);
                        } else {
                                friendImage.setIcon(EditProfilePage.section("src\\main\\java\\icons\\profile-user.png",
                                                null,
                                                profilePh1.getWidth() + 1, profilePh1.getHeight() + 1));

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
                        partOfFriends1.add(newpanel);
                }
            });
            
            JButton block = new JButton("Block");
            block.setForeground(new Color(255,255,255));
            block.setBackground(new Color(0,204,255));
            block.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        boolean sen = FriendManagement.Request.block(ConnectHub.currentUser, user);
                        if (sen) {
                            JOptionPane.showMessageDialog(null, "Blocked " + user.getUsername(),
                                    "Message",
                                    JOptionPane.INFORMATION_MESSAGE);
                            FilesManagement.map.put(ConnectHub.currentUser.getUserId(),
                                    ConnectHub.currentUser);
                            FilesManagement.map.put(user.getUserId(), user);
                            FilesManagement.save(FilesManagement.map);
                        } else {
                            JOptionPane.showMessageDialog(null, "There was an error.", "Message",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NoSuchAlgorithmException | IOException ex) {
                        Logger.getLogger(NotificationsPanel.class.getName()).log(Level.SEVERE, null,
                                ex);
                    }
                }
            });
            newPanel3.add(add);
            newPanel3.add(Box.createHorizontalStrut(30));
            newPanel3.add(block);
            newPanel3.setVisible(true);
        }

        else if (user.getBlockedBy().contains(ConnectHub.currentUser.getUserId())) {
            JButton unblock = new JButton("Unblock");
            unblock.setForeground(new Color(255,255,255));
            unblock.setBackground(new Color(0,204,255));
            unblock.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        boolean sen = FriendManagement.Request.unBlock(ConnectHub.currentUser, user);
                        if (sen) {
                            JOptionPane.showMessageDialog(null, "Unblocked " + user.getUsername(),
                                    "Message",
                                    JOptionPane.INFORMATION_MESSAGE);
                            FilesManagement.map.put(ConnectHub.currentUser.getUserId(),
                                    ConnectHub.currentUser);
                            FilesManagement.map.put(user.getUserId(), user);
                            FilesManagement.save(FilesManagement.map);
                        } else {
                            JOptionPane.showMessageDialog(null, "There was an error.", "Message",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (NoSuchAlgorithmException | IOException ex) {
                        Logger.getLogger(NotificationsPanel.class.getName()).log(Level.SEVERE, null,
                                ex);
                    }
                }

                setVisible(false);
                setVisible(true);
                this.invalidate();
                this.repaint();
        }

        setVisible(false);
        setVisible(true);
        this.invalidate();
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        postsPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        userName1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        partOfFriends1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        profilePh1 = new javax.swing.JLabel();
        coverPh1 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        currentBio1 = new javax.swing.JTextArea();
        newPanel3 = new javax.swing.JPanel();
        changePanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        postsPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout postsPanel3Layout = new javax.swing.GroupLayout(postsPanel3);
        postsPanel3.setLayout(postsPanel3Layout);
        postsPanel3Layout.setHorizontalGroup(
            postsPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        postsPanel3Layout.setVerticalGroup(
            postsPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jScrollPane5.setViewportView(postsPanel3);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Posts");
        jLabel7.setOpaque(true);

        userName1.setBackground(new java.awt.Color(255, 255, 255));
        userName1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        userName1.setOpaque(true);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Friends");

        jButton3.setBackground(new java.awt.Color(0, 204, 255));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("See all Friends");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        partOfFriends1.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout partOfFriends1Layout = new javax.swing.GroupLayout(partOfFriends1);
        partOfFriends1.setLayout(partOfFriends1Layout);
        partOfFriends1Layout.setHorizontalGroup(
            partOfFriends1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        partOfFriends1Layout.setVerticalGroup(
            partOfFriends1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 106, Short.MAX_VALUE)
        );

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profilePh1.setBackground(new java.awt.Color(204, 204, 204));
        profilePh1.setOpaque(true);
        profilePh1.setPreferredSize(new java.awt.Dimension(66, 64));
        jPanel7.add(profilePh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 45, 66, 64));
        jPanel7.add(coverPh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 270, 110));

        currentBio1.setColumns(20);
        currentBio1.setRows(5);
        jScrollPane6.setViewportView(currentBio1);

        newPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout newPanel3Layout = new javax.swing.GroupLayout(newPanel3);
        newPanel3.setLayout(newPanel3Layout);
        newPanel3Layout.setHorizontalGroup(
            newPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
        );
        newPanel3Layout.setVerticalGroup(
            newPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 95, Short.MAX_VALUE)
        );

        jButton4.setBackground(new java.awt.Color(0, 204, 255));
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("EditProfile");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout changePanel1Layout = new javax.swing.GroupLayout(changePanel1);
        changePanel1.setLayout(changePanel1Layout);
        changePanel1Layout.setHorizontalGroup(
            changePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changePanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        changePanel1Layout.setVerticalGroup(
            changePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, changePanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(partOfFriends1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                    .addComponent(userName1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(56, 56, 56)
                                    .addComponent(changePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(newPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userName1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(partOfFriends1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane3.setViewportView(jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        new EditProfilePage();
    }// GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        FriendsPage FriendsPage = new FriendsPage(user);
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
                        @SuppressWarnings("unused")
                        public void run(User user) {
                                try {
                                        new ProfileManagmentPage(user).setVisible(true);
                                } catch (IOException ex) {
                                        Logger.getLogger(ProfileManagmentPage.class.getName()).log(Level.SEVERE, null,
                                                        ex);
                                }
                        }

                        @Override
                        public void run() {
                                throw new UnsupportedOperationException("Unimplemented method 'run'");
                        }
                });
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JPanel changePanel1;
        private javax.swing.JLabel coverPh1;
        private javax.swing.JTextArea currentBio1;
        private javax.swing.JButton jButton3;
        private javax.swing.JButton jButton4;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JPanel jPanel5;
        private javax.swing.JPanel jPanel7;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JScrollPane jScrollPane5;
        private javax.swing.JScrollPane jScrollPane6;
        private javax.swing.JPanel newPanel3;
        private javax.swing.JPanel partOfFriends1;
        private javax.swing.JPanel postsPanel3;
        private javax.swing.JLabel profilePh1;
        private javax.swing.JLabel userName1;
        // End of variables declaration//GEN-END:variables
}