package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ddf.EscherColorRef.SysIndexSource;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UIPractice {

	public static void main(String[] args) throws InterruptedException {
		
		System.out.println(System.getProperty("user.dir")); 
		//System.setProperty("webdriver.chrome.driver","D://Selenium Class//Pom//drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();	
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://book.spicejet.com/");


		String mon = null;
		String day = null;
	
		mon = "August"; 
		day = "29"; 
		
		Thread.sleep(3000);
		Actions act = new Actions(driver); 
		act.moveToElement(driver.findElement(By.xpath("//a[@id='Login']"))).moveToElement(driver.findElement(By.xpath("//a[contains(text(),'SpiceClub Members')]"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Sign up')]")).click();
		
		/*
		
		Thread.sleep(3000);
		
		//driver.findElement(By.xpath("//div[@id='marketDate_1']//input[1]")).sendKeys("30/04");
		//JavascriptExecutor ex = (JavascriptExecutor) driver; 
		//WebElement datele = driver.findElement(By.xpath("//input[@id='date_picker_id_1']")); 
		
		//ex.executeScript("arguments[0].setAttribute('value','"+setdate+"');", datele); 
		//System.out.println("End of Test");
		
		driver.findElement(By.xpath("//div[@id='marketDate_1']//input[1]")).click();
		int flag =0; 
		do{
			flag =0; 
			String t1 = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//span[@class='ui-datepicker-month']")).getText(); 
			String t2 = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-last']//span[@class='ui-datepicker-month']")).getText(); 

			System.out.println(t1);
			System.out.println(t2);
			if (t1.equals(mon)){
				driver.findElement(By.xpath(" //div[@class='ui-datepicker-group ui-datepicker-group-first']//a[text()='"+day+"']")).click();
				break; 
			}
			if (t2.equals(mon)){
				driver.findElement(By.xpath(" //div[@class='ui-datepicker-group ui-datepicker-group-last']//a[text()='"+day+"']")).click();
				break; 
			}
			else {
				Thread.sleep(3000);
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
				flag=1; 
			}
		} while (flag==1); 
		 */
		
		//driver.quit();
		
		
		// fill the form
		WebElement ele = driver.findElement(By.xpath("//select[@id='CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_DropDownListTitle']"));
		
		Select sel = new Select(ele);
		sel.selectByVisibleText("MR");
		
		WebElement birthdateele = driver.findElement(By.xpath("//input[@id='CONTROLGROUPREGISTERVIEW_PersonInputRegisterView_TEXTBOXINPUTDOB']"));
		
		JavascriptExecutor ex = (JavascriptExecutor) driver; 
		ex.executeScript("arguments[0].setAttribute('value','"+"07/02/2001"+"');", birthdateele); 
		System.out.println("End of Test");
		
		
		driver.quit();
		
		Alert al = driver.switchTo().alert(); 
		al.accept();
		
		driver.quit();
		
		
		
		
	}

}
