package com.crn.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.Reservation;
import com.crn.qa.base.TestBase;

public class LoginPageTest extends TestBase{
	
	
	LoginPage lp;
	Reservation rs;
	public LoginPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeTest
	public void setUp() throws IOException, InterruptedException
	{
		initalization();
		lp = new LoginPage();
		
		
	}
	
	@Test(priority=1)
	public void loginTitleTest()
	{
		
		String title= lp.validatePage();
		System.out.println(title);
		assertEquals(title,"Welcome: Mercury Tours");
		
	}
	
	@Test(priority=2)
	public void loginImageTest()
	{
		boolean flag = lp.validateImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException, IOException
	{
		rs=lp.Login(prop.getProperty("un"), prop.getProperty("pwd")); 
		
	}
	
//	@AfterTest
//	public void teardown()
//	{
//		driver.close();
//	}

}
