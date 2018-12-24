package com.ben.mobile.automation.appium_automation.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigurationHandler {
	private static Logger logger = Logger.getLogger(ConfigurationHandler.class);
	private  String propertyFileName= "config_Android.properties";
    private Properties prop = new Properties();
    private InputStream input = null;
 
    
    public String getValue(AppiumConfig configKey) {
    	String value="";
    	System.out.println("Config key: "+configKey);
    	logger.debug("Config key: "+configKey);
		value=prop.getProperty(configKey.toString());
		System.out.println("Config Value: "+value);
		logger.debug("Config Value: "+value);
		return value;
	}
    
    public ConfigurationHandler() throws IOException {    	 
        input = new FileInputStream(this.propertyFileName);      
        // load a properties file
        logger.debug("Loading Property File...");
        prop.load(input);
    }

    
}
