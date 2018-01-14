package gameGunFire;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import fio.FileIOForGame;

public class GunFireGame {

	public static int DOT_SIZE = 15, totalx = 15, totaly = 40,
			pointsPerbox = 10;

	public static BoxManager boxManager = new BoxManager();
	public static Ami mine = new Ami();
	public static AmrGuliManager amrGuliManager = new AmrGuliManager();

	public static int optionValue, gameTimer, scoreValue, levelSize,
			amrMovingCounter = 0, amrMovingValue = 2,
			whichLevelecollusion = 21, notunLayerMakeKorarCounter,
			notunLayerMakeKorarValue = 50, guliMararCounter = 0,
			guliMaraValue = 5;

	public static boolean showGameOver, showOption, playingGame,
			bestGradesShow, enterChaparTimeHoice, marboGuli;

	public GunFireGame() {
		optionValue = 0;
		gameTimer = 0;
		scoreValue = 0;
		enterChaparTimeHoice = false;
		makeAllFalse();
		showOption = true;
		boxManager = new BoxManager();
		amrGuliManager = new AmrGuliManager();
		mine = new Ami();
		amrMovingCounter = 0;
		notunLayerMakeKorarCounter = 0;
		guliMararCounter = 0;
	}

	public void newGame() {
		makeAllFalse();
		playingGame = true;
		gameTimer = 0;
		boxManager = new BoxManager();
		amrGuliManager = new AmrGuliManager();
		mine = new Ami();
		amrMovingCounter = 0;
		notunLayerMakeKorarCounter = 0;
		guliMararCounter = 0;
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
		}

	}

	private void playGame(Graphics g) {
		gameTimer++;
		doAllDrawing(g);
		amiMoveKorboKina();
		if (notunLayerMakeKorboKina()) {
			boxManager.makeOneNewLayer();
		}
		if (amiNotunGuliMakeKarboKina()) {
			amrGuliManager.makeOneNewGuli();
		}
		amrGuliMoveKorbe();
		guliAndBoxCollusion();
		gameOverHobeKina();
	}

	private void guliAndBoxCollusion() {
		// TODO Auto-generated method stub

		for (int i = 0; i < amrGuliManager.totalGuli; i++) {
			if (amrGuliManager.amrGuli[i].vis) {
				int p = (amrGuliManager.amrGuli[i].y - 20) / DOT_SIZE;
				int q = (amrGuliManager.amrGuli[i].x - 435) / DOT_SIZE;

				if (boxManager.boxs[p][q].visibility) {
					boxManager.boxs[p][q].visibility = false;
					amrGuliManager.amrGuli[i].vis = false;
					scoreValue += pointsPerbox;
				}

			}
		}

	}

	private void amrGuliMoveKorbe() {
		// TODO Auto-generated method stub
		amrGuliManager.moveAmrGulis();
	}

	private boolean amiNotunGuliMakeKarboKina() {
		// TODO Auto-generated method stub
		guliMararCounter++;
		if (marboGuli && guliMararCounter > guliMaraValue) {
			guliMararCounter = 0;
			// marboGuli = false;
			return true;
		}
		return false;
	}

	private boolean notunLayerMakeKorboKina() {
		// TODO Auto-generated method stub

		notunLayerMakeKorarCounter++;
		if (notunLayerMakeKorarCounter > notunLayerMakeKorarValue) {
			notunLayerMakeKorarCounter = 0;
			return true;
		}
		return false;
	}

	private void amiMoveKorboKina() {
		// TODO Auto-generated method stub

		amrMovingCounter++;
		if (amrMovingCounter > amrMovingValue) {
			amrMovingCounter = 0;
			mine.moveMine();
		}
	}

	private void doAllDrawing(Graphics g) {
		// TODO Auto-generated method stub
		drawGamebox(g);
		drawProperties(g);
		mine.drawMine(g);
		boxManager.drawBoxs(g);
		amrGuliManager.drawAmrGulis(g);
	}

	private void gameOverHobeKina() {
		boolean ans = true;

		for (int i = 0; i < totalx; i++) {
			if (boxManager.boxs[whichLevelecollusion][i].visibility)
				ans = false;
		}
		if (!ans) {
			makeAllFalse();
			showGameOver = true;
			gameTimer = 0;
			if (FileIOForGame.gunFireKhelarBestScore() < scoreValue) {
				FileIOForGame.gunFireKhelarScoreMucheAddKoro(String
						.valueOf(scoreValue));
			}
		}

	}

	public void makeAllFalse() {
		showGameOver = false;
		showOption = false;
		playingGame = false;
		bestGradesShow = false;
	}

	private void drawGamebox(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		g.fillRect(435, 20, 225, 345);
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

		int bb = FileIOForGame.gunFireKhelarBestScore();

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
		g.fillRect(310, 20, 460, 345);

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

}
