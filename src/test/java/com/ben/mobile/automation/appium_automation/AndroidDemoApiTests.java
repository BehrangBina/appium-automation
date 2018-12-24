package com.ben.mobile.automation.appium_automation;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.ben.mobile.automation.appium_automation.demoApi.TestCases;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AndroidDemoApiTests {
	TestCases testcase;

	@Before
	public void init() {
		testcase = new TestCases();
	}

	@Test
	public void clickView() {
		testcase.ClickViewMenu();
		testcase.tapExtendableListMenu();
		testcase.tapCustomAdapter();
		testcase.tapAndHoldPeopleNamesMenu();
	}
	@Test
	public void clokTest() {

		testcase.ClickViewMenu();
		testcase.tapOnDateWidget();
		testcase.tapOnInlineClock();
		try {
		testcase.SetClock(4, 35);
		testcase.back();
		testcase.tapOnInlineClock();
		testcase.SetClock(9, 5);
		}
		catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
	}
 

}
