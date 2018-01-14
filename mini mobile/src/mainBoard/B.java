package mainBoard;

import fileSearching.SearchWholeComputer;
import fileSearching.SearchingFileErListWithPanel;
import fio.FileIOForGame;
import gameGuliGuli.GuliGame;
import gameGuliGuli.Mine;
import gameGunFire.Ami;
import gameGunFire.GunFireGame;
import gamePacMan.LevelMaking;
import gamePacMan.PacMan;
import gameSnake.Snake;

import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

import playIngAudio.PlaySound;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

import clientServer.MainCS;

import java.awt.Color;

public class B extends JPanel implements KeyListener, MouseListener {

	public static boolean showIpAddress, showCommandPrompt, showNotePad,
			showShutDown, showReStart, showGuliGuliGame, showNormalScreen,
			showSnakeGame, showGunFireGame, searchingFileNeyaHoyeGece,
			showReadyForTakingTheSearchingFileName, passwordTryButFailed,
			showReadyToGetPasswordforUltaPalta, passwordNeyaSesforUltaPalta,
			showPacManGame, showHiberNet, showClientNetWork, showServerNetwork,
			showTaskManager, showTaskManager2, showDidxag, showDidxag2;
	public static String ipAddressString, searchingFileName,
			passwordforUltaPalta;
	public static int shutDownCounter, reStartCounter;

	private static GuliGame guliGame;
	private static Snake snake;
	private static GunFireGame gunFireGame;
	private static PacMan pacMan;
	private PlaySound playSound;

	public static int backGroundCounter = 0, totalBackGround = 10;
	private static BackGround[] backGrounds = new BackGround[totalBackGround];

	public void makeAllFalse() {

		// playSound = new PlaySound("maf.wav", 1);

		showIpAddress = false;
		showCommandPrompt = false;
		showNotePad = false;
		showShutDown = false;
		showReStart = false;
		showGuliGuliGame = false;
		showNormalScreen = false;
		showGunFireGame = false;
		showSnakeGame = false;
		showHiberNet = false;
		showClientNetWork = false;
		showServerNetwork = false;
		shutDownCounter = 0;
		reStartCounter = 0;
		showReadyForTakingTheSearchingFileName = false;
		searchingFileNeyaHoyeGece = false;
		searchingFileName = new String();
		showReadyToGetPasswordforUltaPalta = false;
		passwordNeyaSesforUltaPalta = false;
		passwordTryButFailed = false;
		showPacManGame = false;
		showTaskManager = false;
		showTaskManager2 = false;
		showDidxag = false;
		showDidxag2 = false;
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawRect(300, 10, 480, 400);
		g.drawRect(10, 10, 280, 400);

		if (showNormalScreen) {
			normalScreenShow(g);
		} else if (showIpAddress) {
			shutDownCounter++;
			g.drawString(String.valueOf(shutDownCounter / 100), 350, 200);
			ipAddressShow(g);
		} else if (showCommandPrompt) {
			backGrounds[1].drawBackGround(g);
			commandPromptShow(g);
		} else if (showNotePad) {
			notePadShow(g);
		} else if (showShutDown) {
			shutDownShow(g);
		} else if (showReStart) {
			reStartingShow(g);
		} else if (showGuliGuliGame) {
			guliguliGameKhelo(g);
		} else if (showSnakeGame) {
			snakeGameShow(g);
		} else if (showGunFireGame) {
			gunFireGameShow(g);
		} else if (showReadyForTakingTheSearchingFileName) {
			readyToTakeTheSearchingFileName(g);
		} else if (showReadyToGetPasswordforUltaPalta) {
			readyToGetUltaPaltaPassword(g);
		} else if (showPacManGame) {
			pacManGameShow(g);
		} else if (showHiberNet) {
			hibernetShow(g);
		} else if (showTaskManager) {
			taskManagerShow(g);
		} else if (showTaskManager2) {
			taskManagerShow2(g);
		} else if (showDidxag) {
			didxagShow(g);
		} else if (showDidxag2) {
			didxag2Show(g);
		}
		ghum(8);
		repaint();

	}

	private void didxag2Show(Graphics g) {
		// TODO Auto-generated method stub
		makeFont(g, 40);
		FontMetrics ff = g.getFontMetrics();

		int x = ff.stringWidth("Can't Show");
		x = 540 - x / 2;

		g.drawString("Can't Show", x, 200);

		makeFont(g, 40);
		ff = g.getFontMetrics();

		x = ff.stringWidth("Computer Properties");
		x = 540 - x / 2;

		g.drawString("Computer Properties", x, 300);

	}

	private void didxagShow(Graphics g) {
		// TODO Auto-generated method stub
		makeFont(g, 40);
		FontMetrics ff = g.getFontMetrics();

		int x = ff.stringWidth("Computer Properties");
		x = 540 - x / 2;

		g.drawString("Computer Properties", x, 200);
	}

	private void taskManagerShow2(Graphics g) {
		// TODO Auto-generated method stub
		makeFont(g, 40);
		FontMetrics ff = g.getFontMetrics();

		int x = ff.stringWidth("Can't Show");
		x = 540 - x / 2;

		g.drawString("Can't Show", x, 200);

		makeFont(g, 40);
		ff = g.getFontMetrics();

		x = ff.stringWidth("Task Manager");
		x = 540 - x / 2;

		g.drawString("Task Manager", x, 300);
	}

	private void taskManagerShow(Graphics g) {
		// TODO Auto-generated method stub
		makeFont(g, 40);
		FontMetrics ff = g.getFontMetrics();

		int x = ff.stringWidth("Task Manager");
		x = 540 - x / 2;

		g.drawString("Task Manager", x, 200);
	}

	private void hibernetShow(Graphics g) {
		// TODO Auto-generated method stub
		makeFont(g, 30);
		reStartCounter++;
		FontMetrics ff = g.getFontMetrics();

		int x = ff.stringWidth("Computer Will Hibernet");
		x = 540 - x / 2;
		g.drawString("Computer Will Hibernet", x, 70);

		x = ff.stringWidth("in");
		x = 540 - x / 2;
		g.drawString("in", x, 110);

		x = ff.stringWidth("6");
		x = 540 - x / 2;
		g.drawString("6", x, 160);

		x = ff.stringWidth("Seconds");
		x = 540 - x / 2;
		g.drawString("Seconds", x, 200);

		x = ff.stringWidth(String.valueOf(6 - (reStartCounter / 100)));
		x = 540 - x / 2;
		g.drawString(String.valueOf(6 - (reStartCounter / 100)), x, 280);
		if (reStartCounter / 100 > 5)
			System.exit(0);

	}

	private void pacManGameShow(Graphics g) {
		// TODO Auto-generated method stub
		pacMan.doAll(g);
	}

	private void readyToGetUltaPaltaPassword(Graphics g) {
		// TODO Auto-generated method stub

		makeFont(g, 50);
		FontMetrics ff = g.getFontMetrics();

		int len = passwordforUltaPalta.length();

		String passwordforUltaPaltaSub = new String();

		for (int i = 0; i < len; i++)
			passwordforUltaPaltaSub = passwordforUltaPaltaSub + new String("*");

		int x = ff.stringWidth(passwordforUltaPaltaSub);
		x = 540 - x / 2;

		g.drawString(passwordforUltaPaltaSub, x, 250);

		String s1 = new String();
		if (passwordTryButFailed)
			s1 = new String("Try Again");
		else
			s1 = new String("Type Password");
		x = ff.stringWidth(s1);
		x = 540 - x / 2;

		g.drawString(s1, x, 150);
	}

	private void readyToTakeTheSearchingFileName(Graphics g) {
		// TODO Auto-generated method stub

		makeFont(g, 50);
		FontMetrics ff = g.getFontMetrics();

		int x = ff.stringWidth(searchingFileName);
		x = 540 - x / 2;

		g.drawString(searchingFileName, x, 250);

		x = ff.stringWidth("Type Something");
		x = 540 - x / 2;

		g.drawString("Type Something", x, 150);

	}

	private void gunFireGameShow(Graphics g) {
		// TODO Auto-generated method stub

		gunFireGame.doAll(g);
	}

	private void snakeGameShow(Graphics g) {
		// TODO Auto-generated method stub
		snake.doAll(g);
	}

	private void normalScreenShow(Graphics g) {
		// TODO Auto-generated method stub
		g.drawString("gobindas", 540, 200);

	}

	private void guliguliGameKhelo(Graphics g) {
		// TODO Auto-generated method stub

		guliGame.drawAll(g);

	}

	private void reStartingShow(Graphics g) {
		// TODO Auto-generated method stub

		makeFont(g, 30);
		reStartCounter++;
		FontMetrics ff = g.getFontMetrics();

		int x = ff.stringWidth("Computer Will ReStarting");
		x = 540 - x / 2;
		g.drawString("Computer Will ReStarting", x, 70);

		x = ff.stringWidth("in");
		x = 540 - x / 2;
		g.drawString("in", x, 110);

		x = ff.stringWidth("6");
		x = 540 - x / 2;
		g.drawString("6", x, 160);

		x = ff.stringWidth("Seconds");
		x = 540 - x / 2;
		g.drawString("Seconds", x, 200);

		x = ff.stringWidth(String.valueOf(6 - (reStartCounter / 100)));
		x = 540 - x / 2;
		g.drawString(String.valueOf(6 - (reStartCounter / 100)), x, 280);
		if (reStartCounter / 100 > 5)
			System.exit(0);

	}

	private void shutDownShow(Graphics g) {
		// TODO Auto-generated method stub
		makeFont(g, 30);
		shutDownCounter++;
		FontMetrics ff = g.getFontMetrics();

		int x = ff.stringWidth("Computer Will Shutting");
		x = 540 - x / 2;
		g.drawString("Computer Will Shutting", x, 70);

		x = ff.stringWidth("Down in");
		x = 540 - x / 2;
		g.drawString("Down in", x, 110);

		x = ff.stringWidth("6");
		x = 540 - x / 2;
		g.drawString("6", x, 160);

		x = ff.stringWidth("Seconds");
		x = 540 - x / 2;
		g.drawString("Seconds", x, 200);

		x = ff.stringWidth(String.valueOf(6 - (shutDownCounter / 100)));
		x = 540 - x / 2;
		g.drawString(String.valueOf(6 - (shutDownCounter / 100)), x, 280);
		if (shutDownCounter / 100 > 5)
			System.exit(0);

	}

	private void notePadShow(Graphics g) {
		// TODO Auto-generated method stub
		makeFont(g, 50);
		FontMetrics ff = g.getFontMetrics();

		int x = ff.stringWidth("NotePad");
		x = 540 - x / 2;

		g.drawString("NotePad", x, 200);
	}

	private void commandPromptShow(Graphics g) {
		// TODO Auto-generated method stub
		makeFont(g, 50);
		FontMetrics ff = g.getFontMetrics();

		int x = ff.stringWidth("Command Prompt");
		x = 540 - x / 2;

		g.drawString("Command Prompt", x, 200);
	}

	private void ipAddressShow(Graphics g) {
		// TODO Auto-generated method stub

		makeFont(g, 50);
		FontMetrics ff = g.getFontMetrics();

		int x = ff.stringWidth("Your IP Address");
		x = 540 - x / 2;

		g.drawString("Your IP Address", x, 150);

		x = ff.stringWidth(ipAddressString);
		x = 540 - x / 2;

		g.drawString(ipAddressString, x, 250);

	}

	private void makeFont(Graphics g, int i) {
		// TODO Auto-generated method stub
		g.setFont(new Font("Arial", Font.BOLD + Font.PLAIN, i));

	}

	private void OperationShow(Graphics g) {
		// TODO Auto-generated method stub

	}

	public B() {
		setLayout(null);
		addKeyListener(this);
		addMouseListener(this);

		guliGame = new GuliGame();
		snake = new Snake();
		gunFireGame = new GunFireGame();
		pacMan = new PacMan();

		searchingFileName = new String();
		passwordforUltaPalta = new String();

		for (int i = 0; i < totalBackGround; i++)
			backGrounds[i] = new BackGround(i);
		backGroundCounter = 0;

		JButton guliGuliGameButton = new JButton("guliGame");
		guliGuliGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!FileIOForGame.levelFileAceKiNa()
						|| !FileIOForGame.scoreFileAceKiNa()) {
					FileIOForGame.makeDirectioryFolder();
					FileIOForGame.makeLevelFile();
					FileIOForGame.makeScoreFile();
				}
				makeAllFalse();
				showGuliGuliGame = true;
				guliGame = new GuliGame();
			}
		});
		guliGuliGameButton.addMouseListener(this);
		guliGuliGameButton.addKeyListener(this);
		guliGuliGameButton.setToolTipText("Play Guli Guli Game");
		guliGuliGameButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		guliGuliGameButton.setBounds(24, 365, 128, 35);
		add(guliGuliGameButton);

		JButton snakeGame = new JButton("snakeGame");
		snakeGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				snake = new Snake();
				if (!FileIOForGame.sapKhelarBestScoreFileAceKiNa()) {
					FileIOForGame.makeDirectioryFolder();
					FileIOForGame.makeSapKhelarBestScoreFile();
				}
				makeAllFalse();
				showSnakeGame = true;
			}
		});
		snakeGame.setToolTipText("Play Snake Game");
		snakeGame.addKeyListener(this);
		snakeGame.addMouseListener(this);
		snakeGame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		snakeGame.setBounds(24, 328, 128, 35);
		add(snakeGame);

		JButton GunFireGame = new JButton("gunFireGame");
		GunFireGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				gunFireGame = new GunFireGame();
				if (!FileIOForGame.gunFireKhelarBestScoreFileAceKiNa()) {
					FileIOForGame.makeDirectioryFolder();
					FileIOForGame.makeGunFireKhelarBestScoreFile();
				}
				makeAllFalse();
				showGunFireGame = true;

			}
		});
		GunFireGame.addKeyListener(this);
		GunFireGame.addMouseListener(this);
		GunFireGame.setToolTipText("Play Gun Fire Game");
		GunFireGame.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GunFireGame.setBounds(24, 291, 128, 35);
		add(GunFireGame);

		JButton pacManButton = new JButton("pacMan");
		pacManButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				pacMan = new PacMan();
				if (!FileIOForGame.pacManKhelarBestScoreFileAceKiNa()) {
					FileIOForGame.makeDirectioryFolder();
					FileIOForGame.makepacManKhelarBestScoreFile();
				}

				makeAllFalse();
				showPacManGame = true;
			}
		});
		pacManButton.addKeyListener(this);
		pacManButton.addMouseListener(this);
		pacManButton.setToolTipText("PLAY PACMAN GAME");
		pacManButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pacManButton.setBounds(24, 254, 128, 35);
		add(pacManButton);

		JButton lockpc = new JButton("Lock PC");
		lockpc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					Runtime.getRuntime()
							.exec("C:\\Windows\\System32\\rundll32.exe user32.dll,LockWorkStation");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		lockpc.setToolTipText("Lock The Computer");
		lockpc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lockpc.setBounds(156, 365, 120, 35);
		add(lockpc);

		JButton shutDown = new JButton("ShutDown");
		shutDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				makeAllFalse();
				showShutDown = true;
				Runtime runtime = Runtime.getRuntime();

				try {
					Process proc = runtime.exec("shutdown -s -t 10");
				} catch (IOException e) { // TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		shutDown.setToolTipText("ShutDown This Computer");
		shutDown.setFont(new Font("Tahoma", Font.PLAIN, 18));
		shutDown.setBounds(156, 328, 120, 35);
		add(shutDown);

		JButton reStartPc = new JButton("ReStart");
		reStartPc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				makeAllFalse();
				showReStart = true;
				Runtime runtime = Runtime.getRuntime();

				try {
					Process proc = runtime.exec("shutdown -r -t 10");
				} catch (IOException e) { // TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		reStartPc.setToolTipText("Re-Start This Computer");
		reStartPc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		reStartPc.setBounds(156, 291, 120, 35);
		add(reStartPc);

		JButton cancleShutdownButton = new JButton("Cancel All");
		cancleShutdownButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				makeAllFalse();
				showNormalScreen = true;
				Runtime runtime = Runtime.getRuntime();

				try {
					Process proc = runtime.exec("shutdown -a");
				} catch (IOException e) { // TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		cancleShutdownButton.setToolTipText("cancel Shutdown OR Restart");
		cancleShutdownButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cancleShutdownButton.setBounds(156, 254, 120, 35);
		add(cancleShutdownButton);

		JButton np = new JButton("notepad");
		np.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				makeAllFalse();
				showNotePad = true;
				String filePath = "C:/Windows/Notepad.exe";
				try {
					Process p = Runtime.getRuntime().exec(filePath);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		np.setToolTipText("Note Pad");
		np.setFont(new Font("Tahoma", Font.PLAIN, 18));
		np.setBounds(24, 217, 128, 35);
		add(np);

		JButton normalScreen = new JButton("Normal Screen");
		normalScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				makeAllFalse();
				showNormalScreen = true;
			}
		});
		normalScreen.setToolTipText("NorMally Screen Show");
		normalScreen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		normalScreen.setBounds(24, 44, 252, 35);
		add(normalScreen);

		JButton cp = new JButton("CMD");
		cp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				makeAllFalse();
				showCommandPrompt = true;
				try {
					Runtime.getRuntime().exec(
							new String[] { "cmd", "/k", "start", "cmd" });
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});
		cp.setToolTipText("Command Prompte");
		cp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cp.setBounds(24, 179, 128, 35);
		add(cp);

		JButton mineIpAddressShow = new JButton("mineIpAddressShow");
		mineIpAddressShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				InetAddress local;
				try {
					makeAllFalse();
					showIpAddress = true;
					local = InetAddress.getLocalHost();
					ipAddressString = local.getHostAddress();
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		mineIpAddressShow.setToolTipText("Mine Ip Address Show");
		mineIpAddressShow.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mineIpAddressShow.setBounds(24, 103, 128, 35);
		add(mineIpAddressShow);

		JButton SearchingAFile = new JButton("Search File");
		SearchingAFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				makeAllFalse();
				showReadyForTakingTheSearchingFileName = true;
			}
		});
		SearchingAFile.addKeyListener(this);
		SearchingAFile.addMouseListener(this);
		SearchingAFile.setToolTipText("SEARCHING A FILE");
		SearchingAFile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		SearchingAFile.setBounds(24, 141, 128, 35);
		add(SearchingAFile);

		JButton ultapalta = new JButton("Virus");
		ultapalta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				makeAllFalse();
				showReadyToGetPasswordforUltaPalta = true;
			}
		});
		ultapalta.addKeyListener(this);
		ultapalta.addMouseListener(this);
		ultapalta.setToolTipText("*UNKNOWN SOURCE*");
		ultapalta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ultapalta.setBounds(156, 141, 120, 35);
		add(ultapalta);

		JButton btnTaskmanager = new JButton("TaskMgr");
		btnTaskmanager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				makeAllFalse();

				String filePath = "C:/Windows/System32/taskmgr.exe";
				if (new File(filePath).exists()) {
					showTaskManager = true;
					try {
						Process p = Runtime.getRuntime().exec(filePath);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					showTaskManager2 = true;
				}

			}
		});
		btnTaskmanager.setToolTipText("Command Prompte");
		btnTaskmanager.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTaskmanager.setBounds(156, 179, 120, 35);
		add(btnTaskmanager);

		JButton btnScanVirus = new JButton("CHAT");
		btnScanVirus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainCS.doit();
				makeAllFalse();
				showNormalScreen=true;
			}
		});
		btnScanVirus.setToolTipText("Command Prompte");
		btnScanVirus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnScanVirus.setBounds(156, 103, 120, 35);
		add(btnScanVirus);

		JButton btnPcProperties = new JButton("Properties");
		btnPcProperties.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				makeAllFalse();

				String filePath = "C:/Windows/System32/dxdiag.exe";
				if (new File(filePath).exists()) {
					showDidxag = true;
					try {
						Process p = Runtime.getRuntime().exec(filePath);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					showDidxag2 = true;
				}

			}
		});
		btnPcProperties.setToolTipText("Command Prompte");
		btnPcProperties.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnPcProperties.setBounds(156, 217, 120, 35);
		add(btnPcProperties);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(24, 90, 252, 2);
		add(separator);

	}

	private void ghum(int i) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(i);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void forGuliGuliGameKeyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (GuliGame.optionStage) {
			if (e.getKeyCode() == KeyEvent.VK_UP)
				GuliGame.optionValue--;
			else if (e.getKeyCode() == KeyEvent.VK_DOWN)
				GuliGame.optionValue++;
			else if (e.getKeyCode() == KeyEvent.VK_ENTER) {

				if (GuliGame.optionValue == 0) {
					guliGame.newGame(1);
					GuliGame.life = 3;
					GuliGame.scoreValue = 0;
				} else if (GuliGame.optionValue == 1) {
					guliGame.newGame(FileIOForGame.konLevelEAce());
					GuliGame.life = 3;
					GuliGame.scoreValue = 0;
				} else if (GuliGame.optionValue == 2) {
					guliGame.makeAllFalse();
					GuliGame.bestGradesShow = true;
				} else if (GuliGame.optionValue == 3) {
					makeAllFalse();
					showNormalScreen = true;
				}

			}
		}

		else if (GuliGame.bestGradesShow) {
			if (GuliGame.enterChaparTimeHoice) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					guliGame.makeAllFalse();
					GuliGame.optionStage = true;
					GuliGame.levelSize = 10;
				}
			}
		}

		else if (GuliGame.playingStage) {
			if (e.getKeyCode() == KeyEvent.VK_D
					|| e.getKeyCode() == KeyEvent.VK_RIGHT)
				Mine.direction = 0;
			if (e.getKeyCode() == KeyEvent.VK_A
					|| e.getKeyCode() == KeyEvent.VK_LEFT)
				Mine.direction = 1;
			if (e.getKeyCode() == KeyEvent.VK_W
					|| e.getKeyCode() == KeyEvent.VK_UP)
				Mine.direction = 2;
			if (e.getKeyCode() == KeyEvent.VK_S
					|| e.getKeyCode() == KeyEvent.VK_DOWN)
				Mine.direction = 3;

			if (e.getKeyCode() == KeyEvent.VK_SPACE
					&& GuliGame.amrGuliMararJoggotaCounter > Mine.howQuickGuliCharbe) {
				GuliGame.amiGuliMarboKina = true;
				GuliGame.amrGuliMararJoggotaCounter = 0;
			}

		}
	}

	private void forGuliGuliGameKeyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (GuliGame.playingStage) {
			if (e.getKeyCode() == KeyEvent.VK_D
					|| e.getKeyCode() == KeyEvent.VK_A
					|| e.getKeyCode() == KeyEvent.VK_W
					|| e.getKeyCode() == KeyEvent.VK_S
					|| e.getKeyCode() == KeyEvent.VK_RIGHT
					|| e.getKeyCode() == KeyEvent.VK_LEFT
					|| e.getKeyCode() == KeyEvent.VK_UP
					|| e.getKeyCode() == KeyEvent.VK_DOWN)
				Mine.direction = 5;
			if (e.getKeyCode() == KeyEvent.VK_SPACE)
				GuliGame.amiGuliMarboKina = false;

		}
	}

	private void forGunFireGameKeyReleased(KeyEvent e) {
		if (GunFireGame.playingGame) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {

				Ami.left = false;
			}

			if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
				Ami.right = false;
			}

			if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
				// guli marbe
				GunFireGame.marboGuli = false;
			}

		}
	}

	private void forGunFireGameKeyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (GunFireGame.playingGame) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {

				Ami.left = true;
				Ami.right = false;
			}

			if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
				Ami.right = true;
				Ami.left = false;
			}

			if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
				// guli marbe
				GunFireGame.marboGuli = true;
			}

		} else if (GunFireGame.showOption) {
			if (e.getKeyCode() == KeyEvent.VK_UP)
				GunFireGame.optionValue--;
			else if (e.getKeyCode() == KeyEvent.VK_DOWN)
				GunFireGame.optionValue++;
			else if (e.getKeyCode() == KeyEvent.VK_ENTER) {

				if (GunFireGame.optionValue == 0) {
					gunFireGame.newGame();
					GunFireGame.scoreValue = 0;
				} else if (GunFireGame.optionValue == 1) {
					gunFireGame.makeAllFalse();
					GunFireGame.bestGradesShow = true;
					GunFireGame.gameTimer = 0;
					GunFireGame.levelSize = 10;
				} else if (GunFireGame.optionValue == 2) {
					// clear
					makeAllFalse();
					showNormalScreen = true;
				}

			}
		} else if (GunFireGame.bestGradesShow) {
			if (GunFireGame.enterChaparTimeHoice) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					GunFireGame.enterChaparTimeHoice = false;
					GunFireGame.gameTimer = 0;
					gunFireGame.makeAllFalse();
					GunFireGame.showOption = true;
				}
			}
		}
	}

	private void forShowReadyToTakeSearchingFilekeyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			searchingFileNeyaHoyeGece = true;
		} else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			if (searchingFileName.length() > 0)
				searchingFileName = searchingFileName.substring(0,
						searchingFileName.length() - 1);
		} else {
			searchingFileName += String.valueOf(e.getKeyChar());
		}

		if (searchingFileNeyaHoyeGece) {

			SearchingFileErListWithPanel jl2 = new SearchingFileErListWithPanel(
					new SearchWholeComputer(searchingFileName).matchingList);

			JFrame frame2 = new JFrame();
			frame2.getContentPane().setLayout(new GridLayout(1, 1));
			frame2.setTitle("JList Example");
			frame2.setSize(800, 450);
			frame2.setLocationRelativeTo(null);
			frame2.setVisible(true);

			frame2.getContentPane().add(jl2);
			searchingFileName = new String();
			searchingFileNeyaHoyeGece = false;
			makeAllFalse();
			showNormalScreen = true;
		}

	}

	private void forReadyToGetPasswordKeyPressed(KeyEvent e) {

		char ch = e.getKeyChar();
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			passwordNeyaSesforUltaPalta = true;
		} else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			if (passwordforUltaPalta.length() > 0)
				passwordforUltaPalta = passwordforUltaPalta.substring(0,
						passwordforUltaPalta.length() - 1);
		} else if (((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z'))
				&& passwordforUltaPalta.length() < 16) {
			passwordforUltaPalta += String.valueOf(e.getKeyChar());
		}

		if (passwordNeyaSesforUltaPalta) {

			passwordNeyaSesforUltaPalta = false;
			if (passwordforUltaPalta.equalsIgnoreCase("mynameisgobinda")) {
				passwordTryButFailed = false;
				SearchingFileErListWithPanel jl2 = new SearchingFileErListWithPanel(
						SearchingFileErListWithPanel.makeAFaltuArray());
				JFrame frame2 = new JFrame();
				frame2.getContentPane().setLayout(new GridLayout(1, 1));
				frame2.setTitle("JList Example");
				frame2.setSize(800, 450);
				frame2.setLocationRelativeTo(null);
				frame2.setVisible(true);
				frame2.getContentPane().add(jl2);
				makeAllFalse();
				showNormalScreen = true;
				passwordforUltaPalta = new String();
			} else {
				passwordforUltaPalta = new String();
				passwordTryButFailed = true;
			}

		}
	}

	private void forSnakeGameKeyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (Snake.playingGame) {
			int key = e.getKeyCode();
			if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A)
					&& (!Snake.rightDirection)) {

				snake.makeAllDirectionFalse();
				Snake.leftDirection = true;
			}

			if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D)
					&& (!Snake.leftDirection)) {
				snake.makeAllDirectionFalse();
				Snake.rightDirection = true;
			}

			if ((key == KeyEvent.VK_UP || key == KeyEvent.VK_W)
					&& (!Snake.downDirection)) {
				snake.makeAllDirectionFalse();
				Snake.upDirection = true;
			}

			if ((key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S)
					&& (!Snake.upDirection)) {
				snake.makeAllDirectionFalse();
				Snake.downDirection = true;
			}
		} else if (Snake.showOption) {
			if (e.getKeyCode() == KeyEvent.VK_UP)
				Snake.optionValue--;
			else if (e.getKeyCode() == KeyEvent.VK_DOWN)
				Snake.optionValue++;
			else if (e.getKeyCode() == KeyEvent.VK_ENTER) {

				if (Snake.optionValue == 0) {
					snake.newGame();
					Snake.scoreValue = 0;
				} else if (Snake.optionValue == 1) {
					snake.makeAllFalse();
					Snake.bestGradesShow = true;
					Snake.gameTimer = 0;
					Snake.levelSize = 10;
				} else if (Snake.optionValue == 2) {
					makeAllFalse();
					showNormalScreen = true;
				}

			}
		} else if (Snake.bestGradesShow) {
			if (Snake.enterChaparTimeHoice) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					Snake.enterChaparTimeHoice = false;
					Snake.gameTimer = 0;
					snake.makeAllFalse();
					Snake.showOption = true;
				}
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (showGuliGuliGame) {
			forGuliGuliGameKeyPressed(e);
		} else if (showSnakeGame) {
			forSnakeGameKeyPressed(e);
		} else if (showGunFireGame) {
			forGunFireGameKeyPressed(e);
		} else if (showReadyForTakingTheSearchingFileName) {
			forShowReadyToTakeSearchingFilekeyPressed(e);
		} else if (showReadyToGetPasswordforUltaPalta) {
			forReadyToGetPasswordKeyPressed(e);
		} else if (showPacManGame) {
			forPacManGameKeyPressed(e);
		}

	}

	public boolean moveMine(int a) {
		int pos = gamePacMan.Ami.pos;
		if (a == 0 && pos % 24 != 23 && !LevelMaking.vis[pos + 1]) {
			return true;
		} else if (a == 1 && pos % 24 != 0 && !LevelMaking.vis[pos - 1]) {
			return true;
		} else if (a == 2 && pos > 23 && !LevelMaking.vis[pos - 24]) {
			return true;
		} else if (a == 3 && pos < 408 && !LevelMaking.vis[pos + 24]) {
			return true;
		}
		return false;
	}

	private void forPacManGameKeyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (PacMan.playingGame) {
			int key = e.getKeyCode();
			if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A)
					&& moveMine(1)) {

				pacMan.makeAllDirectionFalse();
				PacMan.leftDirection = true;
			}

			if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D)
					&& moveMine(0)) {
				pacMan.makeAllDirectionFalse();
				PacMan.rightDirection = true;
			}

			if ((key == KeyEvent.VK_UP || key == KeyEvent.VK_W) && moveMine(2)) {
				pacMan.makeAllDirectionFalse();
				PacMan.upDirection = true;
			}

			if ((key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S)
					&& moveMine(3)) {
				pacMan.makeAllDirectionFalse();
				PacMan.downDirection = true;
			}
		} else if (PacMan.showOption) {
			if (e.getKeyCode() == KeyEvent.VK_UP)
				PacMan.optionValue--;
			else if (e.getKeyCode() == KeyEvent.VK_DOWN)
				PacMan.optionValue++;
			else if (e.getKeyCode() == KeyEvent.VK_ENTER) {

				if (PacMan.optionValue == 0) {
					pacMan.newGame();
					PacMan.scoreValue = 0;
				} else if (PacMan.optionValue == 1) {
					pacMan.makeAllFalse();
					PacMan.bestGradesShow = true;
					PacMan.gameTimer = 0;
					PacMan.levelSize = 10;
				} else if (PacMan.optionValue == 2) {
					makeAllFalse();
					showNormalScreen = true;
				}

			}
		} else if (PacMan.bestGradesShow) {
			if (PacMan.enterChaparTimeHoice) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					PacMan.enterChaparTimeHoice = false;
					PacMan.gameTimer = 0;
					pacMan.makeAllFalse();
					PacMan.showOption = true;
				}
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (showGuliGuliGame) {
			forGuliGuliGameKeyReleased(e);
		} else if (showGunFireGame) {
			forGunFireGameKeyReleased(e);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		if (showGuliGuliGame) {
			if (GuliGame.playingStage) {
				if (e.getButton() == 1
						&& GuliGame.amrGuliMararJoggotaCounter > Mine.howQuickGuliCharbe) {
					GuliGame.amiGuliMarboKina = true;
					GuliGame.amrGuliMararJoggotaCounter = 0;
				}

			}

		}

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
