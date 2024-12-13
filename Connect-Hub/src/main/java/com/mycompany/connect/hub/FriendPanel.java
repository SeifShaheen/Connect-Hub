/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Etijah
 */
public class FriendPanel extends JPanel {

    public FriendPanel(User friend, User user) {
        // User user=ConnectHub.CurrentUser;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBackground(Color.white);
        JPanel nameStatusPanel = new JPanel();
        nameStatusPanel.setLayout(new BoxLayout(nameStatusPanel, BoxLayout.Y_AXIS));
        nameStatusPanel.setBackground(Color.WHITE);
        this.setLayout(new FlowLayout(FlowLayout.LEADING));
        JLabel friendImage = new JLabel();
        JButton remove = new JButton("Remove");
        JButton block = new JButton("Block");
        if (friend.profilePhotoPath != null) {
            friendImage.setIcon(EditProfilePage.section(friend.profilePhotoPath, null, 25, 25));
        } else {
            friendImage.setIcon(EditProfilePage.section("src\\main\\java\\icons\\profile-user.png", null, 25, 25));
        }
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean sen = FriendManagement.Request.unFriend(ConnectHub.currentUser, friend);
                    if (sen) {
                        JOptionPane.showMessageDialog(null, "Removed " + friend.getUsername(), "Message",
                                JOptionPane.INFORMATION_MESSAGE);
                        FilesManagement.map.put(ConnectHub.currentUser.getUserId(), ConnectHub.currentUser);
                        FilesManagement.map.put(friend.getUserId(), friend);
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
        block.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean sen = FriendManagement.Request.block(ConnectHub.currentUser, friend);
                    if (sen) {
                        JOptionPane.showMessageDialog(null, "Blocked " + friend.getUsername(), "Message",
                                JOptionPane.INFORMATION_MESSAGE);
                        FilesManagement.map.put(ConnectHub.currentUser.getUserId(), ConnectHub.currentUser);
                        FilesManagement.map.put(friend.getUserId(), friend);
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
        // friendImage.setPreferredSize(new Dimension(50, 50));
        friendImage.setHorizontalAlignment(JLabel.LEFT);
        friendImage.setBackground(Color.white);
        JLabel friendUserName = new JLabel(friend.getUsername());
        JLabel friendStatus = new JLabel(friend.getStatus());
        nameStatusPanel.add(friendUserName);
        nameStatusPanel.add(friendStatus);
        this.add(friendImage);
        this.add(nameStatusPanel);
        if (ConnectHub.currentUser.getUserId() == user.getUserId()) {
            this.add(block);
            this.add(remove);
        }
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

}
