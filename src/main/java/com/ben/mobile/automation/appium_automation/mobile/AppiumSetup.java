package com.ben.mobile.automation.appium_automation.mobile;

import java.io.IOException;

import org.openqa.selenium.remote.DesiredCapabilities;
import com.ben.mobile.automation.appium_automation.io.ApplicationPackageHandler;
import com.ben.mobile.automation.appium_automation.io.AppiumConfig;
import com.ben.mobile.automation.appium_automation.io.ConfigurationHandler;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumSetup {
	private ConfigurationHandler propertyReader  ;
    private DesiredCapabilities cap;
    private ApplicationPackageHandler app ;
	//static Logger logger = Logger.getLogger(AppiumSetup.class);

    public DesiredCapabilities getCapabiities() throws IOException {
    	  propertyReader = new ConfigurationHandler();
          cap = new DesiredCapabilities();
          app= new ApplicationPackageHandler();                   
          cap.setCapability(MobileCapabilityType.APP, app.getApplicationAbsolutePath());
          cap.setCapability(MobileCapabilityType.DEVICE_NAME, propertyReader.getValue(AppiumConfig.DEVICE_NAME));
          cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, propertyReader.getValue(AppiumConfig.PLATFORM_VERSION));
          cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, propertyReader.getValue(AppiumConfig.AUTOMATION_NAME));
          cap.setCapability(MobileCapabilityType.UDID, propertyReader.getValue(AppiumConfig.UDID));
          return cap;
    } 
}
