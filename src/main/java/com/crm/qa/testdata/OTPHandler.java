package com.crm.qa.testdata;

import java.util.concurrent.TimeUnit;
import java.util.stream.StreamSupport;
import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.stream.StreamSupport;

public class OTPHandler {
	
	public static final String ACCOUNT_SID="AC8f032a4d3e58437d9ea9c978b768c731";
	public static final String AUTH_TOKEN= "c68547538b3ae2875bf90270c3deb9cc";
	
	public static WebDriver driver = null;
	
	public static void main(String args[])
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\ADMIN\\Desktop\\Apachae.po\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("http://newtours.demoaut.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("a#nav-link-accountList>span>span")).click();
		driver.findElement(By.linkText("Start here")).click();
		
		driver.findElement(By.xpath("//input[@name=\"customerName\"]")).sendKeys("Harsh");
		driver.findElement(By.xpath("//i[@class=\"a-icon a-icon-dropdown\"]")).click();
		
		driver.findElement(By.xpath("//ul[@role=\"application\"]//li//a[contains(text(),\"United States +1\")]")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Mobile number\"]")).sendKeys("2055066615");
		
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("HarshGupta@680");
		driver.findElement(By.xpath("//input[@id=\"continue\"]")).click();
		
		driver.findElement(By.xpath("//input[@id=\"auth-pv-enter-code\"]")).sendKeys();
		
		Twilio.init(ACCOUNT_SID,AUTH_TOKEN);
		
		
	}
	
	public static String getMessage() {
		return getMessages().filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
				.filter(m -> m.getTo().equals("+13343734019")).map(Message::getBody).findFirst()
				.orElseThrow(IllegalStateException::new);
	}

	private static Stream<Message> getMessages() {
		ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
		return StreamSupport.stream(messages.spliterator(), false);
	}
	
	
	
}
