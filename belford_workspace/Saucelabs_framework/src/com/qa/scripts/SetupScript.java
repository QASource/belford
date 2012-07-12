package com.qa.scripts;
import com.qa.Functions.common.*;

import org.testng.annotations.*;
import com.qa.setup.AndroidEmulatorSetup;
import com.qa.setup.AndroidUtilities;
import com.qa.Functions.webdriver.UIDriver;
/**
 * @author QASource
 *
 */
public class SetupScript {
	
	public static UIDriver driver;
	
	@BeforeSuite
	public void SetupEnvironment() throws Exception {
		CommonUtils.updateBuildParameter();
		AndroidEmulatorSetup obj = new AndroidEmulatorSetup();
		obj.setUpEnvironment();
		driver = new UIDriver();
	}
	
	@BeforeTest
	public void getDriver()
	{
		try{
			
			
			driver.openUrl(CommonUtils.readIni("Environment.ini", "URL"), CommonUtils.toInt(CommonUtils.readIni("Environment.ini", "DELAY")));
		}
		
		catch (Exception e){
			System.out.println("Could not get the driver");
		}
	}

	@AfterTest
	public void quitDriver() 
	{
		//System is waiting for seconds specified
		try{
			driver.openUrl(CommonUtils.readIni("Environment.ini","LogoutURL"), CommonUtils.toInt(CommonUtils.readIni("Environment.ini", "INTERVAL")));
		}
		catch (Exception e){
			System.out.println(" going to quit driver");
			 
			driver.close();
			driver.quit();
			
		}

	}
	
	@AfterSuite
	public static void stopEmulator () throws Exception {
		
		AndroidUtilities.stopEmulator();
		
	}
}
