package com.wordpress.pagelayers;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.wordpress.base.TestBaseParallel;

public class Loginpage  extends TestBaseParallel{
	
	
	@FindBy(xpath = "//input[@id='user_login']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='user_pass']")
	WebElement password;
	
	
	@FindBy(xpath = "//input[@id='wp-submit']")
	WebElement submit;
	
	
	

	public Loginpage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public Dashboardpage validatelogin() {
		username.click();
		username.sendKeys(prop.getProperty("username1"));
		password.click();
		password.sendKeys(prop.getProperty("password1"));
		submit.click();
		return new Dashboardpage();
		
	}



	public boolean validateincorrectlogin1() {
		username.click();
		username.sendKeys(prop.getProperty("username2"));
		password.click();
		password.sendKeys(prop.getProperty("password2"));
		submit.click();
		String errmsg = driver.findElement(By.xpath("//div[@id='login_error']")).getText();
		String errmsg1 = "ERROR: The password you entered for the username opensourcecms is incorrect. Lost your password?";

		if(errmsg.contains(errmsg1))
			return true;
		else {
			return false;
		}

	}


	
	public boolean validateincorrectlogin2() {
		username.click();
		username.sendKeys(prop.getProperty("username3"));
		password.click();
		password.sendKeys(prop.getProperty("password3"));
		submit.click();
		return true;
	}


	

	public String validateLoginpageTitle() {
		String flag = driver.getTitle();
		return flag;

	}

	

	
	

	
	
	
	
	
	

	

}
