package com.ben.mobile.automation.appium_automation.UICatalog.PageLocators;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ben.mobile.automation.appium_automation.io.CSVFileHandler;
import com.ben.mobile.automation.appium_automation.mobile.UIElement;

public class MainMenuLocators {
	private List<UIElement> uiElements;
	private CSVFileHandler csvFileHandler;
	static Logger logger = Logger.getLogger(MainMenuLocators.class);
	public MainMenuLocators() {
		csvFileHandler = new CSVFileHandler();
		uiElements = new ArrayList<UIElement>();
		uiElements=csvFileHandler.readFileData("MainMenuLocators.csv");
		logger.debug("Reading Data from MainMenuLocators.csv");
	}

	public UIElement findObject(MainMenuObjects mainMenuObjects) {
		logger.debug("Searching for"+ mainMenuObjects.toString() + " in csv data collection");
		UIElement as = uiElements
				  .stream()
				  .filter(el -> mainMenuObjects.toString().equals(el.getName()))
				  .findAny()
				  .orElse(null);
		return as;
	}
	public enum MainMenuObjects{
		ActionSheets,Sliders,TextView,Switches,Views,ExpandableLists,CustomAdapter,PeopleNames,DateWidgets,TwelveHour,InlineClock
	}
}
