/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.*;

import controller.PanelController;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Xingan_Wan
 */
public class MessageBoardGUI extends javax.swing.JPanel {

    /**
     * Creates new form MessageTableGUI1
     */
    public MessageBoardGUI(PanelController pm) {
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

        backButton = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        messageTable = new javax.swing.JTable();

        backButton.setBackground(new java.awt.Color(0, 102, 0));
        backButton.setFont(new java.awt.Font("Leelawadee UI", 0, 24)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
            .addComponent(jScrollPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        pm.closeFrame();
    }//GEN-LAST:event_backButtonActionPerformed

    private void messageTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messageTableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) messageTable.getModel();
        if (2 == evt.getClickCount()) {
            int mouseIndex = messageTable.rowAtPoint(evt.getPoint());
            mouseIndex = messageTable.convertRowIndexToModel(mouseIndex);
            pm.changeFrame(new MessageGUI(pm));       
        }
        
    }//GEN-LAST:event_messageTableMouseClicked

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
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException e) {
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
                pm.changeFrame(new MessageBoardGUI(pm));
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable messageTable;
    // End of variables declaration//GEN-END:variables

    PanelController pm;
    private static final long serialVersionUID = 5164463894978645312L;
}
