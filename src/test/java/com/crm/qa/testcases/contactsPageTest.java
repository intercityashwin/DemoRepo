package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.testBase;
import com.crm.qa.pages.contactsPage;
import com.crm.qa.pages.homePage;
import com.crm.qa.pages.loginPage;

public class contactsPageTest extends testBase {
	
	homePage homepage; 
	loginPage loginpage; 
	contactsPage cntspage; 
	
	public contactsPageTest(){
		super(); 
	}
	
	
	//@BeforeMethod
	public void logionApp(){
		initialization(); 
		loginpage = new loginPage();		
		homepage = loginpage.loginToApp(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	//@Test
	public void fillcontactformTest(){
		cntspage = homepage.navigateContacts(); 
		cntspage.fillcontPage("Ashwin","Rao");
	}
	
	//@AfterMethod
	public void tearDown(){               // close all the browser after the method 
		driver.quit();
		
	}
	
	
	
}
