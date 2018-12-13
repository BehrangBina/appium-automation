package com.ben.mobile.automation.appium_automation.mobile;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class DriverInstance implements IDriver{
	private IOSDriver<IOSElement> _diverInstance ;
	public DriverInstance(IOSDriver<IOSElement> diverInstance) {
		
		_diverInstance=diverInstance;
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
 
 

}
