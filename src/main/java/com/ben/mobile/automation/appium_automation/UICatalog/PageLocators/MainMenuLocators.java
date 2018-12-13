package com.ben.mobile.automation.appium_automation.UICatalog.PageLocators;

import java.util.ArrayList;
import java.util.List;

import com.ben.mobile.automation.appium_automation.io.CSVFileHandler;
import com.ben.mobile.automation.appium_automation.mobile.UIElement;

public class MainMenuLocators {
	private List<UIElement> uiElements;
	private CSVFileHandler csvFileHandler;

	public MainMenuLocators() {
		csvFileHandler = new CSVFileHandler();
		uiElements = new ArrayList<UIElement>();
		uiElements=csvFileHandler.readFileData("MainMenuLocators.csv");
	}

	public UIElement findObject(MainMenuObjects mainMenuObjects) {
		UIElement as = uiElements
				  .stream()
				  .filter(el -> mainMenuObjects.toString().equals(el.getName()))
				  .findAny()
				  .orElse(null);
		return as;
	}
	public enum MainMenuObjects{
		ActionSheets
	}
}
