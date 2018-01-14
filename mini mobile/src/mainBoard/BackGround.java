package mainBoard;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class BackGround {

	public BufferedImage image;

	public BackGround(int i) {
		i = 1;
		char ch = 'a';
		ch = (char) (ch + i-1);
		image = null;
		try {
			image = ImageIO.read(getClass().getResource(
					String.valueOf(ch) + ".jpg"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void drawBackGround(Graphics g) {
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.drawImage(image, 300, 10, null);
	}

}
