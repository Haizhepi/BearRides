/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.DashBoard;
import controller.MessageCollectionController;
import controller.PanelController;
import object.User;

/**
 *
 * @author WAN
 */
public class ViewUserGUI extends javax.swing.JPanel {

    /**
     * Creates new form ViewUser
     * @return 
     */
    public ViewUserGUI(DashBoard cp, User user) {
        this.cp = cp;
        this.tc = cp.getMessageCollectionController();
        this.pc = cp.getPanelController();
        this.user = user;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ViewUserInfoLabel = new javax.swing.JLabel();
        upperSeparator = new javax.swing.JSeparator();
        nameLabel = new javax.swing.JLabel();
        nameFormattedTextField = new javax.swing.JFormattedTextField(user.getName());
        ageFormattedTextField = new javax.swing.JFormattedTextField(user.getAge().toString());
        genderLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        contactLabel = new javax.swing.JLabel();
        contactFormattedTextField = new javax.swing.JFormattedTextField(user.getContact());
        isDriverLabel = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox1.setSelected(user.isDriver());
        editButton = new javax.swing.JButton();
        D_VInfoButton = new javax.swing.JButton();

        ViewUserInfoLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        ViewUserInfoLabel.setText("View User Information");

        nameLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        nameLabel.setText("name");

        nameFormattedTextField.setEditable(false);

        ageFormattedTextField.setEditable(false);

        genderLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        genderLabel.setText("Gender");

        backButton.setBackground(new java.awt.Color(255, 255, 51));
        backButton.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        contactLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        contactLabel.setText("Contact (Phone/WeChat#)");

        contactFormattedTextField.setEditable(false);

        isDriverLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        isDriverLabel.setText("Driver Check Box");

        jCheckBox1.setText("DRIVER");
        jCheckBox1.setEnabled(false);

        editButton.setBackground(new java.awt.Color(102, 255, 51));
        editButton.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        D_VInfoButton.setBackground(new java.awt.Color(255, 0, 0));
        D_VInfoButton.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        D_VInfoButton.setText("Driver Info");
        D_VInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                D_VInfoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(upperSeparator)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(genderLabel)
                            .addComponent(contactLabel)
                            .addComponent(ViewUserInfoLabel)
                            .addComponent(isDriverLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .addComponent(ageFormattedTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(contactFormattedTextField, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nameFormattedTextField)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
            .addGroup(layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(D_VInfoButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ViewUserInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(upperSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel)
                    .addComponent(nameFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderLabel)
                    .addComponent(ageFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contactLabel)
                    .addComponent(contactFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isDriverLabel)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(D_VInfoButton)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        pc.closeFrame();
    }//GEN-LAST:event_backButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        pc.changeFrame(new EditUserGUI(cp, user));
    }//GEN-LAST:event_editButtonActionPerformed

    private void D_VInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D_VInfoButtonActionPerformed
        // TODO add your handling code here:
        pc.changeFrame(new ViewVehicleGUI(cp, user));
    }//GEN-LAST:event_D_VInfoButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton D_VInfoButton;
    private javax.swing.JLabel ViewUserInfoLabel;
    private javax.swing.JFormattedTextField ageFormattedTextField;
    private javax.swing.JButton backButton;
    private javax.swing.JFormattedTextField contactFormattedTextField;
    private javax.swing.JLabel contactLabel;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel isDriverLabel;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JFormattedTextField nameFormattedTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JSeparator upperSeparator;
    // End of variables declaration//GEN-END:variables
    
    private DashBoard cp;
    @SuppressWarnings("unused")
    private MessageCollectionController tc;
    private PanelController pc;
    private User user;
    private static final long serialVersionUID = -4418835094826682827L;
}
