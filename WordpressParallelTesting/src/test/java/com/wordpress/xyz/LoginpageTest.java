package com.wordpress.xyz;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.base.TestBaseParallel;
import com.wordpress.pagelayers.Dashboardpage;
import com.wordpress.pagelayers.Loginpage;
import com.wordpress.utils.LoadingTime;

public class LoginpageTest extends TestBaseParallel {

	Loginpage loginpage;
	Dashboardpage Dashboardpage;

	Logger log = Logger.getLogger("Loginpage");

	public LoginpageTest() {
		super();
	}

	
	
	@BeforeMethod
	public void setup() {
		driver.navigate().to("https://s1.demo.opensourcecms.com/wordpress/");
		log.info("The browser is intilalised and opened");
		loginpage = new Loginpage();
		log.info("fetching the website url");
		log.info("The login page is opened");
	}


	@Test
	public void validateloginTest() {
		Dashboardpage = loginpage.validatelogin();
		log.info("Given correct username and password");
		
	}



	@Test
	public void validateincorrectloginTest1() {
		driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);
		loginpage.validateincorrectlogin1();
		log.info("given correct username and incorrect password");
	}



	@Test
	public void validateincorrectloginTest2() {
		driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);
		loginpage.validateincorrectlogin2();
		log.info("given incorrect username and correct password");
	}



	@Test

	public void validatetitleTest() {
		driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);
		String flag = loginpage.validateLoginpageTitle();
		String flag1 = "Log In ‹ opensourcecms — WordPress";
		Assert.assertEquals(flag,flag1);
		log.info("The title of the page is"+ flag);

	}



	@AfterMethod
	public void teardown() {
		log.info("driver is ready to quit");
			}
	}





