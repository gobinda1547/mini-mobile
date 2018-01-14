package gameGuliGuli;

import java.awt.Graphics;

public class MineGuli {

	public static int gulirSpeed = 2;
	public int x, y, d;
	public boolean vis;

	public MineGuli() {
		x = 0;
		y = 0;
		vis = false;
	}

	public MineGuli(int x, int y, int z) {
		this.x = x;
		this.y = y;
		d = z;
		vis = true;
	}

	public void changePosition() {
		if (d == 0) {
			x += gulirSpeed;
			if (x > 765)
				vis = false;
		} else if (d == 1) {
			x -= gulirSpeed;
			if (x < 310)
				vis = false;
		} else if (d == 2) {
			y -= gulirSpeed;
			if (y < 20)
				vis = false;
		} else {
			y += gulirSpeed;
			if (y > 365)
				vis = false;
		}
	}

	public void drawGuli(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(x, y, Mine.one, Mine.one);
	}

}
