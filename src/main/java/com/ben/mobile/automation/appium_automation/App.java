package com.ben.mobile.automation.appium_automation;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.ben.mobile.automation.appium_automation.UICatalog.PageLocators.MainMenuLocators.MainMenuObjects;
import com.ben.mobile.automation.appium_automation.UICatalog.PageObjects.MainPageDemoApi;
import com.ben.mobile.automation.appium_automation.mobile.android.AndroidDevice;
import com.ben.mobile.automation.appium_automation.mobile.android.AndroidGestures;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class App {
	private static final Logger log = Logger.getLogger(App.class.getName());

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		System.out.println("Hello World!");
		
		
		
		//IOSDriver<IOSElement> diverInstance = null;
		try {
			AndroidDevice androidDevice = new AndroidDevice();
			//androidDevice.setDriverTimeout(60);
			AndroidDriver<AndroidElement>  driverInstance = androidDevice.getAndroidDriver();
			MainPageDemoApi mpda =new MainPageDemoApi(driverInstance);
			//String View= "//android.widget.TextView[@content-desc=\"Views\"]";
			AndroidElement view =mpda.findMenuElement(MainMenuObjects.Views);
			
			String extendableList = "//android.widget.TextView[@text='Expandable Lists']";
			
			log.debug(extendableList);			
			view.click(); 
			AndroidElement extendableListElm= driverInstance.findElementByXPath(extendableList);
			/*TouchAction t = new TouchAction(diverInstance);
			t.tap(tapOptions()
					.withElement(element(extendableListElm)))
						.perform();*/
			AndroidGestures g = new AndroidGestures(driverInstance);
			 
			g.tapByElement(extendableListElm);;
			AndroidElement  customAdapterElm = driverInstance.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']");
			customAdapterElm.click();
			AndroidElement peopleNameElm = driverInstance.findElementByXPath("//android.widget.TextView[@text='People Names']");
			g.pressByElement(peopleNameElm, 2);
			//Thread.sleep(2000);
			log.debug(driverInstance.findElementById("android:id/title").isDisplayed());
/*			MainMenuPage mmp = new MainMenuPage();
			IOSElement e = mmp.findMenuElement(MainMenuObjects.ActionSheets);
			e.click()
			mmp.goBack();
			Thread.sleep(2000);
			UIElement switchers = mmp.findUIElement(MainMenuObjects.Switches);
	        mmp.scrollToMainMenuObject(switchers);*/
			log.info("Done");
			
			

			 

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

	}
}
