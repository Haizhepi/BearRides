package gui;

import javax.swing.JPanel;

import controller.PanelController;


public class MainGUI extends JPanel {
    private static final long serialVersionUID = -6508626185123863757L;    
    private PanelController fm;
    
    
    /*
    private EditSettingsGUI editSettings;
    private EditUserGUI editUser;
    private LoginUserGUI loginUser;
    private RegisterDriverGUI registerDriver;
    private RegisterMessageGUI registerMessage;
    private RegisterUserGUI registerUser;
    private ViewMessageBoardGUI viewMessageBoard;
    private ViewMessageGUI viewMessage;
    private ViewProfileGUI viewProfile;
    private HomePage homePage;
    */
        
    public MainGUI() {
    	fm = new PanelController();
    }
    
    public void runGUI() {
    	fm.changeFrame(new HomePageGUI());
    }
    
}
