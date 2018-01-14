package gameGuliGuli;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.Random;

public class Oponents {

	public static int oponentsMakeKorarJoggota = 20, oponentsSpeed = 1,
			oponentsErSorbochoSonkha = 20,
			oponentsErDeractionChangingCheckValue = 150,
			oponentsMakeKortePararCounter, totalVisible = 0;

	public int x, y, gulirMararTimeCounter, oponentsErDeractionChangingCounter,
			direction = 0, midx, midy;
	public boolean vis;
	public static Random random;
	public Polygon polygon = new Polygon();

	public Oponents() {
		vis = false;
		totalVisible = 0;
		random = new Random();
		oponentsMakeKortePararCounter = 0;
		oponentsErDeractionChangingCounter = 0;
		midx = x + Mine.three / 2;
		midy = y + Mine.three / 2;
		polygon = new Polygon();

	}

	public void goDown() {
		// TODO Auto-generated method stub
		if (y < 370 - Mine.three)
			y += oponentsSpeed;
		else
			oponentsErDeractionChangingCounter = 0;

	}

	public void goUp() {
		// TODO Auto-generated method stub
		if (y > 20)
			y -= oponentsSpeed;
		else
			oponentsErDeractionChangingCounter = 0;
	}

	public void goRight() {
		// TODO Auto-generated method stub
		if (x < 770 - Mine.three)
			x += oponentsSpeed;
		else
			oponentsErDeractionChangingCounter = 0;
	}

	public void goLeft() {
		// TODO Auto-generated method stub
		if (x > 310)
			x -= oponentsSpeed;
		else
			oponentsErDeractionChangingCounter = 0;
	}

	public void drawOponent(Graphics g) {
		// TODO Auto-generated method stub
		getPolygon(x, y);
		g.setColor(Color.BLACK);
		g.fillPolygon(polygon);

	}

	public void getPolygon(int u, int v) {
		// TODO Auto-generated method stub
		int[] ax = { u + Mine.one, u + Mine.two, u + Mine.two, u + Mine.three,
				u + Mine.three, u + Mine.two, u + Mine.two, u + Mine.one,
				u + Mine.one, u, u, u + Mine.one };
		int[] ay = { v, v, v + Mine.one, v + Mine.one, v + Mine.two,
				v + Mine.two, v + Mine.three, v + Mine.three, v + Mine.two,
				v + Mine.two, v + Mine.one, v + Mine.one };

		polygon = new Polygon(ax, ay, 12);
	}

}
