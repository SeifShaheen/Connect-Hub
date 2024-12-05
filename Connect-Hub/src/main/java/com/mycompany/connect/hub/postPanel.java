/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author seifs
 */
public class postPanel extends JPanel {

    public postPanel(String title, String content) throws IOException {
        setLayout(new BorderLayout());
        //Adding Author
        JPanel author = new JPanel();
        author.setLayout(new FlowLayout(FlowLayout.LEADING));
        //Adding Author Photo
        BufferedImage authorPic = ImageIO.read(new File("src\\main\\java\\icons\\logout.png")); // temp Image
        JLabel authorLabelPic = new JLabel(new ImageIcon(authorPic.getScaledInstance(20, 20 , java.awt.Image.SCALE_SMOOTH)));
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
        // Adding Content
        JTextArea contentArea = new JTextArea(content);
        contentArea.setEnabled(false);
        contentArea.setDisabledTextColor(Color.RED);
        contentArea.setFont(new Font("Serif", Font.ITALIC, 16));
        contentArea.setLineWrap(true);
        contentArea.setWrapStyleWord(true);
        add(new JScrollPane(contentArea), BorderLayout.CENTER);
        //Adding Image
        BufferedImage pic = ImageIO.read(new File("src\\main\\java\\icons\\logout.png")); // temp Image
        JLabel picLabel = new JLabel(new ImageIcon(pic.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH)));
        add(new JScrollPane(picLabel), BorderLayout.SOUTH);
        setBorder(new EmptyBorder(7,5,7,5));
    }
}
