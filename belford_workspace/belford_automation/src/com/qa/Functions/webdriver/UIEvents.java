package com.qa.Functions.webdriver;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.Functions.common.CommonUtils;

public class UIEvents{
	
public static void click (WebDriver driver, String locator) throws Exception{
		WebElement we=waitForElement(driver,locator);
		we.click();
		System.out.println("Clicked the Object");

		try
		{
			we.submit();
			System.out.println("Submitted the Object");
		}
		catch(Exception E)
		{

		}
		try
		{
			we.sendKeys("\n");
		}
		catch(Exception E)
		{
			
		}
}
public static void clickElement (WebDriver driver, String locator) throws Exception
		{
			System.out.println("Clicking " + locator);
			WebElement we;
			we = waitForElement(driver,locator);
			we.click();
		}
public static void doubleclick (WebDriver driver, String locator) throws Exception
	{
		click(driver, locator);
		click(driver, locator);
		
	}
public static void type (WebDriver driver, String locator, String value) throws Exception {
		System.out.println("Enter into text box " + locator + " value: " + value);
		//System is waiting for seconds specified
		WebElement we=waitForElement(driver,locator);
		we.clear();
		we.sendKeys(value);
	}
public static void select (WebDriver driver, String locator, String value) throws Exception {
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
		
		WebElement we = getElement(driver,locator);
		
		if(!we.isSelected()) {
			System.out.println("Currently not selected");
			//we.setSelected();
			try{
			we.click();
			}
			catch(Exception E){
				we.click();
			}
			//Select dropDownList = Select(we);
			//dropDownList.selectByValue(value); 
		}
	}
public static void check_checkbox (WebDriver driver, String locator) throws Exception {
		System.out.println("Check checkbox with locator: " + locator);
		//System is waiting for seconds specified
		WebElement we = waitForElement(driver,locator);
		if(!(we.isSelected()))
			{
			we.click();	
			//we.setSelected();
			}
		else
			{
				System.out.println("Check checkbox with locator: " + locator+" is already checked");
			}

	}
public static void uncheck_checkbox (WebDriver driver, String locator) throws Exception {
		System.out.println("unCheck checkbox with locator: " + locator);
		//System is waiting for seconds specified
		WebElement we = waitForElement(driver,locator);
		if((we.isSelected()))
			{
				
				we.click();
				System.out.println("unChecked the checkbox with locator: " + locator);
			}
		else
			{
				System.out.println("Check checkbox with locator: " + locator+" is already un checked");
			}

	}
public static WebElement waitForElement (WebDriver driver, String locator) throws Exception{
		
		int count = 1;
		int timeout = CommonUtils.toInt(CommonUtils.readIni("Environment.ini","TIMEOUT"));
		int interval= CommonUtils.toInt(CommonUtils.readIni("Environment.ini","INTERVAL"));
		WebElement we = null;
		boolean elementFound = false;
		while(count < timeout) 
		{
			we = isElementPresent(driver,locator);
			
			if(we!=null)
			{
				System.out.println("Element is found");
				elementFound=true;
				//we.click();
				break;
			}
				//waitForChangesToReflect(interval);
				count += interval;
				System.out.println("Count" + count);
				CommonUtils.waitForChangesToReflect(interval);
			
		}
		
		if(!elementFound){
			throw new NoSuchElementException("Element with locator " + locator + " not found");
		}
		return we;
	}
public static WebElement getElement(WebDriver driver, String locator) {
		
		int index = locator.indexOf("=");
		String locatorType = locator.substring(0, index);
		String locatorValue = locator.substring((index + 1));
		WebElement we = null;
		
		if(locatorType.equalsIgnoreCase("link"))
		{
			try
			{
				we= driver.findElement(By.linkText(locatorValue));
			}
			catch (Exception e)
			{
				we=null;
			}
			
		}
		else if(locatorType.equalsIgnoreCase("class"))
		{
			try
			{
				we= driver.findElement(By.className(locatorValue));
			}
			catch (Exception e)
			{
				we=null;
			}
			
		}
		else if(locatorType.equalsIgnoreCase("tag"))
		{
			try
			{
				we= driver.findElement(By.tagName(locatorValue));
			}
			catch (Exception e)
			{
				we=null;
			}
			
		}
		else if(locatorType.equalsIgnoreCase("xpath")) 
		{
			try
			{
				we= driver.findElement(By.xpath(locatorValue));
			}
			catch (Exception e)
			{
				we=null;
			}
			
		}
		else if(locatorType.equalsIgnoreCase("name")) 
		{
			try
			{
				we= driver.findElement(By.name(locatorValue));
			}
			catch (Exception e)
			{
				we=null;
			}
			
		}
		else if(locatorType.equalsIgnoreCase("id"))		
		{
			try
			{
			we= driver.findElement(By.id(locatorValue));
			}
			catch (Exception e)
			{
				we=null;
			}
		}
		return we;
		
	}
public static WebElement isElementPresent (WebDriver driver, String locator) throws Exception {
		
		if(!validateLocator(driver, locator)){
			System.out.println("Invalid format for the locator. Format: locatorType=argument");
		}
		
		return getElement(driver, locator);
	}
public static boolean validateLocator(WebDriver driver, String locator) throws Exception{
		int index = locator.indexOf("=");
		if(index > 0){
			return true;
		}else {
			throw new Exception("Illegal format for the locator");
		}
	}
	
}

