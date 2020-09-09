package com.crn.qa.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthPopup {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ADMIN\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		
		String username="admin";
		String Password="admin";
		
		
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		Thread.sleep(4000);
		//Thread.sleep(5000);
		
//		String text = driver.findElement(By.xpath("//input[@value=\"Log In\"]")).getAttribute("id");
//		System.out.println("The test is :- "+text);
	}

}
