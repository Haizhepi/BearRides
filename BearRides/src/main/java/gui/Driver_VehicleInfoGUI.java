/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;

import controller.PanelController;

/**
 *
 * @author Xingan_Wan
 */
public class Driver_VehicleInfoGUI extends javax.swing.JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 7794269541984046099L;
    private PanelController pm;
    /**
     * Creates new form DriverInfo
     */
    public Driver_VehicleInfoGUI(PanelController pm) {
        this.pm = pm;
        initComponents();
    }

    /*
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.*/
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        driverLabel = new javax.swing.JLabel();
        driverCheckBox = new javax.swing.JCheckBox();
        vInfoLabel = new javax.swing.JLabel();
        modelLabel = new javax.swing.JLabel();
        capaLabel = new javax.swing.JLabel();
        spaceLabel = new javax.swing.JLabel();
        modelFormattedTextField = new javax.swing.JFormattedTextField();
        capaFormattedTextField = new javax.swing.JFormattedTextField();
        spaceFormattedTextField = new javax.swing.JFormattedTextField();
        middleSeparator = new javax.swing.JSeparator();
        okButton = new javax.swing.JButton();
        bottomSeparator = new javax.swing.JSeparator();
        backButton = new javax.swing.JButton();
        topSeparator = new javax.swing.JSeparator();
        driverCheckLabel = new javax.swing.JLabel();
        dlLabel = new javax.swing.JLabel();
        dlTextField = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(700, 500));

        driverLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        driverLabel.setText("Driver Infomation");

        driverCheckBox.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 18)); // NOI18N
        driverCheckBox.setText("(Check if is a driver)");
        driverCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                driverCheckBoxActionPerformed(evt);
            }
        });

        vInfoLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        vInfoLabel.setText("Vehicle Infomation");

        modelLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        modelLabel.setText("Model (Description)");

        capaLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        capaLabel.setText("Capacity (People)");

        spaceLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        spaceLabel.setText("storage Space (Cases)");

        okButton.setBackground(new java.awt.Color(0, 102, 0));
        okButton.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        backButton.setBackground(new java.awt.Color(255, 0, 0));
        backButton.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        driverCheckLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        driverCheckLabel.setText("Driver");

        dlLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        dlLabel.setText("Driver License #");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bottomSeparator)
                    .addComponent(middleSeparator, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(driverLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topSeparator)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(driverCheckLabel)
                    .addComponent(dlLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(driverCheckBox))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(capaLabel)
                    .addComponent(vInfoLabel)
                    .addComponent(spaceLabel)
                    .addComponent(modelLabel))
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(capaFormattedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                    .addComponent(modelFormattedTextField)
                    .addComponent(spaceFormattedTextField))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {backButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(driverLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(topSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(driverCheckLabel)
                    .addComponent(driverCheckBox))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dlLabel)
                    .addComponent(dlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75)
                .addComponent(vInfoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(middleSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelLabel)
                    .addComponent(modelFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(capaLabel)
                    .addComponent(capaFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spaceLabel)
                    .addComponent(spaceFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(bottomSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {backButton, okButton});

    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_okButtonActionPerformed

    private void driverCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_driverCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_driverCheckBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JSeparator bottomSeparator;
    private javax.swing.JFormattedTextField capaFormattedTextField;
    private javax.swing.JLabel capaLabel;
    private javax.swing.JLabel dlLabel;
    private javax.swing.JTextField dlTextField;
    private javax.swing.JCheckBox driverCheckBox;
    private javax.swing.JLabel driverCheckLabel;
    private javax.swing.JLabel driverLabel;
    private javax.swing.JSeparator middleSeparator;
    private javax.swing.JFormattedTextField modelFormattedTextField;
    private javax.swing.JLabel modelLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JFormattedTextField spaceFormattedTextField;
    private javax.swing.JLabel spaceLabel;
    private javax.swing.JSeparator topSeparator;
    private javax.swing.JLabel vInfoLabel;


    public static void main(String[] args) throws Exception{
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {}
        PanelController pm = new PanelController();
        JFrame jFrame = new JFrame("test");
        Driver_VehicleInfoGUI test = new Driver_VehicleInfoGUI(pm);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setContentPane(test);
        jFrame.pack();
        jFrame.setVisible(true);

    }
    // End of variables declaration//GEN-END:variables
}
