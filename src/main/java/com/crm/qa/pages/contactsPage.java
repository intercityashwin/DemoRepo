package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.testBase;

public class contactsPage extends  testBase {
	
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newLinkbtndclk;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lstname;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement savebtn;
	
	@FindBy(xpath="//div/i[@class='settings icon']")
	WebElement settbtn;
	
	@FindBy(xpath="//span[text()='Log Out']")
	WebElement lgnoutbtn;
	
	public  contactsPage(){
		PageFactory.initElements(driver, this);
	}

	public void fillcontPage(String usrname, String lastname){
		newLinkbtndclk.click();
		
		//WebDriverWait wait = new WebDriverWait (driver, 500); 
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='first_name']")));
		
		
		firstname.sendKeys(usrname);
		lstname.sendKeys(lastname);
		savebtn.click();
		settbtn.click();
		lgnoutbtn.click();
	}
	
	
	
	
}
