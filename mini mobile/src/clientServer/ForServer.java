package clientServer;

import java.awt.GridLayout;

import javax.swing.JFrame;

import clientServer.ServerHander;

public class ForServer extends Thread {

	public static JFrame serverFrame;
	ServerHander serverHander;

	public ForServer() {
		System.out.println("cons server");
		serverFrame = new JFrame();
		serverHander = new ServerHander();

	}

	public void run() {

		int x = 570, y = 360;
		serverFrame = new JFrame();
		serverFrame.setTitle("server");
		serverFrame.setVisible(true);
		serverFrame.setSize(x, y);
		//serverFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		serverFrame.getContentPane().setLayout(new GridLayout(1, 1));
		serverFrame.setResizable(false);
		serverFrame.setLocationRelativeTo(null);
		serverFrame.getContentPane().add(serverHander);

	}

}