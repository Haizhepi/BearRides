package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGUI extends JPanel {
    private static final long serialVersionUID = -6508626185123863757L;
    private static JFrame frame = null;
    
    private EditMessageGUI editMessage;
    private EditSettingsGUI editSettings;
    private EditUserGUI editUser;
    private LoginUserGUI loginUser;
    private RegisterDriverGUI registerDriver;
    private RegisterMessageGUI registerMessage;
    private RegisterUserGUI registerUser;
    private ViewMessageBoardGUI viewMessageBoard;
    private ViewMessageGUI viewMessage;
    private ViewProfileGUI viewProfile;
    
    public MainGUI() {
    	System.out.println("We are in const");
    	
    	frame = new JFrame("BearRides");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
        
        this.editMessage 		= new EditMessageGUI();
        this.editSettings 		= new EditSettingsGUI();
        this.editUser 			= new EditUserGUI();
        this.loginUser 			= new LoginUserGUI();
        this.registerDriver 	= new RegisterDriverGUI();
        this.registerMessage 	= new RegisterMessageGUI();
        this.registerUser 		= new RegisterUserGUI();
        this.viewMessageBoard 	= new ViewMessageBoardGUI();
        this.viewMessage 		= new ViewMessageGUI();
        this.viewProfile 		= new ViewProfileGUI();
    }
    
    public void runMain() {
    	viewProfile.draw(frame);
    }
    
}
