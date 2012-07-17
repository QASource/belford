///////////////////Script Info //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Script Name:												ReusableActions
//What the script does/TestCase Description:				This java file has the reusable actions which will be reused in the scripts
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.qa.ReusableActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import com.qa.Functions.common.CommonUtils;
import com.qa.Functions.webdriver.UIEvents;


public class ReusableActions {	
	


	///////////////////accountSignup //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// This function allows new user to signup with the provided username, password and the city. 
	// This function accepts user name, password and city as arguments and signup the user.
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		public static void accountSignup(RemoteWebDriver driver, String EmailAdress, String Password, String City) throws Exception 
			{			
			driver.get(CommonUtils.readIni("Environment.ini", "URL"));
			 
				//Provide the Email address in username text box
				if(!(EmailAdress.isEmpty()))
						{
					UIEvents.type(driver, CommonUtils.readIni("Repository.ini", "txt_UserName"), EmailAdress);
						}
						
				
				//Provide the password in password text box	
				if(!(Password.isEmpty()))
				{
					UIEvents.type(driver, CommonUtils.readIni("Repository.ini", "txt_Password"), Password);
				}
				
				//choose the city from the drop down list
				if(!(City.isEmpty()))
				{
					UIEvents.select(driver, CommonUtils.readIni("Repository.ini", "select_City"), City);
				}
				
				//driver.findElementByXPath("//input[@value='Sign Up!']").click();
				//click the Sign up button
				UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "btn_Singup"));
				
						
			}		

		///////////////////accountSignin //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// This function allows new user to signin with the provided username and password.
		// This function accepts user name and password as arguments and signin the user.
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		
		public static void accountLogin(WebDriver driver, String EmailAdress, String Password) throws Exception 
		{
			driver.get(CommonUtils.readIni("Environment.ini", "URL"));
			
			//System is waiting for Login link
			UIEvents.waitForElement(driver, CommonUtils.readIni("Repository.ini","Lnk_BelLogin"));
			
			//System is clicking on Login link
			UIEvents.click(driver, CommonUtils.readIni("Repository.ini","Lnk_BelLogin"));
							
			//System is waiting for username field
			UIEvents.waitForElement(driver, CommonUtils.readIni("Repository.ini","Txt_Belusername"));
			
			//Provide the Email address in email text box
			if(!(EmailAdress.isEmpty()))
					{
				UIEvents.type(driver, CommonUtils.readIni("Repository.ini","Txt_Belusername"), EmailAdress);
					}
				
		
			//Provide the password in password text box			
			if(!(Password.isEmpty()))
			{
				UIEvents.type(driver, CommonUtils.readIni("Repository.ini","Txt_Belpassword"), Password);
			}
			
			//click the Sign in button
			UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "Btn_BelLogin"));
			
			//System is waiting for some time
			CommonUtils.waitForChangesToReflect(CommonUtils.toInt(CommonUtils.readIni("Environment.ini", "INTERVAL")));
			Assert.assertEquals("Dashboard | QAOnDemand", driver.getTitle());
		}	
	
		
		public static void accountLogout(WebDriver driver) throws Exception 
		{
			
			//System is waiting for Logout link
			UIEvents.waitForElement(driver, CommonUtils.readIni("Repository.ini","Lnk_BelLogout"));
			
			//System is clicking on Logout link
		    UIEvents.click(driver,CommonUtils.readIni("Repository.ini", "Lnk_BelLogout"));
			
		    //System is waiting for login link
			UIEvents.waitForElement(driver, CommonUtils.readIni("Repository.ini","Lnk_BelLogin"));
				}
			
			
			
				
}
	
	
