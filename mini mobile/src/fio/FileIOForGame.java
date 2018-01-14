package fio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class FileIOForGame {

	private static Scanner scanner;
	private static Formatter formatter;

	private static String directory = new String(
			"D:\\dir1\\dir2\\dir3\\gamingFile\\");
	private static String level = new String(directory
			+ "guliGuliKhelarBestLevel.txt");
	private static String score = new String(directory
			+ "guliGuliKhelarBestScore.txt");
	private static String sapKhelarBestScore = new String(directory
			+ "sapKhelarBestScore.txt");
	private static String gunFireKhelarBestScore = new String(directory
			+ "gunFireKhelarBestScore.txt");
	private static String pacManKhelarBestScore = new String(directory
			+ "pacManKhelarBestScore.txt");

	public FileIOForGame() {
		scanner = null;
		formatter = null;
	}

	public static int gunFireKhelarBestScore() {
		try {
			scanner = new Scanner(new File(gunFireKhelarBestScore));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int a = 1;
		while (scanner.hasNextInt()) {
			a = scanner.nextInt();
		}

		return a;
	}

	public static int sapKhelarBestScore() {
		try {
			scanner = new Scanner(new File(sapKhelarBestScore));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int a = 1;
		while (scanner.hasNextInt()) {
			a = scanner.nextInt();
		}

		return a;
	}

	public static int konLevelEAce() {
		try {
			scanner = new Scanner(new File(level));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int a = 1;
		while (scanner.hasNextInt()) {
			a = scanner.nextInt();
		}

		return a;
	}

	public static int bestScoreKoto() {
		try {
			scanner = new Scanner(new File(score));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int a = 0;
		while (scanner.hasNextInt()) {
			a = scanner.nextInt();
		}

		return a;
	}

	public static boolean levelFileAceKiNa() {

		if (new File(level).exists())
			return true;
		return false;

	}

	public static boolean sapKhelarBestScoreFileAceKiNa() {

		if (new File(sapKhelarBestScore).exists())
			return true;
		return false;

	}

	public static boolean scoreFileAceKiNa() {

		if (new File(score).exists())
			return true;
		return false;

	}

	public static void makeSapKhelarBestScoreFile() {
		try {
			formatter = new Formatter(new File(sapKhelarBestScore));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formatter.format("%s", "0");
		formatter.close();
	}

	public static void makeLevelFile() {
		try {
			formatter = new Formatter(new File(level));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formatter.format("%s", "1");
		formatter.close();
	}

	public static void makeScoreFile() {
		try {
			formatter = new Formatter(new File(score));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formatter.format("%s", "0");
		formatter.close();
	}

	public static void sapKhelarScoreMucheAddKoro(String str) {
		try {
			formatter = new Formatter(new File(sapKhelarBestScore));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formatter.format("%s", str);
		formatter.close();
	}

	public static void levelMucheAddKoro(String str) {
		try {
			formatter = new Formatter(new File(level));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formatter.format("%s", str);
		formatter.close();
	}

	public static void scoreMucheAddKoro(String str) {
		try {
			formatter = new Formatter(new File(score));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formatter.format("%s", str);
		formatter.close();
	}

	public static void makeDirectioryFolder() {
		// TODO Auto-generated method stub

		File file = new File(directory);
		file.mkdirs();

		Process p;
		try {
			p = Runtime.getRuntime().exec("attrib +s +h " + "D:\\dir1");
			try {
				p.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean gunFireKhelarBestScoreFileAceKiNa() {
		// TODO Auto-generated method stub

		if (new File(gunFireKhelarBestScore).exists())
			return true;

		return false;
	}

	public static void makeGunFireKhelarBestScoreFile() {
		// TODO Auto-generated method stub
		try {
			formatter = new Formatter(new File(gunFireKhelarBestScore));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formatter.format("%s", "0");
		formatter.close();
	}

	public static void gunFireKhelarScoreMucheAddKoro(String str) {
		try {
			formatter = new Formatter(new File(gunFireKhelarBestScore));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formatter.format("%s", str);
		formatter.close();
	}

	public static boolean pacManKhelarBestScoreFileAceKiNa() {
		// TODO Auto-generated method stub

		if (new File(pacManKhelarBestScore).exists())
			return true;

		return false;

	}

	public static void makepacManKhelarBestScoreFile() {
		// TODO Auto-generated method stub

		try {
			formatter = new Formatter(new File(pacManKhelarBestScore));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formatter.format("%s", "0");
		formatter.close();

	}

	public static int pacManKhelarBestScore() {
		// TODO Auto-generated method stub

		try {
			scanner = new Scanner(new File(pacManKhelarBestScore));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int a = 1;
		while (scanner.hasNextInt()) {
			a = scanner.nextInt();
		}

		return a;
	}

	public static void pacManKhelarScoreMucheAddKoro(String valueOf) {
		// TODO Auto-generated method stub
		try {
			formatter = new Formatter(new File(pacManKhelarBestScore));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		formatter.format("%s", valueOf);
		formatter.close();

	}

}
