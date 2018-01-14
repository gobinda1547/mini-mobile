package runFiles;

import java.io.File;
import java.io.IOException;

import openingADirectory.OpenFolder;

public class PlayAllKindOffFile {

	public static void EiAudioFileTaOpenKoro(String str) {
		if (new File(
				"C:\\Program Files (x86)\\Windows Media Player\\wmplayer.exe")
				.exists()) {
			ProcessBuilder pb = new ProcessBuilder(
					"C:\\Program Files (x86)\\Windows Media Player\\wmplayer.exe",
					str);
			playAllHere(pb);

		} else if (new File(
				"C:\\Program Files\\Windows Media Player\\wmplayer.exe")
				.exists()) {
			ProcessBuilder pb = new ProcessBuilder(
					"C:\\Program Files\\Windows Media Player\\wmplayer.exe",
					str);
			playAllHere(pb);

		}
	}

	public static void EiVideoFileTaOpenKoro(String str) {
		if (new File("C:\\The KMPlayer\\KMPlayer.exe").exists()) {
			ProcessBuilder pb = new ProcessBuilder(
					"C:\\The KMPlayer\\KMPlayer.exe", str);
			
			playAllHere(pb);

		} else if (new File("C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe")
				.exists()) {
			ProcessBuilder pb = new ProcessBuilder(
					"C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe", str);
			playAllHere(pb);

		} else if (new File("C:\\Program Files\\VideoLAN\\VLC\\vlc.exe")
				.exists()) {
			ProcessBuilder pb = new ProcessBuilder(
					"C:\\Program Files\\VideoLAN\\VLC\\vlc.exe", str);
			playAllHere(pb);
		} else {
			try {
				OpenFolder.openAFile(str);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	private static void playAllHere(ProcessBuilder pb) {

		// TODO Auto-generated method stub
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
