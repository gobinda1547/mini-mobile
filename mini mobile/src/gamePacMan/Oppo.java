package gamePacMan;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Graphics;

public class Oppo {

	public static int changingValue = 20;
	public int pos, f1, changingCounter = 0;
	public boolean vis;
	public int[] tra = new int[432];
	private boolean[] chech = new boolean[432];
	public int ctra = 0, mypos;
	public static boolean gameOver = false;
	public static int[][] para = new int[432][4];
	public static int e, f;

	public Oppo() {
		f1 = PacMan.size;
		pos = 46;
		vis = false;
		changingCounter = 0;
		ctra = 0;
		mypos = Ami.pos;
		gameOver = false;
	}

	public Oppo(int[][] gp) {
		f1 = PacMan.size;
		pos = 46;
		vis = true;
		changingCounter = 0;
		ctra = 0;
		mypos = Ami.pos;
		para = gp;
		gameOver = false;
	}

	public void drawOpponents(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(300 + (pos % 24) * PacMan.size, 10 + (pos / 24)
				* PacMan.size, f1, f1);
	}

	public void changePosition() {
		changingCounter++;
		if (changingCounter > changingValue) {
			changingCounter = 0;
			mypos = Ami.pos;
			ctra = 0;
			pos = makeTraversList(pos, mypos);
			if (Math.abs(pos - mypos) == 1 || Math.abs(pos - mypos) == 24) {
				if (pos == e && mypos == f)
					gameOver = true;
				else {
					e = pos;
					f = mypos;
				}
			}
		}

	}

	private int makeTraversList(int from, int to) {
		// TODO Auto-generated method stub
		int[] uv = new int[432*4];
		int[] t = new int[432];

		for (int i = 0; i < 432; i++) {
			uv[i] = -1;
			chech[i] = false;
		}

		int c = 0, adding = 0;
		chech[from] = true;
		uv[adding++] = from;
		int a = from;
		t[a] = a;
		while (uv[c] != -1) {
			a = uv[c];
			c++;
			for (int i = 0; i < 4; i++) {
				if (para[a][i] != -1 && !chech[para[a][i]]) {
					chech[para[a][i]] = true;
					uv[adding++] = para[a][i];
					t[para[a][i]] = a;
					if (a == to)
						break;
				}
			}
		}
		a = t[to];
		while (t[a] != from) {
			a = t[a];
		}
		return a;

	}
}
