package com.ben.mobile.automation.appium_automation.io;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.ben.mobile.automation.appium_automation.mobile.IDriver;
import com.ben.mobile.automation.appium_automation.mobile.UIElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DeviceAndAppium implements IDriver{
	private ConfigurationHandler propertyReader  ;
    private DesiredCapabilities cap;
    private IOSDriver<IOSElement> _diverInstance;
    private AndroidDriver<AndroidElement> _androidDriver;
    public DeviceAndAppium() throws IOException {
        propertyReader = new ConfigurationHandler();
        cap = new DesiredCapabilities();
    }
    private void SetAppium() throws IOException {      
        ApplicationPackageHandler app = new ApplicationPackageHandler();
          
        cap.setCapability(MobileCapabilityType.APP, app.getApplicationAbsolutePath());
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, propertyReader.getValue(Config.DEVICE_NAME));
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, propertyReader.getValue(Config.PLATFORM_VERSION));
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, propertyReader.getValue(Config.AUTOMATION_NAME));
        cap.setCapability(MobileCapabilityType.UDID, propertyReader.getValue(Config.UDID));
        
    }
    public IOSDriver<IOSElement> getDriver() throws IOException {
    	SetAppium();
        URL url = new URL( propertyReader.getValue(Config.APPIUM_SERVER_URL));

    	_diverInstance = new IOSDriver<IOSElement>(url, cap);
    	return _diverInstance;
    }
    public AndroidDriver<AndroidElement> getAndroidDriver() throws IOException {
    	SetAppium();
        URL url = new URL( propertyReader.getValue(Config.APPIUM_SERVER_URL));
        _androidDriver = new AndroidDriver<AndroidElement>(url, cap);
    	return _androidDriver;
    }
    
	@Override
	public IOSElement findElement(String locator, String finder) {
		locator=locator.toLowerCase();
		IOSElement element = null;
		if(locator.equals("name")) {
			element = _diverInstance.findElementByName(finder);
		}
		return element;
	}
	public void goBack() {
		_diverInstance.navigate().back();
	}
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) _diverInstance;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll",scrollObject);
	}
	public void scrollElementToView(UIElement uiElement) {
		RemoteWebElement parent = (RemoteWebElement)
				_diverInstance.findElement(By.className("XCUIElementTypeTable"));
		String parentID = parent.getId();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
	    scrollObject = new HashMap<String, String>();
	    scrollObject.put("element", parentID);
	    String locator = uiElement.getLocator();
	    String finder =uiElement.getFinder();
	    System.out.println("Looking By: "+locator+" value: "+finder);
	    scrollObject.put(locator, finder);
	    _diverInstance.executeScript("mobile:scroll", scrollObject);
		
	}
	
}
