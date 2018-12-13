package com.ben.mobile.automation.appium_automation.mobile;

public class UIElement {
	private String locator;
	private String finder;
	private String name;

	public String getLocator() {
		return locator;
	}

	public void setLocator(String locator) {
		this.locator = locator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
 
	public String getFinder() {
		return finder;
	}

	public void setFinder(String finder) {
		this.finder = finder;
	}
 
	public UIElement(String name, String locator,String finder) {
		this.name= name;
		this.locator = locator;
		this.finder=finder;
	}




}
