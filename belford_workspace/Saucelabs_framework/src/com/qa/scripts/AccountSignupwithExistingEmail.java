///////////////////Script Info //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Script Name:												AccountSignupWithExistingEmailAddress
//TestCase Summary: 										Verify that new user is unable to signup in application by providing some existing email address.
//What the script does/TestCase Description:				Following is what Scripts does
//															1. Calls the Reusable action signup a new user with some existing user's email address
//															2. After the reusable action it make sure that user does not get signed up.
//What script(s) should be run before this script:			N/A
//What script(s) should be run after this script:			N/A
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.qa.scripts;

import org.testng.annotations.*;
import org.testng.Assert;
import com.qa.Functions.common.CommonUtils;
import com.qa.Functions.webdriver.UIEvents;
import com.qa.ReusableActions.ReusableActions;

public class AccountSignupwithExistingEmail extends SetupScript {
	//This is the test cases to ensure that the user is able to signup with some existing email address
	@Test(description="TC_03_Verify that new user is unable to signup in application by providing some existing email address.", groups="SmokeTest")	
		public void accountSignupwithExistingEmail() throws Exception {
		
		//System is clicking on Signin/Signup link
		UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "lnk_Login_Singup"));
	
		//This sections calls the reusable action to signin application with the provided existing email, password and city.
		ReusableActions.accountSignup(driver, CommonUtils.readIni("TestData.ini", "Existing_Email"), CommonUtils.readIni("TestData.ini", "PASSWORD"), CommonUtils.readIni("TestData.ini", "CITY"));
		
		//System is waiting for seconds specified
		CommonUtils.waitForChangesToReflect(CommonUtils.toInt(CommonUtils.readIni("Environment.ini", "INTERVAL")));
		
		//System is ensuring that user does not get signe up with existing email address.
		Assert.assertNotNull(driver.isElementPresent(CommonUtils.readIni("Repository.ini", "ExistingEmailAddressMessage")));
	}		
		
}