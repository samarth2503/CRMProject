package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crn.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	public WebElement username,password,button,img;

	public LoginPage() throws IOException {
		super();
		
	}
	
	public String validatePage()
	{
		String title=driver.getTitle();
		return title;
	}
	
	public boolean validateImage()
	{
		return getObject(prop.getProperty("images")).isDisplayed();
		
	}
	
	public Reservation Login(String un,String pwd) throws InterruptedException, IOException 
	{
		insertText(prop.getProperty("username"),un);
		insertText(prop.getProperty("password"),pwd);
		clickObject(prop.getProperty("button"));
		if (getObject(prop.getProperty("Login_Text")).getText().equals("Login Successfully"))
		{
			clickObject(prop.getProperty("flight_link"));
			return new Reservation();
		}
		else
		{
			return null;
		}
		
	}
	

}
