package gui;

import javax.swing.*;

public class Mainsomething {
    public static void main(String[] args) {
        JLabel iconLabel = new javax.swing.JLabel();
        iconLabel.setIcon(new ImageIcon("src/main/resources/BearRidesLogo.png")); // NOI18N

        JFrame jFrame = new JFrame("test");
        LoginGUI loginGUI = new LoginGUI();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setContentPane(loginGUI);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
