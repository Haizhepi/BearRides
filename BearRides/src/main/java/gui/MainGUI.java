package gui;

import javax.swing.*;

import controller.FrameController;
import object.Message;

import java.util.Stack;


public class MainGUI extends JPanel {
    private static final long serialVersionUID = -6508626185123863757L;    
    private FrameController fm;
    private static Stack<JPanel> frameStack;
    private static JFrame jFrame = new JFrame("test");
    
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
    protected static Driver_VehicleInfoGUI driver_vehicleInfoGUI;
    protected static LoginGUI loginGUI;
    protected static MessageBoardGUI messageBoardGUI;
    protected static MessageGUI messageGUI;
    protected static RegisterGUI registerGUI;
    protected static UserGUI userGUI;
    protected static MainGUI mainGUI;
    public MainGUI() {


    	//fm = new FrameController();
    	driver_vehicleInfoGUI = new Driver_VehicleInfoGUI();
    	loginGUI = new LoginGUI();
    	messageBoardGUI = new MessageBoardGUI();
    	messageGUI = new MessageGUI();
    	registerGUI = new RegisterGUI();
    	userGUI = new UserGUI();
    	frameStack = new Stack<>();
    	frameStack.push(loginGUI);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setContentPane(loginGUI);
        jFrame.pack();
        jFrame.setVisible(true);
    }
    
    public void runGUI() {
    	fm.changeFrame(new HomePageGUI());
    }

    public static void loadGUI(JPanel jPanel) {
        frameStack.push(jPanel);
        //jFrame.getContentPane().removeAll();
        jFrame.setContentPane(jPanel);
//        jFrame.pack();
//        jFrame.setVisible(true);
        jFrame.revalidate();
        System.out.print("get called");

    }

    public static void exitGUI() {
        //TODO: check if already in the login page
        //if(frameStack.peek().getClass().equals())
        frameStack.pop();
        //jFrame.getContentPane().removeAll();
        jFrame.setContentPane(frameStack.peek());
        jFrame.revalidate();
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {}
        mainGUI = new MainGUI();
        //mainGUI.userGUI.
    }
    
}
