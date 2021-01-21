package com.target.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.target.utils.ConfigsReader;
import com.target.utils.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends PageInit {

	public static WebDriver driver;

	public static WebDriver setup() {

		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);
		String headless = ConfigsReader.getProperty("headless");

		switch (ConfigsReader.getProperty("browser").toLowerCase()) {

		case "chrome":

			WebDriverManager.chromedriver().setup();
			ChromeOptions cOption = new ChromeOptions();
			if (headless.equalsIgnoreCase("true")) {
				cOption.setHeadless(true);
				driver = new ChromeDriver(cOption);
			} else {
				driver = new ChromeDriver();
			}

			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			throw new RuntimeException("Browser is not supported");

		}

		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(ConfigsReader.getProperty("url"));

		PageInit.initialize();
		return driver;

	}
	
	
public static void tearDown() {
	if(driver!=null) {
		driver.quit();
	}
}
	
	
	
	
	
}
