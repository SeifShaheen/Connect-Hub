/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.connect.hub;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Backend.Group;
import Backend.UserGroupConnections;

/**
 *
 * @author seifs
 */
public class GroupsPage extends javax.swing.JFrame {

    static String groupName = null;

    /**
     * Creates new form GroupsPage
     * 
     * @throws IOException
     */
    public GroupsPage() throws IOException {
        initComponents();
        UserGroupConnections u = new UserGroupConnections(ConnectHub.currentUser);
        setVisible(true);
        setTitle(ConnectHub.currentUser.getUsername() + "'s Groups");
        // setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(new Dimension(500, 200));
        this.setLayout(new GridLayout(1,0));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        JButton addGroupbtn = new JButton("Add New Group");
        addGroupbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new addGroupDialog(null, true);
                    if (groupName != null) {
                        JOptionPane.showMessageDialog(null, "Created " + groupName, "Message",
                                JOptionPane.INFORMATION_MESSAGE);
                        new Group(groupName, ConnectHub.currentUser.getUserId());
                    } else {
                        JOptionPane.showMessageDialog(null, "There was an error.", "Message",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NoSuchAlgorithmException | IOException ex) {
                    Logger.getLogger(NotificationsPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        mainPanel.add(addGroupbtn);
        JLabel jLabel1 = new JLabel();
        jLabel1.setText("Primary Admin: " + u.getOwnerGroups().size());
        mainPanel.add(jLabel1);
        ArrayList<Group> owner = u.getOwnerGroups();
        for (Group g : owner) {
            mainPanel.add(new GroupPanel(g), BoxLayout.Y_AXIS);
        }
        JLabel admin = new JLabel("Admin: " + u.getAdminGroups().size());
        mainPanel.add(admin);
        ArrayList<Group> adminGroup = u.getAdminGroups();
        for (Group g : adminGroup) {
            mainPanel.add(new GroupPanel(g), BoxLayout.Y_AXIS);
        }
        JLabel member = new JLabel("Member: " + u.getMemberGroups().size());
        mainPanel.add(member);
        ArrayList<Group> memberGroup = u.getAdminGroups();
        for (Group g : memberGroup) {
            mainPanel.add(new GroupPanel(g), BoxLayout.Y_AXIS);
        }
        mainPanel.setVisible(true);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        childPanel = new javax.swing.JPanel();
        friendImage = new javax.swing.JLabel();
        FriendUserName = new javax.swing.JLabel();
        FriendStatus = new javax.swing.JLabel();
        scrollPane1 = new java.awt.ScrollPane();
        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        childPanel.setBackground(new java.awt.Color(255, 255, 255));

        friendImage.setBackground(new java.awt.Color(204, 204, 204));
        friendImage.setText("jLabel1");
        friendImage.setOpaque(true);

        FriendUserName.setText("......UserName......");

        FriendStatus.setText("status");

        javax.swing.GroupLayout childPanelLayout = new javax.swing.GroupLayout(childPanel);
        childPanel.setLayout(childPanelLayout);
        childPanelLayout.setHorizontalGroup(
                childPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(childPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(friendImage, javax.swing.GroupLayout.PREFERRED_SIZE, 63,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(childPanelLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(childPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(FriendUserName, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(childPanelLayout.createSequentialGroup()
                                                .addGap(32, 32, 32)
                                                .addComponent(FriendStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 91,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(78, Short.MAX_VALUE)));
        childPanelLayout.setVerticalGroup(
                childPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(childPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(friendImage, javax.swing.GroupLayout.DEFAULT_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(childPanelLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(FriendUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FriendStatus)
                                .addContainerGap(12, Short.MAX_VALUE)));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.LINE_AXIS));
        mainPanel.add(jLabel1);

        scrollPane1.add(mainPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GroupsPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GroupsPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GroupsPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GroupsPage.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GroupsPage().setVisible(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FriendStatus;
    private javax.swing.JLabel FriendUserName;
    private javax.swing.JPanel childPanel;
    private javax.swing.JLabel friendImage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel mainPanel;
    private java.awt.ScrollPane scrollPane1;
    // End of variables declaration//GEN-END:variables
}
