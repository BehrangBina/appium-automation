package com.ben.mobile.automation.appium_automation.demoApi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;

import com.ben.mobile.automation.appium_automation.UICatalog.PageLocators.MainMenuLocators.MainMenuObjects;
import com.ben.mobile.automation.appium_automation.UICatalog.PageObjects.MainPageDemoApi;
import com.ben.mobile.automation.appium_automation.mobile.android.AndroidDevice;
import com.ben.mobile.automation.appium_automation.mobile.android.AndroidGestures;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TestCases {
	private AndroidDevice androidDevice;
	private static final Logger logger = Logger.getLogger(TestCases.class.getName());
	private AndroidDriver<AndroidElement> driverInstance;
	private AndroidGestures g;
	private MainPageDemoApi mpda;

	public TestCases() {
		try {
			androidDevice = new AndroidDevice();
			driverInstance = androidDevice.getAndroidDriver();
			mpda= new MainPageDemoApi(driverInstance);
			g= new AndroidGestures(driverInstance);
		}

		catch (Exception e) {
			// TODO: handle exception
			logger.error(e.getStackTrace(), e);
			e.printStackTrace();
		}
	}

	public void ClickViewMenu() {
		AndroidElement view =mpda.findMenuElement(MainMenuObjects.Views);
		logger.info("Clicking on: "+MainMenuObjects.Views);
		view.click(); 
	}
	public void tapExtendableListMenu() {
		AndroidElement el =mpda.findMenuElement(MainMenuObjects.ExpandableLists);
		logger.info("tapping"
				+ " on: "+MainMenuObjects.ExpandableLists);
		g.tapByElement(el);
	}
	public void tapCustomAdapter() {
		AndroidElement ca =mpda.findMenuElement(MainMenuObjects.CustomAdapter);
		logger.info("tapping"
				+ " on: "+MainMenuObjects.CustomAdapter);
		g.tapByElement(ca);
	}
	public void tapAndHoldPeopleNamesMenu() {
		AndroidElement pn =mpda.findMenuElement(MainMenuObjects.PeopleNames);
		logger.info("tapping"
				+ " on: "+MainMenuObjects.PeopleNames);
		g.pressByElement(pn, 2);
		assertTrue(driverInstance.findElementById("android:id/title").isDisplayed());
		logger.debug(driverInstance.findElementById("android:id/title").isDisplayed());
	}
	public void tapOnDateWidget() {
		AndroidElement dw = mpda.findMenuElement(MainMenuObjects.DateWidgets);
		logger.info("tapping"
				+ " on: "+MainMenuObjects.DateWidgets);
		g.tapByElement(dw);
	}
	public void tapOnInlineClock() {
		AndroidElement ic = mpda.findMenuElement(MainMenuObjects.InlineClock);
		logger.info("tapping"
				+ " on: "+MainMenuObjects.InlineClock);
		g.tapByElement(ic);
	}
	public void SetClock(int hour,int min) throws InterruptedException {
		int defaultHour=12;
		int defaultMin=15;
		String mainhour = 	"//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='"+defaultHour+"']";
		
		logger.info("main hour xpath:  " + mainhour);
		logger.debug(defaultHour+ " Displayer / Found : "+driverInstance.findElementByXPath(mainhour).isDisplayed() );
		AndroidElement mainhourElm = driverInstance.findElementByXPath(mainhour);
		//g.tapByElement(mainhourElm);
		String newHour="//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='"+hour+"']";
		logger.info("new hour xpath:  " + newHour);
		logger.debug(hour+ " Displayed / Found : "+driverInstance.findElementByXPath(newHour).isDisplayed() );
		AndroidElement newHourElm =driverInstance.findElementByXPath(newHour);
		logger.info("Swapping from "+ defaultHour + " to " +hour);
		g.swipeByElements(mainhourElm, newHourElm);
		Thread.sleep(300);
		String defaultMinXpath = "//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='"+defaultMin+"']";		
		logger.debug(defaultMin+ " selected : "+driverInstance.findElementByXPath(defaultMinXpath).isSelected() );
		AndroidElement defaultMinElm = driverInstance.findElementByXPath(defaultMinXpath);
		String newMin="//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc='"+min+"']";
		logger.debug(min+ " displayed : "+driverInstance.findElementByXPath(newMin).isDisplayed() );
		AndroidElement newMinElm = driverInstance.findElementByXPath(newMin);
		g.swipeByElements(defaultMinElm, newMinElm);
		
		AndroidElement hourDisplayed= driverInstance.findElementByXPath("//android.widget.TextView[@resource-id='android:id/hours']");
		String hourDisplayedTxt = hourDisplayed.getText();
		AndroidElement minDisplayed= driverInstance.findElementByXPath("//android.widget.TextView[@resource-id='android:id/minutes']");
		String minDisplayedTxt = minDisplayed.getText();
		logger.debug("Clock Displaying "+hourDisplayedTxt+":"+minDisplayedTxt);
		assertEquals(hourDisplayedTxt,Integer.toString(hour));
		String tmpMin = Integer.toString(min);
		
		if(tmpMin.length()==1) {tmpMin="0"+tmpMin;
		logger.debug("min to string="+tmpMin); }
		assertEquals(minDisplayedTxt,tmpMin);
	}
	public void back() {
		driverInstance.navigate().back();
	}
	public void close(){
		driverInstance.close();
	}
}
