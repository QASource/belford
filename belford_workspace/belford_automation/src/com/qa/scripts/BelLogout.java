///////////////////Script Info //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Script Name:												BelLogout
//TestCase Summary: 										Verify that user is able to log out from application.
//What the script does/TestCase Description:				Following is what Scripts does
//															1. Calls the Reusable action to login as a new user
//															2. Calls the Reusable action to log out from the application
//															3. In the reusable action it make sure that user has logged out.
//What script(s) should be run before this script:			N/A
//What script(s) should be run after this script:			N/A
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.qa.scripts;

import org.testng.annotations.*;
import com.qa.Functions.common.CommonUtils;
import com.qa.ReusableActions.ReusableActions;

/**
 * @author QASource
 * @see The script is the demo script
 *
 */

public class BelLogout extends Setup {

   //This is the test cases to ensure that the user is able to login
   @Test(description="TC-375_Ensure that User is successfully able to logout.", groups="SmokeTest")	
  
   public void test_BelLogout () throws Exception {
   try
	{
	   //Reusable to login to application
	   ReusableActions.accountLogin(driver, CommonUtils.readIni("TestData.ini", "usrname"), CommonUtils.readIni("TestData.ini", "password"));
	   //Reusable to Logout from application
	   ReusableActions.accountLogout(driver);
	   //Update the Pass result in TCMS
	   CommonUtils.tcmsReport("TC-375", "p");
    }
    catch(Exception E)
    {
    //Update the fail result in TCMS
    CommonUtils.tcmsReport("TC-375", "f");
    }	
  }

}