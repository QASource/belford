package com.qa.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Functions.common.CommonUtils;
import com.qa.ReusableActions.ReusableActions;

public class AccountSignInwithoutUser extends SetupScript{
	
	@Test(description="TC_29_Verify that user is unable to sign in application without providing email address.", groups="SmokeTest")	
	public void accountsigninwithoutuser() throws Exception 
	{

	//This sections calls the reusable action to signin application with the provided username and password
	ReusableActions.accountSignIn(driver,"",CommonUtils.readIni("TestData.ini", "Password"));

	
	//System is ensuring whether the user got signed in or not
	Assert.assertNotNull(driver.getElement(CommonUtils.readIni("Repository.ini", "signin_withoutcredentialsuser")));
	}			


}
