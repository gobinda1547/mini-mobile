package forRunning;

import java.awt.GridLayout;

import javax.swing.JFrame;

import mainBoard.B;

public class Runthis {

	public static int lenx = 800, leny = 450;
	public static B b = new B();
	private static JFrame mainFrame;

	public static void main(String[] args) {

		mainFrame = new JFrame();
		mainFrame.setLayout(new GridLayout(1, 1));
		mainFrame.setSize(lenx, leny);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.add(b);

	}

}
