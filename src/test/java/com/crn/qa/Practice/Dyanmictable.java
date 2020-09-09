package com.crn.qa.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dyanmictable {
	
	public static WebDriver driver;
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		//System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, "true");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_WHITELISTED_IPS_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium WorkSpace\\CRMProject\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		
		DesiredCapabilities cap = new DesiredCapabilities();
		//cap.setAcceptInsecureCerts(true);
		//cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS ,true);
		
		ChromeOptions option = new ChromeOptions();
		option.setCapability(CapabilityType.ACCEPT_SSL_CERTS ,true);
		//option.merge(cap);
		
		driver = new ChromeDriver(option);
		
		driver.manage().timeouts().pageLoadTimeout(20l, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10l, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com/index.html");
		
		driver.findElement(By.name("username")).sendKeys("batchautomation");
		
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		
		driver.findElement(By.className("btn btn-small"));
		
		String path="//a[contains(text(),\"Contacts\")]";
		
		waitfroVisibility(driver,15,path);
		
		driver.findElement(By.xpath("//a[contains(text(),\"Contacts\")]")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//form[@id=\"vContactsForm\"]"));
		
		for(int i=4;i<13;i++)
		{
			String path1 = "//form[@id=\"vContactsForm\"]//tr["+i+"]//td[2]";
			String name = driver.findElement(By.xpath(path1)).getText();
			
			if(name.equals("AANVITH LST1"))
			{
				driver.findElement(By.xpath("//form[@id=\"vContactsForm\"]//tr["+i+"]//td[1]")).click();
				Thread.sleep(2000);
				break;
			}
		}
		
		driver.findElement(By.xpath("//form[@id=\"vContactsForm\"]//tr[4]//td[8]//a[4]")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		
		for(int j=4;j<=13;j++)
		{
			String txt=driver.findElement(By.xpath("//form[@id=\"vContactsForm\"]//tr["+j+"]//td[2]")).getText();
			System.out.println("The name is :-"+txt);
		}
		
		
	}
	
	public static void waitfroVisibility(WebDriver driver, int time,String xpath)
	{
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

}
