package com.crn.qa.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class AlertWithTextBox {
	
	public static WebDriver  driver =null;
	
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Desktop\\chromedriver.exe");
		
		driver= new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Alerts.html");
		
		WebElement element1= driver.findElement(By.partialLinkText("SwitchTo"));

		Actions ac = new Actions(driver);
		
		ac.moveToElement(element1).build().perform();
		
		Thread.sleep(1000);
		
		WebElement subelement = driver.findElement(By.linkText("Alerts"));
		
		ac.moveToElement(subelement).click().build().perform();
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[3]/button")).click();
		
		Thread.sleep(1000);
		
		driver.switchTo().alert().sendKeys("Automation Testing");
		
		driver.switchTo().alert().accept();
		
		String Excepted = "Hello Automation Testing user How are you today";
		
		String Actual = driver.findElement(By.xpath("//p[@id=\"demo\"]")).getText();
		
		if(Excepted.equals(Actual))
		{
			System.out.println("Test is passed");
		}
		
		// 2nd Click
		
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[3]/button")).click();
		
			
		
	}

}
