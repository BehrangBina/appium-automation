package com.ben.mobile.automation.appium_automation.mobile;

import io.appium.java_client.ios.IOSElement;

public interface IDriver {
   public IOSElement findElement(String locator,String finder);
}
