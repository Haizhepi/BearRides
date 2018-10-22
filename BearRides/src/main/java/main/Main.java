package main;

import controller.PanelController;
import gui.MainGUI;

public class Main {
    public static void main(String args[]) {
        PanelController pm = new PanelController();
        PanelController.chnage
    	MainGUI main = new MainGUI(pm);
    	
    	main.runGUI();
    }
}