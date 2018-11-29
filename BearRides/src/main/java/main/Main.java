/*
 * Contributors: Ash
 * Description: this class serves to initialize the control panel and start loginGUI
 * Date Last Modified: 10/22/2018
 */

package main;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import controller.DashBoard;
import gui.LoginGUI;

import javax.swing.UnsupportedLookAndFeelException;

import org.apache.logging.log4j.LogManager;

public class Main {
    
    public static void main(String[] args) {
        System.setProperty("log4j.configurationFile", "resources/log4j2.xml");
        
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
                
                DashBoard db = new DashBoard();
                db.load();
                db.getPanelController().changeFrame(new LoginGUI(db));
            }
        });
    }
}