package com.ben.mobile.automation.appium_automation.mobile.android;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import com.ben.mobile.automation.appium_automation.io.AppiumConfig;
import com.ben.mobile.automation.appium_automation.io.ConfigurationHandler;
import com.ben.mobile.automation.appium_automation.mobile.AppiumSetup;
import com.ben.mobile.automation.appium_automation.mobile.IMobileDriver;
import com.ben.mobile.automation.appium_automation.mobile.UIElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AndroidDevice implements IMobileDriver {
	private AppiumSetup appium;
	private DesiredCapabilities cap;
	private AndroidDriver<AndroidElement> _androidDriver;
	private ConfigurationHandler propertyReader;
	static Logger logger = Logger.getLogger(AndroidDevice.class);
	public AndroidDevice() throws IOException {
		appium = new AppiumSetup();
		cap = appium.getCapabiities();
		propertyReader = new ConfigurationHandler();
	}

	public AndroidDriver<AndroidElement> getAndroidDriver() throws IOException {
		URL url = new URL(propertyReader.getValue(AppiumConfig.APPIUM_SERVER_URL));
		logger.debug("Url set to: "+url.toString());
		_androidDriver = new AndroidDriver<AndroidElement>(url, cap);
		logger.debug("Android Driver Set with Capabilities");
		return _androidDriver;
	}
	public AndroidElement findAndroidElement(String locator, String finder) {
		locator=locator.toLowerCase();
		AndroidElement element = null;
		if(locator.equals("name")) {
			element = _androidDriver.findElementByName(finder);
		}
		logger.debug("serching for by: " + locator + " :: "+finder);
		return element;
	}
	public void goBack() {
		logger.debug("Navigating Back");
		_androidDriver.navigate().back();
	}

	@Override
	public void scrollDown() {
		logger.debug("Scrolling Down Full Page in android...");
		JavascriptExecutor js = (JavascriptExecutor) _androidDriver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll",scrollObject);		
	}

	@Override
	public void scrollElementToView(UIElement uiElement) {
		RemoteWebElement parent = (RemoteWebElement)
				_androidDriver.findElement(By.className("XCUIElementTypeTable"));
		String parentID = parent.getId();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
	    scrollObject = new HashMap<String, String>();
	    scrollObject.put("element", parentID);
	    String locator = uiElement.getLocator();
	    String finder =uiElement.getFinder();
	    System.out.println("Looking By: "+locator+" value: "+finder);
		logger.debug("Scrolling Down the element to the Page view android...");
		logger.debug("Looking By: "+locator+" value: "+finder);
	    scrollObject.put(locator, finder);
	    _androidDriver.executeScript("mobile:scroll", scrollObject);		
	}

	@Override
	public void setDriverTimeout(int seconds) {
		 logger.debug("Set Timeout to: "+seconds+"s");
		_androidDriver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		
	}
}
