package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.testBase;
import com.crm.qa.utilities.testUtil;

public class homePage extends testBase {
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//button/i[contains(@class,'checkmark icon')]")
	WebElement delbutton; 
	
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
	
	@FindBy (xpath="//span[contains(text(),'Companies')]")
	WebElement  companieslink; 
	
	@FindBy (xpath="//span[contains(text(),'Documents')]")
	WebElement documentLink; 
	
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
	
	
	public void deleteEntries(){
		fromlink.click();
		//WebElement table = driver.findElement(By.xpath("//table[@class='ui celled sortable striped table custom-grid table-scroll']//tbody"));
		List<WebElement> thrashitems = driver.findElements(By.xpath("//i[@class='trash icon']")); 
		
		int siz = thrashitems.size(); 
		for (int i = 0 ;i< siz;i++){
			WebDriverWait wait = new WebDriverWait(driver,30); 
			WebElement hndl = thrashitems.get(i);
			hndl  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='trash icon']")));
			hndl.click();
			WebElement delbtn = driver.findElement(By.xpath("//button/i[contains(@class,'checkmark icon')]"));
			delbtn  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button/i[contains(@class,'checkmark icon')]")));
			delbtn.click();
		}
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
	
	public companiesPage clickonCompanies(){
		companieslink.click();
		return new companiesPage(); 
	}
	
	public documentsPage navigatetoDocuments(){
		testUtil.explicitwaitsforelem(driver, "//span[contains(text(),'Documents')]");
		documentLink.click();
		return new documentsPage(); 
	}

}
