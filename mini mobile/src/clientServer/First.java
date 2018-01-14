package clientServer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class First extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField serverIp;
	public static JTextField clientIp;

	private static ForClient fc;
	private static ForServer fs;

	public First() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 404);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 308, 344);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblServer = new JLabel("SERVER");
		lblServer.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblServer.setHorizontalAlignment(SwingConstants.CENTER);
		lblServer.setBounds(10, 11, 288, 34);
		panel.add(lblServer);

		serverIp = new JTextField();
		serverIp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		serverIp.setText("127.0.0.1");
		serverIp.setHorizontalAlignment(SwingConstants.CENTER);
		serverIp.setColumns(10);
		serverIp.setBounds(75, 70, 161, 34);
		serverIp.setEditable(false);
		panel.add(serverIp);

		JButton btnStart = new JButton("MINE");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				serverIp.setEditable(true);
				try {
					serverIp.setText(InetAddress.getLocalHost()
							.getHostAddress());
				} catch (UnknownHostException e1) {
				}
			}
		});
		btnStart.setBounds(112, 128, 89, 23);
		panel.add(btnStart);

		JButton btnNewButton = new JButton("START");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				fs = new ForServer();
				fs.start();
				MainCS.frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(75, 182, 161, 34);
		panel.add(btnNewButton);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(112, 248, 89, 23);
		panel.add(btnCancel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(338, 11, 308, 344);
		contentPane.add(panel_1);

		JLabel lblClient = new JLabel("CLIENT");
		lblClient.setHorizontalAlignment(SwingConstants.CENTER);
		lblClient.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblClient.setBounds(10, 11, 288, 34);
		panel_1.add(lblClient);

		clientIp = new JTextField();
		clientIp.setText("127.0.0.1");
		clientIp.setHorizontalAlignment(SwingConstants.CENTER);
		clientIp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		clientIp.setColumns(10);
		clientIp.setBounds(75, 70, 161, 34);
		clientIp.setEditable(false);
		panel_1.add(clientIp);

		JButton button = new JButton("NEW");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientIp.setEditable(true);
			}
		});
		button.setBounds(112, 128, 89, 23);
		panel_1.add(button);

		JButton button_1 = new JButton("START");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				fc = new ForClient();
				fc.start();

				MainCS.frame.setVisible(false);

			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_1.setBounds(75, 182, 161, 34);
		panel_1.add(button_1);

		JButton button_2 = new JButton("CANCEL");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		button_2.setBounds(112, 248, 89, 23);
		panel_1.add(button_2);
	}
}
