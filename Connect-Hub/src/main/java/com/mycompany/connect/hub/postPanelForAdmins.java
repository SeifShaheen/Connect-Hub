/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

import Backend.Group;
import Backend.Operations;
import Backend.Post;
import Backend.Proxy;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author seifs
 */
public class postPanelForAdmins extends JPanel {

    static String editPostText = null;
    static String editImagePath = null;

    public postPanelForAdmins(Post post, User user, Group group) throws IOException {
        setLayout(new BorderLayout());
        // Adding Author
        JPanel author = new JPanel();
        author.setLayout(new FlowLayout(FlowLayout.LEADING));
        // Adding Author Photo
        BufferedImage authorPic;
        if (user.getProfilePhotoPath() != null) {
            authorPic = ImageIO.read(new File(user.getProfilePhotoPath())); // temp Image
        } else {
            authorPic = ImageIO.read(new File("src\\main\\java\\icons\\profile-user.png")); // temp Image
        }
        JLabel authorLabelPic = new JLabel(
                new ImageIcon(authorPic.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH)));
        author.add(authorLabelPic);
        this.add(author, BorderLayout.NORTH);
        // Adding Author data
        JPanel data = new JPanel();
        data.setLayout(new BoxLayout(data, BoxLayout.Y_AXIS));
        JLabel name = new JLabel(user.getUsername());
        data.add(name);
        JLabel date = new JLabel(post.getTimestamp());
        date.setForeground(Color.gray);
        data.add(date);
        author.add(data);
        // Adding Content
        JTextArea contentArea = new JTextArea(post.getText());
        contentArea.setEnabled(false);
        contentArea.setDisabledTextColor(Color.RED);
        contentArea.setFont(new Font("Serif", Font.ITALIC, 16));
        contentArea.setLineWrap(true);
        contentArea.setWrapStyleWord(true);
        add(new JScrollPane(contentArea), BorderLayout.CENTER);
        // Adding Image
        if (post.getImagePath() != null) {
            BufferedImage pic = ImageIO.read(new File(post.getImagePath()));
            JLabel picLabel = new JLabel(new ImageIcon(pic.getScaledInstance(200, 200, java.awt.Image.SCALE_SMOOTH)));
            add(new JScrollPane(picLabel), BorderLayout.SOUTH);
        }
        JPanel operations = new JPanel();
        Operations op = new Proxy();
        operations.setLayout(new BoxLayout(operations, BoxLayout.X_AXIS));
        JButton delete = new JButton("Delete Post");
        JButton edit = new JButton("Edit Post");
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Post was deleted", "Message",
                        JOptionPane.INFORMATION_MESSAGE);
                op.deletePost(post, ConnectHub.currentUser.getUserId(), group.getGroupID());
            }
        });
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editPostDialog j = new editPostDialog(null, true);
                JOptionPane.showMessageDialog(null, "Post was edited", "Message",
                        JOptionPane.INFORMATION_MESSAGE);
                if (editImagePath == null) {
                    op.editPost(post, ConnectHub.currentUser.getUserId(), group.getGroupID(), editPostText);
                } else {
                    op.editPost(post, ConnectHub.currentUser.getUserId(), group.getGroupID(), editPostText, editImagePath);
                }
            }
        }
        );
        setBorder(new EmptyBorder(7, 5, 7, 5));
    }
}
