package com.qa.Functions.webdriver;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.Functions.common.CommonUtils;

public class UIEvents{
	
public static void click (WebDriver driver, String locator) throws Exception{
		WebElement el=waitForElement(driver,locator);
		el.click();
		System.out.println("Clicked the Object");

		try
		{
			el.submit();
			System.out.println("Submitted the Object");
		}
		catch(Exception E)
		{

		}
		try
		{
			el.sendKeys("\n");
		}
		catch(Exception E)
		{
			
		}
}
		public static void click1 (WebDriver driver, String locator) throws Exception
		{
			System.out.println("Clicking " + locator);
			WebElement el;
			el = waitForElement(driver,locator);
			el.click();
		}
	
public static void doubleclick (WebDriver driver, String locator) throws Exception
	{
		click(driver, locator);
		click(driver, locator);
		
	}
	public static void type (WebDriver driver, String locator, String value) throws Exception {
		System.out.println("Enter into text box " + locator + " value: " + value);
		//System is waiting for seconds specified
		WebElement el=waitForElement(driver,locator);
		el.clear();
		el.sendKeys(value);
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
		
		WebElement el = getElement(driver,locator);
		
		if(!el.isSelected()) {
			System.out.println("Currently not selected");
			//el.setSelected();
			try{
			el.click();
			}
			catch(Exception E){
				el.click();
			}
			//Select dropDownList = Select(el);
			//dropDownList.selectByValue(value); 
		}
	}
	
	public static void check_checkbox (WebDriver driver, String locator) throws Exception {
		System.out.println("Check checkbox with locator: " + locator);
		//System is waiting for seconds specified
		WebElement el = waitForElement(driver,locator);
		if(!(el.isSelected()))
			{
			el.click();	
			//el.setSelected();
			}
		else
			{
				System.out.println("Check checkbox with locator: " + locator+" is already checked");
			}

	}
	
	public static void uncheck_checkbox (WebDriver driver, String locator) throws Exception {
		System.out.println("unCheck checkbox with locator: " + locator);
		//System is waiting for seconds specified
		WebElement el = waitForElement(driver,locator);
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
	public static WebElement waitForElement (WebDriver driver, String locator) throws Exception{
		
		int count = 1;
		int timeout = CommonUtils.toInt(CommonUtils.readIni("Environment.ini","TIMEOUT"));
		int interval= CommonUtils.toInt(CommonUtils.readIni("Environment.ini","INTERVAL"));
		WebElement el = null;
		boolean elementFound = false;
		while(count < timeout) 
		{
			el = isElementPresent(driver,locator);
			
			if(el!=null)
			{
				System.out.println("Element is found");
				elementFound=true;
				//el.click();
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
		return el;
	}
	public static WebElement getElement(WebDriver driver, String locator) {
		
		int index = locator.indexOf("=");
		String locatorType = locator.substring(0, index);
		String locatorValue = locator.substring((index + 1));
		WebElement el = null;
		
		if(locatorType.equalsIgnoreCase("link"))
		{
			try
			{
				el= driver.findElement(By.linkText(locatorValue));
			}
			catch (Exception e)
			{
				el=null;
			}
			
		}
		else if(locatorType.equalsIgnoreCase("class"))
		{
			try
			{
				el= driver.findElement(By.className(locatorValue));
			}
			catch (Exception e)
			{
				el=null;
			}
			
		}
		else if(locatorType.equalsIgnoreCase("tag"))
		{
			try
			{
				el= driver.findElement(By.tagName(locatorValue));
			}
			catch (Exception e)
			{
				el=null;
			}
			
		}
		else if(locatorType.equalsIgnoreCase("xpath")) 
		{
			try
			{
				el= driver.findElement(By.xpath(locatorValue));
			}
			catch (Exception e)
			{
				el=null;
			}
			
		}
		else if(locatorType.equalsIgnoreCase("name")) 
		{
			try
			{
				el= driver.findElement(By.name(locatorValue));
			}
			catch (Exception e)
			{
				el=null;
			}
			
		}
		else if(locatorType.equalsIgnoreCase("id"))		
		{
			try
			{
			el= driver.findElement(By.id(locatorValue));
			}
			catch (Exception e)
			{
				el=null;
			}
		}
		return el;
		
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
	public static void waitForChangesToReflect(int timeInSeconds){
		try {
			Thread.sleep((timeInSeconds * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

