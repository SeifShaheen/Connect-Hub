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
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Backend.Group;
import Backend.Operations;
import Backend.Proxy;

/**
 *
 * @author seifs
 */
public class GroupSuggetPanel extends JPanel {

    public GroupSuggetPanel(Group group) throws IOException, NoSuchAlgorithmException {
        setLayout(new BorderLayout());
        // Adding User
        JPanel author = new JPanel();
        author.setLayout(new FlowLayout(FlowLayout.LEADING));
        // Adding User Photo
        BufferedImage authorPic;
        if (group.getImagePath() != null) {
            authorPic = ImageIO.read(new File(group.getImagePath())); // temp Image
        } else {
            authorPic = ImageIO.read(new File("src\\main\\java\\icons\\groups.png")); // temp Image
        }
        JLabel authorLabelPic = new JLabel(
                new ImageIcon(authorPic.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
        author.add(authorLabelPic);
        // Adding User data
        JPanel data = new JPanel();
        data.setLayout(new BoxLayout(data, BoxLayout.Y_AXIS));
        JLabel name = new JLabel(group.getGroupName());
        data.add(name);
        JButton send = new JButton();
        send.setText("Request to join");
        author.add(data);
        author.add(send);
        this.add(author, BorderLayout.NORTH);
        send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Operations operation = new Proxy();
                operation.requestJoin(ConnectHub.currentUser.getUserId(), group.getGroupID());
                JOptionPane.showMessageDialog(null, "Requested to join " + group.getGroupName(), "Message",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        setBorder(new EmptyBorder(7, 5, 7, 5));
    }

}
