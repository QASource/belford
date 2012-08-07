///////////////////Script Info //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Script Name:												Setup
//What the script does/TestCase Description:				This java file has the set up actions which will be used in the scripts before executing a test and after the test executed.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.qa.scripts;

import java.net.URL;
import com.qa.Functions.common.*;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import com.thoughtworks.selenium.Selenium;

/**
 * @author QASource
 *
 */

public class Setup {
     public static RemoteWebDriver driver;
	
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

	@AfterTest
	public void quitDriver() 
	{
		//System is closing the driver object
		try
		{
		System.out.print("going to quit driver");
		}
		catch (Exception e){
		 System.err.print(e);
					
		}finally
		{
		  driver.close();
		  driver.quit();	
		}

	}
	
	
}
