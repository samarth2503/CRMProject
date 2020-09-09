/* 3 stages of page 
 * 1> Loading
 * 2> Ready
 * 3> Interactive
 */

package com.crn.qa.Practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageLoading {
	
	public static WebDriver driver=null;
	
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Desktop\\chromedriver.exe");
		
		driver= new ChromeDriver();
		
		driver.get("http://learn-automation.com/handle-multiple-windows-in-selenium-webdriver/");
		
		for(int i=0;i<30;i++)
		{
			try {
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				
			}
			if(verifyLoading(driver))
			{
				System.out.println("Page is loaded");
				break;
			}
			else
			{
				System.out.println("Page is not loaded");
			}
			System.out.println("Wiating for "+i*60+" seconds");
		}
		
	}
	
	public static boolean verifyLoading(WebDriver driver)
	{
		boolean flag;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		flag=js.executeScript("return document.readyState").toString().equals("complete");
		return flag;
	}

}
