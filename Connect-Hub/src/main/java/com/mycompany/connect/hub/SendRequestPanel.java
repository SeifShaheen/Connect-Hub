/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

import java.awt.BorderLayout;
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
public class SendRequestPanel extends JPanel {

    public SendRequestPanel(User user) throws IOException, NoSuchAlgorithmException {
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
        author.add(authorLabelPic);
        // Adding User data
        JPanel data = new JPanel();
        data.setLayout(new BoxLayout(data, BoxLayout.Y_AXIS));
        JLabel name = new JLabel(user.getUsername());
        data.add(name);
        JButton send = new JButton();
        send.setText("Add Friend");
        send.setIcon(new ImageIcon(new ImageIcon("src\\main\\java\\icons\\addFriend.png").getImage()
                .getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH)));
        author.add(data);
        author.add(send);
        this.add(author, BorderLayout.NORTH);
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    boolean sen = FriendManagement.Request.send(ConnectHub.currentUser, user);
                    if (sen) {
                        JOptionPane.showMessageDialog(null, "Sent a request to " + user.getUsername(), "Message",
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
        setBorder(new EmptyBorder(7, 5, 7, 5));
    }

}
