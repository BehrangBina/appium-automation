package com.ben.mobile.automation.appium_automation;

import java.io.IOException;
import java.net.MalformedURLException;

import com.ben.mobile.automation.appium_automation.UICatalog.PageLocators.MainMenuLocators.MainMenuObjects;
import com.ben.mobile.automation.appium_automation.UICatalog.PageObjects.MainMenuPage;
import com.ben.mobile.automation.appium_automation.io.Config;
import com.ben.mobile.automation.appium_automation.io.ConfigurationHandler;
import com.ben.mobile.automation.appium_automation.io.DeviceAndAppium;
import com.ben.mobile.automation.appium_automation.mobile.UIElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;

public class App {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		System.out.println("Hello World!");

		DeviceAndAppium driver;
		//IOSDriver<IOSElement> diverInstance = null;
		try {
			driver = new DeviceAndAppium();
			AndroidDriver<AndroidElement>  diverInstance = driver.getAndroidDriver();
			
			
		 
		 
			
/*			MainMenuPage mmp = new MainMenuPage();
			IOSElement e = mmp.findMenuElement(MainMenuObjects.ActionSheets);
			e.click();
			mmp.goBack();
			Thread.sleep(2000);
			UIElement switchers = mmp.findUIElement(MainMenuObjects.Switches);
	        mmp.scrollToMainMenuObject(switchers);*/
			
			
			

			 

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

	}
}
