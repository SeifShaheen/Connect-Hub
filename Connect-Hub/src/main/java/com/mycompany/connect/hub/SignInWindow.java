/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.connect.hub;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Reem
 */
public class SignInWindow extends javax.swing.JFrame {

    /**
     * Creates new form SignInWindow
     */
    public SignInWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        emailField = new javax.swing.JTextField();
        signInButton = new javax.swing.JButton();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        passField = new java.awt.Label();
        usernameField = new javax.swing.JTextField();
        label3 = new java.awt.Label();
        passField1 = new java.awt.Label();
        yearField = new javax.swing.JTextField();
        monthField = new javax.swing.JTextField();
        dayField = new javax.swing.JTextField();
        passField2 = new java.awt.Label();
        passField3 = new java.awt.Label();
        passField4 = new java.awt.Label();
        passwordField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Connect Hub");

        signInButton.setBackground(new java.awt.Color(0, 0, 153));
        signInButton.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        signInButton.setForeground(new java.awt.Color(255, 255, 255));
        signInButton.setText("Sign up");
        signInButton.setToolTipText("");
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Times New Roman", 3, 75)); // NOI18N
        label1.setForeground(new java.awt.Color(0, 0, 153));
        label1.setText("Connect Hub");

        label2.setFont(new java.awt.Font("Times New Roman", 3, 25)); // NOI18N
        label2.setForeground(new java.awt.Color(0, 0, 153));
        label2.setText("Email:");

        passField.setFont(new java.awt.Font("Times New Roman", 3, 25)); // NOI18N
        passField.setForeground(new java.awt.Color(0, 0, 153));
        passField.setText("Password :");

        label3.setFont(new java.awt.Font("Times New Roman", 3, 25)); // NOI18N
        label3.setForeground(new java.awt.Color(0, 0, 153));
        label3.setText("User Name :");

        passField1.setFont(new java.awt.Font("Times New Roman", 3, 25)); // NOI18N
        passField1.setForeground(new java.awt.Color(0, 0, 153));
        passField1.setText("Date Of Birth :");

        passField2.setFont(new java.awt.Font("Times New Roman", 3, 25)); // NOI18N
        passField2.setForeground(new java.awt.Color(0, 0, 153));
        passField2.setText("Month");

        passField3.setFont(new java.awt.Font("Times New Roman", 3, 25)); // NOI18N
        passField3.setForeground(new java.awt.Color(0, 0, 153));
        passField3.setText("Day");

        passField4.setFont(new java.awt.Font("Times New Roman", 3, 25)); // NOI18N
        passField4.setForeground(new java.awt.Color(0, 0, 153));
        passField4.setText("Year");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(passField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(passField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(passField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(monthField, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addComponent(passField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(dayField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(154, 154, 154)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(95, 95, 95))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(passField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passwordField))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(yearField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(monthField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(passField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInButtonActionPerformed
        //checking if all info are written
        if (emailField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter email address!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (passwordField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter password!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (usernameField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your username!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (yearField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter year of birth!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (monthField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter month of birth!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (dayField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter day of birth!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            //check the date format

            if ((Integer.parseInt(dayField.getText()) < 1 || Integer.parseInt(dayField.getText()) > 31) //day should be between 1 and 31
                    || (Integer.parseInt(monthField.getText()) < 1 || Integer.parseInt(monthField.getText()) > 12) //month should be between 1 and 12
                    || (Integer.parseInt(yearField.getText()) < 1920 || Integer.parseInt(yearField.getText()) > 2023)) //year should be between 1920 and 2023
            {
                JOptionPane.showMessageDialog(null, "Please enter right format of date!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please enter right format of date!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int day = Integer.parseInt(dayField.getText());
        int month = Integer.parseInt(monthField.getText());
        int year = Integer.parseInt(yearField.getText());

        String date;
        if (day < 10 && month < 10) {
            date = year + "-0" + month + "-0" + day;
        } else if (day < 10) {
            date = year + "-" + month + "-0" + day;

        } else if (month < 10) {
            date = year + "-0" + month + "-" + day;

        } else {
            date = year + "-" + month + "-" + day;
        }

        try {
            User user = null;
            SignIn.operate(user, emailField.getText(), usernameField.getText(), new String(passwordField.getPassword()), date);
            if (ConnectHub.currentUser != null) {
                NewsfeedPage nfs = new NewsfeedPage();
                dispose();
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SignInWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SignInWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_signInButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignInWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignInWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignInWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignInWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignInWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dayField;
    private javax.swing.JTextField emailField;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private javax.swing.JTextField monthField;
    private java.awt.Label passField;
    private java.awt.Label passField1;
    private java.awt.Label passField2;
    private java.awt.Label passField3;
    private java.awt.Label passField4;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton signInButton;
    private javax.swing.JTextField usernameField;
    private javax.swing.JTextField yearField;
    // End of variables declaration//GEN-END:variables
}
