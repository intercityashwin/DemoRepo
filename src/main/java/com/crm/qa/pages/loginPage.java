package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.testBase;

public class loginPage extends testBase {
	

	//Page factory - create the OR for this page 
	@FindBy(name="email")
	WebElement userid; 
	
	@FindBy(name="password")
	WebElement passwd; 
	
	@FindBy (xpath="//div[text()='Login']")
	WebElement lgnbutton; 
	
	
	// define a constructor and initialise all the elements 
	public loginPage(){
		PageFactory.initElements(driver, this);   //this means current class objects 
	}
	
	// define all the actions that are available for the above objects here 
	
	public String validateLoginPageTitle() {
		return driver.getTitle(); 
	}
	
	public homePage loginToApp(String un, String pass){
		userid.sendKeys(un);
		passwd.sendKeys(pass);
		lgnbutton.click();
		return new homePage(); 
	}
	
}
