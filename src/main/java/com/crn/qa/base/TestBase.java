package com.crn.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.crm.qa.config.*;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	private static Logger log= Logger.getLogger(TestBase.class);
	
	public TestBase() throws IOException
	{
		
		
		try
		{
			prop=new Properties();
			FileInputStream f= new FileInputStream("D:\\Selenium WorkSpace\\CRMProject\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(f);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void initalization() throws InterruptedException
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\eclipse\\chromedriver.exe");	
			driver = new ChromeDriver(); 
			
		}
//		else if(browserName.equals("FF")){
//			System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");	
//			driver = new FirefoxDriver(); 
//		}

		driver.get("http://demo.guru99.com/test/newtours/");
		Thread.sleep(5);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	public WebElement getObject(String xpath)
	{
		try
		{
			return driver.findElement(By.xpath(xpath));
		}
		catch (Throwable t)
		{
			System.out.println(xpath + "Element not found");
			log.error(xpath+" "+"Element not found");
			t.printStackTrace();
			return null;
		}
	}
	
	public boolean insertText(String xpath,String key) throws InterruptedException
	{
		WebElement Ele= getObject(xpath);
		if(Ele.isDisplayed())
		{
			if(key.isEmpty())
			{
				System.out.println(xpath + "is Displayed and Enabled");
				log.info("Element is Displayed and Enabled");
				return true;
			}
			else
			{
				Ele.clear();
				Thread.sleep(5);
				Ele.sendKeys(key);
				return true;
			}
		}
		else
		{
			System.out.println(xpath + "is not Displayed and not Enabled");
			log.error(xpath + "is not Displayed and Enabled");
			return false;
		}
	}
	
	public boolean clickObject(String xpath)
	{
		WebElement element = getObject(xpath);
		element.click();
		log.info("Element is clicked");
		return true;
	}
	
	

}
