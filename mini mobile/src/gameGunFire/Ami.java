package gameGunFire;

import java.awt.Color;
import java.awt.Graphics;

public class Ami {

	public static int x, y, f1;
	public static boolean left = false, right = false;

	public Ami() {
		x = 435 + 2 * GunFireGame.DOT_SIZE;
		y = 335;
		left = false;
		right = false;
		f1 = GunFireGame.DOT_SIZE;
	}

	public void drawMine(Graphics g) {
		g.setColor(Color.BLACK);

		g.fillRect(x, y, f1, f1);
		g.fillRect(x, y + f1, f1, f1);

		if (x != 435)
			g.fillRect(x - f1, y + f1, f1, f1);
		if (x != 645)
			g.fillRect(x + f1, y + f1, f1, f1);
	}

	public void moveMine() {
		if (right) {
			right = false;
			if (x >= 645)
				return;
			x += f1;
		} else if (left) {
			left = false;
			if (x <= 435)
				return;
			x -= f1;
		}

	}

}
