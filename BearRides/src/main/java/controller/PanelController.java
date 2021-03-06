/*
 * Contributors: Ash, Andrew
 * Description: this serves as our panel controller for our frame
 * Date Last Modified: 10/22/2018
 */

package controller;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Shutdown;

public class PanelController {
    
    /*~~~~~~~~~~~~ Construction  ~~~~~~~~~~~~*/

	public PanelController(DashBoard db) {
		frame = new JFrame("BearRides");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 500);
        frame.setResizable(false);
		frame.setVisible(true);

		this.stack = new Stack<JPanel>();
		this.db = db;
	}
    
    /*~~~~~~~~~~~~ Insertion  ~~~~~~~~~~~~*/
    
    /*
     * description: puts a frame onto the stack
     * return: void
     * precondition: void
     * postcondition: the new frame will be on top
     */
    public void changeFrame(JPanel newFrame) {
        this.stack.push(newFrame);

        frame.getContentPane().removeAll();
        frame.add(newFrame);
        frame.revalidate();
        frame.pack();
        frame.repaint();
    }
    
    /*~~~~~~~~~~~~ Removal  ~~~~~~~~~~~~*/
    
    /*
     * description: pops off the top of the stack
     * return: void
     * precondition: void
     * postcondition: if there is no frame to pop shutdown is called
     */
    public void closeFrame() {
        if (this.stack.isEmpty()) {
            new Shutdown(db);
        }
        this.stack.pop();

        frame.getContentPane().removeAll();
        frame.add(this.stack.peek());
        frame.revalidate();
        frame.pack();
        frame.repaint();
    }
    
	/*~~~~~~~~~~~~ Getters  ~~~~~~~~~~~~*/
    
    /*
     * description: getter
     * return: the top of stack
     * precondition: void
     * postcondition: nothing is changed
     */
	
	public JPanel getCurrentFrame() {
        return stack.peek();
    }
	
	//variable not to be saved upon shutdown
	private static JFrame frame;
	private Stack<JPanel> stack;
	private DashBoard db;
}
