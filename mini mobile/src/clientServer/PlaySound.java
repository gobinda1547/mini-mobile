package clientServer;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

import javax.swing.JApplet;

public class PlaySound extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PlaySound(String str, int p) {
		Th t = new Th(str, p);
		t.start();
	}

	class Th extends Thread {

		private AudioClip audio_clip;
		public int counter, total;

		public Th(String str, int to) {
			URL url = getClass().getResource(str);
			audio_clip = Applet.newAudioClip(url);
			total = to;
		}

		public void run() {
			if (audio_clip != null)
				audio_clip.play();
			counter = 0;
			cholbeEtoSecond();

		}

		private void cholbeEtoSecond() {
			// TODO Auto-generated method stub

			while (counter++ < total) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (audio_clip != null)
				audio_clip.stop();
		}
	}

}