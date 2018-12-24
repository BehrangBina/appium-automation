package com.ben.mobile.automation.appium_automation.UICatalog.PageObjects;

import java.io.IOException;

import com.ben.mobile.automation.appium_automation.UICatalog.PageLocators.MainMenuLocators;
import com.ben.mobile.automation.appium_automation.UICatalog.PageLocators.MainMenuLocators.MainMenuObjects; 
import com.ben.mobile.automation.appium_automation.mobile.UIElement;
import com.ben.mobile.automation.appium_automation.mobile.ios.IOSDevice;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class MainMenuPage {
	private MainMenuLocators mainMenuLocators;
	private IOSDriver<IOSElement> diverInstance;
	IOSDevice ios;

	public MainMenuPage() throws IOException {
		mainMenuLocators = new MainMenuLocators();
		ios = new IOSDevice();
		diverInstance = ios.getIOSDriver();
	}

	public IOSElement ActionSheet() {
		UIElement element = mainMenuLocators.findObject(MainMenuObjects.ActionSheets);
		IOSElement iosElement = diverInstance.findElement(element.getLocator(), element.getFinder());
		return iosElement;
	}

	public IOSElement Sliders() {
		UIElement element = mainMenuLocators.findObject(MainMenuObjects.Sliders);
		IOSElement iosElement = diverInstance.findElement(element.getLocator(), element.getFinder());
		return iosElement;
	}

	public IOSElement TextView() {
		UIElement element = mainMenuLocators.findObject(MainMenuObjects.TextView);
		IOSElement iosElement = diverInstance.findElement(element.getLocator(), element.getFinder());
		return iosElement;
	}

	public IOSElement findMenuElement(MainMenuObjects mainMenuObjects) {
		UIElement element = mainMenuLocators.findObject(mainMenuObjects);
		IOSElement iosElement = diverInstance.findElement(element.getLocator(), element.getFinder());
		return iosElement;
	}
	public UIElement findUIElement(MainMenuObjects mainMenuObjects) {
		UIElement element = mainMenuLocators.findObject(mainMenuObjects);
		return element;
	}
	public void scrollToMainMenuObject(UIElement uiElement) {
		ios.scrollElementToView(uiElement);
	}

	public void goBack() {
		ios.goBack();
	}
}
