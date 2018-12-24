package com.ben.mobile.automation.appium_automation.UICatalog.PageObjects;

import java.io.IOException;

import com.ben.mobile.automation.appium_automation.UICatalog.PageLocators.MainMenuLocators;
import com.ben.mobile.automation.appium_automation.UICatalog.PageLocators.MainMenuLocators.MainMenuObjects;
import com.ben.mobile.automation.appium_automation.mobile.UIElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MainPageDemoApi {
	private MainMenuLocators mainMenuLocators;
	private AndroidDriver<AndroidElement> diverInstance;
	

	public MainPageDemoApi(AndroidDriver<AndroidElement> driver) throws IOException {
		mainMenuLocators = new MainMenuLocators();
//		android = new AndroidDevice();
		diverInstance = driver;
	}
	public AndroidElement findMenuElement(MainMenuObjects mainMenuObjects) {
		UIElement element = mainMenuLocators.findObject(mainMenuObjects);
		AndroidElement androidElement = diverInstance.findElement(element.getLocator(), element.getFinder());
		return androidElement;
	}
	public void goBack() {
		diverInstance.navigate().back();
	}
}