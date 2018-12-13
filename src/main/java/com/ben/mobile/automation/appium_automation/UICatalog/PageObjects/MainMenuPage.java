package com.ben.mobile.automation.appium_automation.UICatalog.PageObjects;

import com.ben.mobile.automation.appium_automation.UICatalog.PageLocators.MainMenuLocators;
import com.ben.mobile.automation.appium_automation.UICatalog.PageLocators.MainMenuLocators.MainMenuObjects;
import com.ben.mobile.automation.appium_automation.mobile.DriverInstance;
import com.ben.mobile.automation.appium_automation.mobile.UIElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class MainMenuPage {
	private MainMenuLocators mainMenuLocators;
	DriverInstance diverInstance;
	public MainMenuPage(IOSDriver<IOSElement> diverInstance) {
		mainMenuLocators=new MainMenuLocators();
		this.diverInstance = new DriverInstance(diverInstance);
	
	}
   public  IOSElement ActionSheet() {
	 UIElement element=  mainMenuLocators.findObject(MainMenuObjects.ActionSheets);
	 IOSElement iosElement =  diverInstance.findElement(element.getLocator(), element.getFinder());
	 return iosElement;
   }
   
}
