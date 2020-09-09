package com.crn.qa.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumExecutor {
	
	public static WebDriver driver;
	
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ADMIN\\Desktop\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		/* 1. driver.navigate.refresh()
		
		
		*/
		driver.get("https://www.facebook.com/");
		
		WebElement element = driver.findElement(By.xpath("//button[@name='login']"));
		
		//drawborder(element,driver);
		//generateAlert("This is facebook Alert",driver);
		//clickElementByJs(element,driver);
		//System.out.println("Text is "+getInnerText(driver));
		//changeColor("purple",element,driver);
		flash(element,driver);
	}
	
	public static void drawborder(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static void generateAlert(String message,WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickElementByJs(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void refreshByJS(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("history.go(0)");
	}
	
	public static String getTitleJS(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String Title=js.executeScript("return document.title;").toString();
		return Title;
	}
	
	public static String getInnerText(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String text=js.executeScript("return document.documentElement.innerText").toString();
		return text;
	}
	
	public static void ScrollDown(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void flash(WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String bgcolor = element.getCssValue("backgroundColor");
		for(int i=0;i<100;i++)
		{
			changeColor("rgb(0,200,0)",element,driver);
			changeColor(bgcolor,element,driver);
		}
		
	}
	
	public static void changeColor(String color,WebElement element,WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor='"+color+"'", element);
	}
	
}
