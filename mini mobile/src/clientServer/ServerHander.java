package clientServer;

import java.awt.Font;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

public class ServerHander extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JScrollPane scrollPane;

	private static JButton btnConnection;
	public JTextField textField;
	private JTextArea textArea;

	private ServerSocket serverSocket;
	public Socket socket;

	private static JTextField txtConnectedWithNo;

	private JTextField textField_1;
	private static boolean firstTime = true;

	private JButton sounderButton;
	private static boolean sound = true;

	/**
	 * Create the panel.
	 */
	public ServerHander() {
		setLayout(new BorderLayout(0, 0));

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
		textField.setEditable(false);
		textField.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ForWritting t1 = new ForWritting(socket);
				t1.start();
			}
		});

		panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		btnConnection = new JButton("Connect");
		btnConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (firstTime) {
					btnConnection.setEnabled(false);
					firstTime = false;
					Amr2 amr2 = new Amr2();
					amr2.start();

				}
			}

		});
		btnConnection.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnConnection);

		txtConnectedWithNo = new JTextField();
		txtConnectedWithNo.setEditable(false);
		txtConnectedWithNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtConnectedWithNo.setText("Connected with : NO ONE");
		panel.add(txtConnectedWithNo);
		txtConnectedWithNo.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		panel.add(textField_1);
		textField_1.setColumns(10);

		sounderButton = new JButton("ON");
		sounderButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(sounderButton);
		sounderButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (sounderButton.getText().equals("ON")) {
					sounderButton.setText("OFF");
					sound = false;
				} else {
					sound = true;
					sounderButton.setText("ON");
				}
			}
		});

		scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		scrollPane.setViewportView(textArea);
	}

	private void problem(String string) {
		// TODO Auto-generated method stub
		textField.setEditable(false);
		btnConnection.setEnabled(true);
	}

	class Amr2 extends Thread {
		public Amr2() {
		}

		public void run() {
			int port = 1500;
			try {
				problem("Connecting....");
				serverSocket = new ServerSocket(port);
				socket = serverSocket.accept();
			} catch (IOException e) {
				problem("No Network Found");
			}

			txtConnectedWithNo.setText(socket.getInetAddress().getHostName());

			try {
				textField_1.setText(InetAddress.getLocalHost().toString());
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			ForReading t2 = new ForReading(socket);
			t2.start();
		}
	}

	/** One instance of this thread will run for each client */
	class ForWritting extends Thread {
		// the socket where to listen/talk
		Socket socket;
		ObjectOutputStream Soutput;

		ForWritting(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			try {
				Soutput = new ObjectOutputStream(socket.getOutputStream());
				Soutput.flush();
			} catch (IOException e) {
				problem("Problem Occurs!");
				return;
			}
			try {
				Soutput.writeObject(textField.getText());
				if (!textField.getText().equals("")) {
					textArea.setText(textField.getText() + "\n"
							+ textArea.getText());

				}
				textField.setText("");
				Soutput.flush();
			} catch (IOException e) {
				problem("Problem Occurs!");
				return;
			} finally {
				try {
					// Soutput.close();
				} catch (Exception e) {
				}
			}
		}
	}

	/** One instance of this thread will run for each client */
	class ForReading extends Thread {
		// the socket where to listen/talk
		Socket socket;
		ObjectInputStream Sinput;

		ForReading(Socket socket) {
			this.socket = socket;
		}

		public void run() {

			while (socket.isConnected()) {
				btnConnection.setEnabled(false);
				textField.setEditable(true);

				try {
					Sinput = new ObjectInputStream(socket.getInputStream());
				} catch (IOException e) {
					problem("making input stream");
					break;
				}

				try {
					String str = new String();
					str = (String) Sinput.readObject();
					if (!str.equals("") && !str.equals(null)) {
						if (sound)
							new PlaySound("maf.WAV", 1);
						textArea.setText("      " + str + "\n"
								+ textArea.getText());
					}
				} catch (IOException e) {
					problem("getting message");
					break;
				} catch (ClassNotFoundException o) {
				} finally {
					try {
						// Sinput.close();
					} catch (Exception e) {
						problem("Problem Occurs!");
					}
				}

			}
			btnConnection.setEnabled(true);
			textField.setEditable(false);
			problem("Connection Failed!");
		}
	}
}
