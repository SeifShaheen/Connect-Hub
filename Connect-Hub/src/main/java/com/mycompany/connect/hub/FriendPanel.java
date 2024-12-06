/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Etijah
 */
public class FriendPanel extends JPanel {

    public FriendPanel(String userName, String status, String imagePath) {
        // User user=ConnectHub.CurrentUser;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBackground(Color.white);
        JPanel nameStatusPanel = new JPanel();
        nameStatusPanel.setLayout(new BoxLayout(nameStatusPanel, BoxLayout.Y_AXIS));
        nameStatusPanel.setBackground(Color.WHITE);
        this.setLayout(new FlowLayout(FlowLayout.LEADING));
        JLabel friendImage = new JLabel();
        if (imagePath != null) {
            friendImage.setIcon(EditProfilePage.section(imagePath, null, 25, 25));
        } else {
            friendImage.setIcon(EditProfilePage.section("src\\main\\java\\icons\\profile-user.png", null, 25, 25));
        }

        // friendImage.setPreferredSize(new Dimension(50, 50));
        friendImage.setHorizontalAlignment(JLabel.LEFT);
        friendImage.setBackground(Color.white);
        JLabel friendUserName = new JLabel(userName);
        JLabel friendStatus = new JLabel(status);
        nameStatusPanel.add(friendUserName);
        nameStatusPanel.add(friendStatus);
        this.add(friendImage);
        this.add(nameStatusPanel);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

}
