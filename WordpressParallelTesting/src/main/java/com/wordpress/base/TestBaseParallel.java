package com.wordpress.base;




import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.wordpress.utils.LoadingTime;

import io.github.bonigarcia.wdm.WebDriverManager;




public class TestBaseParallel {

	static String type = "Head";
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBaseParallel(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/wordpress/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	public static void intilization() {
		driver.manage().getCookies();
		driver.manage().deleteAllCookies();	
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);
	}
	
	
@Parameters("myBrowser")
@BeforeTest

	public static void getBrowser(String myBrowser) {


		if (type.contains("Headless")) {
			
			System.out.print("You selected to run the script with Headless ");

			if (myBrowser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_52);
				driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);
				
			}
			else if (myBrowser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new HtmlUnitDriver(BrowserVersion.CHROME);
				driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);
			}
				
			else if (myBrowser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER);
				driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);

			}

		}

		else {
			
			System.out.print("You selected to run the script with browser ");
			
			if (myBrowser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);
			}
			else if (myBrowser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);
			}
			else if (myBrowser.equalsIgnoreCase("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);
			}
		}

	}

	
@AfterTest
	public void closeBrowser() {
	driver.quit();
		}
	
}
