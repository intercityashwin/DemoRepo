package com.crm.qa.testcases;

import java.util.HashMap;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.testBase;
import com.crm.qa.pages.homePage;
import com.crm.qa.pages.loginPage;
import com.crm.qa.utilities.testUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class homePageTest extends testBase{
	
	loginPage loginPage; 
	homePage  homePage;  
	HashMap <String, String> dataval = null; 
	ExtentReports report;
	ExtentTest test; 
	
	public homePageTest(){
		super();                    // the super will execute the code in the constructor of the testBase
	}
	
	
	// login in each test case using the login method 
	// test cases should be independant of one another 
	// at the end of each test case tear down or close the browser 
	
	@BeforeMethod
	public void init(){
		initialization();	
		//report = testUtil.getInstance();
		//test = report.startTest("Home page Flow"); 
		loginPage = new loginPage();
		homePage = loginPage.loginToApp(prop.getProperty("username"), prop.getProperty("password")); 
	}
	
	//@Test
	//public void data(){
		//dataval = testUtil.gettestdata("forms", "homepagetest"); 
	//}
	
	
	//@DataProvider
	/*public Object [][] gettestcasedata(){
		Object data [][] = testUtil.gettestdata("forms"); 
		return data;
	}*/
	
	@Test(priority=1)
	public void fillformTest(){
		report = testUtil.getInstance();
		test = report.startTest("fill the Home Page Form for Test Data 1"); 
		
		HashMap<String,String> datava =  testUtil.gettestdata("forms","homepagetesttwo"); 
		homePage.fillform(datava.get("firstname"), datava.get("LastName"), datava.get("MiddleName"));	
		testUtil.takeScreenShot(driver, test);
		test.log(LogStatus.PASS, "Created with the Data1");
		
		report.endTest(test);
		report.flush();
	}
	
	@Test(priority=2)
	public void fillformTest2(){	
		report = testUtil.getInstance();
		test = report.startTest("fill the Home Page Form for Test Data 2"); 
		
		homePage.fillform ("Ashwin2", "Test2", "Test2");	
		testUtil.takeScreenShot(driver, test);
		test.log(LogStatus.PASS, "Created with the Data2");
		
		report.endTest(test);
		report.flush();
	}

	@AfterMethod
	public void teardown(){
		System.out.println("close");
		driver.quit();
		//report.endTest(test);
		//report.flush();
	}
	
}
