/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.connect.hub;

import Backend.Group;
import Backend.Operations;
import Backend.Post;
import Backend.Proxy;
import static com.mycompany.connect.hub.EditProfilePage.section;
import static com.mycompany.connect.hub.FilesManagement.map;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Etijah
 */
public class GroupFrame extends javax.swing.JFrame {

    Operations operation = new Proxy();
    Group group;

    /**
     * Creates new form GroupFrame
     */
    public GroupFrame(Group group) throws IOException {
        initComponents();
        setVisible(true);
        setResizable(false);
        setTitle(group.getGroupName());
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.group = group;
        // ..............add cover Photo..............
        String coverPath = group.getImagePath();
        if (coverPath != null) {
            groupCover.setIcon(EditProfilePage.section(coverPath, null, groupCover.getWidth(), groupCover.getHeight()));
        }
        // ...................add user name......................
        String use = group.getGroupName();
        groupName.setText(use);
        // ..............changePanel..........
        changePanel.setLayout(new BoxLayout(changePanel, BoxLayout.X_AXIS));
        if (!((((Proxy) operation).isMember(ConnectHub.currentUser.getUserId(), group.getGroupID()))) && !(((Proxy) operation).isPrimaryAdmin(ConnectHub.currentUser.getUserId(), group.getGroupID()))) {
            JButton join = new JButton("join");

            join.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Requested to join " + group.getGroupName(), "Message",
                            JOptionPane.INFORMATION_MESSAGE);
                    operation.requestJoin(ConnectHub.currentUser.getUserId(), group.getGroupID());
                }
            });
            newPost.setVisible(false);
            jButton1.setVisible(false);
            jButton2.setVisible(false);
            changePanel.add(join);
        } else if ((((Proxy) operation).isMember(ConnectHub.currentUser.getUserId(), group.getGroupID())) && !(((Proxy) operation).isAdmin(ConnectHub.currentUser.getUserId(), group.getGroupID()))) {
            JButton Leave = new JButton("leave");

            Leave.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Left " + group.getGroupName(), "Message",
                            JOptionPane.INFORMATION_MESSAGE);
                    operation.leaveGroup(ConnectHub.currentUser.getUserId(), group.getGroupID());
                }
            });
            changePanel.add(Leave);
        } else if ((((Proxy) operation).isAdmin(ConnectHub.currentUser.getUserId(), group.getGroupID()))) {
            JButton viewMembers = new JButton("viewMembers");
            JButton changeCoverPhoto = new JButton("changeCoverPhoto");
            JButton Leave = new JButton("leave");

            viewMembers.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new MembersOfGroup_Page(group);
                }
            });
            changeCoverPhoto.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fc = new JFileChooser();
                    // Add a filter to allow only image files (png, jpeg, gif)
                    new FileNameExtensionFilter("All Pic", "png", "jpeg");

                    int returnValue = fc.showOpenDialog(null);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File f = fc.getSelectedFile();
                        String path = f.getAbsolutePath();
                        groupCover.setIcon(section(path, null, groupCover.getWidth(), groupCover.getHeight()));
                        JOptionPane.showMessageDialog(null, "Cover Photo Changed", "Message",
                                JOptionPane.INFORMATION_MESSAGE);

                    }
                }
            });
            Leave.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Left " + group.getGroupName(), "Message",
                            JOptionPane.INFORMATION_MESSAGE);
                    operation.leaveGroup(ConnectHub.currentUser.getUserId(), group.getGroupID());
                }
            });
            changePanel.add(viewMembers);
            changePanel.add(changeCoverPhoto);
            changePanel.add(Leave);
            changePanel.add(viewMembers);
        } else if ((((Proxy) operation).isPrimaryAdmin(ConnectHub.currentUser.getUserId(), group.getGroupID()))) {
            JButton viewMembers = new JButton("viewMembers");
            JButton viewAdmins = new JButton("viewAdmins");
            JButton deleteGroup = new JButton("deleteGroup");
            JButton changeCoverPhoto = new JButton("changeCoverPhoto");
            viewMembers.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new MembersOfGroup_Page(group);
                }
            });
            viewAdmins.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new MembersOfGroup_Page(group);
                }
            });
            changeCoverPhoto.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fc = new JFileChooser();
                    // Add a filter to allow only image files (png, jpeg, gif)
                    new FileNameExtensionFilter("All Pic", "png", "jpeg");

                    int returnValue = fc.showOpenDialog(null);
                    if (returnValue == JFileChooser.APPROVE_OPTION) {
                        File f = fc.getSelectedFile();
                        String path = f.getAbsolutePath();
                        groupCover.setIcon(section(path, null, groupCover.getWidth(), groupCover.getHeight()));
                        JOptionPane.showMessageDialog(null, "Cover Photo Changed", "Message",
                                JOptionPane.INFORMATION_MESSAGE);

                    }
                }
            });
            deleteGroup.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Deleted " + group.getGroupName(), "Message",
                            JOptionPane.INFORMATION_MESSAGE);
                    operation.deleteGroup(ConnectHub.currentUser.getUserId(), group.getGroupID());
                    dispose();
                }
            });
            changePanel.add(viewMembers);
            changePanel.add(viewAdmins);
            changePanel.add(deleteGroup);
            changePanel.add(changeCoverPhoto);
        }

        // .....addPOst...........
        if ((((Proxy) operation).isMember(ConnectHub.currentUser.getUserId(), group.getGroupID()))
                && !(((Proxy) operation).isAdmin(ConnectHub.currentUser.getUserId(), group.getGroupID()))) {
            ArrayList<Post> posts = group.getPosts();
            postList.setLayout(new BoxLayout(postList, BoxLayout.Y_AXIS));
            for (Post post : posts) {
                User auth = FilesManagement.map.get(post.getAuthorID());
                postList.add(new postPanel(post, auth));
            }
        } else {
            ArrayList<Post> posts = group.getPosts();
            postList.setLayout(new BoxLayout(postList, BoxLayout.Y_AXIS));
            for (Post post : posts) {
                User auth = FilesManagement.map.get(post.getAuthorID());
                postList.add(new postPanelForAdmins(post, auth, group));
            }

        }
        changePanel.setVisible(true);
        postList.setVisible(true);
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        groupCover = new javax.swing.JLabel();
        groupName = new javax.swing.JLabel();
        changePanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        newPost = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        postList = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        groupCover.setBackground(new java.awt.Color(204, 204, 204));
        groupCover.setOpaque(true);

        changePanel.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout changePanelLayout = new javax.swing.GroupLayout(changePanel);
        changePanel.setLayout(changePanelLayout);
        changePanelLayout.setHorizontalGroup(
            changePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        changePanelLayout.setVerticalGroup(
            changePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Add Post");

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("Posts");

        jButton1.setBackground(new java.awt.Color(0, 204, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("add post");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 204, 255));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("add photo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        newPost.setColumns(20);
        newPost.setRows(5);
        jScrollPane1.setViewportView(newPost);

        javax.swing.GroupLayout postListLayout = new javax.swing.GroupLayout(postList);
        postList.setLayout(postListLayout);
        postListLayout.setHorizontalGroup(
            postListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );
        postListLayout.setVerticalGroup(
            postListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(postList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(groupCover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(groupName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(changePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(groupCover, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(groupName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String ImagePath = null;

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
        if (newPost.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please Write Something!", "Message",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            if (ImagePath == null) {
                operation.createPost(ConnectHub.currentUser.getUserId(), group.getGroupID(), newPost.getText());
            } else {
                operation.createPost(ConnectHub.currentUser.getUserId(), group.getGroupID(), newPost.getText(),
                        ImagePath);
            }
            JOptionPane.showMessageDialog(null, "Post was created!", "Message",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }// GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser JFC = new JFileChooser();

        int returnValue = JFC.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = JFC.getSelectedFile();
            String extension = "";
            int i = selectedFile.getName().lastIndexOf('.');
            if (i > 0) {
                extension = selectedFile.getName().substring(i + 1);
            }
            if ("png".equals(extension) || "jpeg".equals(extension)) {
                ImagePath = selectedFile.getPath();
            } else {
                JOptionPane.showMessageDialog(null, "Please choose png or jpeg file!", "Message",
                        JOptionPane.WARNING_MESSAGE);
            }
        }

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GroupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GroupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GroupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GroupFrame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run(Group group) {
                try {
                    new GroupFrame(group).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(GroupFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void run() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from
                // nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel changePanel;
    private javax.swing.JLabel groupCover;
    private javax.swing.JLabel groupName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea newPost;
    private javax.swing.JPanel postList;
    // End of variables declaration//GEN-END:variables
}
