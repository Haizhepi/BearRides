package gui;

import javax.swing.JPanel;

import controller.FrameController;


public class MainGUI extends JPanel {
    private static final long serialVersionUID = -6508626185123863757L;    
    private FrameController fm;
    
    
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
    	fm = new FrameController();
    }
    
    public void runGUI() {
    	fm.changeFrame(new HomePageGUI());
    }
    
}
