package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crn.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	
	//PageFactory or Object repoistory
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[conatins(text(),'Sign Up')]")
	WebElement SignUp;
	
	@FindBy(xpath="//a[@class=\"navbar-brand\"]//img[contains(@class,\"img-responsive\")]")
	WebElement crnlogo;
	
	
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);              // to initalize the Pagefactory
		// TODO Auto-generated constructor stub
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateImage()
	{
		return crnlogo.isDisplayed();
	}
	
	public void login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
	}

}
