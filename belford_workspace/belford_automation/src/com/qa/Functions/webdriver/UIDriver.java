package com.qa.Functions.webdriver;
import java.net.MalformedURLException;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.android.AndroidDriver;

import com.qa.Functions.common.CommonUtils;

public class UIDriver extends RemoteWebDriver {
		
	public UIDriver() throws MalformedURLException {
		super();
	}
	
	public void openUrl(String URL, int url_load_time) throws Exception {		
		this.get(URL);
		CommonUtils.waitForChangesToReflect(url_load_time);
	}
	
	public WebElement waitForElement (String locator) throws Exception{
		
		int count = 1;
		int timeout = CommonUtils.toInt(CommonUtils.readIni("Environment.ini","TIMEOUT"));
		int interval= CommonUtils.toInt(CommonUtils.readIni("Environment.ini","INTERVAL"));
		WebElement el = null;
		boolean elementFound = false;
		while(count < timeout) 
		{
			el = isElementPresent(locator);
			if(el!=null)
			{
				System.out.println("Element is found");
				elementFound=true;
				//el.click();
				break;
			}
			else
			{
				System.out.println("Element is not found");
				//waitForChangesToReflect(interval);
				count += interval;
				System.out.println("Count"+count);
			}
			return(el);
			
			
		}
		
		if(!elementFound){
			throw new NoSuchElementException("Element with locator " + locator + " not found");
		}
		return el;
	}
	
	public WebElement getElement(String locator) {
		
		int index = locator.indexOf("=");
		String locatorType = locator.substring(0, index);
		String locatorValue = locator.substring((index + 1));
		
		if(locatorType.equalsIgnoreCase("link"))
		{
			return this.findElementByLinkText(locatorValue);
		}
		else if(locatorType.equalsIgnoreCase("class"))
		{
			return this.findElementByClassName(locatorValue);
		}
		else if(locatorType.equalsIgnoreCase("tag"))
		{
			return this.findElementByTagName(locatorValue);
		}
		else if(locatorType.equalsIgnoreCase("xpath")) 
		{
			return this.findElementByXPath(locatorValue);
		}
		else if(locatorType.equalsIgnoreCase("name")) 
		{
			return this.findElementByName(locatorValue);
		}
		else		
		{
			return this.findElementById(locatorValue);
		}
		
	}
	
	public WebElement isElementPresent (String locator) throws Exception {
		
		if(!validateLocator(locator)){
			System.out.println("Invalid format for the locator. Format: locatorType=argument");
		}
		
		return getElement(locator);
	}

	public boolean validateLocator(String locator) throws Exception{
		int index = locator.indexOf("=");
		if(index > 0){
			return true;
		}else {
			throw new Exception("Illegal format for the locator");
		}
	}
		
	public void waitForChangesToReflect(int timeInSeconds){
		try {
			Thread.sleep((timeInSeconds * 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
