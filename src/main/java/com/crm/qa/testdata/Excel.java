package com.crm.qa.testdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
 
import org.apache.poi.ss.usermodel.CellStyle;  
import org.apache.poi.ss.usermodel.FillPatternType;  
import org.apache.poi.ss.usermodel.IndexedColors; 
import com.crm.qa.testdata.*;


public class Excel {

	
	@SuppressWarnings("resource")
	public static void main(String args[]) throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ADMIN\\Desktop\\Apachae.po\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("1");
		
		String filepath="D:\\Selenium WorkSpace\\FreeCRMTest\\src\\main\\java\\com\\crn\\qa\\util\\Excel_Utility.xlsx";
		System.out.println("2");
		FileInputStream fo = new FileInputStream(filepath);
		System.out.println("3");
		
		XSSFWorkbook workbook= new XSSFWorkbook(fo);
		XSSFSheet sheet = null;
		System.out.println("4");
		XSSFRow row=null;
		System.out.println("5");
		XSSFCell cell=null;
		CellStyle style = workbook.createCellStyle();
		
		
		com.crm.qa.util.ExcelReader ex = new com.crm.qa.util.ExcelReader(filepath);
		
		ex.getSheetName();
		
		 
		
		sheet=workbook.getSheetAt(0);
		String s =sheet.getSheetName();
		System.out.println(s);
		System.out.println("9");
		boolean b = ex.isSheetExist(s);
		
		System.out.print(ex.getRowCount(s));
		if(b==true)
		{
			System.out.println("10");
			for(int k =1;k<=ex.getRowCount(s);k++)
			{
				if(driver.findElement(By.xpath("//b[contains(text(),\"May 31, 2020\")]")).getText().equals("May 31, 2020"))
				{
					Thread.sleep(1000);
					driver.findElement(By.name("userName")).sendKeys(ex.getCellData(s, "Username", k+1));												// 
					Thread.sleep(1000);
					System.out.println(ex.getCellData(s, "Password", k+1));
					driver.findElement(By.name("password")).sendKeys(ex.getCellData(s, "Password", k+1));															// 
					Thread.sleep(5000);
					driver.findElement(By.xpath("//input[@alt=\"Sign-In\"]")).click();
					Thread.sleep(1000);

					if(driver.getTitle().equals("Find a Flight: Mercury Tours:"))
					{
						row = ex.getSheetName().getRow(k+1);
						
						style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());  
						//style.setFillPattern(FillPatternType.BIG_SPOTS);
						cell = row.createCell(2); 
						ex.setCellData(s, "Status", k+1, "Passed",filepath);
					
						cell.setCellStyle(style);
						
						driver.findElement(By.xpath("//a[@href='mercurywelcome.php']")).click();

					}
					else {
						Thread.sleep(1000);
						row = ex.getSheetName().getRow(k+1);
//						
						  
						Thread.sleep(1000);
						cell = row.createCell(2); 
						ex.setCellData(s, "Status", k+1, "Failed",filepath);
						cell.setCellStyle(style);
						Thread.sleep(1000);
						driver.findElement(By.xpath("//a[@href='mercurywelcome.php']")).click();
				
					}
				}
			}
		}
//		Thread.sleep(1000);
//		workbook.close();
		
	}
}
