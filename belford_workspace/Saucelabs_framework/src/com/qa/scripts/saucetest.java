package com.qa.scripts;
import junit.framework.TestCase;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.Functions.common.CommonUtils;
import com.thoughtworks.selenium.Selenium;

import java.net.URL;
import java.util.concurrent.TimeUnit;

	public class saucetest  extends TestCase {


		private WebDriver driver;
		@BeforeTest
	    public void setUp() throws Exception {
	        DesiredCapabilities capabillities = DesiredCapabilities.firefox();
	        capabillities.setCapability("version", "5");
	        capabillities.setCapability("platform", Platform.XP);
	        capabillities.setCapability("name", "Testing Selenium 2 with Java on Sauce");

	        this.driver = new RemoteWebDriver(
	           new URL("http://nicky:d7d84364-0b4a-41d7-bb5a-bff1ab346f7e@ondemand.saucelabs.com:80/wd/hub"),
	           capabillities);
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   
	        String URL;
			
			URL="http://"+CommonUtils.readIni("Environment.ini", "str_UserName")+":"+CommonUtils.readIni("Environment.ini", "str_access-key-string")+"@ondemand.saucelabs.com:80/wd/hub";
				
						Selenium selenium = new WebDriverBackedSelenium(driver, CommonUtils.readIni("Environment.ini", "str_AppURL"));
						selenium.windowMaximize();
						driver.get(CommonUtils.readIni("Environment.ini", "str_AppURL"));	
					}
			
	    @Test
	    public void testSauce() throws Exception {
	        this.driver.get(CommonUtils.readIni("Environment.ini", "str_AppURL"));
	        assertEquals("I am a page title - Sauce Labs",
	                     this.driver.getTitle());
	    }
		@AfterTest
	    public void tearDown() throws Exception {
	        this.driver.quit();
	    }
	}


