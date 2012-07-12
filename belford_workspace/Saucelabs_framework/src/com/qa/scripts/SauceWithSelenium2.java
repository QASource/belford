package com.qa.scripts;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.qa.Functions.common.*;
import com.thoughtworks.selenium.Selenium;

import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.*;

/**
 * @author QASource
 * @see The script is the set up script which contains the functions which needs to be executed before and after running each test case.
 *
 */
public class SauceWithSelenium2 {
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
		            DesiredCapabilities capabillities = new DesiredCapabilities("iexplore", "8", Platform.WINDOWS);
		            capabillities.setCapability("name", this.getClass().toString());
		            driver = new RemoteWebDriver(new URL(URL), capabillities);
				}	
					Selenium selenium = new WebDriverBackedSelenium(driver, CommonUtils.readIni("Environment.ini", "URL"));
					selenium.windowMaximize();
				}

		catch (Exception e){
			System.out.println("Could not define the driver");
		}	
		
		driver.get(CommonUtils.readIni("Environment.ini", "URL"));	
	}
	
	@Test
	public static void TestSelenium2()
	{
		driver.get(CommonUtils.readIni("Environment.ini", "URL"));
	  Assert.assertEquals("Cross browser testing with Selenium - Sauce Labs", driver.getTitle());
//	  CommonUtils.tcmsReport(1, 1, "p");
		
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