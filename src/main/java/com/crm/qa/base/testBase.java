package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class testBase {
	//initialize the driver 
	
	public static WebDriver driver; 
	public static Properties prop; 
	
	
	//define the constructor 	
	// this will be called as the super class from all the test cases 
	public testBase(){
		try {
			prop = new Properties(); 
			FileInputStream ip = new FileInputStream("D://Selenium Class//Pom//src//main//java//com//crm//qa//config/config.properties");
			try {
				prop.load(ip);
				System.out.println(prop.get("browser"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	// call this at the start of each of the test cases 
	public static void initialization(){
		String browserType = prop.getProperty("browser");
		System.out.println(browserType);
		
			//if (browserType.equals("chrome")){
				System.out.println("launch chrome");
				System.setProperty("webdriver.chrome.driver","D://Selenium Class//Pom//drivers/chromedriver.exe");
			//	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers/chromedriver.exe");
				
				driver = new ChromeDriver(); 
			//}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.MINUTES); 
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.MINUTES); 
			driver.get(prop.getProperty("url"));
			//driver.get(prop.getProperty("url"));
	}
	
	public static void passedlistner(){
		System.out.println("PASSED-->> LISTNER CALLED");
	}
	
	public static void failedlistner(){
		System.out.println("FAILED-->> LISTNER CALLED");
	}

	
}
