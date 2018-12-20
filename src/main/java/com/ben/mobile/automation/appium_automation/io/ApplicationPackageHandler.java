package com.ben.mobile.automation.appium_automation.io;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;

public class ApplicationPackageHandler {
	static Logger logger = Logger.getLogger(ApplicationPackageHandler.class);
    private String fileName ;
    private File f ;
    public ApplicationPackageHandler() throws IOException {
        f = new File("src");
        ConfigurationHandler propertyReader =new ConfigurationHandler();
        fileName= propertyReader.getValue(AppiumConfig.APPLICATION_NAME);
        logger.debug("Applicaion Name File Name: "+fileName);
    }
    public  String getApplicationAbsolutePath() {
         
        f= new File(f,fileName);
        String path = f.getAbsolutePath();
        logger.debug("Absolute Path of File: "+fileName);
        return path;
    }
}
