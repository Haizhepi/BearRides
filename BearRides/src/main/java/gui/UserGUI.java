package gui;

/**
 *
 * @author Xingan_Wan
 */
import javax.swing.*;

import controller.PanelController;

public class UserGUI extends JPanel {
    
    /**
     * Creates new form UserGUI
     */
    public UserGUI(PanelController pm) {
        this.pm = pm;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userInfoLabel = new javax.swing.JLabel();
        reqLabel = new javax.swing.JLabel();
        firstnameLabel = new javax.swing.JLabel();
        lastnameLabel = new javax.swing.JLabel();
        ageLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        contactLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        firstNameFormattedTextField = new javax.swing.JFormattedTextField();
        lastNameFormattedTextField = new javax.swing.JFormattedTextField();
        ageFormattedTextField = new javax.swing.JFormattedTextField();
        genderFormattedTextField = new javax.swing.JFormattedTextField();
        contactFormattedTextField = new javax.swing.JFormattedTextField();
        emailFormattedTextField = new javax.swing.JFormattedTextField();
        upperSeparator = new javax.swing.JSeparator();
        LowerSeparator = new javax.swing.JSeparator();
        okButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        D_VInfoButton = new javax.swing.JButton();
        passwordLabel = new javax.swing.JLabel();
        passwordComfirmLabel = new javax.swing.JLabel();
        setPasswordField = new javax.swing.JPasswordField();
        comfirmPasswordField = new javax.swing.JPasswordField();

        setPreferredSize(new java.awt.Dimension(700, 500));

        userInfoLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        userInfoLabel.setText("User Infomation");

        reqLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        reqLabel.setText("* Indicates required field");

        firstnameLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        firstnameLabel.setText("First Name*");

        lastnameLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        lastnameLabel.setText("Last Name*");

        ageLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        ageLabel.setText("Age*");

        genderLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        genderLabel.setText("Gender");

        contactLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        contactLabel.setText("Contact (Phone/WeChat#)*");

        emailLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        emailLabel.setText("Email Address*");

        okButton.setBackground(new java.awt.Color(255, 255, 51));
        okButton.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        backButton.setBackground(new java.awt.Color(0, 102, 0));
        backButton.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
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

        passwordLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        passwordLabel.setText("Set Password*");

        passwordComfirmLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        passwordComfirmLabel.setText("Confirm Password*");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LowerSeparator)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userInfoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 316, Short.MAX_VALUE)
                        .addComponent(reqLabel))
                    .addComponent(upperSeparator)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(firstnameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(62, 62, 62))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lastnameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(119, 119, 119))
                                            .addComponent(genderLabel)
                                            .addComponent(contactLabel)
                                            .addComponent(emailLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(ageLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(passwordLabel)
                                    .addGap(293, 293, 293)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(passwordComfirmLabel)
                                .addGap(254, 254, 254)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comfirmPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                            .addComponent(setPasswordField)
                            .addComponent(contactFormattedTextField)
                            .addComponent(genderFormattedTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ageFormattedTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lastNameFormattedTextField)
                            .addComponent(firstNameFormattedTextField)
                            .addComponent(emailFormattedTextField))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(D_VInfoButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {backButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userInfoLabel)
                    .addComponent(reqLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(upperSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstnameLabel)
                    .addComponent(firstNameFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastnameLabel)
                    .addComponent(lastNameFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ageFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ageLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genderLabel)
                    .addComponent(genderFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contactLabel)
                    .addComponent(contactFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel)
                    .addComponent(emailFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(setPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordComfirmLabel)
                    .addComponent(comfirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(D_VInfoButton)
                .addGap(18, 18, 18)
                .addComponent(LowerSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton))
                .addGap(64, 64, 64))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {ageFormattedTextField, contactFormattedTextField, emailFormattedTextField, firstNameFormattedTextField, genderFormattedTextField, lastNameFormattedTextField});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {backButton, okButton});

    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        pm.closeFrame();
    }//GEN-LAST:event_okButtonActionPerformed

    private void D_VInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_D_VInfoButtonActionPerformed
        // TODO add your handling code here:
        pm.changeFrame(new Driver_VehicleInfoGUI(pm));
    }//GEN-LAST:event_D_VInfoButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        pm.closeFrame();
    }//GEN-LAST:event_backButtonActionPerformed
    
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
                } catch (ClassNotFoundException ex) {} catch (InstantiationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (UnsupportedLookAndFeelException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
                // turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                PanelController pm = new PanelController();
                pm.changeFrame(new UserGUI(pm));
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton D_VInfoButton;
    private javax.swing.JSeparator LowerSeparator;
    private javax.swing.JFormattedTextField ageFormattedTextField;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JPasswordField comfirmPasswordField;
    private javax.swing.JFormattedTextField contactFormattedTextField;
    private javax.swing.JLabel contactLabel;
    private javax.swing.JFormattedTextField emailFormattedTextField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JFormattedTextField firstNameFormattedTextField;
    private javax.swing.JLabel firstnameLabel;
    private javax.swing.JFormattedTextField genderFormattedTextField;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JFormattedTextField lastNameFormattedTextField;
    private javax.swing.JLabel lastnameLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel passwordComfirmLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel reqLabel;
    private javax.swing.JPasswordField setPasswordField;
    private javax.swing.JSeparator upperSeparator;
    private javax.swing.JLabel userInfoLabel;
    // End of variables declaration//GEN-END:variables
    
    private PanelController pm;
    private static final long serialVersionUID = -4925806868701427735L;
}