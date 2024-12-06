/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author seifs
 */
public class NotificationsPanel extends JPanel {

    public NotificationsPanel(User user) throws IOException {
        setLayout(new BorderLayout());
        // Adding User
        JPanel author = new JPanel();
        author.setLayout(new FlowLayout(FlowLayout.LEADING));
        // Adding User Photo
        BufferedImage authorPic;
        if (user.getProfilePhotoPath() != null) {
            authorPic = ImageIO.read(new File(user.getProfilePhotoPath())); // temp Image
        } else {
            authorPic = ImageIO.read(new File("src\\main\\java\\icons\\profile-user.png")); // temp Image
        }
        JLabel authorLabelPic = new JLabel(
                new ImageIcon(authorPic.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
        // Adding User data
        author.add(authorLabelPic);
        JLabel name = new JLabel();
        name.setText(user.getUsername());
        author.add(name);
        this.add(author, BorderLayout.NORTH);
        JButton accept = new JButton();
        JButton decline = new JButton();
        accept.setText("Accept");
        decline.setText("Decline");
        accept.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\icons\\accept.png").getImage()
                .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));
        decline.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\icons\\decline.png").getImage()
                .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));
        JPanel but = new JPanel();
        but.setLayout(new BoxLayout(but, BoxLayout.Y_AXIS));
        but.add(accept);
        but.add(decline);
        but.setSize(new Dimension(100, 100));
        add(but);
        setBorder(new EmptyBorder(7, 5, 7, 5));
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

        setBorder(BorderFactory.createLineBorder(Color.black));
    }

}
