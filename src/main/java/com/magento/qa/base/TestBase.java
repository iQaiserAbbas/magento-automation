package com.magento.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.magento.qa.util.TestUtils;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		// this constructor is to read properties from config file
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Eclipse-workspace\\MagentoTest\\src\\main\\java\\com\\magento\\qa\\config\\config.properties");
			prop.load(ip);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() {
		Logger.getLogger("").setLevel(Level.OFF);
			
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			
			//added the below line because was facing error: Unable to establish websocket connection
			options.addArguments("--remote-allow-origins=*");

			driver = new ChromeDriver(options);		
		} 
		
		else if (browserName.equals("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			driver = new FirefoxDriver(options);
		}
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.IMPLICIT_WAIT));
		
		driver.manage().deleteAllCookies();

		driver.get(prop.getProperty("url"));
		
	}

}
