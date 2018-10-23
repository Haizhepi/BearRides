/*
 * Contributors: Ash
 * Description: this class serves to initialize the control panel and start loginGUI
 * Date Last Modified: 10/22/2018
 */

package main;

import java.io.File;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import controller.ControlPanel;
import controller.PanelController;
import gui.LoginGUI;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
    public static void main(String[] args) {

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
                
                ControlPanel cp = new ControlPanel(new File(""));
                cp.getPanelController().changeFrame(new LoginGUI(cp));
            }
        });
    }
}