package com.crm.qa.testcases;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.testBase;
import com.crm.qa.pages.companiesPage;
import com.crm.qa.pages.homePage;
import com.crm.qa.pages.loginPage;
import com.crm.qa.utilities.testUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class companiesTest extends testBase{
	loginPage loginpage ;
	homePage homepage; 
	companiesPage comptest; 
	ExtentReports report;
	ExtentTest test; 
	boolean res; 
	
	public companiesTest(){
		super(); 
	}
	
	
	@BeforeMethod
	public void init(){
		initialization();	
		loginpage = new loginPage(); 
		homepage = loginpage.loginToApp(prop.getProperty("username"), prop.getProperty("password")); 
	}
	
	@Test(priority=1)
	public void createAddCompany(){
		report = testUtil.getInstance();
		test = report.startTest("Add the Company"); 
		comptest = homepage.clickonCompanies(); 
		//get the test data 
		HashMap <String, String> data = null; 
		data = testUtil.gettestdata("forms","companiestest"); 
		System.out.println(data.get("name"));
		
		//comptest.AddCompanies("ashwin", "automation", "Low", "D:\\pics\\New folder\food.jpg");	
		comptest.AddCompanies(data.get("name"), data.get("desp"), data.get("prio"), prop.getProperty("imgPath"));	
			
				test.log(LogStatus.PASS, "Company Added Successfully");
				testUtil.takeScreenShot(driver, test);
			
		driver.findElement(By.xpath("//body/div[@id='ui']/div[@class='ui fluid container']/div[@class='ui fluid container']/div[@id='top-header-menu']/div[@class='right menu']/div[@class='ui buttons']/div[@class='ui basic button floating item dropdown']/i[1]")).click();
		testUtil.explicitwaitsforelem(driver, "//span[contains(text(),'Log Out')]");
		driver.findElement(By.xpath("//span[contains(text(),'Log Out')]")).click();
		report.endTest(test);
		report.flush();
	}
	
	@Test(priority=2)
	public void deleteAllCreatedCompanies(){
		report = testUtil.getInstance();
		test = report.startTest("Delete the Company"); 
		comptest = homepage.clickonCompanies(); 
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
		}
		comptest.deleteCompanies("test");
		test.log(LogStatus.PASS, "Deleted Successfully");
		testUtil.takeScreenShot(driver, test);
		report.endTest(test);
		report.flush();
	}
	
	@AfterMethod
	public void tearDown(){	
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
	

}
