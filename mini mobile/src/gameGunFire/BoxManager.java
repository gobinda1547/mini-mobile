package gameGunFire;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class BoxManager {

	public Box[][] boxs = new Box[GunFireGame.totaly][GunFireGame.totaly];
	public Random random;

	public BoxManager() {

		random = new Random();
		for (int i = 0; i < GunFireGame.totaly; i++) {
			for (int j = 0; j < GunFireGame.totalx; j++) {
				boxs[i][j] = new Box();
			}
		}
	}

	public void drawBoxs(Graphics g) {

		g.setColor(Color.BLACK);
		for (int i = 0; i < GunFireGame.totaly; i++) {
			for (int j = 0; j < GunFireGame.totalx; j++) {
				if (boxs[i][j].visibility) {
					boxs[i][j].drawBox(g);
				}
			}
		}
	}

	public void makeOneNewLayer() {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < GunFireGame.totalx; j++) {
				if (boxs[i][j].visibility)
					System.out.print(" 1 ");
				else
					System.out.print(" 0 ");
			}
			System.out.println();
		}

		for (int i = GunFireGame.totaly - 1; i > 0; i--) {
			for (int j = 0; j < GunFireGame.totalx; j++) {
				if (boxs[i - 1][j].visibility)
					boxs[i][j] = new Box(j, i);
				else
					boxs[i][j].visibility = false;

			}
		}

		boolean bo = false;
		for (int i = 0; i < GunFireGame.totalx; i++) {
			bo = random.nextBoolean();
			if (bo)
				boxs[0][i] = new Box(i, 0);
			else
				boxs[0][i].visibility = false;
		}
	}

}
