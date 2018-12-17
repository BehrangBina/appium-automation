package com.ben.mobile.automation.appium_automation.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationHandler {
	private  String propertyFileName= "config_Android.properties";
    private Properties prop = new Properties();
    private InputStream input = null;
 
    
    public String getValue(Config configKey) {
    	String value="";
    	System.out.println("Config key: "+configKey);
		value=prop.getProperty(configKey.toString());
		System.out.println("Config Value: "+value);
		return value;
	}
    
    public ConfigurationHandler() throws IOException {    	 
        input = new FileInputStream(this.propertyFileName);      
        // load a properties file
        prop.load(input);
    }

    
}
