package gamePacMan;

import fio.FileIOForGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PacMan extends JPanel {

	public static Ami mine = new Ami();
	public static LevelMaking levelMaking = new LevelMaking();
	public static Oppo[] oppos = new Oppo[3];

	public static boolean showGameOver, showOption, playingGame,
			bestGradesShow, enterChaparTimeHoice, marboGuli;

	public static int size = 20, optionValue, gameTimer, scoreValue,
			amrMovingCounter, amrMovingValue = 10, levelSize = 10,
			levelValue = 1, totalOpponents = 1;

	public static boolean leftDirection, rightDirection, upDirection,
			downDirection, showStarting;

	public void makeAllDirectionFalse() {
		leftDirection = false;
		rightDirection = false;
		upDirection = false;
		downDirection = false;
	}

	public void makeAllFalse() {
		showGameOver = false;
		showOption = false;
		playingGame = false;
		bestGradesShow = false;
		showStarting = false;

	}

	public PacMan() {

		for (int i = 0; i < totalOpponents; i++)
			oppos[i] = new Oppo();

		optionValue = 0;
		gameTimer = 0;
		scoreValue = 0;
		enterChaparTimeHoice = false;
		makeAllDirectionFalse();
		makeAllFalse();
		showOption = true;
		mine = new Ami();
		levelMaking = new LevelMaking();
		amrMovingCounter = 0;
		// ooiponents er jonn0
		levelSize = 10;
	}

	public void newGame() {
		makeAllDirectionFalse();
		makeAllFalse();
		showStarting = true;
		gameTimer = 0;
		mine = new Ami();
		levelMaking = new LevelMaking(levelValue);
		for (int i = 0; i < totalOpponents; i++)
			oppos[i] = new Oppo(LevelMaking.para);

		amrMovingCounter = 0;
		enterChaparTimeHoice = false;
		marboGuli = false;
		levelSize = 10;
	}

	public void doAll(Graphics g) {

		gameBoardBackgroundDesign(g);
		if (showOption) {
			optionShow(g);
		} else if (playingGame) {
			playGame(g);
		} else if (showGameOver) {
			gameOverShow(g);
		} else if (bestGradesShow) {
			showBestGrades(g);
		} else if (showStarting) {
			startingShow(g);
		}

	}

	private void playGame(Graphics g) {
		gameTimer++;
		doAllDrawing(g);
		if (gameOverHobeKina()) {
			doGameOverKaj();
		}
		if (levelChangeHobeKina()) {
			makeAllFalse();
			showStarting = true;
			levelValue++;
			gameTimer = 0;
			mine = new Ami();
			levelMaking = new LevelMaking(levelValue);
			for (int i = 0; i < totalOpponents; i++)
				oppos[i] = new Oppo(LevelMaking.para);
		}
		amiMoveKorboKina();
		if (notunOponentMakeKorbeKina())
			makeNotunOponent();
		changeOponentsErPosition();

	}

	private void changeOponentsErPosition() {
		// TODO Auto-generated method stub
		for (int i = 0; i < totalOpponents; i++) {
			if (oppos[i].vis) {
				oppos[i].changePosition();
			}
		}
	}

	private boolean notunOponentMakeKorbeKina() {
		// TODO Auto-generated method stub

		for (int i = 0; i < totalOpponents; i++) {
			if (!oppos[i].vis) {
				return true;
			}
		}
		return false;
	}

	private void makeNotunOponent() {
		// TODO Auto-generated method stub
		for (int i = 0; i < totalOpponents; i++) {
			if (!oppos[i].vis) {
				oppos[i] = new Oppo(LevelMaking.para);
			}
		}
	}

	private void amiMoveKorboKina() {
		// TODO Auto-generated method stub

		amrMovingCounter++;
		if (amrMovingCounter > amrMovingValue) {
			amrMovingCounter = 0;
			if (rightDirection)
				mine.moveMine(0);
			else if (leftDirection)
				mine.moveMine(1);
			else if (upDirection)
				mine.moveMine(2);
			else if (downDirection)
				mine.moveMine(3);
		}
	}

	private void doAllDrawing(Graphics g) {
		// TODO Auto-generated method stub
		drawGamebox(g);
		drawProperties(g);
		mine.drawMine(g);
		oponentsDrawing(g);
		levelDesigning(g);
	}

	private void levelDesigning(Graphics g) {
		// TODO Auto-generated method stub
		levelMaking.drawLevel(g);
	}

	private void oponentsDrawing(Graphics g) {
		// TODO Auto-generated method stub
		for (int i = 0; i < totalOpponents; i++)
			oppos[i].drawOpponents(g);
	}

	private boolean levelChangeHobeKina() {
		int counter = 0;
		for (int i = 0; i < 432; i++)
			if (LevelMaking.value[i])
				counter++;

		if (counter == 432)
			return true;
		else
			return false;

	}

	private boolean gameOverHobeKina() {
		if (Oppo.gameOver)
			return true;

		boolean ans = false;
		for (int i = 0; i < totalOpponents; i++) {
			if (oppos[i].vis) {
				if (Ami.pos == oppos[i].pos) {
					ans = true;
				}
			}
		}
		return ans;

	}

	private void doGameOverKaj() {
		makeAllFalse();
		showGameOver = true;
		gameTimer = 0;
		if (FileIOForGame.pacManKhelarBestScore() < scoreValue) {
			FileIOForGame.pacManKhelarScoreMucheAddKoro(String
					.valueOf(scoreValue));
		}
	}

	private void drawGamebox(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		// g.fillRect(435, 20, 225, 345);
		g.drawRect(300, 10, 480, 360);
	}

	private void showBestGrades(Graphics g) {
		// TODO Auto-generated method stub
		gameTimer++;
		int gx, gy, time = 120;

		if (gameTimer % 120 == 0)
			levelSize = 10;
		if (gameTimer % 3 == 0)
			levelSize++;

		g.setColor(Color.WHITE);
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

		int bb = FileIOForGame.pacManKhelarBestScore();

		gx = ff.stringWidth(String.valueOf(bb));
		gy = ff.getAscent();

		gx = 540 - gx / 2;
		gy = 200 + gy / 2 - 100;

		g.drawString(String.valueOf(bb), gx, gy + 50);

	}

	private void gameBoardBackgroundDesign(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillRect(300, 10, 480, 400);

		g.setColor(Color.BLACK);
		g.fillRect(300, 10, 480, 360);

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

		g.setColor(Color.WHITE);
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
			String ss = new String("PLAY GUN FIRE GAME");

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

	private void startingShow(Graphics g) {
		// TODO Auto-generated method stub

		gameTimer++;
		drawProperties(g);
		int gx, gy, time = 300;

		if (gameTimer % 60 == 0)
			levelSize = 10;
		if (gameTimer % 2 == 0 || gameTimer % 5 == 0)
			levelSize++;

		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD + Font.PLAIN, levelSize));
		FontMetrics ff = g.getFontMetrics();

		if (gameTimer > time) {
			gameTimer = 0;
			makeAllFalse();
			playingGame = true;
			return;
		}
		if (gameTimer < 60) {

			gx = ff.stringWidth("Level: " + String.valueOf(levelValue));
			gy = ff.getAscent();

			gx = 540 - gx / 2;
			gy = 200 + gy / 2 - 100;
			g.drawString("Level: " + String.valueOf(levelValue), gx, gy);
		}

		else {

			if (gameTimer / 60 == 1) {
				gx = ff.stringWidth("Starts");
				gy = ff.getAscent();

				gx = 540 - gx / 2;
				gy = 200 + gy / 2 - 100;
				g.drawString("Starts", gx, gy);
			} else {
				gx = ff.stringWidth(String.valueOf(5 - gameTimer / 60));
				gy = ff.getAscent();

				gx = 540 - gx / 2;
				gy = 200 + gy / 2 - 100;

				g.drawString(String.valueOf(5 - gameTimer / 60), gx, gy);
			}
		}

	}

}