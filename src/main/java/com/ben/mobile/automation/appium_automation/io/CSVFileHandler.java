package com.ben.mobile.automation.appium_automation.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ben.mobile.automation.appium_automation.mobile.UIElement;

public class CSVFileHandler {
	String csvFile;
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";
	private List<UIElement> uiElements = new ArrayList<UIElement>();

	private String read(String fileName) throws IOException {
		File f = new File("src");
		f = new File(f, "locators");
		f = new File(f, fileName);
		String path = f.getAbsolutePath();
		return path;
	}

	public List<UIElement> readFileData(String fileName) {
		try {
			csvFile = read(fileName);
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] items = line.split(cvsSplitBy);
				uiElements.add(new UIElement(items[0], items[1], items[2]));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return uiElements;
	}
	 
}
