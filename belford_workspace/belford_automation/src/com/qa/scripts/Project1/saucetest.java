package com.qa.scripts.Project1;
import junit.framework.TestCase;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.URL;
import java.util.concurrent.TimeUnit;

	public class saucetest  extends TestCase {


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
	    public void testSauce() throws Exception {
	        this.driver.get("http://saucelabs.com/test/guinea-pig");
	        assertEquals("I am a page title - Sauce Labs",
	                     this.driver.getTitle());
	    }
		@AfterTest
	    public void tearDown() throws Exception {
	        this.driver.quit();
	    }
	}


