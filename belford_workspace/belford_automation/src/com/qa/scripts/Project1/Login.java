/*
 * This class contains reusable actions to Login to VCC admin portal and viewer portals.
 */


package com.qa.scripts.Project1;

import com.thoughtworks.selenium.Selenium;

import com.qa.Functions.common.*;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.qa.Functions.common.CommonUtils;
import com.qa.Functions.webdriver.UIDriver;
import com.qa.Functions.webdriver.UIEvents;
import org.openqa.selenium.*;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
//import org.apache.tools.ant.types.Environment;

public class Login 	{
 
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
	
	driver.get(CommonUtils.readIni("Environment.ini", "URL"));	
}

@Test


//	Utility_Functions utilityFunction = new Utility_Functions();
		//Function for login to admin portal
		
		public static void adminPortalLogin(WebDriver driver,String usrName, String password, String domainName) throws Exception
		{
			//Global Variables File
//			String globalVariableFile ="Global_variables.xml";
			
			
//			driver.get("http://10.1.204.87/adminportal/login.do");
//
//			driver.findElement(By.id("loginbox")).clear();
//			driver.findElement(By.id("loginbox")).sendKeys("admin@qumu.com");
//			driver.findElement(By.id("passwordbox")).clear();
//			driver.findElement(By.id("passwordbox")).sendKeys("password");
//			new select(driver.findElement(By.id("domainselect"))).selectByVisibleText("social_00");
//			driver.findElement(By.id("loginbutton")).click();
//
//			assertEquals("Log Out", driver.findElement(By.linkText("Log Out")).getText());
			
//			
//			
//			UIEvents.type(driver, CommonUtils.readIni("Repository.ini", "txt_UserName"), usrName);
			
			driver.get(CommonUtils.readIni("Environment.ini", "URL"));
			UIEvents.waitForElement(driver, CommonUtils.readIni("Repository.ini","Txt_UserName"));
			UIEvents.type(driver,CommonUtils.readIni("Repository.ini", "Txt_UserName"), usrName);
			UIEvents.type(driver,CommonUtils.readIni("Repository.ini", "Txt_password"), password);
			UIEvents.select(driver,CommonUtils.readIni("Repository.ini", "Drp_domain"), "label="+domainName);
			UIEvents.click(driver,CommonUtils.readIni("Repository.ini", "Btn_login"));
			UIEvents.waitForChangesToReflect(3000);
			UIEvents.waitForElement(driver, CommonUtils.readIni("Repository.ini","Txt_LogOut"));
//	public static void test_CVPviewerportallogin(Selenium sel) throws Exception
//	{
//		String globalVariableFile ="Global_variables.xml";
//		
//		Utility_Functions utilityFunction = new Utility_Functions();
//		String VAR_userEmailID = utilityFunction.GetValue(globalVariableFile, "VAR_userEmailID");
// 		//Viewer portal login password
//		String VAR_userPassword = utilityFunction.GetValue(globalVariableFile, "VAR_userPassword");
//		
//		sel.click(EnvObjectMap_Rep.Txt_ViewerUserLogin);
//		
//		sel.type(EnvObjectMap_Rep.Txt_ViewerUserLogin, VAR_userEmailID);
//		
//		sel.type(EnvObjectMap_Rep.Txt_ViewerPasswordLogin, VAR_userPassword);
//		sel.click(EnvObjectMap_Rep.Btn_loginSVP);
//		utilityFunction.waitForChangesToReflect();
//	}
		}
	
}
