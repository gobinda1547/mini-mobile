package fileSearching;

import java.awt.Color;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import openingADirectory.OpenFolder;

import runFiles.PlayAllKindOffFile;

import fileSearching.SearchWholeComputer;

public class SearchingFileErListWithPanel extends JPanel {

	private JList countryList;
	public static boolean vis = false;

	public SearchingFileErListWithPanel(final String[] str) {

		setLayout(new GridLayout(1, 1));

		int len = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals("")) {
				len = i;
				break;
			}
		}
		final String[] st = new String[len];
		for (int i = 0; i < len; i++)
			st[i] = str[i];

		countryList = new JList(st);
		countryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		countryList.addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent le) {

				if (vis) {
					vis = false;
					if (whatTypeOfFile(st[countryList.getSelectedIndex()]) == 4)
						PlayAllKindOffFile.EiVideoFileTaOpenKoro(st[countryList
								.getSelectedIndex()]);
					else if (whatTypeOfFile(st[countryList.getSelectedIndex()]) == 0)
						OpenFolder.openAFile(st[countryList.getSelectedIndex()]);
					else if (whatTypeOfFile(st[countryList.getSelectedIndex()]) == 3)
						PlayAllKindOffFile.EiAudioFileTaOpenKoro(st[countryList
								.getSelectedIndex()]);
				} else
					vis = true;

			}
		});

		JScrollPane jScrollPane = new JScrollPane(countryList);
		jScrollPane
				.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jScrollPane.setViewportBorder(new LineBorder(Color.RED));
		add(jScrollPane);

	}

	private static int whatTypeOfFile(String str) {

		int ans = 0;

		if (new File(str).isDirectory())
			ans = 0;

		else if (str.toLowerCase().endsWith(".mp3"))
			ans = 3;
		else if (str.toLowerCase().endsWith(".wav"))
			ans = 3;

		else if (str.toLowerCase().endsWith(".mp4"))
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

	public static String[] makeAFaltuArray() {

		SearchWholeComputer[] search = new SearchWholeComputer[5];

		search[0] = new SearchWholeComputer("fuck");
		search[1] = new SearchWholeComputer("xvideo");
		search[2] = new SearchWholeComputer("sex");
		search[3] = new SearchWholeComputer("pussy");
		search[4] = new SearchWholeComputer("porn");

		String[] strings = new String[5000];
		int k = 0;

		for (int j = 0; j < 5; j++)
			for (int i = 0; i < search[j].motKotoGuloMatchKorlo; i++)
				strings[k++] = search[j].matchingList[i];

		for (int i = k; i < 5000; i++)
			strings[i] = new String("");
		
		return strings;

	}
}