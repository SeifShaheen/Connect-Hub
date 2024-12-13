package com.mycompany.connect.hub;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Backend.Group;

/**
 *
 * @author seifs
 */
public class GroupPanel extends JPanel {

    public GroupPanel(Group group) {
        // User user=ConnectHub.CurrentUser;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBackground(Color.white);
        JPanel nameStatusPanel = new JPanel();
        nameStatusPanel.setLayout(new BoxLayout(nameStatusPanel, BoxLayout.Y_AXIS));
        nameStatusPanel.setBackground(Color.WHITE);
        this.setLayout(new FlowLayout(FlowLayout.LEADING));
        JLabel friendImage = new JLabel();
        JButton view = new JButton("View Group");
        if (group.getImagePath() != null) {
            friendImage.setIcon(EditProfilePage.section(group.getImagePath(), null, 25, 25));
        } else {
            friendImage.setIcon(EditProfilePage.section("src\\main\\java\\icons\\groups.png", null, 25, 25));
        }
        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // new group page
            }
        });
        // friendImage.setPreferredSize(new Dimension(50, 50));
        friendImage.setHorizontalAlignment(JLabel.LEFT);
        friendImage.setBackground(Color.white);
        JLabel friendUserName = new JLabel(group.getGroupName());
        JLabel friendStatus = new JLabel(group.getDescription());
        nameStatusPanel.add(friendUserName);
        nameStatusPanel.add(friendStatus);
        this.add(friendImage);
        this.add(nameStatusPanel);
        this.add(view);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

}
