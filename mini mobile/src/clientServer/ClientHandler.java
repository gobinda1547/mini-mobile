package clientServer;

import java.awt.Font;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

public class ClientHandler extends JPanel {

	private static final long serialVersionUID = 1L;
	public Socket socket;
	private JTextField textField;
	private JPanel panel;
	private JButton btnConnect;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JTextField txtConnectedWithNo;
	private JTextField textField_1;
	private JButton sounderButton;
	private static boolean sound = true;

	public ClientHandler() {

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

		btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnConnect.setEnabled(false);
				Amr1 amr1 = new Amr1();
				amr1.start();

			}
		});
		btnConnect.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnConnect);

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
		textField.setEditable(false);
		btnConnect.setEnabled(true);
	}

	class Amr1 extends Thread {

		public Amr1() {

		}

		public void run() {
			int port = 1500;
			problem("Connecting....");
			try {
				socket = new Socket(First.clientIp.getText(), port);
				txtConnectedWithNo.setText(socket.getInetAddress()
						.getHostName());
				textField_1.setText(InetAddress.getLocalHost().toString());
				ForReading t2 = new ForReading(socket);
				t2.start();
			} catch (Exception e) {
				problem("No Network Found!");
				return;
			}
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
			} catch (IOException e) {
				problem("creating output steradfm");
				return;
			}

			String test = new String();
			test = textField.getText();
			try {
				Soutput.writeObject(test);
				Soutput.flush();
				if (!textField.getText().equals("")) {
					textArea.setText(textField.getText() + "\n"
							+ textArea.getText());
				}
				textField.setText("");
			} catch (IOException e) {
				problem("sending messbgae");
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
				btnConnect.setEnabled(false);
				textField.setEditable(true);

				try {
					Sinput = new ObjectInputStream(socket.getInputStream());
				} catch (IOException e) {
					problem("creatinginput stream");
					break;
				}

				String response;
				try {
					response = (String) Sinput.readObject();
					System.out.println("c:" + response + ".");
					if (!response.equals("") && !response.equals(null)) {
						textArea.setText("      " + response + "\n"
								+ textArea.getText());
						if (sound)
							new PlaySound("maf.WAV", 1);
					}

				} catch (Exception e) {
					problem("getting message");
					break;
				}
				try {
					// Sinput.close();
				} catch (Exception e) {
				}
			}
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			btnConnect.setEnabled(true);
			textField.setEditable(false);
			problem("Connection Failed!");
		}
	}

}
