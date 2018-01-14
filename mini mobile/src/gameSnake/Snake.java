package gameSnake;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;

import fio.FileIOForGame;

public class Snake {

	private final int DOT_SIZE = 10;
	private final int x[] = new int[900];
	private final int y[] = new int[900];
	public static int dots, apple_x, apple_y, optionValue, gameTimer,
			scoreValue, levelSize;
	public static boolean leftDirection, rightDirection, upDirection,
			downDirection, showGameOver, showOption, playingGame,
			bestGradesShow, enterChaparTimeHoice;

	public Snake() {
		optionValue = 0;
		gameTimer = 0;
		scoreValue = 0;
		enterChaparTimeHoice = false;
		makeAllFalse();
		showOption = true;
	}

	public void makeAllFalse() {
		showGameOver = false;
		showOption = false;
		playingGame = false;
		bestGradesShow = false;
	}

	public void makeAllDirectionFalse() {
		// TODO Auto-generated method stub
		leftDirection = false;
		rightDirection = false;
		upDirection = false;
		downDirection = false;
	}

	public void newGame() {
		makeAllDirectionFalse();
		rightDirection = true;
		makeAllFalse();
		playingGame = true;
		gameTimer = 0;
		dots = 3;
		for (int z = 0; z < dots; z++) {
			x[z] = 550 - z * 10;
			y[z] = 50;
		}
		locateApple();
	}

	public void doAll(Graphics g) {

		gameBoardDesign(g);
		if (showOption) {
			optionShow(g);
		} else if (playingGame) {
			playGame(g);
		} else if (showGameOver) {
			gameOverShow(g);
		} else if (bestGradesShow) {
			showBestGrades(g);
		}

	}

	private void showBestGrades(Graphics g) {
		// TODO Auto-generated method stub
		gameTimer++;
		int gx, gy, time = 120;

		if (gameTimer % 120 == 0)
			levelSize = 10;
		if (gameTimer % 3 == 0)
			levelSize++;

		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD + Font.PLAIN, levelSize));
		FontMetrics ff = g.getFontMetrics();

		if (gameTimer > time) {
			gameTimer = 0;
			enterChaparTimeHoice = true;
		}

		gx = ff.stringWidth("TOP SCORE");
		gy = ff.getAscent();

		gx = 540 - gx / 2;
		gy = 200 + gy / 2 - 100;
		g.drawString("TOP SCORE", gx, gy);

		int bb = FileIOForGame.sapKhelarBestScore();

		gx = ff.stringWidth(String.valueOf(bb));
		gy = ff.getAscent();

		gx = 540 - gx / 2;
		gy = 200 + gy / 2 - 100;

		g.drawString(String.valueOf(bb), gx, gy + 50);

	}

	private void gameBoardDesign(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillRect(300, 10, 480, 400);

		g.setColor(Color.WHITE);
		g.fillRect(310, 20, 460, 350);

	}

	private void gameOverShow(Graphics g) {
		// TODO Auto-generated method stub

		gameTimer++;
		drawProperties(g);
		int gx, gy, time = 300;

		if (gameTimer % 60 == 0)
			levelSize = 10;
		if (gameTimer % 2 == 0 || gameTimer % 5 == 0)
			levelSize++;

		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD + Font.PLAIN, levelSize));
		FontMetrics ff = g.getFontMetrics();

		if (gameTimer > time) {
			makeAllFalse();
			showOption = true;
			return;
		}
		if (gameTimer < 120) {

			gx = ff.stringWidth("Game Over!");
			gy = ff.getAscent();

			gx = 540 - gx / 2;
			gy = 200 + gy / 2 - 100;
			g.drawString("Game Over!", gx, gy);
		}

		else {

			gx = ff.stringWidth("Your Score:");
			gy = ff.getAscent();

			gx = 540 - gx / 2;
			gy = 200 + gy / 2 - 100;
			g.drawString("Your Score:", gx, gy);

			gx = ff.stringWidth(String.valueOf(scoreValue));
			gy = ff.getAscent();

			gx = 540 - gx / 2;
			gy = 200 + gy / 2 - 100;

			g.drawString(String.valueOf(scoreValue), gx, gy + 50);
		}

	}

	private void drawProperties(Graphics g) {
		// TODO Auto-generated method stub
		if (showOption) {
			String ss = new String("PLAY SNAKE GAME");

			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD + Font.PLAIN, 30));
			FontMetrics ff = g.getFontMetrics();

			int gx, gy;
			gx = 540 - ff.stringWidth(ss) / 2;
			gy = ff.getAscent();

			g.drawString(ss, gx, 425 - gy);
		} else {
			String ss = new String();
			if (gameTimer / 100 < 10)
				ss = new String("0" + String.valueOf(gameTimer / 100));
			else
				ss = String.valueOf(gameTimer / 100);

			g.drawString(ss, 753, 30);

			g.setColor(Color.BLACK);
			String pai = new String("  Score: " + String.valueOf(scoreValue));
			int gx, gy;

			g.setFont(new Font("Arial", Font.BOLD + Font.PLAIN, 30));
			FontMetrics ff = g.getFontMetrics();

			gx = ff.stringWidth(pai);
			gy = ff.getAscent();

			gx = 540 - gx / 2;

			g.drawString(pai, gx, 425 - gy);
		}
	}

	private void playGame(Graphics g) {
		// TODO Auto-generated method stub
		gameTimer++;
		drawProperties(g);
		doDrawing(g);
		checkApple();
		checkCollision();
		move();
	}

	private void optionShow(Graphics g) {
		// TODO Auto-generated method stub
		drawProperties(g);
		String[] strings = { "NewGame", "Best Grades", "Exit" };
		int val = 0, gy_ext = 100, gx, gy, optionErSize = 20;
		g.setFont(new Font("Arial", Font.BOLD + Font.PLAIN, optionErSize));
		FontMetrics ff = g.getFontMetrics();

		if (optionValue == -1)
			optionValue = 2;
		else if (optionValue == 3)
			optionValue = 0;

		while (val < 3) {

			gx = ff.stringWidth(strings[val]);
			gy = ff.getAscent();

			gx = 540 - gx / 2;
			gy = gy / 2 + gy_ext;

			if (val == optionValue)
				g.setColor(Color.RED);
			else
				g.setColor(Color.BLUE);

			g.drawString(strings[val], gx, gy);

			gy_ext += 50;

			val++;
		}
	}

	private void doDrawing(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(apple_x, apple_y, DOT_SIZE, DOT_SIZE);

		for (int z = 0; z < dots; z++) {
			if (z == 0) {
				g.setColor(Color.blue);
				g.drawRect(x[z], y[z], DOT_SIZE, DOT_SIZE);
			} else {
				g.setColor(Color.BLACK);
				g.drawRect(x[z], y[z], DOT_SIZE, DOT_SIZE);
			}
		}

	}

	private void checkApple() {

		if ((x[0] == apple_x) && (y[0] == apple_y)) {
			dots++;
			scoreValue++;
			locateApple();
		}
	}

	private void move() {

		if (gameTimer % 10 != 0)
			return;

		int moving = 10;
		for (int z = dots; z > 0; z--) {
			x[z] = x[(z - 1)];
			y[z] = y[(z - 1)];
		}

		if (leftDirection) {
			x[0] -= moving;
		}

		if (rightDirection) {
			x[0] += moving;
		}

		if (upDirection) {
			y[0] -= moving;
		}

		if (downDirection) {
			y[0] += moving;
		}
	}

	private void checkCollision() {

		boolean ans = true;
		for (int z = dots; z > 0; z--) {

			if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
				ans = false;
			}
		}

		if (y[0] >= 370) {
			ans = false;
		}

		if (y[0] <= 10) {
			ans = false;
		}

		if (x[0] >= 770) {
			ans = false;
		}

		if (x[0] <= 300) {
			ans = false;
		}

		if (!ans) {
			makeAllFalse();
			showGameOver = true;
			gameTimer = 0;
			if (FileIOForGame.sapKhelarBestScore() < scoreValue) {
				FileIOForGame.sapKhelarScoreMucheAddKoro(String.valueOf(scoreValue));
			}
		}

	}

	private void locateApple() {
		Random random = new Random();

		apple_x = random.nextInt(77);
		while (apple_x < 31 || 77 <= apple_x)
			apple_x = random.nextInt(770);
		apple_x *= 10;
		apple_y = random.nextInt(37);
		while (apple_y < 2 || 37 <= apple_y)
			apple_y = random.nextInt(37);
		apple_y *= 10;
		boolean ans = false;
		for (int i = 0; i < dots; i++) {
			if (x[i] == apple_x && y[i] == apple_y) {
				ans = true;
				break;
			}
		}
		if (ans) {
			locateApple();
		}
	}
}
