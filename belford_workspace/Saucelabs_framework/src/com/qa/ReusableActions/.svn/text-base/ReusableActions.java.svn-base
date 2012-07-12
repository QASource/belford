///////////////////Script Info //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Script Name:												ReusableActions
// What the script does/TestCase Description:				This java file has the reusable actions which will be reused in the scripts
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package com.qa.ReusableActions;

import com.qa.Functions.common.CommonUtils;
import com.qa.Functions.webdriver.UIEvents;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ReusableActions {

	///////////////////accountSignup //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// This function allows new user to signup with the provided username, password and the city. 
	// This function accepts user name, password and city as arguments and signup the user.
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		public static void accountSignup(RemoteWebDriver driver, String EmailAdress, String Password, String City) throws Exception 
			{			
			
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

		
		public static void accountSignIn(RemoteWebDriver driver, String EmailAdress, String Password) throws Exception 
		{

			//System is clicking on Signin/Signup link
			UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "lnk_Login_Singup"));
			
			//System is clicking on Signin button
			UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "btn_SingIn"));
			
			//Provide the Email address in email text box
			if(!(EmailAdress.isEmpty()))
					{
				UIEvents.type(driver, CommonUtils.readIni("Repository.ini", "txt_SigninEmail"), EmailAdress);
					}
					
			
			//Provide the password in password text box			
			if(!(Password.isEmpty()))
			{
				UIEvents.type(driver, CommonUtils.readIni("Repository.ini", "txt_SigninPassword"), Password);
			}
			
			//click the Sign in button
			UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "btn_SignInButton"));
			
			//System is waiting for some time
			CommonUtils.waitForChangesToReflect(CommonUtils.toInt(CommonUtils.readIni("Environment.ini", "INTERVAL")));
		}	
		
		///////////////////accountSignup //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// This function allows new user to signup with the provided username, password and the city. 
		// This function accepts user name, password and city as arguments and signup the user.
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			public static void updateProfile(RemoteWebDriver driver, String City, String ZipCode, String DealsCategory, String Gender) throws Exception 
				{				
					//Provide the City for the profile
					if(!(City.isEmpty()))
							{
								UIEvents.select(driver, CommonUtils.readIni("Repository.ini", "slect_Profile_City"), City);
							}
									
					//Provide the ZipCode in ZipCode text box	
					if(!(ZipCode.isEmpty()))
					{
						UIEvents.type(driver, CommonUtils.readIni("Repository.ini", "txt_Profile_Zip"), ZipCode);
					}
					
					//choose the city from the drop down list
					if(!(DealsCategory.isEmpty()))
					{
						UIEvents.select(driver, CommonUtils.readIni("Repository.ini", "select_Profile_DealCategory"), DealsCategory);
					}

					//choose the Gender from the drop down list
					if(!(Gender.isEmpty()))
					{
						UIEvents.select(driver, CommonUtils.readIni("Repository.ini", "select_Profile_Gender"), Gender);
					}
					//click the Save Profile button
					UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "btn_SaveProfile"));
				}		
			///////////////////accountSignup //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			// This function allows new user to signup with the provided username, password and the city. 
			// This function accepts user name, password and city as arguments and signup the user.
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				public static void addCard(RemoteWebDriver driver, String CardHolderName, String CardNumber, String ExpiryMonth, String ExpiryYear, String BillingZip) throws Exception 
					{
						
						//Provide the Email address in username text box
						if(!(CardHolderName.isEmpty()))
								{
							UIEvents.type(driver, CommonUtils.readIni("Repository.ini", "txt_CardHolderName"), CardHolderName);
								}
								
						
						//Provide the password in password text box	
						if(!(CardNumber.isEmpty()))
						{
							UIEvents.type(driver, CommonUtils.readIni("Repository.ini", "txt_CardNumber"), CardNumber);
						}
						
						//choose the city from the drop down list
						if(!(ExpiryMonth.isEmpty()))
						{
							UIEvents.select(driver, CommonUtils.readIni("Repository.ini", "select_CardExpiryMonth"), ExpiryMonth);
						}
					
						//choose the city from the drop down list
						if(!(ExpiryYear.isEmpty()))
						{
							UIEvents.select(driver, CommonUtils.readIni("Repository.ini", "select_CardExpirtYear"), ExpiryYear);
						}		
						
						//Provide the password in password text box	
						if(!(BillingZip.isEmpty()))
						{
							UIEvents.type(driver, CommonUtils.readIni("Repository.ini", "txt_BillingZip"), BillingZip);
						}
						
						//click the Sign up button
						UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "btn_CreatCard"));
					}				///////////////////accountSignup //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				// This function allows new user to signup with the provided username, password and the city. 
				// This function accepts user name, password and city as arguments and signup the user.
				/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

					public static void ResetPassword(RemoteWebDriver driver, String oldPassword, String NewPassword) throws Exception 
						{
						UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "btn_ResetPasswordButton"));
						//System is waiting for seconds specified
						CommonUtils.waitForChangesToReflect(CommonUtils.toInt(CommonUtils.readIni("Environment.ini", "INTERVAL")));
							//Provide the Email address in username text box
							if(!(oldPassword.isEmpty()))
									{
								UIEvents.type(driver, CommonUtils.readIni("Repository.ini", "txt_OldPassword"), oldPassword);
									}
									
							
							//Provide the password in password text box	
							if(!(NewPassword.isEmpty()))
							{
								UIEvents.type(driver, CommonUtils.readIni("Repository.ini", "txt_NewPassword"), NewPassword);
								UIEvents.type(driver, CommonUtils.readIni("Repository.ini", "txt_ConfirmPassword"), NewPassword);
							}
							
							//click the Sign up button
							UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "btn_ChangePassword"));
						}	
					
					public static void passwordMismatch(RemoteWebDriver driver, String oldPassword, String NewPassword,String confirmPassword) throws Exception 
					{
						UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "btn_ResetPasswordButton"));
						//System is waiting for seconds specified
						CommonUtils.waitForChangesToReflect(CommonUtils.toInt(CommonUtils.readIni("Environment.ini", "INTERVAL")));
						//Provide the Email address in username text box
						if(!(oldPassword.isEmpty()))
								{
							UIEvents.type(driver, CommonUtils.readIni("Repository.ini", "txt_OldPassword"), oldPassword);
								}
								
						
						//Provide the password in password text box	
						if(!(NewPassword.isEmpty())||!(confirmPassword.isEmpty()))
						{
							if(!(NewPassword.isEmpty()))
							{
							UIEvents.type(driver, CommonUtils.readIni("Repository.ini", "txt_NewPassword"), NewPassword);
							}
							if(!(confirmPassword.isEmpty()))
							{
							UIEvents.type(driver, CommonUtils.readIni("Repository.ini", "txt_ConfirmPassword"), confirmPassword);
							}
						}
						
						//click the Sign up button
						UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "btn_ChangePassword"));
					}	
				
					
					// This function allows new user to signup with the provided username, password and the city. 
					// This function accepts user name, password and city as arguments and signup the user.
					/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

						public static void RefineFilter(RemoteWebDriver driver, String City, String Category) throws Exception 
							{
									
								UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "btn_Refine"));

								if(!(City.isEmpty()))
										{
											UIEvents.select(driver, CommonUtils.readIni("Repository.ini", "select_RefineCity"), City);
										}
								//Provide the Email address in username text box
								if(!(Category.isEmpty()))
										{
									UIEvents.select(driver, CommonUtils.readIni("Repository.ini", "selecy_RefineCategory"), Category);
										}
								
								//system Clicks Update Button
								UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "btn_Update"));
							}	
			///////////////////accountSignup //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			// This function allows new user to signup with the provided username, password and the city. 
			// This function accepts user name, password and city as arguments and signup the user.
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
						public static void chooseCard(RemoteWebDriver driver,String existingCard) throws Exception 
						{				
							//choose the card from the drop down list
							if(!(existingCard.isEmpty()))
							{
								UIEvents.select(driver, CommonUtils.readIni("Repository.ini", "select_existingCard"), existingCard);
							}		
							
							//Provide the password in password text box	
						
						}
						
				public static void SignOut(RemoteWebDriver driver) throws Exception 			
					{	
							driver.get(CommonUtils.readIni("Environment.ini", "URL"));
							CommonUtils.waitForChangesToReflect(CommonUtils.toInt(CommonUtils.readIni("Environment.ini", "DELAY")));
							
							UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "btn_MyDeals"));
							
							//System clicks on the My Account button.
							UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "btn_MyAccount"));

							
							//System clicks on the My Account button.
							UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "btn_SignOut"));								
							

					}	
				
				
				public static void buyDeal(RemoteWebDriver driver) throws Exception 
				{
					
					
					try
					{
						//click on the Deal
						UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "select_existuserreadydeal"));
					}
					catch(Exception E)
					{
						UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "lnk_FeaturedDeal"));
					}
					 //Click on Buy now button
					UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "buy_now"));
							
					chooseCard(driver,CommonUtils.readIni("TestData.ini", "cardno"));
				    					
				    //Click on the  confirm Payment button
				    UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "confirm_payment"));
						
				}
				
		public static void buyDealWithoutSignup(RemoteWebDriver driver) throws Exception 
		{
			
			
			try
			{
				//click on the Deal
				UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "select_existuserreadydeal"));
			}
			catch(Exception E)
			{
				UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "lnk_FeaturedDeal"));
			}
			 //Click on Buy now button
			UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "buy_now"));
			
			String str_EmailAddress;
			str_EmailAddress=CommonUtils.readIni("TestData.ini", "Email_User")+"_"+CommonUtils.generateRandomNumber()+"@"+CommonUtils.readIni("TestData.ini", "Email_Domain");
		
			//This sections calls the reusable action to signin application with the provided email, password and city.
			ReusableActions.accountSignup(driver, str_EmailAddress, CommonUtils.readIni("TestData.ini", "PASSWORD"), CommonUtils.readIni("TestData.ini", "CITY"));
		
			UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "btn_AddCreditCard"));
		
			//System calls a reusable action to add card with the provided card details.
			ReusableActions.addCard(driver,CommonUtils.readIni("TestData.ini", "CardHolderName") , CommonUtils.readIni("TestData.ini", "CardNumber"), CommonUtils.readIni("TestData.ini", "ExpiryMonth"), CommonUtils.readIni("TestData.ini", "ExpiryYear"), CommonUtils.readIni("TestData.ini", "BillingZip"));
		    					
		    //Click on the  confirm Payment button
		    UIEvents.click(driver, CommonUtils.readIni("Repository.ini", "confirm_payment"));
				
		}
				
				public static void Redeem(RemoteWebDriver driver) throws Exception 
				{
					
					 
					 //Click on Deal
					 UIEvents.click(driver,CommonUtils.readIni("Repository.ini", "lnk_DealinReadyToUseSection"));
					 
					 //Click on Redeem button
					 UIEvents.click(driver,CommonUtils.readIni("Repository.ini", "btn_RedeemButton"));
					 
					 UIEvents.click(driver,CommonUtils.readIni("Repository.ini", "btn_YesRedeem"));
			
				
				
				}
				
				
				
				
}