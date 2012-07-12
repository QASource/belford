package com.qa.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.Functions.common.CommonUtils;
import com.qa.ReusableActions.ReusableActions;

public class AccountSignInWithoutPassword extends SetupScript{
	
	@Test(description="TC_19_Verify that existing user is not able to signed into the  application without password.", groups="SmokeTest")	
	public void accountsigninwithoutpass() throws Exception 
	{

	//This sections calls the reusable action to signin application with the provided username and password
	ReusableActions.accountSignIn(driver, CommonUtils.readIni("TestData.ini", "UserName"),"");

	
	//System is ensuring whether the user got signed in or not
	Assert.assertNotNull(driver.getElement(CommonUtils.readIni("Repository.ini", "Sign_page")));
	}			

}
