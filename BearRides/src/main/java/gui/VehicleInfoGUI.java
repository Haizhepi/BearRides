/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author wan
 */
public class VehicleInfoGUI extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form DriverInfo
     */
    public VehicleInfoGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
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
        topSeparator = new javax.swing.JSeparator();
        saveButton = new javax.swing.JButton();
        bottomSeparator = new javax.swing.JSeparator();
        backButton = new javax.swing.JButton();

        driverLabel.setText("Be a driver?");

        driverCheckBox.setText("YES!");

        vInfoLabel.setText("Vehicle Infomation");

        modelLabel.setText("Model (Description)");

        capaLabel.setText("Capacity (People)");

        spaceLabel.setText("storage Space (Cases)");

        saveButton.setText("Save");

        backButton.setText("Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bottomSeparator)
                    .addComponent(topSeparator, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modelLabel)
                            .addComponent(capaLabel)
                            .addComponent(spaceLabel))
                        .addGap(139, 139, 139)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spaceFormattedTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(capaFormattedTextField)
                            .addComponent(modelFormattedTextField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vInfoLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(driverLabel)
                                .addGap(18, 18, 18)
                                .addComponent(driverCheckBox)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(saveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(60, 60, 60))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {backButton, saveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(driverLabel)
                    .addComponent(driverCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vInfoLabel)
                .addGap(2, 2, 2)
                .addComponent(topSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modelLabel)
                    .addComponent(modelFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(capaLabel)
                    .addComponent(capaFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spaceLabel)
                    .addComponent(spaceFormattedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bottomSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(backButton))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {backButton, saveButton});

    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JSeparator bottomSeparator;
    private javax.swing.JFormattedTextField capaFormattedTextField;
    private javax.swing.JLabel capaLabel;
    private javax.swing.JCheckBox driverCheckBox;
    private javax.swing.JLabel driverLabel;
    private javax.swing.JFormattedTextField modelFormattedTextField;
    private javax.swing.JLabel modelLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JFormattedTextField spaceFormattedTextField;
    private javax.swing.JLabel spaceLabel;
    private javax.swing.JSeparator topSeparator;
    private javax.swing.JLabel vInfoLabel;
    // End of variables declaration//GEN-END:variables
}
