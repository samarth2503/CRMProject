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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.crm.qa.config.*;
import com.crm.qa.util.Constants;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	private static Logger log= Logger.getLogger(TestBase.class);
	
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void Initalize(@Optional String browser,@Optional String url) throws InterruptedException
	{
		DesiredCapabilities dc; 
		ChromeOptions opt1 = new ChromeOptions();
		if(browser.equals(Constants.Chrome))
		{ 
			dc= new DesiredCapabilities();
//			opt1.setAcceptInsecureCerts(true);
			dc.setAcceptInsecureCerts(true);
			//opt1.addArguments("--headless");
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium WorkSpace\\CRMProject\\chromedriver.exe");
			driver= new ChromeDriver(dc);
		}
//		else if(browser.equals(browser))
//		{
//			
//		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(url);
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[conatins(@class,'img-responsive"))));
	}
	
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
