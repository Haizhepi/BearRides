/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;

import org.apache.logging.log4j.LogManager;

import controller.DashBoard;
import controller.MessageCollectionController;
import controller.PanelController;
import object.Message;

/**
 *
 * @author Xingan_Wan
 */
public class EditMessageGUI extends javax.swing.JPanel {
    
    /**
     * Creates new form MessageGUI
     */
    public EditMessageGUI(DashBoard cp, Message message) {
        this.cp = cp;
        this.tc = cp.getMessageCollectionController();
        this.pc = cp.getPanelController();
        this.message = message;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        descriptionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
<<<<<<< HEAD
        jTextArea1 = new javax.swing.JTextArea(message.getBody());
        creatorLabel = new javax.swing.JLabel();
        titleTextField = new javax.swing.JTextField(message.getTitle());
        postTimeLabel = new javax.swing.JLabel();
        postTimeTextField = new javax.swing.JTextField(message.getPostTime());
        backButton = new javax.swing.JButton();
        creatorTextField = new javax.swing.JTextField(message.getCreator().toString());
=======
        jTextArea1 = new javax.swing.JTextArea();
        creatorTextField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
>>>>>>> 613328bce7d7d3d77c219c7f27d091cfaf4a125f
        titleLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        messageLabel = new javax.swing.JLabel();
        saveTripButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(700, 500));

        descriptionLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        descriptionLabel.setText("Description");

        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        backButton.setBackground(new java.awt.Color(0, 102, 0));
        backButton.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        titleLabel.setText("Title");

        messageLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        messageLabel.setText("Message");

        saveTripButton.setBackground(new java.awt.Color(0, 102, 0));
        saveTripButton.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        saveTripButton.setText("Save Trip");
        saveTripButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTripButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(messageLabel)
                        .addGap(0, 586, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
<<<<<<< HEAD
                            .addComponent(titleTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(postTimeTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(creatorTextField)
=======
                            .addComponent(creatorTextField, javax.swing.GroupLayout.Alignment.LEADING)
>>>>>>> 613328bce7d7d3d77c219c7f27d091cfaf4a125f
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(descriptionLabel)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(saveTripButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageLabel)
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
<<<<<<< HEAD
                .addComponent(titleTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(creatorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(creatorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(postTimeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(postTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
=======
                .addComponent(creatorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
>>>>>>> 613328bce7d7d3d77c219c7f27d091cfaf4a125f
                .addComponent(descriptionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveTripButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        message.setBody(jTextArea1.getText());
        message.setTitle(titleTextField.getText());
        pc.closeFrame();
    }//GEN-LAST:event_backButtonActionPerformed

    private void saveTripButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTripButtonActionPerformed
        // TODO add your handling code here:
<<<<<<< HEAD
        pc.changeFrame(new EditTripGUI(cp, message));
    }//GEN-LAST:event_editTripButtonActionPerformed
=======
        pc.changeFrame(new EditTripGUI(cp));
    }//GEN-LAST:event_saveTripButtonActionPerformed
>>>>>>> 613328bce7d7d3d77c219c7f27d091cfaf4a125f
    
    @SuppressWarnings("unused")
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
        pc.closeFrame();
    }                                         
    
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
                cp.getPanelController().changeFrame(new EditMessageGUI(cp, null));
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
<<<<<<< HEAD
    private javax.swing.JLabel creatorLabel;
    private javax.swing.JTextField titleTextField;
=======
    private javax.swing.JTextField creatorTextField;
>>>>>>> 613328bce7d7d3d77c219c7f27d091cfaf4a125f
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel messageLabel;
<<<<<<< HEAD
    private javax.swing.JLabel postTimeLabel;
    private javax.swing.JTextField postTimeTextField;
    private javax.swing.JTextField creatorTextField;
=======
    private javax.swing.JButton saveTripButton;
>>>>>>> 613328bce7d7d3d77c219c7f27d091cfaf4a125f
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
    
    private DashBoard cp;
    @SuppressWarnings("unused")
    private MessageCollectionController tc;
    private PanelController pc;
    private Message message;
    private static final long serialVersionUID = -8737577434831994363L;
}
