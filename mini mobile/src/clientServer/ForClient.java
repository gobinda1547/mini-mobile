package clientServer;

import java.awt.GridLayout;

import javax.swing.JFrame;

import clientServer.ClientHandler;

public class ForClient extends Thread {

	JFrame clientFrame;
	ClientHandler clientHandler;

	public ForClient() {
		System.out.println("cons client");
		clientFrame = new JFrame();
		clientHandler = new ClientHandler();

	}

	public void run() {

		int x = 570, y = 360;
		clientFrame = new JFrame();
		clientFrame.setTitle("client");
		clientFrame.setVisible(true);
		clientFrame.setSize(x, y);
		//clientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clientFrame.getContentPane().setLayout(new GridLayout(1, 1));
		clientFrame.setResizable(false);
		clientFrame.setLocationRelativeTo(null);
		clientFrame.getContentPane().add(clientHandler);

	}

}