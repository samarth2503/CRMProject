package com.crn.qa.Practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class windowspopup {
	
	public WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.out.println("1");
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ADMIN\\Desktop\\samarth\\chromedriver.exe");
		try
		{
			driver=new ChromeDriver();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		driver.navigate().to("http://learn-automation.com/handle-multiple-windows-in-selenium-webdriver/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
//	@Test
//	public void windowpopupTest() throws InterruptedException
//	{
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[@class=\"at4win-header\"]//a")).click();
//		
//		Actions ac = new Actions(driver);
//		WebElement w1 = driver.findElement(By.xpath("//li[@class=\"dropdown\"][2]//a[contains(text(),\"Alerts & Modals\")]"));
//	
//		ac.moveToElement(w1).click();
//		ac.moveToElement(driver.findElement(By.xpath("//li[@class=\"dropdown\"][2]//a[contains(text(),\"Alerts & Modals\")]//following-sibling::ul[@class=\"dropdown-menu\"]//li[3]//a"))).click().build().perform();
//		
//		driver.findElement(By.xpath("//div[@class=\"panel-body\"]//a[contains(text(),\"Follow On Twitter\")]")).click();
//		
//		Set<String> handles = driver.getWindowHandles();
//		
//		for(String s:handles)
//		{
//			driver.switchTo().window(s);
//		}
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//a[@data-testid=\"signup\"]");
//		driver.findElement(By.xpath("//input[@name=\"session[username_or_email]\"]")).sendKeys("Samarth");
//	}
	
//	@Test
//	public void JavascriptAlert() throws InterruptedException
//	{
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[@class=\"at4win-header\"]//a")).click();
//		
//		Actions ac = new Actions(driver);
//		WebElement w1 = driver.findElement(By.xpath("//li[@class=\"dropdown\"][2]//a[contains(text(),\"Alerts & Modals\")]"));
//	
//		ac.moveToElement(w1).click();
//		ac.moveToElement(driver.findElement(By.xpath("//li[@class=\"dropdown\"][2]//a[contains(text(),\"Alerts & Modals\")]//following-sibling::ul[@class=\"dropdown-menu\"]//li[5]//a"))).click().build().perform();
//		
//		//driver.findElement(By.xpath("//b[contains(text(),\"Click the button to display an confirm box:\")]//following-sibling::button")).click();
//		
//		driver.findElement(By.xpath("//button[contains(text(),\"Click for Prompt Box\")]")).click();
//		driver.switchTo().alert().sendKeys("Samarth");
//		driver.switchTo().alert().accept();
//		
//		String txt=driver.findElement(By.xpath("//p[@id=\"prompt-demo\"]")).getText();
//		System.out.println(txt);
//	}
	
//	@Test
//	public void BootStrapModal() throws InterruptedException
//	{
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[@class=\"at4win-header\"]//a")).click();
//		
//		Actions ac = new Actions(driver);
//		WebElement w1 = driver.findElement(By.xpath("//li[@class=\"dropdown\"][2]//a[contains(text(),\"Alerts & Modals\")]"));
//	
//		ac.moveToElement(w1).click();
//		ac.moveToElement(driver.findElement(By.xpath("//li[@class=\"dropdown\"][2]//a[contains(text(),\"Alerts & Modals\")]//following-sibling::ul[@class=\"dropdown-menu\"]//li[2]//a"))).click().build().perform();
//		
//		driver.findElement(By.xpath("//div[contains(text(),\"Multiple Modal Example\")]//following::a[contains(text(),\"Launch modal\")][1]")).click();
//		
//		//driver.switchTo().alert();
//		
//		driver.findElement(By.xpath("//div[@class=\"modal-body\"]//a[contains(text(),\"Launch modal\")][1]")).click();
//		
//		//driver.switchTo().alert();
//		
//		driver.findElement(By.xpath("//h4[contains(text(),\"Modal 2\")]//following::div[5]//a[2]")).click();
//		
//
//	}
	
//	@Test
//	public void BootStrapDropDown() throws InterruptedException
//	{
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//div[@class=\"at4win-header\"]//a")).click();
//		
//		Actions ac = new Actions(driver);
//		WebElement w1 = driver.findElement(By.xpath("//ul[@class=\"nav navbar-nav navbar-right\"]//li[@class=\"dropdown\"][3]//a[contains(text(),\"List Box\")]"));
//	
//		ac.moveToElement(w1).click();
//		ac.moveToElement(driver.findElement(By.xpath("//ul[@class=\"dropdown-menu\"]//li//a[contains(text(),\"Bootstrap List \")]"))).click().build().perform();
//		
//		List<WebElement> l1 = driver.findElements(By.xpath("//div[@class=\"dual-list list-left col-md-5\"]//ul[@class=\"list-group\"]//li"));
//		
//		System.out.println(l1.size());
//		
//		String s1[] = {"Dapibus ac facilisis in","bootstrap-duallist"};
//		try {
//			for(int i=0;i<l1.size();i++)
//			{
//				for(int j=0;j<s1.length;j++)
//				{
//					if(l1.get(i).getText().equals(s1[j]))
//					{
//						driver.findElement(By.xpath("//div[@class=\"dual-list list-left col-md-5\"]//ul[@class=\"list-group\"]//li[contains(text(),'"+s1[j]+"')]")).click();
//						
//						driver.findElement(By.xpath("//button[@class=\"btn btn-default btn-sm move-right\"]")).click();
//						
//					}
//				}
//				
//			}
//		}
//		catch(StaleElementReferenceException e)
//		{
//			List<WebElement> l2 = driver.findElements(By.xpath("//div[@class=\"dual-list list-right col-md-5\"]//ul//li"));
//			
//			for(int k=0;k<l2.size();k++)
//			{
//				System.out.println(l2.get(k).getText());
//			}
//			System.out.println(l2.size());
//		}
//		
//		
//		
//		//driver.navigate().refresh();
//		
//		
//
//	}
	@Test
	public void Brokenlinks() throws IOException
	{
		List<WebElement> linklist = driver.findElements(By.tagName("a"));
		linklist.addAll(driver.findElements(By.tagName("img")));
		
		List<WebElement> activelink = new ArrayList<WebElement>();
		
		for(int i=0;i<linklist.size();i++)
		{
			if(linklist.get(i).getAttribute("href")!=null)
			{
				activelink.add(linklist.get(i));
			}
		}
		
		System.out.println("Total number of links are : " +activelink.size());
		
		for(int j=0;j<activelink.size();j++)
		{
			HttpURLConnection connection = (HttpURLConnection) new URL(activelink.get(j).getAttribute("href")).openConnection();
			
			((URLConnection) connection).connect();
			String response = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activelink.get(j).getAttribute("href")+"---------"+response);
		}
			
		
	}
	
	
//	@Test
//	public void windowHandles() throws InterruptedException
//	{
//		driver.findElement(By.xpath("//a[@id=\"sendx-close-dNnOns5gBj56SFGkOimE4p\"]")).click();
//		Thread.sleep(3000);
//		
//		driver.findElement(By.xpath("//span[contains(text(),\"Katalon\")]")).click();
//		Thread.sleep(3000);
//		
//		driver.findElement(By.xpath("//a[@id=\"sendx-close-dNnOns5gBj56SFGkOimE4p\"]")).click();
//		Thread.sleep(2000);
//		
//		driver.findElement(By.xpath("//a[contains(text(),\"www.katalon.com\")]")).click();
//		
//		//System.out.println("Parent window is :-"+driver.getWindowHandle());
//		
//		//System.out.println("Title is :-"+ driver.getTitle());
//		
//		Set<String> windows = driver.getWindowHandles();									// It return key value of window.
//		
//		//ArrayList<String> list1 = new ArrayList<String>(windows);							//convert set into list(By doing this we can access any random window through index which is not possible through Set).
//		
//		Iterator<String> itr = windows.iterator();
//		
//		String parentwindow = itr.next();
//		System.out.println("Parent window is :- "+parentwindow);
//		
//		String childwindow = itr.next();
//		System.out.println("child window is :- "+childwindow);
//		
//		driver.switchTo().window(childwindow);
//		
//		Thread.sleep(3000);
//		
//		String t = driver.getTitle();
//		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//		Thread.sleep(3000);
//		
//		driver.findElement(By.xpath("//div[@class=\"item_menu_footer\"]//a[contains(text(),\"Web Testing\")]")).click();
//		
//		
//		Set<String> windows2 = driver.getWindowHandles();
//		System.out.println("Inside for : -" +windows2.size());
//		
//		String t1 = driver.getTitle();
//		
//		String childwindow2 = itr.next();
//		System.out.println("Child2 window:- "+childwindow2);
//		
//		driver.switchTo().window(childwindow2);
//		Thread.sleep(3000);
//		
//		JavascriptExecutor js1 = (JavascriptExecutor)driver;
//		js1.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//		Thread.sleep(3000);
//		
//		driver.findElement(By.xpath("//div[@class=\"item_technology_matrix_mobile_menu\"]//a[contains(text(),\"Desktop Testing\")]")).click();
//		
//		String childwindow3 = itr.next();
//		System.out.println("child window3 is : -" +childwindow3);
//		
//		driver.switchTo().window(parentwindow);
//		Thread.sleep(3000);
//		
//		String text = driver.findElement(By.xpath("//p[@class=\"site-title\"]//a")).getText();
//		System.out.println("Title is :- "+ driver.getTitle());
//		System.out.println("The text is :- "+text);
//		
//		String t2 = driver.getTitle();
//		System.out.println("Title of 3rd child window is :- "+t2);
//		
//		JavascriptExecutor js2 = (JavascriptExecutor)driver;
//		js2.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//		Thread.sleep(3000);
//		
		
		
//		for(String win:windows)
//		{
//			
//			driver.switchTo().window(win);
//			
//			
//			
//			if(t.contains("Katalon | Simplify Web, API"))
//			{
//				
//				
//				
//				
//				if(t1.contains("Web Application Testing Guide"))
//				{
//					driver.findElement(By.xpath("//a[contains(text(),\"Start Web Testing\")]"));
//				}
//				//System.out.println("Title is :-"+driver.getTitle());
//			}
//			else
//			{
//				System.out.println("Title is :-"+driver.getTitle());
//				driver.close();
//				System.out.println("Window "+driver.getTitle()+ "  "+"is closed");
//			}
			
			
		
		
		
		
//	}
	

}
