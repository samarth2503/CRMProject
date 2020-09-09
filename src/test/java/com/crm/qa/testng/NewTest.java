package com.org.TestngAttributes;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest {
	

	@BeforeClass
	@Parameters({"Browser","URL"})
	public void setUp(@Optional("chrome")String browser1,@Optional("https://www.javatpoint.com/")String url) {
		System.out.println("Browser:"+browser1);
		System.out.println("AUT Link: "+url); 
		if(browser1=="chrome")
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\ADMIN\\Desktop\\Apachae.po\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.navigate().to("https://www.javatpoint.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}
	@Test(priority=1)
	public void test()
	{
		System.out.println("Test1");
	}
	
	@Test(priority=2,groups="Smoke")
	public void test2()
	{
		System.out.println("Test2");
	}
	
	@Test(priority=3,groups="Smoke")
	public void test3()
	{
		System.out.println("Test3");
	}


    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Inside Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Inside After Method");
    }

  
    @AfterClass
    public void afterClass() {
        System.out.println("Inside AfterClass Method");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Inside BeforeTest Method");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Inside AfterTest Method");
    }

    @BeforeSuite
    public void beforeSuite() {
    System.out.println("Inside BeforeSuite Method");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Inside AfterSuite Method");
    }

}


