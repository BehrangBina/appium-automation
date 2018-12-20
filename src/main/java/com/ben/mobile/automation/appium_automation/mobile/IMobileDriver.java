package com.ben.mobile.automation.appium_automation.mobile;

public interface IMobileDriver {
	public void scrollDown() ;
	public void scrollElementToView(UIElement uiElement) ;	
	public void setDriverTimeout(int seconds) ;
}
