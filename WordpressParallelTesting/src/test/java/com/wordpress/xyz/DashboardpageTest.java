package com.wordpress.xyz;



import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wordpress.base.TestBaseParallel;
import com.wordpress.pagelayers.Dashboardpage;
import com.wordpress.pagelayers.Loginpage;
import com.wordpress.utils.LoadingTime;


public class DashboardpageTest extends TestBaseParallel {

	Dashboardpage dashboardpage;
	Loginpage loginpage;

	Logger log = Logger.getLogger("Homepage");

	public DashboardpageTest() {
		super();
	}


	@BeforeMethod
	public void setUp() {
		intilization();
		log.info("The browser is getting launched");
		loginpage = new Loginpage();
		dashboardpage = loginpage.validatelogin();
		log.info("The url is getting fetched");
		
	}
	
	
	
	

	@Test
	public void validatecustomizeTest() {
		driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);
		dashboardpage.validatecustomizesite();
		log.info("Clicked on the  customize link");
		log.info("The page is redirected to Customized link");
	
		
	}



	@Test
	public void validatepostTest() throws Exception {
		driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);
		dashboardpage.validatePostmenu();
		log.info("Clicked on the post menu option present in side menu");
		log.info("The sub-optionns in post are getting displayed");
		
		
	}


	@Test 
	public void validatefirstenrtyTest() throws Exception {
		driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);
		dashboardpage.validatefirstentry();
		log.info("Clicked on the writing blog");
		log.info("The page is redirected to new writing blog");
		
	}


	@Test 

	public void validatecreatepageTest() {
		driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);
		dashboardpage.validatecreatePage();
		log.info("Clicked on the welcome add page");
		log.info("The page is redirected to welcome add page");
		
	}


	@Test(dependsOnMethods = {"validatecreatepageTest"})

	public void validatecommentsTest() {
		driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);
		dashboardpage.validateComments();
		log.info("Clicked on the Comments link");
		log.info("The page is redirected to comments page");
		
	}



	@AfterMethod

	public void tearDown() {
		log.info("The webdriver instance is ready to close");
	
		}
	

}
