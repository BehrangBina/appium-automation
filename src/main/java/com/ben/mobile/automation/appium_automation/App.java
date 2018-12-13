package com.ben.mobile.automation.appium_automation;

import java.io.IOException;
import java.net.MalformedURLException;
import com.ben.mobile.automation.appium_automation.UICatalog.PageObjects.MainMenuPage;
import com.ben.mobile.automation.appium_automation.io.DeviceAndAppium;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws MalformedURLException {
		System.out.println("Hello World!");

		DeviceAndAppium d;
		IOSDriver<IOSElement> diverInstance = null;
		try {
			d = new DeviceAndAppium();
			diverInstance = d.getDriver();
			MainMenuPage mmp = new MainMenuPage(diverInstance);
			IOSElement e=mmp.ActionSheet();
			e.click();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		  
		}

	}
}
