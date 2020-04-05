package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.testBase;
import com.crm.qa.pages.homePage;
import com.crm.qa.pages.loginPage;
import com.crm.qa.utilities.testUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class loginTest extends testBase {
	
	loginPage loginPage; 
	homePage  homePage;             
	// create a home page class obj as the login will return this object 
	//define the constructor for the test case also 
	
	ExtentReports report;
	ExtentTest test; 
	
	
	public loginTest(){
		super();                    // the super will execute the code in the constructor of the testBase
	}
	
	@BeforeMethod
	public void init(){
		initialization();
		report = testUtil.getInstance();
		test = report.startTest("Login page Flow"); 
		loginPage = new loginPage();    //create an instance of the constructor for the login page 
	}
	
	
	//============= Write the test case steps here 
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		report = testUtil.getInstance();
		test = report.startTest("Verify the Title"); 
		String v = loginPage.validateLoginPageTitle(); 
		Assert.assertEquals(v, "Cogmento CRM");
		test.log(LogStatus.PASS, "Verify the Title");
		testUtil.takeScreenShot(driver, test);
	}
	
	@Test(priority=2)
	public void loginpageLoginActionTest(){             //this method in page class is returning the object for the home page
		report = testUtil.getInstance();
		test = report.startTest("Login to the Application"); 
		homePage = loginPage.loginToApp(prop.getProperty("username"), prop.getProperty("password")); 
		test.log(LogStatus.INFO, "Click Login Button");
		testUtil.takeScreenShot(driver, test);
	}
	
	
	//============
	
	@AfterMethod
	public void tearDown(){               // close all the browser after the method 
		driver.quit();
		report.endTest(test);
		report.flush();
	}
}