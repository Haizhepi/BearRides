package controller;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.Shutdown;

public class PanelController {

	public PanelController() {
		frame = new JFrame("BearRides");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setVisible(true);

		this.stack = new Stack<JPanel>();
	}

	public void changeFrame(JPanel newFrame) {
		this.stack.push(newFrame);

		frame.getContentPane().removeAll();
		frame.add(newFrame);
		frame.revalidate();
		frame.pack();
		frame.repaint();
	}

	public void closeFrame() {
		if (this.stack.isEmpty()) {
			new Shutdown();
		}
		this.stack.pop();

		frame.getContentPane().removeAll();
		frame.add(this.stack.peek());
		frame.revalidate();
		frame.repaint();
	}

	public JPanel getCurrentFrame() {
		return stack.peek();
	}

	private static JFrame frame;
	private Stack<JPanel> stack;
}
