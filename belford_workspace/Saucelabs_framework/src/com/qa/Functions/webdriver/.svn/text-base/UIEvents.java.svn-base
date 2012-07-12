package com.qa.Functions.webdriver;

import org.openqa.selenium.WebElement;
import com.qa.Functions.common.*;

public class UIEvents {
	
public static void click (UIDriver driver, String locator) throws Exception{
		System.out.println("Clicking " + locator);
		driver.waitForElement(locator).click();
		CommonUtils.waitForChangesToReflect(CommonUtils.toInt(CommonUtils.readIni("Environment.ini", "DELAY")));
		
		//Runtime r = Runtime.getRuntime();
		// r.freeMemory();
	}

	public static void doubleClick(UIDriver driver, String locator) throws Exception{
		driver.getElement(locator).click();
		driver.getElement(locator).click();
	}
	
	public static void type (UIDriver driver, String locator, String value) throws Exception {
		System.out.println("Enter into text box " + locator + " value: " + value);
		//System is waiting for seconds specified
		driver.waitForElement(locator).sendKeys(value);
		
/*		
		CommonUtils.waitForChangesToReflect(CommonUtils.toInt(CommonUtils.readIni("Environment.ini", "INTERVAL")));
		try
		{
		WebElement el = driver.waitForElement(locator);
		el.sendKeys(value);
		}
		catch(Exception e)
		{
			System.out.println("Element with Locator "+locator+" Not Found");
		}*/
	}
	
	public static void select (UIDriver driver, String locator, String value) throws Exception {
		System.out.println("Select value: " + value + " from dropdown with locator: " + locator);
		
		int index = locator.indexOf("=");
		String locatorType = locator.substring(0, index);
		String locatorValue = locator.substring((index + 1));
		
		if(locatorType.equalsIgnoreCase("xpath")){
			locatorValue = locatorValue + "/option[text()='" + value + "']";
			locator = locatorType + "=" + locatorValue;
		}else {
			locator = "xpath=//select[@" + locatorType + "='" + locatorValue + "']/option[text()='" + value + "']"; 
		}
		
		WebElement el = driver.getElement(locator);
		
		if(!el.isSelected()) {
			System.out.println("Currently not selected");
			el.setSelected();
		}
	}
	
	public static void check_checkbox (UIDriver driver, String locator) throws Exception {
		System.out.println("Check checkbox with locator: " + locator);
		//System is waiting for seconds specified
		WebElement el = driver.waitForElement(locator);
		if(!(el.isSelected()))
			{
				el.setSelected();
			}
		else
			{
				System.out.println("Check checkbox with locator: " + locator+" is already checked");
			}

	}
	
	public static void uncheck_checkbox (UIDriver driver, String locator) throws Exception {
		System.out.println("unCheck checkbox with locator: " + locator);
		//System is waiting for seconds specified
		WebElement el = driver.waitForElement(locator);
		if((el.isSelected()))
			{
				
				el.click();
				System.out.println("unChecked the checkbox with locator: " + locator);
			}
		else
			{
				System.out.println("Check checkbox with locator: " + locator+" is already un checked");
			}

	}

}
