package gameGuliGuli;

import java.awt.Graphics;

public class OponentsErGuli {

	public static int guliMararTimeCheck = 200, gulirSpeed = 2;
	public int gulirVisibilityCounter = 0;
	public int gulirx, guliry, d;
	public boolean visibility = false;

	public OponentsErGuli() {
		gulirx = 0;
		guliry = 0;
		visibility = false;
		d = 0;
	}

	public OponentsErGuli(int x, int y, int d) {
		gulirx = x;
		guliry = y;
		visibility = true;
		this.d = d;
	}

	public void changePosition() {
		if (d == 0) {
			gulirx += gulirSpeed;
			if (gulirx > 765)
				visibility = false;
		} else if (d == 1) {
			gulirx -= gulirSpeed;
			if (gulirx < 310)
				visibility = false;
		} else if (d == 2) {
			guliry -= gulirSpeed;
			if (guliry < 20)
				visibility = false;
		} else {
			guliry += gulirSpeed;
			if (guliry > 365)
				visibility = false;
		}
	}

	public void drawGulis(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(gulirx, guliry, Mine.one, Mine.one);
	}

}
