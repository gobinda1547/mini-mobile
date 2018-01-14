package openingADirectory;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import runFiles.PlayAllKindOffFile;

public class OpenFolder {

	public static void openAFile(String str) {
		// TODO Auto-generated method stub
		Desktop desktop = Desktop.getDesktop();
		File dirToOpen = null;
		try {
			dirToOpen = new File(str);
			try {
				desktop.open(dirToOpen);
			} catch (IOException e) {
				PlayAllKindOffFile
						.EiAudioFileTaOpenKoro("C:\\Windows\\Media\\Sonata\\Windows Hardware Remove.wav");
			}
		} catch (IllegalArgumentException iae) {
			// System.out.println("File Not Found");
		}

	}
}