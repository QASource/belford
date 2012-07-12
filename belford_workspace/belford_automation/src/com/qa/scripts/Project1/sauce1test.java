package com.qa.scripts.Project1;
import junit.framework.TestCase;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.URL;
import com.qa.Functions.webdriver.UIDriver;
import com.qa.Functions.webdriver.UIEvents;
import com.qa.Functions.common.CommonUtils;
import java.util.concurrent.TimeUnit;

	public class sauce1test extends TestCase {
		private WebDriver driver;
	@BeforeTest
	    public void setUp() throws Exception {
	        DesiredCapabilities capabillities = DesiredCapabilities.firefox();
	        capabillities.setCapability("version", "5");
	        capabillities.setCapability("platform", Platform.XP);
	        capabillities.setCapability("name", "Testing Selenium 2 with Java on Sauce");

	        this.driver = new RemoteWebDriver(
	           new URL("http://nicky:d7d84364-0b4a-41d7-bb5a-bff1ab346f7e@ondemand.saucelabs.com:80/wd/hub"),
	           capabillities);
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    }
	  @Test
	    public void Sauce1test() throws Exception {

			
		 driver.get(CommonUtils.readIni("Environment.ini", "URL"));
		 UIEvents.waitForElement(driver, CommonUtils.readIni("Repository.ini","Txt_UserName"));
		 UIEvents.type(driver,CommonUtils.readIni("Repository.ini", "Txt_UserName"), "admin@qumu.com");
		 UIEvents.type(driver,CommonUtils.readIni("Repository.ini", "Txt_password"), "password");
		 UIEvents.select(driver,CommonUtils.readIni("Repository.ini", "Drp_domain"), "label="+"social_00");
		 UIEvents.click(driver,CommonUtils.readIni("Repository.ini", "Btn_login"));
		 UIEvents.waitForChangesToReflect(3000);
		 UIEvents.waitForElement(driver, CommonUtils.readIni("Repository.ini","Txt_LogOut"));
		  
	    }
	    
	@AfterTest
	    public void tearDown() throws Exception {
	        this.driver.quit();
	    }
	}


