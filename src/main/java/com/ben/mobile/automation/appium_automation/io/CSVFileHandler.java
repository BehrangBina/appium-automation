package com.ben.mobile.automation.appium_automation.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ben.mobile.automation.appium_automation.mobile.UIElement;

public class CSVFileHandler {
	static Logger logger = Logger.getLogger(CSVFileHandler.class);
	private String csvFile;
	private BufferedReader br = null;
	private String line = "";
	private String cvsSplitBy = ",";
	private List<UIElement> uiElements = new ArrayList<UIElement>();

	private String read(String fileName) throws IOException {
		logger.debug("Getting src Folder");
		File f = new File("src");
		logger.debug("Loading locators Folder");
		f = new File(f, "locators");
		logger.debug("loading File: "+ fileName);
		f = new File(f, fileName);
		String path = f.getAbsolutePath();
		return path;
	}

	public List<UIElement> readFileData(String fileName) {
		try {
			csvFile = read(fileName);
			logger.debug("Reading Data From: "+fileName);
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] items = line.split(cvsSplitBy);
				UIElement uiElement = new UIElement(items[0], items[1], items[2]);
				logger.debug("UIElement Added: " + uiElement);
				uiElements.add(uiElement);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getStackTrace());
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
					logger.error(e.getStackTrace());
				}
			}
		}
		return uiElements;
	}
	 
}
