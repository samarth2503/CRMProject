package com.crn.qa.Practice;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class FileUpload {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException, FindFailed
	{
		
		//Download File to desired Location
		
		HashMap<String,Object> chromeopt = new HashMap<String,Object>();
		
		chromeopt.put("profile.default_content_settings.popups", 0);
		chromeopt.put("downlaod.prompt_for_downlaod","false");
		chromeopt.put("downlaod.default_directory", "D:\\Downalodedfile");
		
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("pref", chromeopt);
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, true);
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ADMIN\\Desktop\\tomCatAPIFiles\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Register.html");
		
		driver.manage().window().maximize();
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//*[@id='imagesrc']")).click();

		
		String imagefilepath="C:\\Users\\Public\\Pictures\\Sample Pictures\\";
		String inputfilepath="C:\\Users\\Public\\Pictures\\Sample Pictures\\";
		
		Screen s = new Screen();
		
		Pattern fileInputTextBox = new Pattern(imagefilepath+"FileName.PNG");
		Pattern openButton = new Pattern(imagefilepath+"OpenButton.PNG");
		
		Thread.sleep(3000);
		
		s.wait(fileInputTextBox,20);
		s.type(fileInputTextBox,inputfilepath+"Desert.PNG");
		s.click(openButton);
		
		
//		driver.get("http://demo.automationtesting.in/FileDownload.html");
//		
//		driver.manage().window().maximize();
//		Thread.sleep(2000);
//		
//		
//		// Downlaod Text File
//		driver.findElement(By.id("textbox")).sendKeys("Selenium Testing");
//		
//		driver.findElement(By.id("createTxt")).click();
//		
//		driver.findElement(By.id("link-to-download")).click();
//		
//		Thread.sleep(4000);
//		
//		Boolean file=isFileExist("D:\\Downalodedfile\\info (1).txt");
//		
//		if(file)
//		{
//			System.out.println("File Exist");
//		}
//		else
//		{
//			System.out.println("File not exist");
//		}
//		
//		//Downlaod PDF File
//		driver.findElement(By.id("pdfbox")).sendKeys("Testing pdf downlaod");
//		
//		driver.findElement(By.id("createPdf")).click();
//		
//		driver.findElement(By.id("pdf-link-to-download")).click();
//		
//		Thread.sleep(4000);
//		
//		Boolean pdf=isFileExist("D:\\Downalodedfile\\info.pdf");
//		
//		if(file)
//		{
//			System.out.println("File Exist");
//		}
//		else
//		{
//			System.out.println("File not exist");
//		}
//		
		
	}
	
	public static boolean isFileExist(String path)
	{
		File f = new File(path);
		if(f.exists())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
