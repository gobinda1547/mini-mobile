package gameGunFire;

import java.awt.Color;
import java.awt.Graphics;

public class AmrGuli {

	public static int f1, changinValueCheck = 5;
	public int x, y, chaningCounter;
	public boolean vis;

	public AmrGuli() {
		x = 0;
		y = 0;
		f1 = GunFireGame.DOT_SIZE;
		vis = false;
		chaningCounter = 0;
	}

	public AmrGuli(int a, int b) {
		x = a;
		y = b;
		vis = true;
		chaningCounter = 0;
	}

	public void drawAmrGuli(Graphics g) {
		g.setColor(Color.BLUE);
		g.drawRect(x, y, f1, f1);

		g.setColor(Color.BLUE);
		g.drawRect(x + 5, y + 5, 5, 5);

	}

	public void moveAmrGuli() {
		chaningCounter++;
		if (chaningCounter > changinValueCheck) {
			chaningCounter = 0;
			if (y == 20)
				vis = false;
			y -= f1;
		}

	}

}
