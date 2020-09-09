package com.crn.qa.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Alerts {
	
	public static WebDriver driver = null;
	
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
		
		Thread.sleep(1000);
		
		boolean res=driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/button")).isDisplayed();
		
		try
		{
			Thread.sleep(1000);
			if(res)
			{
				driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[1]/button")).click();
			}
			else
			{
				System.out.println("No such Element");
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Inside catch");
			e.printStackTrace();
		}
		
		// To return text present in alertbox
		
		String text=driver.switchTo().alert().getText();
		Thread.sleep(1000);
		if(text.equals("I am an alert box!"))
		{
			// To Click on OK (use accept)
			driver.switchTo().alert().accept();
		}
		
		else
		{
			System.out.println("No such alert");
		}
		
		
	}

}
