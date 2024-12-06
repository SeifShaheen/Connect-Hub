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
public class BlockedPanel extends JPanel {

    public BlockedPanel(User user) {
        // User user=ConnectHub.CurrentUser;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBackground(Color.white);
        JPanel nameStatusPanel = new JPanel();
        nameStatusPanel.setLayout(new BoxLayout(nameStatusPanel, BoxLayout.Y_AXIS));
        nameStatusPanel.setBackground(Color.WHITE);
        this.setLayout(new FlowLayout(FlowLayout.LEADING));
        JLabel friendImage = new JLabel();
        JButton unblock = new JButton("Unblock");
        if (user.profilePhotoPath != null) {
            friendImage.setIcon(EditProfilePage.section(user.profilePhotoPath, null, 25, 25));
        } else {
            friendImage.setIcon(EditProfilePage.section("src\\main\\java\\icons\\profile-user.png", null, 25, 25));
        }
        unblock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean sen = FriendManagement.Request.unBlock(ConnectHub.currentUser, user);
                    if (sen) {
                        JOptionPane.showMessageDialog(null, "Unblocked " + user.getUsername(), "Message",
                                JOptionPane.INFORMATION_MESSAGE);
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
        // friendImage.setPreferredSize(new Dimension(50, 50));
        friendImage.setHorizontalAlignment(JLabel.LEFT);
        friendImage.setBackground(Color.white);
        JLabel friendUserName = new JLabel(user.getUsername());
        JLabel friendStatus = new JLabel(user.getStatus());
        nameStatusPanel.add(friendUserName);
        nameStatusPanel.add(friendStatus);
        this.add(friendImage);
        this.add(nameStatusPanel);
        this.add(unblock);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

}
