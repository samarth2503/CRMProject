package com.crm.qa.testng;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

class firsttestng {
    public String baseUrl = "http://demo.guru99.com/test/newtours/";
    String driverPath = "D:\\Selenium WorkSpace\\CRMProject\\chromedriver.exe";
    public WebDriver driver; 
    public String expected = null;
    public String actual = null;
        @BeforeTest
      public void launchBrowser() {
          System.out.println("launching firefox browser"); 
          System.setProperty("webdriver.chrome.driver", driverPath);
          driver= new ChromeDriver();
          driver.get(baseUrl);
      }
      
      @BeforeMethod
      public void verifyHomepageTitle() {
    	  System.out.println("Before Method"); 
          String expectedTitle = "Welcome: Mercury Tours";
          String actualTitle = driver.getTitle();
          Assert.assertEquals(actualTitle, expectedTitle);
      }
          @Test(priority = 0)
      public void register(){
          System.out.println("Register Test"); 
          driver.findElement(By.linkText("REGISTER")).click() ;
          expected = "Register: Mercury Tours";
          actual = driver.getTitle();
          Assert.assertEquals(actual, expected);
      }
          @Test(priority = 1)
      public void support() {
        	System.out.println("Support Test");  
            driver.findElement(By.linkText("SUPPORT")).click() ;
            expected = "Under Construction: Mercury Tours";
            actual = driver.getTitle();
            Assert.assertEquals(actual, expected);
      }
      @AfterMethod
      public void goBackToHomepage ( ) {
    	  	System.out.println("After Method");
            driver.findElement(By.linkText("Home")).click() ;
      }
       
      @AfterTest
      public void terminateBrowser(){
    	  System.out.println("After Test");
          driver.close();
      }
}