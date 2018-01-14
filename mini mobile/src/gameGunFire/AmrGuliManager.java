package gameGunFire;

import java.awt.Graphics;

public class AmrGuliManager {

	public final int totalGuli = 25;
	public AmrGuli[] amrGuli = new AmrGuli[totalGuli];

	public AmrGuliManager() {

		for (int i = 0; i < totalGuli; i++) {
			amrGuli[i] = new AmrGuli();
		}

	}

	public void makeOneNewGuli() {

		for (int i = 0; i < totalGuli; i++) {
			if (!amrGuli[i].vis) {
				// make it
				amrGuli[i] = new AmrGuli(Ami.x, Ami.y - GunFireGame.DOT_SIZE);
				break;
			}
		}

	}

	public void drawAmrGulis(Graphics g) {

		for (int i = 0; i < totalGuli; i++) {
			if (amrGuli[i].vis)
				amrGuli[i].drawAmrGuli(g);
		}

	}

	public void moveAmrGulis() {

		for (int i = 0; i < totalGuli; i++) {
			if (amrGuli[i].vis)
				amrGuli[i].moveAmrGuli();
		}
	}
}
