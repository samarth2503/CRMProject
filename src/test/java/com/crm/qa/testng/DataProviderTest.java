package com.crm.qa.testng;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.util.ExcelReader;
import com.crm.qa.util.TestUtil;

public class DataProviderTest {
	
	WebDriver driver = null;
	XSSFWorkbook workbook=null;
	ExcelReader ex =null;
	XSSFSheet sheet = null;
	XSSFRow row = null;
	XSSFCellStyle style;
	XSSFCell cell=null;
	
	
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@DataProvider
	public Iterator<Object[]> getTestData()
	{
		ArrayList<Object[]> data = TestUtil.getdataFromExcel();
		return data.iterator();
	}
  
	
	@Test(dataProvider="getTestData")
	public void LoginTest(String username,String password) throws InterruptedException, FileNotFoundException
	{
		if(driver.findElement(By.xpath("//b[contains(text(),\"Jun 2, 2020\")]")).getText().equals("Jun 2, 2020"))
		{
			Thread.sleep(1000);
			driver.findElement(By.name("userName")).clear();
			driver.findElement(By.name("userName")).sendKeys(username);												// 
			Thread.sleep(1000);
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(password);											   // 
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@alt=\"Sign-In\"]")).click();
			Thread.sleep(1000);
			String filepth="D:\\Selenium WorkSpace\\FreeCRMTest\\src\\main\\java\\com\\crn\\qa\\util\\Excel_Utility.xlsx";
			try 
			{
				ex=new ExcelReader(filepth);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			
			for(int k =1;k<ex.getRowCount("UserDetails");k++)
			{
				if(driver.getTitle().equals("Find a Flight: Mercury Tours:"))
				{
					row = ex.getSheetName().getRow(k+1);

//					style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());  
//					style.setFillPattern(FillPatternType.BIG_SPOTS);
//					cell = row.createCell(2); 
					ex.setCellData("UserDetails", "Status", k+1, "Passed",filepth);

//					cell.setCellStyle(style);

					driver.findElement(By.xpath("//a[@href='mercurywelcome.php']")).click();

				}
				else {
					Thread.sleep(1000);
					row = ex.getSheetName().getRow(k+1);
					//				
//					style.setFillBackgroundColor(IndexedColors.RED.getIndex());  
//					style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
//					Thread.sleep(1000);
//					cell = row.createCell(2); 
					ex.setCellData("UserDetails", "Status", k+1, "Failed",filepth);
//					cell.setCellStyle(style);
					Thread.sleep(1000);
					driver.findElement(By.xpath("//a[@href='mercurywelcome.php']")).click();

				}
			}
		}
	}
}

