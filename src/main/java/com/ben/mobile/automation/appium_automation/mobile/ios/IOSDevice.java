package com.ben.mobile.automation.appium_automation.mobile.ios;

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

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class IOSDevice implements IMobileDriver {
	private IOSDriver<IOSElement> _iOSInstance;
	private AppiumSetup appium;
	private DesiredCapabilities cap;
	private ConfigurationHandler propertyReader;
	static Logger logger = Logger.getLogger(IOSDevice.class);
	public IOSDevice() throws IOException {
		appium = new AppiumSetup();
		cap = appium.getCapabiities();
		propertyReader = new ConfigurationHandler();
	}

	public IOSDriver<IOSElement> getIOSDriver() throws IOException {
		URL url = new URL(propertyReader.getValue(AppiumConfig.APPIUM_SERVER_URL));
		_iOSInstance = new IOSDriver<IOSElement>(url, cap);
		logger.debug("IOSDriver Driver Set with Capabilities");

		return _iOSInstance;
	}

	@Override
	public void scrollDown() {
		logger.debug("Scrolling Down Full Page in iOS...");
		JavascriptExecutor js = (JavascriptExecutor) _iOSInstance;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject);
	}

	@Override
	public void scrollElementToView(UIElement uiElement) {
		RemoteWebElement parent = (RemoteWebElement) _iOSInstance.findElement(By.className("XCUIElementTypeTable"));
		String parentID = parent.getId();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject = new HashMap<String, String>();
		scrollObject.put("element", parentID);
		String locator = uiElement.getLocator();
		String finder = uiElement.getFinder();
		System.out.println("Looking By: " + locator + " value: " + finder);
		logger.debug("Scrolling Down the element to the Page view iOS...");
		logger.debug("Looking By: "+locator+" value: "+finder);
		scrollObject.put(locator, finder);
		_iOSInstance.executeScript("mobile:scroll", scrollObject);
	}

	@Override
	public void setDriverTimeout(int seconds) {
		 logger.debug("Set Timeout to: "+seconds+"s");
		_iOSInstance.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
	public void goBack() {
		logger.debug("Navigating Back");
		_iOSInstance.navigate().back();
	}

}
