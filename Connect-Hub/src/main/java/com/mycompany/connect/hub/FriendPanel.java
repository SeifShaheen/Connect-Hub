/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 *
 * @author Etijah
 */
public class FriendPanel extends JPanel{
    
    public FriendPanel(String userName,String status,String imagePath)
    {
            
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS)); 
        this.setBackground(Color.WHITE);
          JPanel nameStatusPanel = new JPanel();
        nameStatusPanel.setLayout(new BoxLayout(nameStatusPanel, BoxLayout.Y_AXIS));
        nameStatusPanel.setBackground(Color.WHITE); 
            
        this.setPreferredSize(new Dimension(20, 60));
        this.setLayout(new FlowLayout());
         JLabel friendImage = new JLabel();
         //friendImage.setIcon(section(imagePath, null,40, 40));
       
         //friendImage.setPreferredSize(new Dimension(50, 50)); 
        friendImage.setHorizontalAlignment(JLabel.LEFT); 
        //friendImage.setBackground(Color.gray);
        JLabel friendUserName = new JLabel(userName);
        JLabel friendStatus = new JLabel(status);
       nameStatusPanel.add(friendUserName);
        nameStatusPanel.add(friendStatus);
         nameStatusPanel.add(friendImage); 
        nameStatusPanel.add(nameStatusPanel);
       
         JSeparator separator = new JSeparator(JSeparator.HORIZONTAL);
       this.add(separator);
    }

    
}
