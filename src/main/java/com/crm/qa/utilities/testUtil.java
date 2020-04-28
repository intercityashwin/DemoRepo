package com.crm.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class testUtil {

	public static ExtentReports report = null; 
	public Object data [][]; 
	
	static Workbook book; 
	static Sheet sheet; 
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sht;

	public static ExtentTest test = null; 
	
	
	public static String ExcelFilePath = "D://Selenium Class//Pom//src//main//java//com//crm//qa//TestData/CRMTestData.xlsx"; 
	
	/*public static void main(String[] args) {
		HashMap<String,String> datava =  gettestdata("forms","homepagetesttwo"); 

		System.out.println(datava.get("Age"));
	}*/
	
	public static  HashMap<String,String> gettestdata(String SheetName, String TestcaseName){
		FileInputStream File = null; 
		HashMap<String,String> exceldata = null; 
		
		try {
			File = new FileInputStream(ExcelFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		try {
			book = WorkbookFactory.create(File);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		
		sheet = book.getSheet(SheetName); 
		
		for (int ro = 0 ; ro < sheet.getLastRowNum(); ro ++){
			String tcName = sheet.getRow(ro).getCell(0).toString().trim(); 
				if (tcName.equals(TestcaseName)){
					exceldata = new HashMap<String,String>(); 
					for (int col = 0;col<sheet.getRow(ro+1).getLastCellNum();col++){
						String keyname = sheet.getRow(ro+1).getCell(col).toString().trim(); 
						String keyvalue = sheet.getRow(ro+2).getCell(col).toString().trim(); 
						exceldata.put(keyname, keyvalue);
					}
					break; 
				};
		}
		
		return exceldata; 
	}
	
	
	// new code to read the data
	public static HashMap<String,String> getData(String TestCaseName, String Sheetname) {
		HashMap<String,String> data=null;

		try {
			FileInputStream fis=new FileInputStream(ExcelFilePath);
			wb=new XSSFWorkbook(fis);
			sht=wb.getSheet(Sheetname);
			//get row count
			int rowCount=sht.getLastRowNum();

			//loop to iterate on all rows
			for(int i=0;i<rowCount;i=i+4) {
				String ActTestCaseName=sht.getRow(i).getCell(0).getStringCellValue();
					if(TestCaseName.equals(ActTestCaseName)) {
						System.out.println(ActTestCaseName);
						int TCRowNo=i;//testcase number
						int TCColHeaderRowNo=i+1; //testcase col row number
						int TCDataRowNo=i+2;//testcase data row number
						//get cols depth
						int ColsCount=sheet.getRow(TCColHeaderRowNo).getLastCellNum();
						data=new HashMap<String,String>();
							for(int j=0;j<ColsCount;j++) {
								Cell ColHeaderCell=sht.getRow(TCColHeaderRowNo).getCell(j);
								String Key=getCellValue(ColHeaderCell);
								Cell ColDataCell=sht.getRow(TCDataRowNo).getCell(j);
								String Value=getCellValue(ColDataCell);
								//pupulate tc data into hashmap
								data.put(Key, Value);
								}
							break;
						}
				}

			}catch(Exception e) {
				e.printStackTrace();
				}
			return data;
		}

		public static String getCellValue(Cell c) {
			String value=null;
				/*switch (c.getCellType()) {

					case Cell.CELL_TYPE_STRING:
					value=c.getStringCellValue();
					break;

					case Cell.CELL_TYPE_NUMERIC:
					value = new BigDecimal(c.getNumericCellValue()).toPlainString();
					break;
		
					default:
					value=null;
					break;
				}*/
				return value;
		}
	
		// Takes Screen Shot
		public static void takeScreenShot(WebDriver driver,ExtentTest test){
			try {
				Date d = new Date(); 
				String timeStamp = d.toString().replace(" ", "_").replace(":","_");
				String screenShotPath = System.getProperty("user.dir")+"//screenshots//s_"+timeStamp+".png";
				TakesScreenshot snapshot = (TakesScreenshot)driver; 
				File f = snapshot.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(f, new File(screenShotPath));
				test.log(LogStatus.INFO, test.addScreenCapture(screenShotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
	
		}
		
	
	// get the instance of the Extend Report		
	public static ExtentReports getInstance(){
				
		if (report==null){
			Date d = new Date(); 
			String timeStamp = d.toString().replace(" ", "_").replace(":","_");
			String reportPath = System.getProperty("user.dir")+"//reports//r_"+timeStamp+".html";
			report = new ExtentReports(reportPath);
		}	
			return report; 
	}
	
	//webdriver explicit wait 
	
	public static void explicitwaitsforelem(WebDriver driver, String xpathValue){
		WebDriverWait wait = new WebDriverWait(driver,100); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathValue))); 
		
	}
		
	
}
