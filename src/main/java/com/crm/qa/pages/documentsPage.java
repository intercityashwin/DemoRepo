package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.testBase;

public class documentsPage extends testBase{
	
	@FindBy(xpath="//button[contains(text(),'New Folder')]")
	WebElement newLinkbtn;
	
	@FindBy(xpath="//input[@name='folderName']")
	WebElement newFolderLink; 
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement savebtnlink;
	
	@FindBy(xpath="//p[contains(text(),'Folder already exists')]")
	WebElement folexits;
	
	@FindBy(xpath="//button[@class='ui red button']")
	WebElement okbtn; 
	
	public documentsPage(){
		PageFactory.initElements(driver, this);
	}

	
	public void clickNewBtn(){
		newLinkbtn.click();
	}
	
	public void enterFolderName(String folderName){
		newFolderLink.sendKeys(folderName);
	}
	
	public void clickSavebtn(){
		savebtnlink.click();
	}
	
	public boolean verfiyFolderAdded(String name){
		boolean k = driver.findElement(By.xpath("//a[text()='"+name+"']")).isDisplayed(); 
			if (k==true){
				return true;
			}
			else
			{
				return false;
			}
		
	}
	
	public String isFolErrorDisplayed(){
		if (folexits.isDisplayed()){
			return "true";
		}
		else{
			return "false";
		}
	}
	
	public void clickOKbtn(){
		okbtn.click();
	}
	
}