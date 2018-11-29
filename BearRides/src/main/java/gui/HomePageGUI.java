/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;

import org.apache.logging.log4j.LogManager;

import controller.DashBoard;
import controller.PanelController;
/**
 *
 * @author Xingan_wan
 */
public class HomePageGUI extends JPanel {
    
    /**
     * Creates new form HomePageGUI
     */
    public HomePageGUI(DashBoard cp) {
        this.cp = cp;
        pc = cp.getPanelController();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeLabel = new javax.swing.JLabel();
        topSeparator = new javax.swing.JSeparator();
        tripLabel = new javax.swing.JLabel();
        tripButton = new javax.swing.JButton();
        messageBoardLabel = new javax.swing.JLabel();
        messageBoardButton = new javax.swing.JButton();
        userInfoLabel = new javax.swing.JLabel();
        accountSettingButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        notificationLabel = new javax.swing.JLabel();
        notificationButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(700, 500));

        welcomeLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        welcomeLabel.setText("Welcome To Bear Rides!");

        tripLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        tripLabel.setText("Your Coming Trip:");

        tripButton.setBackground(new java.awt.Color(51, 153, 0));
        tripButton.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        tripButton.setText("Your Trip");
        tripButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tripButtonActionPerformed(evt);
            }
        });

        messageBoardLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        messageBoardLabel.setText("Find A Trip:");

        messageBoardButton.setBackground(new java.awt.Color(255, 255, 0));
        messageBoardButton.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        messageBoardButton.setText("Message Board");
        messageBoardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageBoardButtonActionPerformed(evt);
            }
        });

        userInfoLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        userInfoLabel.setText("Change your Info:");

        accountSettingButton.setBackground(new java.awt.Color(0, 102, 204));
        accountSettingButton.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        accountSettingButton.setText("Account Setting");
        accountSettingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountSettingButtonActionPerformed(evt);
            }
        });

        backButton.setBackground(new java.awt.Color(255, 51, 51));
        backButton.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        notificationLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        notificationLabel.setText("Notification:");

        notificationButton.setBackground(new java.awt.Color(255, 102, 102));
        notificationButton.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        notificationButton.setText("Notification");
        notificationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notificationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(topSeparator)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(userInfoLabel)
                                    .addComponent(tripLabel)
                                    .addComponent(notificationLabel)
                                    .addComponent(messageBoardLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 231, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(messageBoardButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(accountSettingButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(tripButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(notificationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(33, 33, 33))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(welcomeLabel)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(welcomeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(topSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(notificationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(notificationLabel))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tripButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tripLabel))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageBoardLabel)
                    .addComponent(messageBoardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountSettingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userInfoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tripButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tripButtonActionPerformed
        pc.changeFrame(new ViewTripGUI(cp));
    }//GEN-LAST:event_tripButtonActionPerformed

    private void messageBoardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageBoardButtonActionPerformed
        pc.changeFrame(new MessageBoardGUI(cp));
    }//GEN-LAST:event_messageBoardButtonActionPerformed

    private void accountSettingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accountSettingButtonActionPerformed
        pc.changeFrame(new ViewUserGUI(cp));
    }//GEN-LAST:event_accountSettingButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        pc.closeFrame();
    }//GEN-LAST:event_backButtonActionPerformed

    private void notificationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notificationButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_notificationButtonActionPerformed

    public static void main(String[] args) throws Exception{
        // take place on thread other than main thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Windows".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    LogManager.getLogger().error(e.getMessage(), e);
                }
                // turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                
                DashBoard cp = new DashBoard();
                cp.load();
                cp.getPanelController().changeFrame(new HomePageGUI(cp));
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton accountSettingButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton messageBoardButton;
    private javax.swing.JLabel messageBoardLabel;
    private javax.swing.JButton notificationButton;
    private javax.swing.JLabel notificationLabel;
    private javax.swing.JSeparator topSeparator;
    private javax.swing.JButton tripButton;
    private javax.swing.JLabel tripLabel;
    private javax.swing.JLabel userInfoLabel;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
    
    private DashBoard cp;
    private PanelController pc;
    private static final long serialVersionUID = -3303691846979303846L;
}
