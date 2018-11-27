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
public class ViewMessageGUI extends javax.swing.JPanel {
    
    /**
     * Creates new form ViewMessageGUI
     */
    public ViewMessageGUI(DashBoard cp) {
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

        viewMessageLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        titleLabel = new javax.swing.JLabel();
        creatorTextField = new javax.swing.JTextField();
        creatorLabel = new javax.swing.JLabel();
        postTimeTextField1 = new javax.swing.JTextField();
        postTimeLabel = new javax.swing.JLabel();
        postTimeTextField = new javax.swing.JTextField();
        descriptionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        TripButton = new javax.swing.JButton();
        creatorButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(700, 500));

        viewMessageLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        viewMessageLabel.setText("View Message");

        titleLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        titleLabel.setText("Title");

        creatorTextField.setEditable(false);

        creatorLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        creatorLabel.setText("Creator");

        postTimeTextField1.setEditable(false);

        postTimeLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        postTimeLabel.setText("PostTime");

        postTimeTextField.setEditable(false);

        descriptionLabel.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        descriptionLabel.setText("Description");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        TripButton.setBackground(new java.awt.Color(0, 102, 0));
        TripButton.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        TripButton.setText("Trip");
        TripButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TripButtonActionPerformed(evt);
            }
        });

        creatorButton.setBackground(new java.awt.Color(0, 102, 0));
        creatorButton.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        creatorButton.setText("Creator");
        creatorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creatorButtonActionPerformed(evt);
            }
        });

        backButton.setBackground(new java.awt.Color(0, 102, 0));
        backButton.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(creatorTextField)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(viewMessageLabel)
                                    .addComponent(creatorLabel)
                                    .addComponent(postTimeLabel)
                                    .addComponent(descriptionLabel))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator1)
                            .addComponent(jScrollPane1)
                            .addComponent(postTimeTextField)
                            .addComponent(postTimeTextField1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(creatorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(TripButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewMessageLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(creatorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(creatorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(postTimeTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(postTimeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(postTimeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(descriptionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TripButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creatorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TripButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TripButtonActionPerformed
        // TODO add your handling code here:
        pc.closeFrame();
    }//GEN-LAST:event_TripButtonActionPerformed

    private void creatorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creatorButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_creatorButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TripButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton creatorButton;
    private javax.swing.JLabel creatorLabel;
    private javax.swing.JTextField creatorTextField;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel postTimeLabel;
    private javax.swing.JTextField postTimeTextField;
    private javax.swing.JTextField postTimeTextField1;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel viewMessageLabel;
    // End of variables declaration//GEN-END:variables
    
    @SuppressWarnings("unused")
    private DashBoard cp;
    @SuppressWarnings("unused")
    private MessageCollectionController tc;
    private PanelController pc;
    private static final long serialVersionUID = 5688490924844336601L;
}
