package clientServer;

import java.awt.EventQueue;

public class MainCS {

	public static First frame;

	public static void doit() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new First();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

}
