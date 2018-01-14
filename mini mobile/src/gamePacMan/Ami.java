package gamePacMan;

import java.awt.Color;
import java.awt.Graphics;

public class Ami {

	public static int pos, f1, amrColorChangingCounter = 0;

	public Ami() {
		f1 = PacMan.size;
		pos = 24 * 16 + 1;
		amrColorChangingCounter = 0;
	}

	public void drawMine(Graphics g) {
		amrColorChangingCounter++;
		if (amrColorChangingCounter % 10 <= 5)
			g.setColor(Color.BLUE);
		else
			g.setColor(Color.WHITE);
		g.fillRect(300 + (pos % 24) * PacMan.size, 10 + (pos / 24) * PacMan.size, f1, f1);
	}

	public void moveMine(int a) {
		if (a == 0 && pos % 24 != 23 && !LevelMaking.vis[pos + 1]) {
			pos++;
		} else if (a == 1 && pos % 24 != 0 && !LevelMaking.vis[pos - 1]) {
			pos--;
		} else if (a == 2 && pos > 23 && !LevelMaking.vis[pos - 24]) {
			pos -= 24;
		} else if (a == 3 && pos < 408 && !LevelMaking.vis[pos + 24]) {
			pos += 24;
		}
		if (!LevelMaking.value[pos]) {
			LevelMaking.value[pos] = true;
			PacMan.scoreValue++;
			System.out.println("ok");
		}
	}

}
