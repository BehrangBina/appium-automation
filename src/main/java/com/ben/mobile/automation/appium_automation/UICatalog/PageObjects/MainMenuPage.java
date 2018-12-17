package com.ben.mobile.automation.appium_automation.UICatalog.PageObjects;

import java.io.IOException;

import com.ben.mobile.automation.appium_automation.UICatalog.PageLocators.MainMenuLocators;
import com.ben.mobile.automation.appium_automation.UICatalog.PageLocators.MainMenuLocators.MainMenuObjects;
import com.ben.mobile.automation.appium_automation.io.DeviceAndAppium;
import com.ben.mobile.automation.appium_automation.mobile.UIElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class MainMenuPage {
	private MainMenuLocators mainMenuLocators;
	private IOSDriver<IOSElement> diverInstance;
	DeviceAndAppium driver;

	public MainMenuPage() throws IOException {
		mainMenuLocators = new MainMenuLocators();
		driver = new DeviceAndAppium();
		diverInstance = driver.getDriver();
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
		driver.scrollElementToView(uiElement);
	}
	public void goBack() {
		driver.goBack();
	}
}
