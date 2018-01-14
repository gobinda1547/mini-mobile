package gameGuliGuli;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.util.Random;

import fio.FileIOForGame;

public class GuliGame {

	public static boolean optionStage, levelShowStage, playingStage,
			gameOverStage, amiGuliMarboKina, enterChaparTimeHoice;

	public static int optionValue = 0, level = 1, gameTimer, levelSize,
			amrGuliMararJoggotaCounter = 0, life = 3, scoreValue = 0,
			pointsPerOponents = 10, showVal, khelarTime = 6000,
			ageiOponentsMakingBondhoKoro = 500;

	public static Mine mine;

	public final int totalOponents = 10, totalAmrGuli = 20,
			totalOponentsGuli = 50;
	public static Random random;

	public static boolean bestGradesShow;

	public Oponents[] oponents = new Oponents[totalOponents];
	public MineGuli[] mineGulis = new MineGuli[totalAmrGuli];
	public OponentsErGuli[] oponentsErGulis = new OponentsErGuli[totalOponentsGuli];

	public GuliGame() {
		mine = new Mine();
		random = new Random();
		makeAllFalse();
		optionStage = true;
		optionValue = 0;
		life = 3;
		scoreValue = 0;
		amiGuliMarboKina = false;
		amrGuliMararJoggotaCounter = 0;
		for (int i = 0; i < totalOponents; i++)
			oponents[i] = new Oponents();

		for (int i = 0; i < totalAmrGuli; i++)
			mineGulis[i] = new MineGuli();

		for (int i = 0; i < totalOponentsGuli; i++)
			oponentsErGulis[i] = new OponentsErGuli();

	}

	public void drawAll(Graphics g) {

		gameBoardDesign(g);
		gameTimer++;
		if (optionStage) {
			drawOptionStage(g);
		} else if (levelShowStage) {
			drawLevelShowStage(g);
		} else if (playingStage) {
			playingStageAll(g);
		} else if (gameOverStage) {
			drawGameOverStage(g);
		} else if (bestGradesShow) {
			showBestGrades(g);
		}

	}

	private void showBestGrades(Graphics g) {
		// TODO Auto-generated method stub

		gameTimer++;

		int gx, gy, time = 400;

		if (gameTimer % 200 == 0)
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
		if (gameTimer < 200) {

			gx = ff.stringWidth("TOP LEVEL");
			gy = ff.getAscent();

			gx = 540 - gx / 2;
			gy = 200 + gy / 2 - 100;
			g.drawString("TOP LEVEL", gx, gy);

			int bb = FileIOForGame.konLevelEAce();

			gx = ff.stringWidth(String.valueOf(bb));
			gy = ff.getAscent();

			gx = 540 - gx / 2;
			gy = 200 + gy / 2 - 100;

			g.drawString(String.valueOf(bb), gx, gy + 50);
		}

		else {

			gx = ff.stringWidth("TOP SCORE");
			gy = ff.getAscent();

			gx = 540 - gx / 2;
			gy = 200 + gy / 2 - 100;
			g.drawString("TOP SCORE", gx, gy);

			int bb = FileIOForGame.bestScoreKoto();

			gx = ff.stringWidth(String.valueOf(bb));
			gy = ff.getAscent();

			gx = 540 - gx / 2;
			gy = 200 + gy / 2 - 100;

			g.drawString(String.valueOf(bb), gx, gy + 50);
		}

	}

	public void newGame(int leve) {
		mine = new Mine();
		makeAllFalse();
		levelShowStage = true;
		gameTimer = 0;
		level = leve;
		amrGuliMararJoggotaCounter = 0;
		levelSize = 10; // initial stage e

		for (int i = 0; i < totalAmrGuli; i++)
			mineGulis[i].vis = false;
		for (int i = 0; i < totalOponents; i++)
			oponents[i].vis = false;
		for (int i = 0; i < totalOponentsGuli; i++)
			oponentsErGulis[i].visibility = false;

	}

	private void drawGameOverStage(Graphics g) {
		// TODO Auto-generated method stub
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
			optionStage = true;
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

	private void playingStageAll(Graphics g) {

		mine.changeHobeKina();
		mine.drawMine(g);

		if (gameTimer < khelarTime - ageiOponentsMakingBondhoKoro
				&& oponentsMakeKorbeKina()) {
			makeNotunOponents();
		}
		changeOponentsErPosition();
		drawOponents(g);

		amiGuliCharboKina();
		gulirPositionChange();
		drawMineGuli(g);

		oponentsGuliMarbeKina();
		changeGulirPosition();
		drawOponentsGuli(g);

		amrGuliTeOra();
		oderGuliTeAmi(g);
		guliGuliColusion();
		if (!gameOverStage && !levelShowStage && gameOverCheck()) {
			makeAllFalse();
			gameOverStage = true;
			gameTimer = 0;
		} else if (levelChangeHobeKina()) {
			newGame(level + 1);
		}

		drawProperties(g);

	}

	private boolean levelChangeHobeKina() {
		// TODO Auto-generated method stub

		getTotalOponentsVisible();
		if (gameTimer > khelarTime && Oponents.totalVisible == 0) {

			for (int i = 0; i < totalAmrGuli; i++)
				mineGulis[i].vis = false;
			for (int i = 0; i < totalOponents; i++)
				oponents[i].vis = false;
			for (int i = 0; i < totalOponentsGuli; i++)
				oponentsErGulis[i].visibility = false;

			return true;
		}

		return false;
	}

	private void drawProperties(Graphics g) {
		// TODO Auto-generated method stub
		if (optionStage) {
			String ss = new String("PLAY  GULI  GULI  GAME");

			g.setColor(Color.BLACK);
			g.setFont(new Font("Arial", Font.BOLD + Font.PLAIN, 30));
			FontMetrics ff = g.getFontMetrics();

			int gx, gy;
			gx = 540 - ff.stringWidth(ss) / 2;
			gy = ff.getAscent();

			g.drawString(ss, gx, 425 - gy);
		}else{
			String ss = new String();
			if (gameTimer / 100 < 10)
				ss = new String("0" + String.valueOf(gameTimer / 100));
			else
				ss = String.valueOf(gameTimer / 100);

			g.drawString(ss, 753, 30);

			g.setColor(Color.BLACK);
			String pai = new String("Level: " + String.valueOf(level) + "  Life: "
					+ String.valueOf(life) + "  Score: "
					+ String.valueOf(scoreValue));
			int gx, gy;

			g.setFont(new Font("Arial", Font.BOLD + Font.PLAIN, 30));
			FontMetrics ff = g.getFontMetrics();

			gx = ff.stringWidth(pai);
			gy = ff.getAscent();

			gx = 540 - gx / 2;

			g.drawString(pai, gx, 425 - gy);
		}
	}

	private void guliGuliColusion() {
		// TODO Auto-generated method stub
		for (int i = 0; i < totalAmrGuli; i++) {
			if (mineGulis[i].vis) {
				Rectangle r1 = new Rectangle(mineGulis[i].x, mineGulis[i].y,
						Mine.one, Mine.one);
				for (int j = 0; j < totalOponentsGuli; j++) {
					if (oponentsErGulis[j].visibility) {
						Rectangle r2 = new Rectangle(oponentsErGulis[j].gulirx,
								oponentsErGulis[j].guliry, Mine.one, Mine.one);
						if (r1.intersects(r2)) {
							oponentsErGulis[j].visibility = false;
							mineGulis[i].vis = false;
						}
					}
				}
			}
		}
	}

	private void oderGuliTeAmi(Graphics g) {
		// TODO Auto-generated method stub
		for (int i = 0; i < totalOponentsGuli; i++) {
			if (oponentsErGulis[i].visibility) {
				int[] ax = { oponentsErGulis[i].gulirx,
						oponentsErGulis[i].gulirx + Mine.one,
						oponentsErGulis[i].gulirx + Mine.one,
						oponentsErGulis[i].gulirx };
				int[] ay = { oponentsErGulis[i].guliry,
						oponentsErGulis[i].guliry,
						oponentsErGulis[i].guliry + Mine.one,
						oponentsErGulis[i].guliry + Mine.one };

				Polygon ch = new Polygon(ax, ay, 4);
				if (check(ch, Mine.minepPolygon)) {
					life--;
					if (life <= 0) {
						makeAllFalse();
						gameOverStage = true;
						gameTimer = 0;
					} else {
						newGame(level);
						gameTimer = 0;
					}
					oponentsErGulis[i].visibility = false;
				}
			}
		}
	}

	private void amrGuliTeOra() {
		// TODO Auto-generated method stub
		for (int i = 0; i < totalAmrGuli; i++) {
			if (mineGulis[i].vis) {
				int[] ax = { mineGulis[i].x, mineGulis[i].x + Mine.one,
						mineGulis[i].x + Mine.one, mineGulis[i].x };
				int[] ay = { mineGulis[i].y, mineGulis[i].y,
						mineGulis[i].y + Mine.one, mineGulis[i].y + Mine.one };
				for (int j = 0; j < totalOponents; j++) {
					if (oponents[j].vis) {
						if (check(new Polygon(ax, ay, 4), oponents[j].polygon)) {
							oponents[j].vis = false;
							mineGulis[i].vis = false;
							scoreValue += pointsPerOponents;

						}
					}
				}
			}
		}

	}

	private boolean check(Polygon mPolygon, Polygon polygon) {
		// TODO Auto-generated method stub

		for (int i = 0; i < mPolygon.npoints; i++) {
			Point p = new Point(mPolygon.xpoints[i], mPolygon.ypoints[i]);
			if (polygon.contains(p))
				return true;
		}
		for (int i = 0; i < polygon.npoints; i++) {
			Point p = new Point(polygon.xpoints[i], polygon.ypoints[i]);
			if (mPolygon.contains(p))
				return true;
		}

		return false;
	}

	private boolean gameOverCheck() {
		// TODO Auto-generated method stub

		for (int i = 0; i < totalOponents; i++) {
			if (oponents[i].vis) {
				if (check(oponents[i].polygon, Mine.minepPolygon)) {

					life--;
					if (life <= 0) {
						makeAllFalse();
						gameOverStage = true;
						gameTimer = 0;
						if (FileIOForGame.konLevelEAce() < level) {
							FileIOForGame.levelMucheAddKoro(String.valueOf(level));
						}
						if (FileIOForGame.bestScoreKoto() < scoreValue) {
							FileIOForGame.scoreMucheAddKoro(String.valueOf(scoreValue));
						}
						return true;
					} else {
						newGame(level);
						gameTimer = 0;
						return false;
					}
				}
			}
		}
		return false;
	}

	private void drawOponentsGuli(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.GREEN);

		for (int i = 0; i < totalOponentsGuli; i++) {
			if (oponentsErGulis[i].visibility) {
				oponentsErGulis[i].drawGulis(g);
			}
		}

	}

	private void changeGulirPosition() {
		// TODO Auto-generated method stub

		for (int i = 0; i < totalOponentsGuli; i++) {
			if (oponentsErGulis[i].visibility) {
				oponentsErGulis[i].changePosition();
			}
		}
	}

	private void oponentsGuliMarbeKina() {
		// TODO Auto-generated method stub
		int closeness = 2;
		for (int i = 0; i < totalOponents; i++) {
			if (oponents[i].vis) {
				if (oponents[i].gulirMararTimeCounter > OponentsErGuli.guliMararTimeCheck) {
					if (Math.abs(oponents[i].midx - Mine.midx) < closeness) {
						oponents[i].gulirMararTimeCounter = 0;
						for (int j = 0; j < 100; j++) {
							if (!oponentsErGulis[j].visibility) {
								if (oponents[i].midy > Mine.midy) {
									oponentsErGulis[j] = new OponentsErGuli(
											oponents[i].x + Mine.one,
											oponents[i].y + Mine.one, 2);
								} else {
									oponentsErGulis[j] = new OponentsErGuli(
											oponents[i].x + Mine.one,
											oponents[i].y + Mine.one, 3);
								}

								break;
							}
						}

					} else if (Math.abs(oponents[i].midy - Mine.midy) < closeness) {
						oponents[i].gulirMararTimeCounter = 0;
						for (int j = 0; j < 100; j++) {
							if (!oponentsErGulis[j].visibility) {
								if (oponents[i].midx > Mine.midx) {
									oponentsErGulis[j] = new OponentsErGuli(
											oponents[i].x + Mine.one,
											oponents[i].y + Mine.one, 1);
								} else {
									oponentsErGulis[j] = new OponentsErGuli(
											oponents[i].x + Mine.one,
											oponents[i].y + Mine.one, 0);
								}

								break;
							}
						}
					}
				} else {
					oponents[i].gulirMararTimeCounter++;
				}

			}
		}

	}

	private void drawMineGuli(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		for (int i = 0; i < totalAmrGuli; i++)
			if (mineGulis[i].vis)
				mineGulis[i].drawGuli(g);

	}

	private void gulirPositionChange() {
		// TODO Auto-generated method stub

		for (int i = 0; i < totalAmrGuli; i++)
			if (mineGulis[i].vis)
				mineGulis[i].changePosition();
	}

	private void amiGuliCharboKina() {
		// TODO Auto-generated method stub
		amrGuliMararJoggotaCounter++;
		if (amiGuliMarboKina) {
			amiGuliMarboKina = false;

			for (int i = 0; i < totalAmrGuli; i++)
				if (!mineGulis[i].vis) {
					mineGulis[i] = new MineGuli(Mine.x + Mine.one, Mine.y
							+ Mine.one, Mine.goingPermission);
					break;
				}
		}
	}

	private void drawOponents(Graphics g) {
		// TODO Auto-generated method stub
		for (int i = 0; i < totalOponents; i++)
			if (oponents[i].vis)
				oponents[i].drawOponent(g);
	}

	private void changeOponentsErPosition() {
		// TODO Auto-generated method stub

		for (int i = 0; i < totalOponents; i++) {
			if (oponents[i].vis) {
				oponents[i].midx = oponents[i].x + Mine.three / 2;
				oponents[i].midy = oponents[i].y + Mine.three / 2;
				if (oponents[i].oponentsErDeractionChangingCounter
						% Oponents.oponentsErDeractionChangingCheckValue == 0) {
					oponents[i].oponentsErDeractionChangingCounter++;
					int val = random.nextInt(4);
					oponents[i].direction = val;
					if (val == 0) {
						oponents[i].goLeft();
					} else if (val == 1) {
						oponents[i].goRight();
					} else if (val == 2) {
						oponents[i].goUp();
					} else if (val == 3) {
						oponents[i].goDown();
					}
				} else {
					oponents[i].oponentsErDeractionChangingCounter++;
					int val = oponents[i].direction;
					if (val == 0) {
						oponents[i].goLeft();
					} else if (val == 1) {
						oponents[i].goRight();
					} else if (val == 2) {
						oponents[i].goUp();
					} else if (val == 3) {
						oponents[i].goDown();
					}
				}
			}
		}

	}

	private void makeNotunOponents() {
		// TODO Auto-generated method stub

		boolean ans = false;
		for (int i = 0; i < totalOponents; i++) {
			if (!oponents[i].vis) {
				oponents[i].vis = true;
				oponents[i].gulirMararTimeCounter = 0;
				oponents[i].oponentsErDeractionChangingCounter = 0;
				int ch = random.nextInt(8);

				if (ch == 0) {
					oponents[i].x = 310;
					oponents[i].y = 20;
				} else if (ch == 1) {
					oponents[i].x = 770 - Mine.three;
					oponents[i].y = 20;
				} else if (ch == 2) {
					oponents[i].x = 770 - Mine.three;
					oponents[i].y = 370 - Mine.three;
				} else if (ch == 3) {
					oponents[i].x = 310;
					oponents[i].y = 370 - Mine.three;
				} else if (ch == 4) {
					oponents[i].x = 310 + (770 - 310 - Mine.three) / 2;
					oponents[i].y = 20;
				} else if (ch == 5) {
					oponents[i].x = 770 - Mine.three;
					oponents[i].y = 20 + (370 - 20 - Mine.three) / 2;
				} else if (ch == 6) {
					oponents[i].x = 310 + (770 - 310 - Mine.three) / 2;
					oponents[i].y = 370 - Mine.three;
				} else {
					oponents[i].x = 310;
					oponents[i].y = 20 + (370 - 20 - Mine.three) / 2;
				}

				Rectangle rectangle1 = new Rectangle(oponents[i].x,
						oponents[i].y, Mine.three, Mine.three);
				ans = false;
				for (int j = 0; j < totalOponents; j++) {
					if (oponents[j].vis && i != j) {
						Rectangle rectangle2 = new Rectangle(oponents[j].x,
								oponents[j].y, Mine.three, Mine.three);
						if (rectangle1.intersects(rectangle2)) {
							ans = true;
							oponents[i].vis = false;
							break;
						}
					}
				}

				if (!ans) {
					Rectangle r = new Rectangle(Mine.x, Mine.y, Mine.three,
							Mine.three);
					getTotalOponentsVisible();
					if (rectangle1.intersects(r)) {
						if (Oponents.totalVisible == 8)
							ans = false;
						else
							ans = true;
						oponents[i].vis = false;
					}
				}
				break;
			}
		}
		if (ans)
			makeNotunOponents();

	}

	private boolean oponentsMakeKorbeKina() {
		// TODO Auto-generated method stub

		getTotalOponentsVisible();

		Oponents.oponentsMakeKortePararCounter++;

		if (Oponents.totalVisible < level + 2
				&& Oponents.oponentsMakeKortePararCounter >= Oponents.oponentsMakeKorarJoggota
				&& Oponents.random.nextInt(10) == 0) {
			Oponents.oponentsMakeKortePararCounter = 0;
			return true;
		}

		return false;
	}

	private void getTotalOponentsVisible() {
		// TODO Auto-generated method stub
		Oponents.totalVisible = 0;
		for (int i = 0; i < totalOponents; i++) {
			if (oponents[i].vis)
				Oponents.totalVisible++;
		}
	}

	private void drawLevelShowStage(Graphics g) {
		// TODO Auto-generated method stub
		drawProperties(g);
		int gx, gy, time = 150;
		String strings = new String();

		if (gameTimer < 50)
			strings = new String("Level " + String.valueOf(level));
		else if (gameTimer < 100)
			strings = new String("Starts");
		else if (gameTimer < 150)
			strings = new String("Go");

		if (gameTimer % 50 == 0)
			levelSize = 10;

		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD + Font.PLAIN, levelSize++));
		FontMetrics ff = g.getFontMetrics();

		System.out.println("Game timer : " + gameTimer);
		if (gameTimer > time) {
			makeAllFalse();
			playingStage = true;
			return;
		}

		gx = ff.stringWidth(strings);
		gy = ff.getAscent();

		gx = 540 - gx / 2;
		gy = 200 + gy / 2 - 100 + (gameTimer / 10) * 2;

		g.drawString(strings, gx, gy);

	}

	private void drawOptionStage(Graphics g) {
		// TODO Auto-generated method stub

		drawProperties(g);
		// optionValue++;
		String[] strings = { "NewGame", "Continue", "Best Grades", "Exit" };
		int val = 0, gy_ext = 100, gx, gy, optionErSize = 20;
		;
		g.setFont(new Font("Arial", Font.BOLD + Font.PLAIN, optionErSize));
		FontMetrics ff = g.getFontMetrics();

		if (optionValue == -1)
			optionValue = 3;
		else if (optionValue == 4)
			optionValue = 0;

		while (val < 4) {

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

	private void gameBoardDesign(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillRect(300, 10, 480, 400);

		g.setColor(Color.WHITE);
		g.fillRect(310, 20, 460, 350);

	}

	public void makeAllFalse() {
		optionStage = false;
		levelShowStage = false;
		playingStage = false;
		gameOverStage = false;
		bestGradesShow = false;
		enterChaparTimeHoice = false;
		showVal = 0;
		gameTimer = 0;
	}

}
