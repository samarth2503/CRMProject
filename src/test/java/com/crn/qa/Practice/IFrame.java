/* IFrame:- IFrame is an external html document which will be placed inside other html document 
 * 
 * driver.swicthTo().frame("name of iframe")    ---- switching focus parent iframe to child iframe. 
 * 
 * driver.switchTo().defaultContent()           ----- Switching focus from iframe to parent frame.
 * 
 * Right click and check wheather view frame source is avaialble if available then it is a iframe.
 * 
 * driver.switchTo().frame(index);              ------ switch to frame through index number
 * 
 * driver.switchTo().frame(WebElement element);   ---- switch to frame through Webelement
 * 
 * driver.swichTo().parentframe()                 ---- Switching from child frame to parent frame
 * 
 * */

package com.crn.qa.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrame {
	
	public static WebDriver driver = null;
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Desktop\\chromedriver.exe");
		
		driver= new ChromeDriver();
		
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_iframe_height_width");
		
		//driver.manage().timeouts().pageLoadTimeout(60l, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		// Switching to frame through index
		driver.switchTo().frame(1);
		
		try {
			
			Thread.sleep(2000);
			
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src=\"demo_iframe.htm\"]")));
			Thread.sleep(1000);
			String txt = driver.findElement(By.xpath("//h1")).getText();
			
			System.out.println("Content of child 2 Frmae is = "+txt);
			
			driver.switchTo().parentFrame();
			
			String txt1 = driver.findElement(By.xpath("//p")).getText();
			
			System.out.println("Content inside child1 frame is = "+txt1);
			
			driver.switchTo().defaultContent();
			int count = driver.findElements(By.tagName("iframes")).size();
			System.out.println("count is "+ count);
		}
		catch(Exception e)
		{
			System.out.println("Inside catch");
			System.out.println(e.getMessage());
		}
		
	}
	

}
