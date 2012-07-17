/*
 * This class contains reusable actions to Login to qaondemand
 */


package com.qa.scripts.Project1;

import com.thoughtworks.selenium.Selenium;
import org.testng.annotations.*;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.qa.Functions.common.CommonUtils;
import com.qa.Functions.webdriver.UIEvents;
import com.qa.ReusableActions.ReusableActions;

import java.net.URL;


/**
 * @author QASource
 * @see The script is the demo script
 *
 */

public class BelLogin extends Setup	{
  //This is the test cases to ensure that the user is able to login
   @Test(description="TC_01_Verify that new user is able to login to application.", groups="SmokeTest")	
	
    public void test_BelLogin () throws Exception {

    //Reusable action to login to application
    ReusableActions.accountLogin(driver, CommonUtils.readIni("TestData.ini", "usrname"), CommonUtils.readIni("TestData.ini", "password"));
		
	//System is waiting for seconds specified
	CommonUtils.waitForChangesToReflect(CommonUtils.toInt(CommonUtils.readIni("Environment.ini", "INTERVAL")));	
    
    }	
	
}

