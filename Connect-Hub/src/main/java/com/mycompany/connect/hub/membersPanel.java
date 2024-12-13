/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.connect.hub;

import Backend.Group;
import Backend.Operations;
import Backend.Proxy;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Etijah
 */
public class membersPanel extends JPanel {

    private Operations op = new Proxy();

    public membersPanel(User member, Group group) {
        // User user=ConnectHub.CurrentUser;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBackground(Color.white);
        JPanel nameStatusPanel = new JPanel();
        nameStatusPanel.setLayout(new BoxLayout(nameStatusPanel, BoxLayout.Y_AXIS));
        nameStatusPanel.setBackground(Color.WHITE);
        this.setLayout(new FlowLayout(FlowLayout.LEADING));
        JLabel friendImage = new JLabel();
        if (member.profilePhotoPath != null) {
            friendImage.setIcon(EditProfilePage.section(member.profilePhotoPath, null, 25, 25));
        } else {
            friendImage.setIcon(EditProfilePage.section("src\\main\\java\\icons\\profile-user.png", null, 25, 25));
        }
        // friendImage.setPreferredSize(new Dimension(50, 50));
        friendImage.setHorizontalAlignment(JLabel.LEFT);
        friendImage.setBackground(Color.white);
        JLabel friendUserName = new JLabel(member.getUsername());
        JLabel friendStatus = new JLabel(member.getStatus());
        nameStatusPanel.add(friendUserName);
        nameStatusPanel.add(friendStatus);
        this.add(friendImage);
        this.add(nameStatusPanel);
        if (ConnectHub.currentUser.getUserId().equals(group.getPrimaryAdmin())) {
            if (group.getAdmins().contains(member.getUserId())) {
                JButton remove = new JButton("Remove");
                JButton demote = new JButton("Demote");
                remove.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "Removed " + member.getUsername(), "Message",
                                JOptionPane.INFORMATION_MESSAGE);
                        op.removeAdmin(ConnectHub.currentUser.getUserId(), member.getUserId(), group.getGroupID());
                    }
                });
                demote.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "Demoted " + member.getUsername(), "Message",
                                JOptionPane.INFORMATION_MESSAGE);
                        op.demoteAdmin(ConnectHub.currentUser.getUserId(), member.getUserId(), group.getGroupID());
                    }
                });
                this.add(remove);
                this.add(demote);
            } else {
                JButton remove = new JButton("Remove");
                JButton promote = new JButton("Promote");
                remove.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "Removed " + member.getUsername(), "Message",
                                JOptionPane.INFORMATION_MESSAGE);
                        op.removeMember(ConnectHub.currentUser.getUserId(), member.getUserId(), group.getGroupID());
                    }
                });
                promote.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null, "Promoted" + member.getUsername(), "Message",
                                JOptionPane.INFORMATION_MESSAGE);
                        op.promoteAdmin(ConnectHub.currentUser.getUserId(), member.getUserId(), group.getGroupID());
                    }
                });
                this.add(remove);
                this.add(promote);
            }
        } else if (group.getAdmins().contains(ConnectHub.currentUser.getUserId())) {
            JButton remove = new JButton("Remove");
            remove.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Removed " + member.getUsername(), "Message",
                            JOptionPane.INFORMATION_MESSAGE);
                    op.removeMember(ConnectHub.currentUser.getUserId(), member.getUserId(), group.getGroupID());
                }
            });
            this.add(remove);
        }
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

}
