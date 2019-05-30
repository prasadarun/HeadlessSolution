package com.wordpress.pagelayers;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wordpress.base.TestBaseParallel;
import com.wordpress.utils.LoadingTime;


public class Dashboardpage extends TestBaseParallel{
	
	Dashboardpage dashboardpage;
	
	
	

	
	@FindBy(partialLinkText = "Customize Your Site")
	WebElement customizebutton;

	@FindBy(linkText = "Write your first blog post")
	WebElement firstEntry;


	@FindBy(xpath = "//a[@class='welcome-icon welcome-add-page']")
	WebElement Createpage;


	@FindBy(linkText = "Turn comments on or off")
	WebElement Comments;



	public Dashboardpage() {
		PageFactory.initElements(driver, this);
	}



	public boolean validatecustomizesite() {
		driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);
		customizebutton.click();
		return true;

	}



	public boolean validatePostmenu() throws Exception {

		Actions actions = new Actions(driver);
		WebElement mainMenu = driver.findElement(By.xpath("//div[contains(text(),'Posts')]"));
		actions.moveToElement(mainMenu).perform();

		// for submenu
		WebElement subMenu = driver.findElement(By.xpath("//div[contains(text(),'Posts')]"));
		actions.moveToElement(subMenu).perform();
		boolean flag = subMenu.isDisplayed();
		return flag;

	}


	public boolean validatefirstentry() throws Exception {
		driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);
		firstEntry.click();
		return true;

	}


	public boolean validatecreatePage() {
		driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);
		Createpage.click();
		return true;

	}


	public boolean validateComments() {
		driver.manage().timeouts().implicitlyWait(LoadingTime.IMPLICT_WAIT, TimeUnit.SECONDS);
		Comments.click();
		
		return true;
	}
	
	


}
