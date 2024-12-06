/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

import Backend.Story;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author seifs
 */
public class StoryPanel extends JPanel {

    public StoryPanel(Story story) throws IOException {
        MouseListener ml = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // open the story page
            }
        };
        addMouseListener(ml);
        setLayout(new BorderLayout());
        // Adding Author
        JPanel author = new JPanel();
        author.setLayout(new FlowLayout(FlowLayout.LEADING));
        // Adding Author Photo
        BufferedImage authorPic;
        if (ConnectHub.currentUser.profilePhotoPath == null) {
            authorPic = ImageIO.read(new File("src\\main\\java\\icons\\profile-user.png")); // temp Image
        } else {
            authorPic = ImageIO.read(new File(ConnectHub.currentUser.profilePhotoPath)); // temp Image
        }
        JLabel authorLabelPic = new JLabel(
                new ImageIcon(authorPic.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH)));
        author.add(authorLabelPic);
        this.add(author, BorderLayout.NORTH);
        // Adding Author data
        JPanel data = new JPanel();
        data.setLayout(new BoxLayout(data, BoxLayout.Y_AXIS));
        JLabel name = new JLabel("Seif");
        data.add(name);
        JLabel date = new JLabel(story.getTimestamp());
        date.setForeground(Color.gray);
        data.add(date);
        author.add(data);
        // Adding Image
        if (story.getImagePath() != null) {
            BufferedImage pic = ImageIO.read(new File(story.getImagePath())); // temp Image
            JLabel picLabel = new JLabel(
                    new ImageIcon(pic.getScaledInstance(new ImageIcon(story.getImagePath()).getIconWidth(),
                            new ImageIcon(story.getImagePath()).getIconHeight(), java.awt.Image.SCALE_SMOOTH)));
            add(new JScrollPane(picLabel), BorderLayout.SOUTH);
        }
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
}
