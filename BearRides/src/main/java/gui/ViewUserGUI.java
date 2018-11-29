/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import controller.DashBoard;
import controller.MessageCollectionController;
import controller.PanelController;

/**
 *
 * @author WAN
 */
public class ViewUserGUI extends javax.swing.JPanel {

    /**
     * Creates new form ViewUser
     * @return 
     */
    public ViewUserGUI(DashBoard cp) {
        this.cp = cp;
        this.tc = cp.getMessageCollectionController();
        this.pc = cp.getPanelController();
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
        firstnameLabel = new javax.swing.JLabel();
        firstNameFormattedTextField = new javax.swing.JFormattedTextField();
        lastnameLabel = new javax.swing.JLabel();
        lastNameFormattedTextField = new javax.swing.JFormattedTextField();
        ageFormattedTextField = new javax.swing.JFormattedTextField();
        genderLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        contactLabel = new javax.swing.JLabel();
        contactFormattedTextField = new javax.swing.JFormattedTextField();
        isDriverLabel = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        ViewUserInfoLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        ViewUserInfoLabel.setText("View User Infomation");

        firstnameLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        firstnameLabel.setText("First Name");

        firstNameFormattedTextField.setEditable(false);

        lastnameLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        lastnameLabel.setText("Last Name");

        lastNameFormattedTextField.setEditable(false);

        ageFormattedTextField.setEditable(false);

        genderLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        genderLabel.setText("Gender");

        backButton.setBackground(new java.awt.Color(255, 255, 51));
        backButton.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        backButton.setText("BACK");
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
                            .addComponent(lastnameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                            .addComponent(firstnameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(firstNameFormattedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .addComponent(lastNameFormattedTextField)))
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
                            .addComponent(contactFormattedTextField, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(209, 209, 209))
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
                    .addComponent(firstnameLabel)
                    .addComponent(firstNameFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastnameLabel)
                    .addComponent(lastNameFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        pc.closeFrame();
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ViewUserInfoLabel;
    private javax.swing.JFormattedTextField ageFormattedTextField;
    private javax.swing.JButton backButton;
    private javax.swing.JFormattedTextField contactFormattedTextField;
    private javax.swing.JLabel contactLabel;
    private javax.swing.JFormattedTextField firstNameFormattedTextField;
    private javax.swing.JLabel firstnameLabel;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel isDriverLabel;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JFormattedTextField lastNameFormattedTextField;
    private javax.swing.JLabel lastnameLabel;
    private javax.swing.JSeparator upperSeparator;
    // End of variables declaration//GEN-END:variables
    
    @SuppressWarnings("unused")
    private DashBoard cp;
    @SuppressWarnings("unused")
    private MessageCollectionController tc;
    private PanelController pc;
    private static final long serialVersionUID = -4418835094826682827L;
}