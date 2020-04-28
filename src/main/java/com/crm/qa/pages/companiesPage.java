package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.testBase;
import com.crm.qa.utilities.testUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class companiesPage extends testBase {

	
	
	@FindBy (xpath="//button[contains(text(),'New')]")
	WebElement newBtn; 
	
	@FindBy (xpath="//div[@class='ui right corner labeled input']//input[@name='name']")
	WebElement nameset; 
	
	@FindBy (xpath="//textarea[@name='description']")
	WebElement descriptionset; 
	
	
	@FindBy (xpath = "//div[@name='priority']//i[@class='dropdown icon']")
	WebElement prioiconlclick; 
	
	@FindBy (xpath = "//span[text()='Low']")
	WebElement lowlinkclick;
	

	@FindBy (xpath="//button[text()='Save']")
	WebElement savebtn; 
	
	@FindBy (xpath = "//input[@name='image']")
	WebElement uploadlinkimage; 
	
	@FindBy (xpath ="//body/div[@id='ui']/div[@class='ui fluid container']/div[@class='ui fluid container']/div[@id='top-header-menu']/div[@class='right menu']/div[@class='ui buttons']/div[@class='ui basic button floating item dropdown']/i[1]")
	WebElement logoutbtn; 
	
	@FindBy (xpath ="//span[contains(text(),'Log Out')]")
	WebElement lgnlink; 
	
	@FindBy (xpath ="//button[@class='ui button']")
	WebElement deltebtn;
	
	@FindBy(xpath="//div/i[@class='settings icon']")
	WebElement settbtn;
	
	@FindBy(xpath="//span[text()='Log Out']")
	WebElement lgnoutbtn;
	
	public companiesPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void AddCompanies (String Name, String description, String priority, String imgPath ){
		//testUtil.explicitwaitsforelem(driver, "//button[contains(text(),'New')]");
		//Actions act = new Actions (driver); 
		//act.moveToElement(driver.findElement(By.xpath("//button[contains(text(),'New')]"))).click().build().perform();
		//newBtn.click();
		driver.findElement(By.xpath("//i[@class='edit icon']")).click();
		//testUtil.explicitwaitsforelem(driver, "///div[@class='ui right corner labeled input']//input[@name='name']");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().refresh();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().refresh();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nameset.sendKeys(Name);
		descriptionset.sendKeys(description);
		prioiconlclick.click();
		testUtil.explicitwaitsforelem(driver, "//span[text()='"+priority+"']");
		driver.findElement(By.xpath("//span[text()='"+priority+"']")).click();
		uploadlinkimage.sendKeys(imgPath);
		savebtn.click();
		testUtil.explicitwaitsforelem(driver, "//div[contains(text(),'Name')]");
		//return driver.findElement(By.xpath("//div[contains(text(),'Name')]")).isDisplayed(); 
	}
	
	
	
	public void deleteCompanies(String datatodele){
		//List<WebElement> delte  = driver.findElements(By.xpath("//i[@class='trash icon']")); 
		driver.navigate().refresh();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.navigate().refresh();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> delte  = driver.findElements(By.xpath("//table//tbody/tr")); 
		
		for (int i = 1 ; i<=delte.size();i++){
			String data = driver.findElement(By.xpath("//table//tbody/tr["+i+"]/td[2]")).getText(); 
				System.out.println(data);
				if (data.equals(datatodele)){
					driver.findElement(By.xpath("//td[text()='"+datatodele+"']//..//i[@class='trash icon']")).click();
					deltebtn.click();
					break;
				}
		}
		
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			settbtn.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lgnoutbtn.click();
	}
	
	

}
