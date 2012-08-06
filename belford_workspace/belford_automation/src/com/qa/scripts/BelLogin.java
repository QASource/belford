///////////////////Script Info //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Script Name:												BelLogin
//TestCase Summary: 										Verify that new user is able to login to the application.
//What the script does/TestCase Description:				Following is what Scripts does
//															1. Calls the Reusable action to login a new user
//															2. In the reusable action it makes sure that user got logged in.
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

public class BelLogin extends Setup	{
   
	//This is the test cases to ensure that the user is able to login
    @Test(description="TC-378_Ensure that buyer is successfully able to log in to application and navigated to “Dashboard” page” page.", groups="SmokeTest")	
    public void test_BelLogin () throws Exception {
	try
    {
		//Reusable action to login to application
		ReusableActions.accountLogin(driver, CommonUtils.readIni("TestData.ini", "usrname"), CommonUtils.readIni("TestData.ini", "password"));
		//Update the pass result in TCMS
		CommonUtils.tcmsReport("TC-378", "p");
    }
    catch(Exception E)
    {
    //Update the fail result in TCMS
    CommonUtils.tcmsReport("TC-378", "f");
    }
  }
}

