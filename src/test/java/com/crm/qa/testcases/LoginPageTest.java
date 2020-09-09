package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.crm.qa.pages.LoginPage;
import com.crn.qa.base.TestBase;

import org.testng.Assert;

public class LoginPageTest extends TestBase{

	LoginPage lp;
	public LoginPageTest() throws IOException {
		super();
		lp = new LoginPage();
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void verifytitleTest()
	{
		String title=lp.validateLoginPageTitle();
		Assert.assertEquals(title,"#1 Free CRM for Any Bussiness: Online Customer Relationship Software");
	}
	
	/*@SuppressWarnings("deprecation")
	@Test
	public void imageTest()
	{
		boolean flag=lp.validateImage();
		Assert.assertTrue(true);
		//Assert.assertEquals(flag, true);
	}*/
	
	@Test
	public void loginTest()
	{
		lp.login(prop.getProperty("username"),prop.getProperty("password"));
	}

}
