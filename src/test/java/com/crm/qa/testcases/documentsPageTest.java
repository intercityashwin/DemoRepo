package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.qa.base.testBase;
import com.crm.qa.customlistner.customlistner;
import com.crm.qa.pages.documentsPage;
import com.crm.qa.pages.homePage;
import com.crm.qa.pages.loginPage;
import com.crm.qa.utilities.testUtil;
import com.qa.ExtentReportListner.ExtentReportListner;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(customlistner.class)
public class documentsPageTest extends testBase {
	loginPage lgnPage;
	homePage hmePage; 
	documentsPage docPage; 
	ExtentReports report; 
	ExtentTest test;
	
	public documentsPageTest(){
		super(); 
	}

	
	@BeforeMethod
	public void init(){
		initialization();
		lgnPage = new loginPage(); 
		hmePage = lgnPage.loginToApp(prop.getProperty("username"), prop.getProperty("password")); 
		docPage = hmePage.navigatetoDocuments(); 
	}

	@Test
	public void docsPageTest(){
		report = testUtil.getInstance();
		test = report.startTest("Add a Folder to Documents"); 
		
		docPage.clickNewBtn();
		test.log(LogStatus.INFO, "Click on New Folder Button");
		
		docPage.enterFolderName("AutomationTester12");
		test.log(LogStatus.INFO, "Set the Value of the Folder Name");
		
		docPage.clickSavebtn();
		test.log(LogStatus.INFO, "Click on Save");
		
		String statuschk = docPage.isFolErrorDisplayed();
		
		if (statuschk == "true"){
			docPage.clickOKbtn();
			test.log(LogStatus.FAIL, "Folder Addition Failed !!!");
			testUtil.takeScreenShot(driver, test);
		}
		else{
			if (docPage.verfiyFolderAdded("AutomationTester12") == true){
				test.log(LogStatus.PASS, "Folder Added Succesfully");
				testUtil.takeScreenShot(driver, test);
			}
			else{
				test.log(LogStatus.FAIL, "Folder Addition Failed !!!");
				testUtil.takeScreenShot(driver, test);
			}
		}
		
		driver.findElement(By.xpath("//body/div[@id='ui']/div[@class='ui fluid container']/div[@class='ui fluid container']/div[@id='top-header-menu']/div[@class='right menu']/div[@class='ui buttons']/div[@class='ui basic button floating item dropdown']/i[1]")).click();
		testUtil.explicitwaitsforelem(driver, "//span[contains(text(),'Log Out')]");
		driver.findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
		test.log(LogStatus.INFO, "Logout the Application");
		
		report.endTest(test);
		report.flush();
	}
	
	@AfterMethod
	public void teardown(){
		System.out.println("Tear Down");
		driver.quit();
	}
	
}
