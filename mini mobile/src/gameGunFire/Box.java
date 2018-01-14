package gameGunFire;

import java.awt.Color;
import java.awt.Graphics;

public class Box {

	public int x, y;
	public boolean visibility;

	public Box() {
		x = 0;
		y = 0;
		visibility = false;
	}

	public Box(int a, int b) {
		x = 435 + a * GunFireGame.DOT_SIZE;
		y = 20 + b * GunFireGame.DOT_SIZE;
		visibility = true;
	}

	public void drawBox(Graphics g) {
		g.drawRect(x, y, GunFireGame.DOT_SIZE, GunFireGame.DOT_SIZE);
		g.setColor(Color.BLACK);
		g.fillOval(x+2, y+2,  GunFireGame.DOT_SIZE-4, GunFireGame.DOT_SIZE-4);
		
	}

}
