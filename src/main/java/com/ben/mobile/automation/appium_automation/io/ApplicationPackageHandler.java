package com.ben.mobile.automation.appium_automation.io;

import java.io.File;
import java.io.IOException;

public class ApplicationPackageHandler {
    private String fileName ;
    private File f ;
    public ApplicationPackageHandler() throws IOException {
        f = new File("src");
        PropertyFileReader propertyReader =new PropertyFileReader();
        fileName= propertyReader.getValue(Config.APPLICATION_NAME);
    }
    public  String getApplicationAbsolutePath() {
         
        f= new File(f,fileName);
        String path = f.getAbsolutePath();
        return path;
    }
}
