package fileSearching;

import java.io.File;

public class SearchWholeComputer {

	public int motKotoGuloMatchKorlo = 0, ultaPaltaListKotoGulo = 0;
	private int anumaniqEtoGuloHoitePare = 5000;
	public String searchingFileName;
	public boolean searchingFileFound;
	public String[] matchingList = new String[anumaniqEtoGuloHoitePare];
	public String[] ultaPaltaList = new String[anumaniqEtoGuloHoitePare];

	public int[] fileType = new int[anumaniqEtoGuloHoitePare];

	public SearchWholeComputer() {
		for (int i = 0; i < anumaniqEtoGuloHoitePare; i++) {
			matchingList[i] = new String("");
			fileType[i] = 0;
			ultaPaltaList[i] = new String();
		}
		motKotoGuloMatchKorlo = 0;
		searchingFileFound = false;
		ultaPaltaListKotoGulo = 0;
	}

	public SearchWholeComputer(String str) {
		for (int i = 0; i < anumaniqEtoGuloHoitePare; i++) {
			matchingList[i] = new String("");
			fileType[i] = 0;
			ultaPaltaList[i] = new String();
		}
		motKotoGuloMatchKorlo = 0;
		searchingFileFound = false;
		ultaPaltaListKotoGulo = 0;
		searchingFileName = str.toLowerCase();
		searchInWholeComputer();
	}

	private void searchInWholeComputer() {

		char alphabet = 'A';
		for (int i = 0; i < 26; i++, alphabet++) {
			File file = new File(String.valueOf(alphabet) + ":");
			if (alphabet != 'C')
				makeAListOfMatchingItem(file);
		}

	}

	private void makeAListOfMatchingItem(File f) {

		if (motKotoGuloMatchKorlo >= anumaniqEtoGuloHoitePare-1)
			return;

		try {
			if (f.isDirectory()) {
				File[] fi = f.listFiles();
				int len = fi.length;
				if (f.getName().toLowerCase().indexOf(searchingFileName) != -1) {
					saveTheFileToTheList(f);
				}
				for (int i = 0; i < len; i++) {
					makeAListOfMatchingItem(fi[i]);
				}
			} else {
				if (f.getName().toLowerCase().indexOf(searchingFileName) != -1) {
					saveTheFileToTheList(f);
				}
			}
		} catch (Exception e) {
			// e.printStackTrace();
			// System.out.println("111111111: " + f.getAbsolutePath());
		}

	}

	private void saveTheFileToTheList(File f) {
		String str = new String(f.getPath().toString().replace("\\", "\\\\"));
		matchingList[motKotoGuloMatchKorlo] = str;
		int type = whatTypeOfFile(str);
		fileType[motKotoGuloMatchKorlo] = type;
		motKotoGuloMatchKorlo++;
		searchingFileFound = true;
		if (type == 4)
			ultaPaltaList[ultaPaltaListKotoGulo++] = str;
	}

	private static int whatTypeOfFile(String str) {
		int ans = 0;

		if (str.toLowerCase().endsWith(".mp3"))
			ans = 3;
		else if (str.toLowerCase().endsWith(".wav"))
			ans = 3;

		else if (str.toLowerCase().endsWith(".mp4"))
			ans = 4;
		else if (str.toLowerCase().endsWith(".3gp"))
				ans = 4;
		else if (str.toLowerCase().endsWith(".avi"))
			ans = 4;
		else if (str.toLowerCase().endsWith(".flv"))
			ans = 4;
		else if (str.toLowerCase().endsWith(".mpeg"))
			ans = 4;
		else if (str.toLowerCase().endsWith(".mkv"))
			ans = 4;
		else if (str.toLowerCase().endsWith(".webm"))
			ans = 4;
		else if (str.toLowerCase().endsWith(".wmv"))
			ans = 4;

		return ans;

	}
}
