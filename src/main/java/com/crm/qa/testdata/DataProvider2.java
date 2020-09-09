package com.crm.qa.testdata;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.util.HashMapUtility;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class DataProvider2 extends HashMapUtility{
	
	public static WebDriver driver;
	
	public DataProvider2() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","D:\\eclipse\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj = new Object[sheet.getLastRowNum()][1];
		
		HashMap<String,String> h = new HashMap<String,String>();
		
		int rows=sheet.getLastRowNum()+1;
		int cols= sheet.getRow(0).getLastCellNum();
		System.out.println(rows+" "+cols);
		for(int i=0;i<rows-1;i++)
		{
			for(int j=0;j<cols;j++)
			{
				System.out.println(j);
				System.out.println(sheet.getRow(0).getCell(j).getStringCellValue().toString());
				System.out.println(sheet.getRow(i+1).getCell(j).getStringCellValue().toString());
				h.put(sheet.getRow(0).getCell(j).getStringCellValue().toString(),sheet.getRow(i+1).getCell(j).getStringCellValue().toString());
			}
			System.out.println("I is:"+i);
			obj[i][0]=h;
		}
		
		return obj;
	}
	
	@Test(dataProvider="getData")
	public void Login(Map<Object,Object> m)
	{
//		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys((CharSequence[]) m.get("Username"));
//		driver.findElement(By.xpath("//input[@pass='password']")).sendKeys((CharSequence[]) m.get("Password"));
//		driver.findElement(By.xpath("//input[@name='login']")).click();
		System.out.println(m);
		System.out.println(m.get("Username"));
		System.out.println(m.get("Password"));
	}

}
