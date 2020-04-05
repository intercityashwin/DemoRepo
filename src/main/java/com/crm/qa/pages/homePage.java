package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.testBase;
import com.crm.qa.utilities.testUtil;

public class homePage extends testBase {
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//span[contains(text(),'Home')]")
	WebElement homelink;
	
	@FindBy(xpath="//span[contains(text(),'Forms')]")
	WebElement fromlink;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	WebElement newLinkbtn;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement nameset;
	
	@FindBy(name="intro")
	WebElement introset;
	
	@FindBy(name="outro")
	WebElement compset;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement savebtn;
	
	@FindBy(xpath="//div/i[@class='settings icon']")
	WebElement settbtn;
	
	@FindBy(xpath="//span[text()='Log Out']")
	WebElement lgnoutbtn;
	
	public homePage(){
		PageFactory.initElements(driver, this); 
	}
	
	// fill in the form 
	public void fillform(String nameText, String introText, String compText) {
		fromlink.click();
		newLinkbtn.click();
		nameset.sendKeys(nameText);
		introset.click();
		introset.sendKeys(introText);
		compset.click();
		compset.sendKeys(compText);
		savebtn.click();
		homelink.click();
		fromlink.click();
		settbtn.click();
		lgnoutbtn.click();
	}
	
	
	public void waitFunc() throws InterruptedException{
		Thread.sleep(50);
	}
	
	public contactsPage navigateContacts(){
		contactslink.click();
		return new contactsPage(); 
		
	}

}
