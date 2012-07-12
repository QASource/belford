///////////////////Script Info //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Script Name:												AccountSignup
//TestCase Summary: 										Verify that new user is able to sign up with application.
//What the script does/TestCase Description:				Following is what Scripts does
//															1. Calls the Reusable action signup a new user
//															2. After the reusable action it make sure that user got signed up.
//What script(s) should be run before this script:			N/A
//What script(s) should be run after this script:			N/A
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.qa.scripts;

import org.testng.annotations.*;
import org.testng.Assert;
import com.qa.Functions.common.CommonUtils;
import com.qa.Functions.webdriver.UIEvents;
import com.qa.ReusableActions.ReusableActions;

public class AccountSignup extends SetupScript {
	//This is the test cases to ensure that the user is able to signup
	@Test(description="TC_04_Verify that new user is able to sign up with application.", groups="SmokeTest")	
		public void accountSinghup() throws Exception {
		
		String str_EmailAddress;
		str_EmailAddress=CommonUtils.readIni("TestData.ini", "Email_User")+"_"+CommonUtils.readIni("Environment.ini","Build_Number")+"@"+CommonUtils.readIni("TestData.ini", "Email_Domain");
		
		//System is clicking on Signin/Signup link
		UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "lnk_Login_Singup"));
		
		//This sections calls the reusable action to signin application with the provided email, password and city.
		ReusableActions.accountSignup(driver, str_EmailAddress, CommonUtils.readIni("TestData.ini", "PASSWORD"), CommonUtils.readIni("TestData.ini", "CITY"));
		
		//System is waiting for seconds specified
		CommonUtils.waitForChangesToReflect(CommonUtils.toInt(CommonUtils.readIni("Environment.ini", "INTERVAL")));
		
		//System is ensuring whether the user got signed up or not
		Assert.assertNotNull(driver.isElementPresent(CommonUtils.readIni("Repository.ini","signupConfirmationMessage")));
		
	}		
		
}