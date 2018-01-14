package gameGuliGuli;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;

public class Mine {

	public static int x = 0, y = 0, midx, midy, changingSpeed = 1,
			direction = 1, goingPermission = 0, gridLength = 10, one, two,
			three, colorChangingCounter = 0;
	public static Polygon minepPolygon;
	public static int howQuickGuliCharbe = 10;

	public Mine() {

		direction = 1;
		goingPermission = 0;
		one = gridLength;
		two = 2 * gridLength;
		three = 3 * gridLength;
		x = 310;
		y = 20;
		midx = x + three / 2;
		midy = y + three / 2;
		lookRight();
		colorChangingCounter = 0;
	}

	public void drawMine(Graphics g) {

		colorChangingCounter++;
		g.setColor(Color.BLACK);
		g.fillPolygon(minepPolygon);

		g.setColor(Color.BLUE);
		g.drawPolygon(minepPolygon);

		if (colorChangingCounter % 50 > 25)
			g.setColor(Color.BLACK);
		else
			g.setColor(Color.WHITE);

		if (colorChangingCounter > 10000)
			colorChangingCounter = 0;

		g.fillRect(x + one, y + one, one, one);

	}

	public void lookRight() {
		int[] ax = { x, x + two, x + two, x + three, x + three, x + two,
				x + two, x };
		int[] ay = { y, y, y + one, y + one, y + two, y + two, y + three,
				y + three };
		minepPolygon = new Polygon(ax, ay, 8);
	}

	public void lookLeft() {
		int[] ax = { x + one, x + three, x + three, x + one, x + one, x, x,
				x + one };
		int[] ay = { y, y, y + three, y + three, y + two, y + two, y + one,
				y + one };
		minepPolygon = new Polygon(ax, ay, 8);
	}

	public void lookUp() {
		int[] ax = { x + one, x + two, x + two, x + three, x + three, x, x,
				x + one };
		int[] ay = { y, y, y + one, y + one, y + three, y + three, y + one,
				y + one };
		minepPolygon = new Polygon(ax, ay, 8);
	}

	public void lookDown() {
		int[] ax = { x, x + three, x + three, x + two, x + two, x + one,
				x + one, x };
		int[] ay = { y, y, y + two, y + two, y + three, y + three, y + two,
				y + two };
		minepPolygon = new Polygon(ax, ay, 8);
	}

	public void goRight() {
		if (x >= 770 - Mine.three)
			return;
		x += changingSpeed;
		lookRight();

	}

	public void goLeft() {
		if (x <= 310)
			return;
		x -= changingSpeed;
		lookLeft();

	}

	public void goUp() {
		if (y <= 20)
			return;
		y -= changingSpeed;
		lookUp();

	}

	public void goDown() {
		if (y >= 370 - Mine.three)
			return;
		y += changingSpeed;
		lookDown();

	}

	public void changeHobeKina() { // TODO Auto-generated method stub

		midx = x + three / 2;
		midy = y + three / 2;

		if (direction == 0 && goingPermission != 0) {
			goingPermission = 0;
			lookRight();
		} else if (direction == 0 && goingPermission == 0) {
			goRight();
		}

		if (direction == 1 && goingPermission != 1) {
			goingPermission = 1;
			lookLeft();
		} else if (direction == 1 && goingPermission == 1) {
			goLeft();
		}

		if (direction == 2 && goingPermission != 2) {
			goingPermission = 2;
			lookUp();
		} else if (direction == 2 && goingPermission == 2) {
			goUp();
		}

		if (direction == 3 && goingPermission != 3) {
			goingPermission = 3;
			lookDown();
		} else if (direction == 3 && goingPermission == 3) {
			goDown();
		}

	}

}
