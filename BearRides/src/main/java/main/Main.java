/*
 * Contributors: Ash
 * Description: This class serves as our data structure for users
 * Date Last Modified: 10/22/2018
 */

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