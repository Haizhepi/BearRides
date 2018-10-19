package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainGUI extends JPanel {
    private static final long serialVersionUID = -6508626185123863757L;
    private static JFrame frame = null;
    
    private static EditMessageGUI editMessage				= null;
    private static EditSettingsGUI editSettings			= null;
    private static EditUserGUI editUser					= null;
    private static LoginUserGUI loginUser					= null;
    private static RegisterDriverGUI registerDriver		= null;
    private static RegisterMessageGUI registerMessage		= null;
    private static RegisterUserGUI registerUser			= null;
    private static ViewMessageBoardGUI viewMessageBoard	= null;
    private static ViewMessageGUI viewMessage				= null;
    private static ViewProfileGUI viewProfile				= null;
    
    public MainGUI() {
    	System.out.println("We are in const");
    	
    	frame = new JFrame("BearRides");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    
    public void drawTest() {
    	this.viewProfile.draw(frame);
    }
    
}
