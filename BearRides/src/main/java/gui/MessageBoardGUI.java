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

/**
 *
 * @author Xingan_Wan
 */
public class MessageBoardGUI extends javax.swing.JPanel {

    /**
     * Creates new form MessageTableGUI1
     */
    public MessageBoardGUI(DashBoard cp) {
        //later make load from file
        this.cp = cp;
        tc = cp.getMessageTableController();
        messageTable = tc.getTable();
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

        jScrollPane = new javax.swing.JScrollPane();
        messageTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();

        messageTable.setFont(new java.awt.Font("Leelawadee", 0, 14)); // NOI18N
        messageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"OK", "1", "123"},
                {"TEST", "2", "123123"},
                {"Your", "2", "1233"},
                {"Program", "33", "3131"},
                {"First", "44", null}
            },
            new String [] {
                "Message", "Time Post", "Creator"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
            
            private static final long serialVersionUID = -3166042634019832264L;
        });
        messageTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        messageTable.setFillsViewportHeight(true);
        messageTable.setRowHeight(20);
        messageTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        messageTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                messageTableMouseClicked(evt);
            }
        });
        jScrollPane.setViewportView(messageTable);
        if (messageTable.getColumnModel().getColumnCount() > 0) {
            messageTable.getColumnModel().getColumn(0).setPreferredWidth(500);
            messageTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            messageTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        backButton.setBackground(new java.awt.Color(0, 102, 0));
        backButton.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        addButton.setBackground(new java.awt.Color(255, 0, 51));
        addButton.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        addButton.setText("Add Message");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {addButton, backButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addButton, backButton});

    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        pc.closeFrame();
    }//GEN-LAST:event_backButtonActionPerformed

    private void messageTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageTableMouseClicked
        // TODO add your handling code here:
        if (2 == evt.getClickCount()) {
            int mouseIndex = messageTable.rowAtPoint(evt.getPoint());
            mouseIndex = messageTable.convertRowIndexToModel(mouseIndex);
            pc.changeFrame(new MessageGUI(cp));
        }
        
    }//GEN-LAST:event_messageTableMouseClicked

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addButtonActionPerformed

    public static void main(String[] args) throws Exception {
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
                cp.getPanelController().changeFrame(new MessageBoardGUI(cp));
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable messageTable;
    // End of variables declaration//GEN-END:variables
    
    private DashBoard cp;
    private MessageCollectionController tc;
    private PanelController pc;
    private static final long serialVersionUID = 5164463894978645312L;
}
