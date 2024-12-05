/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

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

/**
 *
 * @author seifs
 */
public class StoryPanel extends JPanel {

    public StoryPanel(String title, String content) throws IOException {
        MouseListener ml = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // open the story page
            }
        };
        addMouseListener(ml);
        setLayout(new BorderLayout());
        //Adding Author
        JPanel author = new JPanel();
        author.setLayout(new FlowLayout(FlowLayout.LEADING));
        //Adding Author Photo
        BufferedImage authorPic = ImageIO.read(new File("src\\main\\java\\icons\\logout.png")); // temp Image
        JLabel authorLabelPic = new JLabel(new ImageIcon(authorPic.getScaledInstance(15, 15, java.awt.Image.SCALE_SMOOTH)));
        author.add(authorLabelPic);
        this.add(author, BorderLayout.NORTH);
        //Adding Author data
        JPanel data = new JPanel();
        data.setLayout(new BoxLayout(data, BoxLayout.Y_AXIS));
        JLabel name = new JLabel("Seif");
        data.add(name);
        JLabel date = new JLabel("time");
        date.setForeground(Color.gray);
        data.add(date);
        author.add(data);
        setBorder(BorderFactory.createLineBorder(Color.black));
        
    }
}
