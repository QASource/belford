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
import java.net.URL;


/**
 * @author QASource
 * @see The script is the demo script
 *
 */

public class BelLogin 	{
 
	public static WebDriver driver;

	
   @BeforeTest
   @Parameters({"browser"})

   public void getDriver(String browser)
   {
  
	String URL;
	
	URL="http://"+CommonUtils.readIni("Environment.ini", "str_SauceLabUser")+":"+CommonUtils.readIni("Environment.ini", "str_SauceLabUserKey")+"@ondemand.saucelabs.com:80/wd/hub";
		try{
			if(browser.equalsIgnoreCase("Firefox"))
			{
				DesiredCapabilities capabillities = new DesiredCapabilities("firefox", "4", Platform.VISTA);
	            capabillities.setCapability("name",this.getClass().toString());

	            driver = new RemoteWebDriver(new URL(URL), capabillities);
	         }
			if(browser.equalsIgnoreCase("IE"))
			{
	            DesiredCapabilities capabillities = new DesiredCapabilities("iexplore", "7", Platform.WINDOWS);
	            capabillities.setCapability("name", this.getClass().toString());
	            driver = new RemoteWebDriver(new URL(URL), capabillities);
			}	
				Selenium selenium = new WebDriverBackedSelenium(driver, CommonUtils.readIni("Environment.ini", "URL"));
				selenium.windowMaximize();
			}

	catch (Exception e){
		System.out.println("Could not define the driver");
	}	
	
	driver.get(CommonUtils.readIni("Environment.ini", "BelURL"));	
}

    @Test
    public void test_BelLogin () throws Exception {

	driver.get(CommonUtils.readIni("Environment.ini", "BelURL"));
	UIEvents.waitForElement(driver, CommonUtils.readIni("Repository.ini","Lnk_BelLogin"));
	UIEvents.click(driver,CommonUtils.readIni("Repository.ini", "Lnk_BelLogin"));
	UIEvents.waitForElement(driver, CommonUtils.readIni("Repository.ini","Txt_Belusername"));
	UIEvents.type(driver, CommonUtils.readIni("Repository.ini","Txt_Belusername"),"pkaur@qasource.com");
	UIEvents.type(driver, CommonUtils.readIni("Repository.ini","Txt_Belpassword"),"test123");
	UIEvents.click(driver,CommonUtils.readIni("Repository.ini", "Btn_BelLogin"));
		
    }	
	
    @AfterTest
	public static void quitDriver()
	{
		try
		{
			driver.close();
			driver.quit();
		}
		catch(Exception E)
		{

		}
	}
}

