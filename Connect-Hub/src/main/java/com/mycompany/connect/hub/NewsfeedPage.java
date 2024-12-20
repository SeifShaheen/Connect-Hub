/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.connect.hub;

import Backend.Post;
import Backend.Story;
import Backend.StoryMonitor;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author seifs
 */
public class NewsfeedPage extends javax.swing.JFrame {

    String ImagePath = null;

    /**
     * Creates new form NewsfeedPage
     *
     */
    public NewsfeedPage() throws IOException {
        initComponents();
        setTitle("Newsfeed");
        setSize(new Dimension(1000, 319));
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        userbtn.setText(ConnectHub.currentUser.getUsername());// here we put the name of the current user
        postField.setLineWrap(true);
        postField.setWrapStyleWord(true);
        postField.setRows(1);
        // setting icons of buttons
        if (ConnectHub.currentUser.getProfilePhotoPath() == null) {
            userbtn.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\icons\\profile-user.png").getImage()
                    .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));
        } else {
            userbtn.setIcon(new ImageIcon(new ImageIcon(ConnectHub.currentUser.getProfilePhotoPath()).getImage()
                    .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));
        }
        groupsbtn.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\icons\\groups.png").getImage()
                .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));
        groupsSuggestbtn.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\icons\\add-group.png").getImage()
                .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));
        friendSuggestion.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\icons\\add-user.png").getImage()
                .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));
        searchbtn.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\icons\\search-interface-symbol.png").getImage()
                .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));
        refreshbtn.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\icons\\reload.png").getImage()
                .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));
        postbtn.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\icons\\add-post.png").getImage()
                .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));
        storybtn.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\icons\\story.png").getImage()
                .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));
        addImagebtn.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\icons\\image.png").getImage()
                .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));
        logoutbtn.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\icons\\logout.png").getImage()
                .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));
        friendsbtn.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\icons\\high-five.png").getImage()
                .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));
        blockedbtn.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\icons\\block.png").getImage()
                .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));
        // temporary true (if the user has no requests)
        if (ConnectHub.currentUser.getRequestsRecieved().isEmpty()) {
            friendRequestsbtn.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\icons\\bellNoNotification.png")
                    .getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
        } else {
            friendRequestsbtn.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\icons\\bellNotification.png")
                    .getImage().getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
        }
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        storyPanel.setLayout(new GridLayout(0, 3));
        ArrayList<String> fr = ConnectHub.currentUser.getFriends();
        for (String friend : fr) {
            User f = FilesManagement.map.get(friend);
            for (Post post : f.getPosts()) {
                mainPanel.add(new postPanel(post, f));
            }
            for (Story story : f.getStories()) {
                storyPanel.add(new StoryPanel(story));
            }
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userbtn = new javax.swing.JButton();
        friendRequestsbtn = new javax.swing.JButton();
        friendSuggestion = new javax.swing.JButton();
        searchbtn = new javax.swing.JButton();
        refreshbtn = new javax.swing.JButton();
        postbtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        postField = new javax.swing.JTextArea();
        logoutbtn = new javax.swing.JButton();
        addImagebtn = new javax.swing.JButton();
        postsPane = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        storyPanel = new javax.swing.JPanel();
        storybtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        friendsbtn = new javax.swing.JButton();
        blockedbtn = new javax.swing.JButton();
        groupsbtn = new javax.swing.JButton();
        groupsSuggestbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userbtnActionPerformed(evt);
            }
        });

        friendRequestsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendRequestsbtnActionPerformed(evt);
            }
        });

        friendSuggestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendSuggestionActionPerformed(evt);
            }
        });

        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        refreshbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshbtnActionPerformed(evt);
            }
        });

        postbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postbtnActionPerformed(evt);
            }
        });

        postField.setColumns(20);
        postField.setLineWrap(true);
        postField.setRows(5);
        jScrollPane1.setViewportView(postField);

        logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtnActionPerformed(evt);
            }
        });

        addImagebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addImagebtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 359, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
        );

        postsPane.setViewportView(mainPanel);

        javax.swing.GroupLayout storyPanelLayout = new javax.swing.GroupLayout(storyPanel);
        storyPanel.setLayout(storyPanelLayout);
        storyPanelLayout.setHorizontalGroup(
            storyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
        );
        storyPanelLayout.setVerticalGroup(
            storyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(storyPanel);

        storybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storybtnActionPerformed(evt);
            }
        });

        jLabel1.setText("Friends Stories");

        friendsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friendsbtnActionPerformed(evt);
            }
        });

        blockedbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockedbtnActionPerformed(evt);
            }
        });

        groupsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupsbtnActionPerformed(evt);
            }
        });

        groupsSuggestbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupsSuggestbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(logoutbtn)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(userbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(friendRequestsbtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(friendSuggestion)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(refreshbtn))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(postbtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(storybtn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(addImagebtn))
                        .addComponent(jScrollPane1))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(postsPane, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(groupsbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(groupsSuggestbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(blockedbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(friendsbtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(postsPane)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(refreshbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                .addComponent(friendSuggestion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(friendRequestsbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(userbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(searchbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(postbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addImagebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(storybtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(logoutbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(blockedbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(groupsbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(friendsbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(groupsSuggestbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void groupsSuggestbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupsSuggestbtnActionPerformed
        try {
            new GroupSuggestions();
        } catch (IOException ex) {
            Logger.getLogger(NewsfeedPage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(NewsfeedPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_groupsSuggestbtnActionPerformed

    private void groupsbtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_groupsbtnActionPerformed
        try {
            new GroupsPage();
        } catch (IOException ex) {
            Logger.getLogger(NewsfeedPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_groupsbtnActionPerformed

    private void blockedbtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_blockedbtnActionPerformed
        new BlockedPage();
    }// GEN-LAST:event_blockedbtnActionPerformed

    private void friendsbtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_friendsbtnActionPerformed
        new FriendsPage(ConnectHub.currentUser);
    }// GEN-LAST:event_friendsbtnActionPerformed

    private void userbtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_userbtnActionPerformed
        try {
            new ProfileManagmentPage(ConnectHub.currentUser);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_userbtnActionPerformed

    private void friendRequestsbtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_friendRequestsbtnActionPerformed
        try {
            new Notifications();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_friendRequestsbtnActionPerformed

    private void friendSuggestionActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_friendSuggestionActionPerformed
        try {
            new Suggestions();
        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_friendSuggestionActionPerformed

    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchbtnActionPerformed
        new SearchFram();
    }// GEN-LAST:event_searchbtnActionPerformed

    private void refreshbtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_refreshbtnActionPerformed
        StoryMonitor.checkExpiredStories();
        try {
            FilesManagement.map = FilesManagement.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ConnectHub.currentUser = FilesManagement.map.get(ConnectHub.currentUser.getUserId());
        dispose();
        try {
            new NewsfeedPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }// GEN-LAST:event_refreshbtnActionPerformed

    private void postbtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_postbtnActionPerformed
        // Add new post and refresh
        if (postField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "post must have text.", "Message", JOptionPane.ERROR_MESSAGE);
        } else {
            if (ImagePath == null) {
                // creates a post with only text
                try {
                    ConnectHub.currentUser.createPost(postField.getText());
                } catch (NoSuchAlgorithmException | IOException e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "post created succefully.", "Message",
                        JOptionPane.INFORMATION_MESSAGE);
                postField.setText("");
                ImagePath = null;
            } else {
                // creates a post with the text and image
                try {
                    ConnectHub.currentUser.createPost(postField.getText(), ImagePath);
                } catch (NoSuchAlgorithmException | IOException e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "post created succefully.", "Message",
                        JOptionPane.INFORMATION_MESSAGE);
                postField.setText("");
                ImagePath = null;
            }
        }
    }// GEN-LAST:event_postbtnActionPerformed

    private void logoutbtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logoutbtnActionPerformed
        try {
            LogOut.operate(ConnectHub.currentUser);
            ConnectHub.currentUser = null;
            new ProjectsOpening().setVisible(true);
            dispose();
        } catch (IOException | NoSuchAlgorithmException ex) {
            Logger.getLogger(NewsfeedPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }// GEN-LAST:event_logoutbtnActionPerformed

    private void addImagebtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_addImagebtnActionPerformed
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
    }// GEN-LAST:event_addImagebtnActionPerformed

    private void storybtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_storybtnActionPerformed
        if (postField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "story must have text.", "Message", JOptionPane.ERROR_MESSAGE);
        } else {
            if (ImagePath == null) {
                // creates a post with only text
                try {
                    ConnectHub.currentUser.createStory(postField.getText());
                } catch (NoSuchAlgorithmException | IOException e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "story created succefully.", "Message",
                        JOptionPane.INFORMATION_MESSAGE);
                postField.setText("");
                ImagePath = null;
            } else {
                // creates a post with the text and image
                try {
                    ConnectHub.currentUser.createStory(postField.getText(), ImagePath);
                } catch (NoSuchAlgorithmException | IOException e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "story created succefully.", "Message",
                        JOptionPane.INFORMATION_MESSAGE);
                postField.setText("");
                ImagePath = null;
            }
        }
    }// GEN-LAST:event_storybtnActionPerformed

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
            java.util.logging.Logger.getLogger(NewsfeedPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewsfeedPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewsfeedPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewsfeedPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NewsfeedPage().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(NewsfeedPage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addImagebtn;
    private javax.swing.JButton blockedbtn;
    private javax.swing.JButton friendRequestsbtn;
    private javax.swing.JButton friendSuggestion;
    private javax.swing.JButton friendsbtn;
    private javax.swing.JButton groupsSuggestbtn;
    private javax.swing.JButton groupsbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logoutbtn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextArea postField;
    private javax.swing.JButton postbtn;
    private javax.swing.JScrollPane postsPane;
    private javax.swing.JButton refreshbtn;
    private javax.swing.JButton searchbtn;
    private javax.swing.JPanel storyPanel;
    private javax.swing.JButton storybtn;
    private javax.swing.JButton userbtn;
    // End of variables declaration//GEN-END:variables
}
