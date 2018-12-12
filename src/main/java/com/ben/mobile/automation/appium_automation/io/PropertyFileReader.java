package com.ben.mobile.automation.appium_automation.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyFileReader {
    private Properties prop = new Properties();
    private InputStream input = null;
 
    public String getValue(String key) {
          
        String value=null;
        try {
 
            input = new FileInputStream("config.properties");
 
            // load a properties file
            prop.load(input);
             value = prop.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
    public PropertyFileReader() throws IOException {
    	
        input = new FileInputStream("config.properties");      
        // load a properties file
        prop.load(input);
    }
    
    public String getValue(Config configKey) {
    	String value="";
    	System.out.println("Config key: "+configKey);
		value=prop.getProperty(configKey.toString());
		System.out.println("Config Value: "+value);
		return value;
	}
}
