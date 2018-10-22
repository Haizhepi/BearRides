package main;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import controller.PanelController;
import gui.LoginGUI;

public class Main {
    public static void main(String[] args) {

        // take place on thread other than main thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // turn off metal's use of bold fonts
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                PanelController pm = new PanelController();
                pm.changeFrame(new LoginGUI(pm));
            }
        });
    }
}