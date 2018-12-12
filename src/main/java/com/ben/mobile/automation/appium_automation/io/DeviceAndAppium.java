package com.ben.mobile.automation.appium_automation.io;

import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DeviceAndAppium {
	private PropertyFileReader propertyReader  ;
    private DesiredCapabilities cap;
    public DeviceAndAppium() throws IOException {
        propertyReader = new PropertyFileReader();
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

    	IOSDriver<IOSElement> driver = new IOSDriver<IOSElement>(url, cap);
    	return driver;
    }
}
