/*
 * This class contains reusable actions to Login to qaondemand
 */


package com.qa.scripts.Project1;

import com.thoughtworks.selenium.Selenium;
import org.testng.annotations.*;
//import org.testng.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.qa.Functions.common.CommonUtils;
//import com.qa.Functions.webdriver.UIEvents;
import com.qa.ReusableActions.ReusableActions;

import java.net.URL;


/**
 * @author QASource
 * @see The script is the demo script
 *
 */

public class BelLogout extends Setup 	{

 //This is the test cases to ensure that the user is able to login
   @Test(description="TC_02_Verify that user is able to logout from the application.", groups="SmokeTest")	
  
   public void test_BelLogout () throws Exception {

	//Reusable to login to application
	ReusableActions.accountLogin(driver, CommonUtils.readIni("TestData.ini", "usrname"), CommonUtils.readIni("TestData.ini", "password"));
	//Reusable to Logout from application
	ReusableActions.accountLogout(driver);
	
    }	
}

